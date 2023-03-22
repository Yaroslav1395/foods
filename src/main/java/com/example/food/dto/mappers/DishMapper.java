package com.example.food.dto.mappers;

import com.example.food.domain.dish.Dish;
import com.example.food.dto.dish.DishDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface DishMapper {
    DishDto toDto(Dish dish);
    Dish toEntity(DishDto dishDto);
}
