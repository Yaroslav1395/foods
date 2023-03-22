package com.example.food.dto;

import com.example.food.dto.dish.DishDto;
import com.example.food.dto.user.UserDto;
import com.example.food.dto.validate.OnCreate;
import com.example.food.dto.validate.OnUpdate;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

@Data
public class OrderDto {
    @Schema(description = "Order id", example = "1")
    @NotNull(message = "Id must be not null.", groups = OnUpdate.class)
    private Long id;
    @Schema(description = "User", example = "See UserDto")
    @NotNull(message = "Name must be not null.", groups = {OnCreate.class, OnUpdate.class})
    private UserDto userDto;
    @Schema(description = "Dish", example = "See DishDto")
    @NotNull(message = "Name must be not null.", groups = {OnCreate.class, OnUpdate.class})
    private DishDto dishDto;
}
