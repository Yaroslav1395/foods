package com.example.food.repository;

import com.example.food.domain.dish.Dish;
import com.example.food.domain.dish.Type;
import com.example.food.domain.restaurant.Restaurant;
import com.example.food.domain.user.Role;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Optional;

@Mapper
public interface DishRepository {
    Optional<Dish> getById(Long id);
    List<Dish> getDishOfRestaurant(Long restaurantId);

    void create(Dish dish);
    void insertDishType(@Param("dishId") Long dishId, @Param("type") Type type);
    void insertDishMenu(@Param("dishId") Long dishId, @Param("restaurantId") Long restaurantId);
}
