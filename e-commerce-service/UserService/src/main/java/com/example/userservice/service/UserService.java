package com.example.userservice.service;

import com.example.userservice.controller.dto.UserCreateResponseDto;
import com.example.userservice.controller.dto.UserDto;

public interface UserService {

    UserCreateResponseDto createUser(UserDto userDto);

}
