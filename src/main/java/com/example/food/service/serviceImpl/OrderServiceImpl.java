package com.example.food.service.serviceImpl;

import com.example.food.domain.exception.ResourceNotFoundException;
import com.example.food.domain.order.Order;
import com.example.food.repository.OrderRepository;
import com.example.food.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;

    @Override
    public Order getById(Long id) {
        return orderRepository.getById(id).orElseThrow(() -> new ResourceNotFoundException("Order not found"));
    }

    @Override
    public List<Order> getUserOrder(Long userId) {
        return orderRepository.getUserOrder(userId);
    }

    @Override
    public Order create(Order order) {
        orderRepository.create(order);
        return order;
    }
}
