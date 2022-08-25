package com.example.kitchenservice.controller;

import com.example.kitchenservice.dto.ApiResponse;
import com.example.kitchenservice.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.web.bind.annotation.PathVariable;

import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(MockitoExtension.class)
@RequiredArgsConstructor

class OrderControllerTest {
 private final OrderRepository orderRepository;
 private final  OrderController orderController;


    @Test
    @BeforeAll
    @Order(1)
    void testGetOrder( Long id ) {
        ApiResponse<?> order = orderController.getOrder(id);

    }

    @Test
    void testOrderChanges() {
    }

    @Test
    void testDeleteOrder() {
    }
}