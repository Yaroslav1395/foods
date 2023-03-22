package com.example.food.service.serviceImpl;

import com.example.food.domain.dish.Dish;
import com.example.food.domain.exception.ResourceNotFoundException;
import com.example.food.dto.dish.DishDto;
import com.example.food.repository.DishRepository;
import com.example.food.service.DishService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class DishServiceImpl implements DishService {
    private final DishRepository dishRepository;

    @Override
    public Dish create(Dish dish, Long restaurantId) {
        dishRepository.create(dish);
        dishRepository.insertDishType(dish.getId(), dish.getType());
        dishRepository.insertDishMenu(dish.getId(), restaurantId);
        return dish;
    }

    @Override
    public List<Dish> getDishOfRestaurant(Long restaurantId) {
        return dishRepository.getDishOfRestaurant(restaurantId);
    }

    @Override
    public Dish getById(Long id) {
        return dishRepository.getById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Dish not found"));
    }
}
