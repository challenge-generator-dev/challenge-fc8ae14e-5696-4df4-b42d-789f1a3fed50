package com.orders.application;

import com.orders.domain.OrderRepository;
import com.orders.domain.OrderStatus;
import com.orders.infrastructure.OrderController.OrderRequest;
import com.orders.infrastructure.OrderController.OrderResponse;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class OrderServiceTest {

    @Mock
    private OrderRepository orderRepository;

    @InjectMocks
    private OrderService orderService;

    @Test
    void getOrders_withStatus_returnsFilteredOrders() {
        // TODO(reto): Implementar test para getOrders con filtro de status
        // Given: un estado de orden y una lista de orders en el repositorio mock
        // When: se llama a getOrders con ese estado
        // Then: verificar que retorna solo las orders con ese estado
    }

    @Test
    void getOrderById_existingId_returnsOrder() {
        // TODO(reto): Implementar test para getOrderById cuando existe
        // Given: un ID existente y una orden en el repositorio mock
        // When: se llama a getOrderById con ese ID
        // Then: verificar que retorna la orden correcta
    }

    @Test
    void getOrderById_nonExistingId_throwsOrderNotFoundException() {
        // TODO(reto): Implementar test para getOrderById cuando no existe
        // Given: un ID que no existe en el repositorio mock
        // When: se llama a getOrderById con ese ID
        // Then: verificar que lanza OrderNotFoundException
    }

    @Test
    void createOrder_validRequest_createsAndReturnsOrder() {
        // TODO(reto): Implementar test para createOrder
        // Given: una OrderRequest válida
        // When: se llama a createOrder
        // Then: verificar que se guarda en el repositorio y retorna la orden creada
    }

    @Test
    void updateOrder_existingId_updatesAndReturnsOrder() {
        // TODO(reto): Implementar test para updateOrder
        // Given: un ID existente y una OrderRequest con nuevos datos
        // When: se llama a updateOrder
        // Then: verificar que se actualiza en el repositorio y retorna la orden actualizada
    }

    @Test
    void updateOrder_nonExistingId_throwsOrderNotFoundException() {
        // TODO(reto): Implementar test para updateOrder cuando no existe
        // Given: un ID que no existe en el repositorio mock
        // When: se llama a updateOrder con ese ID
        // Then: verificar que lanza OrderNotFoundException
    }

    @Test
    void deleteOrder_existingId_deletesOrder() {
        // TODO(reto): Implementar test para deleteOrder
        // Given: un ID existente
        // When: se llama a deleteOrder
        // Then: verificar que se elimina del repositorio
    }

    @Test
    void deleteOrder_nonExistingId_throwsOrderNotFoundException() {
        // TODO(reto): Implementar test para deleteOrder cuando no existe
        // Given: un ID que no existe en el repositorio mock
        // When: se llama a deleteOrder
        // Then: verificar que lanza OrderNotFoundException
    }
}