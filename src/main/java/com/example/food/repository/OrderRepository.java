package com.example.food.repository;

import com.example.food.domain.order.Order;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Optional;

@Mapper
public interface OrderRepository {
    Optional<Order> getById(Long id);
    List<Order> getUserOrder(Long userId);
    void create(Order order);
}
