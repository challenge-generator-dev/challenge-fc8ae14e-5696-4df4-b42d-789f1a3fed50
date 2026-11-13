package com.orders.infrastructure;

import com.orders.domain.Order;
import com.orders.domain.OrderRepository;
import com.orders.domain.OrderStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface OrderJpaRepository extends OrderRepository, JpaRepository<Order, String> {
    @Override
    default List<Order> findByStatus(OrderStatus status) {
        return findAll().stream()
                .filter(order -> order.getStatus() == status)
                .toList();
    }

    @Override
    default List<Order> findByCreatedAtBetween(LocalDateTime dateFrom, LocalDateTime dateTo) {
        return findAll().stream()
                .filter(order -> !order.getCreatedAt().isBefore(dateFrom) && !order.getCreatedAt().isAfter(dateTo))
                .toList();
    }

    @Override
    default Optional<Order> findByIdAndCustomerId(String id, String customerId) {
        return findById(id)
                .filter(order -> order.getCustomerId().equals(customerId));
    }
}