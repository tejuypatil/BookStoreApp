package com.example.bookstoreproject.dto;

import com.example.bookstoreproject.entity.Book;
import com.example.bookstoreproject.entity.UserData;

public class UserResponseDTO {
    public int userId;
    public String message;
    public  Object userData;

    public UserResponseDTO(String message, UserData userData) {
        this.message = message;
        this.userData = userData;
    }
    public UserResponseDTO(String message, int userId) {
        this.message = message;
        this.userId = userId;
    }

    public UserResponseDTO(String updated_book_data_successfully, String userData) {
    }
}
