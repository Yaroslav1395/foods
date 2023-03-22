package com.example.food.domain.dish;

import lombok.Data;

@Data
public class Dish {
    private Long id;
    private String name;
    private Type type;
    private int price;
}
