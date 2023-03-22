package com.example.food.service;

import com.example.food.domain.dish.Dish;
import com.example.food.dto.dish.DishDto;

import java.util.List;

public interface DishService {
    Dish create(Dish dish, Long restaurantId);
    List<Dish> getDishOfRestaurant(Long restaurantId);
    Dish getById(Long id);
}
