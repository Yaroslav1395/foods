package com.example.food.service;

import com.example.food.dto.auth.JwtRequest;
import com.example.food.dto.auth.JwtResponse;

public interface AuthService {

    JwtResponse login(JwtRequest loginRequest);

    JwtResponse refresh(String refreshToken);

}
