package com.example.food.controller;

import com.example.food.domain.restaurant.Restaurant;
import com.example.food.dto.mappers.RestaurantMapper;
import com.example.food.dto.restaurant.RestaurantDto;
import com.example.food.dto.validate.OnCreate;
import com.example.food.service.RestaurantService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/restaurant")
@RequiredArgsConstructor
@Validated
@Tag(name = "Restaurant Controller", description = "Restaurant API")
public class RestaurantController {
    private final RestaurantService restaurantService;
    private final RestaurantMapper restaurantMapper;
    @GetMapping("/{id}")
    @Operation(summary = "Get restaurant by id")
    public RestaurantDto getById(@PathVariable Long id){
        return restaurantMapper.toDto(restaurantService.getById(id));
    }
    @GetMapping
    @Operation(summary = "Get all restaurants")
    public List<RestaurantDto> getAllRestaurant(){
        return restaurantService.getAllRestaurant().stream()
                .map(restaurantMapper::toDto)
                .toList();
    }

    @PostMapping
    @Operation(summary = "Create restaurant")
    public RestaurantDto create(@Validated(OnCreate.class) @RequestBody RestaurantDto restaurantDto){
        Restaurant restaurant = restaurantMapper.toEntity(restaurantDto);
        System.out.println(restaurant);
        return restaurantMapper.toDto(restaurantService.create(restaurant));
    }

}
