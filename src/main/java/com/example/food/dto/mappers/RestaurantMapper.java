package com.example.food.dto.mappers;

import com.example.food.domain.restaurant.Restaurant;
import com.example.food.dto.restaurant.RestaurantDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface RestaurantMapper {
    RestaurantDto toDto(Restaurant restaurant);
    Restaurant toEntity(RestaurantDto restaurantDto);
}
