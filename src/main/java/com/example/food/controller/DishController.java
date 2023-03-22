package com.example.food.controller;

import com.example.food.domain.dish.Dish;
import com.example.food.dto.dish.DishDto;
import com.example.food.dto.mappers.DishMapper;
import com.example.food.service.DishService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/dish")
@RequiredArgsConstructor
@Validated
@Tag(name = "Dish Controller", description = "Dish API")
public class DishController {
    private final DishService dishService;
    private final DishMapper dishMapper;

    @PostMapping("for/restaurant/{id}")
    public DishDto create(@Validated DishDto dishDto, @PathVariable Long restaurantId){
        Dish dish = dishMapper.toEntity(dishDto);
        Dish createDish = dishService.create(dish, restaurantId);
        return dishMapper.toDto(createDish);
    }

    @GetMapping("/from/restaurant/{id}")
    public List<DishDto> getDishOfRestaurant(@PathVariable Long id){
        return dishService.getDishOfRestaurant(id).stream()
                .map(dishMapper::toDto)
                .collect(Collectors.toList());
    }

    @GetMapping("{id}")
    public DishDto getById(@PathVariable Long id){
        return dishMapper.toDto(dishService.getById(id));
    }
}
