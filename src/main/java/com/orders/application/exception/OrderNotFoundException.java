package com.orders.application.exception;


import com.orders.domain.Order;
import java.util.Map;

public class OrderNotFoundException extends RuntimeException {
    private final String orderId;
    private final String customerId;
    private final Map<String, String> context;

    public OrderNotFoundException(String orderId) {
        super(String.format("Order with id %s not found", orderId));
        this.orderId = orderId;
        this.customerId = null;
        this.context = Map.of("orderId", orderId);
    }

    public OrderNotFoundException(String orderId, String customerId) {
        super(String.format("Order with id %s not found for customer %s", orderId, customerId));
        this.orderId = orderId;
        this.customerId = customerId;
        this.context = Map.of(
            "orderId", orderId,
            "customerId", customerId
        );
    }

    public String getOrderId() {
        return orderId;
    }

    public String getCustomerId() {
        return customerId;
    }

    public Map<String, String> getContext() {
        return context;
    }
}