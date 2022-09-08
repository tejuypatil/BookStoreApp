package com.example.bookstoreproject.dto;

import com.example.bookstoreproject.entity.UserData;

public class UserResponseDTO {
    public String message;
    public String token;
    public  Object userData;

    public UserResponseDTO(String message, UserData userData, String token) {
        this.message = message;
        this.userData = userData;
        this.token=token;
    }
    public UserResponseDTO(String message, UserData userData) {
        this.message = message;
        this.userData = userData;
    }
}
