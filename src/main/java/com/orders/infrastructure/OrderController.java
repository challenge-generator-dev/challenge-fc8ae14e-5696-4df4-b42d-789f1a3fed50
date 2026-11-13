// TODO(reto): archivo stubbeado; implementa los cuerpos.
package com.orders.infrastructure;

import com.orders.application.OrderService;
import com.orders.domain.OrderStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping
    public ResponseEntity<List<OrderResponse>> getOrders(
            @RequestParam(required = false) OrderStatus status,
            @RequestParam(required = false) String dateFrom,
            @RequestParam(required = false) String dateTo) {
        throw new UnsupportedOperationException("TODO(reto): getOrders");
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrderResponse> getOrderById(@PathVariable String id) {
        throw new UnsupportedOperationException("TODO(reto): getOrderById");
    }

    @PostMapping
    public ResponseEntity<OrderResponse> createOrder(@RequestBody OrderRequest request) {
        throw new UnsupportedOperationException("TODO(reto): createOrder");
    }

    @PutMapping("/{id}")
    public ResponseEntity<OrderResponse> updateOrder(@PathVariable String id, @RequestBody OrderRequest request) {
        throw new UnsupportedOperationException("TODO(reto): updateOrder");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOrder(@PathVariable String id) {
        throw new UnsupportedOperationException("TODO(reto): deleteOrder");
    }
}

record OrderRequest(String customerId, List<OrderItemRequest> items, OrderStatus status) {
    record OrderItemRequest(String productId, int quantity, double price) {}
}

record OrderResponse(String id, String customerId, List<OrderItemResponse> items, OrderStatus status, String createdAt, String updatedAt) {
    record OrderItemResponse(String productId, int quantity, double price) {}
}