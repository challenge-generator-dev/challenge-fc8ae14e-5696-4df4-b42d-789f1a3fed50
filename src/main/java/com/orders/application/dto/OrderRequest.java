package com.orders.application.dto;

import com.orders.domain.OrderStatus;

import java.util.List;

public record OrderRequest(
    String customerId,
    List<OrderItemRequest> items,
    OrderStatus status
) {
    public record OrderItemRequest(String productId, int quantity, double price) {}
}