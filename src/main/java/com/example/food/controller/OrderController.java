package com.example.food.controller;

import com.example.food.domain.order.Order;
import com.example.food.dto.OrderDto;
import com.example.food.dto.mappers.OrderMapper;
import com.example.food.service.OrderService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/order")
@RequiredArgsConstructor
@Validated
@Tag(name = "Dish Controller", description = "Dish API")
public class OrderController {
    private final OrderService orderService;
    private  final OrderMapper orderMapper;
    @PostMapping
    public OrderDto create(@Validated @RequestBody OrderDto orderDto){
        Order order = orderMapper.toEntity(orderDto);
        return orderMapper.toDto(orderService.create(order));
    }
    @GetMapping("/user/{id}")
    public List<OrderDto> getUserOrders(@PathVariable Long id){
        return orderService.getUserOrder(id).stream()
                .map(orderMapper::toDto)
                .collect(Collectors.toList());
    }
    @GetMapping("/{id}")
    public OrderDto getById(@PathVariable Long id){
        return orderMapper.toDto(orderService.getById(id));
    }
}
