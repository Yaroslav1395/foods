package com.example.food.dto.mappers;

import com.example.food.domain.order.Order;
import com.example.food.dto.OrderDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface OrderMapper {
    Order toEntity(OrderDto orderDto);
    OrderDto toDto(Order order);
}
