package com.example.food.dto.mappers;

import com.example.food.domain.user.User;
import com.example.food.dto.user.UserDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserDto toDto(User user);

    User toEntity(UserDto dto);

}
