package com.example.bookstoreproject.dto;
import com.example.bookstoreproject.entity.UserData;

public class UserResponseDTO {
    public String message;
    public  Object userData;

    public UserResponseDTO(String message, UserData userData) {
        this.message = message;
        this.userData = userData;
    }
}
