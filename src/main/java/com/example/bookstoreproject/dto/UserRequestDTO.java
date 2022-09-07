package com.example.bookstoreproject.dto;

import lombok.Data;

@Data
public class UserRequestDTO {
    private String firstName;
    private String lastName;
    private String address;
    private int userId;
    private String email;

}

