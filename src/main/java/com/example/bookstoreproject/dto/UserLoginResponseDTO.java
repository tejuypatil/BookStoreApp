package com.example.bookstoreproject.dto;

import com.example.bookstoreproject.entity.UserData;

public class UserLoginResponseDTO {
    public String message;
    public String token;

    public UserLoginResponseDTO(String message,String token) {
        this.message = message;
        this.token = token;
    }
}
