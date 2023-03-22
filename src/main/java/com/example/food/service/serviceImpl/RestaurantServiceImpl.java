package com.example.food.service.serviceImpl;

import com.example.food.domain.exception.ResourceNotFoundException;
import com.example.food.domain.restaurant.Restaurant;
import com.example.food.repository.RestaurantRepository;
import com.example.food.service.RestaurantService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@RequiredArgsConstructor
public class RestaurantServiceImpl implements RestaurantService {
    private final RestaurantRepository restaurantRepository;
    @Override
    @Transactional(readOnly = true)
    public Restaurant getById(Long id) {
        return restaurantRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Restaurant with response id not found"));
    }

    @Override
    public Restaurant create(Restaurant restaurant) {
        restaurantRepository.create(restaurant);

        return restaurantRepository.findById(restaurant.getId())
                .orElseThrow(() -> new ResourceNotFoundException("Restaurant creating fail"));
    }

    @Override
    @Transactional(readOnly = true)
    public List<Restaurant> getAllRestaurant() {
        return restaurantRepository.findAll();
    }
}
