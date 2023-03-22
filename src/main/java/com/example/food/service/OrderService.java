package com.example.food.service;

import com.example.food.domain.order.Order;

import java.util.List;
import java.util.Optional;

public interface OrderService {
    Order getById(Long id);
    List<Order> getUserOrder(Long userId);
    Order create(Order order);
}
