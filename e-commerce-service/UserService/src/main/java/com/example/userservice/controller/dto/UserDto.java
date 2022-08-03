package com.example.userservice.controller.dto;

import lombok.Data;

@Data
public class UserDto {

    private Long id;
    private String email;
    private String name;
    private String userId;
    private String encryptedPassword;

}
