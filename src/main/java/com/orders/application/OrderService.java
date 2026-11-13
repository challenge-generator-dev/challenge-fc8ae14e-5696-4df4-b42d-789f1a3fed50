package com.orders.application;

import com.orders.application.dto.OrderRequest;
import com.orders.application.dto.OrderResponse;
import com.orders.application.exception.OrderNotFoundException;
import com.orders.domain.Order;
import com.orders.domain.OrderItem;
import com.orders.domain.OrderRepository;
import com.orders.domain.OrderStatus;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

@Service
public class OrderService {

    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ISO_LOCAL_DATE_TIME;

    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public List<OrderResponse> getOrders(OrderStatus status, String dateFrom, String dateTo) {
        List<Order> orders;

        if (status != null && dateFrom != null && dateTo != null) {
            LocalDateTime from = LocalDateTime.parse(dateFrom, DATE_FORMATTER);
            LocalDateTime to = LocalDateTime.parse(dateTo, DATE_FORMATTER);
            orders = orderRepository.findByCreatedAtBetween(from, to)
                    .stream()
                    .filter(o -> o.getStatus() == status)
                    .collect(Collectors.toList());
        } else if (status != null) {
            orders = orderRepository.findByStatus(status);
        } else if (dateFrom != null && dateTo != null) {
            LocalDateTime from = LocalDateTime.parse(dateFrom, DATE_FORMATTER);
            LocalDateTime to = LocalDateTime.parse(dateTo, DATE_FORMATTER);
            orders = orderRepository.findByCreatedAtBetween(from, to);
        } else {
            orders = orderRepository.findAll();
        }

        return orders.stream()
                .map(this::toResponse)
                .collect(Collectors.toList());
    }

    public OrderResponse getOrderById(String id) {
        Order order = orderRepository.findById(id)
                .orElseThrow(() -> new OrderNotFoundException(id));
        return toResponse(order);
    }

    public OrderResponse createOrder(OrderRequest request) {
        if (request == null) {
            throw new IllegalArgumentException("Order request cannot be null");
        }

        List<OrderItem> items = mapItems(request.items());
        Order order = new Order(request.customerId(), items);

        if (request.status() != null) {
            order.updateStatus(request.status());
        }

        Order savedOrder = orderRepository.save(order);
        return toResponse(savedOrder);
    }

    public OrderResponse updateOrder(String id, OrderRequest request) {
        Order existingOrder = orderRepository.findById(id)
                .orElseThrow(() -> new OrderNotFoundException(id));

        existingOrder.setCustomerId(request.customerId());

        List<OrderItem> newItems = mapItems(request.items());
        existingOrder.setItems(newItems);

        if (request.status() != null) {
            existingOrder.updateStatus(request.status());
        }

        Order updatedOrder = orderRepository.save(existingOrder);
        return toResponse(updatedOrder);
    }

    public void deleteOrder(String id) {
        if (!orderRepository.existsById(id)) {
            throw new OrderNotFoundException(id);
        }
        orderRepository.deleteById(id);
    }

    private OrderResponse toResponse(Order order) {
        List<OrderResponse.OrderItemResponse> itemResponses = order.getItems().stream()
                .map(item -> new OrderResponse.OrderItemResponse(
                        item.getProductId(),
                        item.getQuantity(),
                        item.getPrice()))
                .collect(Collectors.toList());

        return new OrderResponse(
                order.getId(),
                order.getCustomerId(),
                itemResponses,
                order.getStatus(),
                order.getCreatedAt() != null ? order.getCreatedAt().format(DATE_FORMATTER) : null,
                order.getUpdatedAt() != null ? order.getUpdatedAt().format(DATE_FORMATTER) : null);
    }

    private List<OrderItem> mapItems(List<OrderRequest.OrderItemRequest> items) {
        if (items == null || items.isEmpty()) {
            throw new IllegalArgumentException("Order must contain at least one item");
        }

        return items.stream()
                .map(item -> new OrderItem(item.productId(), item.quantity(), item.price()))
                .collect(Collectors.toList());
    }
}