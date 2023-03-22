package com.example.food.service;

import com.example.food.domain.restaurant.Restaurant;

import java.util.List;

public interface RestaurantService {
    Restaurant getById(Long id);
    Restaurant create(Restaurant restaurant);
    List<Restaurant> getAllRestaurant();
}
