package com.example.food.domain.user;



import lombok.Data;


import java.util.Set;
@Data
public class User {
    private Long id;
    private String name;
    private String username;
    private String password;
    private Set<Role> roles;
}
