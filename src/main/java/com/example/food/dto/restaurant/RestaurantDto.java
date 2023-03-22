package com.example.food.dto.restaurant;

import com.example.food.dto.validate.OnCreate;
import com.example.food.dto.validate.OnUpdate;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.hibernate.validator.constraints.Length;


@Data
public class RestaurantDto {
    @Schema(description = "Restaurant id", example = "1")
    @NotNull(message = "Id must be not null.", groups = OnUpdate.class)
    private Long id;
    @Schema(description = "Restaurant name", example = "Dodo")
    @NotNull(message = "Name must be not null.", groups = {OnCreate.class, OnUpdate.class})
    @Length(max = 255, message = "Name length must be smaller than 255 symbols.", groups = {OnCreate.class, OnUpdate.class})
    private String name;
    @Schema(description = "Description", example = "Some description")
    @NotNull(message = "Name must be not null.", groups = {OnCreate.class, OnUpdate.class})
    @Length(max = 255, message = "Name length must be smaller than 255 symbols.", groups = {OnCreate.class, OnUpdate.class})
    private String description;
}
