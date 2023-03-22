package com.example.food.dto.dish;

import com.example.food.domain.dish.Type;
import com.example.food.dto.validate.OnCreate;
import com.example.food.dto.validate.OnUpdate;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

@Data
public class DishDto {
    @Schema(description = "Dish id", example = "1")
    @NotNull(message = "Id must be not null.", groups = OnUpdate.class)
    private Long id;
    @Schema(description = "Dish name", example = "Margarita")
    @NotNull(message = "Name must be not null.", groups = {OnCreate.class, OnUpdate.class})
    @Length(max = 255, message = "Name length must be smaller than 255 symbols.", groups = {OnCreate.class, OnUpdate.class})
    private String name;
    @Schema(description = "Dish type", example = "Desert")
    @NotNull(message = "Type must be not null.", groups = {OnCreate.class, OnUpdate.class})
    @Length(max = 255, message = "Type length must be smaller than 255 symbols.", groups = {OnCreate.class, OnUpdate.class})
    private Type type;
    @Schema(description = "Dish price", example = "100")
    @NotNull(message = "Price must be not null.", groups = {OnCreate.class, OnUpdate.class})
    private int price;
}
