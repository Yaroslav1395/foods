package com.example.food.domain.order;

import com.example.food.domain.dish.Dish;
import com.example.food.domain.user.User;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Order {
    private Long id;
    private User user;
    private Dish dish;
    private LocalDateTime dateTime;
}
