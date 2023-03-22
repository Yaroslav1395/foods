package com.example.food.repository;

import com.example.food.domain.restaurant.Restaurant;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Optional;

@Mapper
public interface RestaurantRepository {
    Optional<Restaurant> findById(Long id);
    List<Restaurant> findAll();
    Long create(Restaurant restaurant);
}
