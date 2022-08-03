package com.example.userservice.controller.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;

@Getter
@RequiredArgsConstructor
public class UserCreateResponseDto {

    private final String email;

    private final String password;

    private final String name;

    private final String userId;

    private final LocalDate createAt;

    private final String encryptedPassword;
}
