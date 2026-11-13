package com.orders.application.dto;

import com.orders.domain.OrderStatus;

import java.util.List;

public record OrderResponse(
    String id,
    String customerId,
    List<OrderItemResponse> items,
    OrderStatus status,
    String createdAt,
    String updatedAt
) {
    public record OrderItemResponse(String productId, int quantity, double price) {}
}