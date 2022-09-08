package com.example.bookstoreproject.dto;

import lombok.Data;

@Data
public class UserRegisterRequestDTO {
    private String firstName;
    private String lastName;
    private String address;
    private String email;
    private String loginId;
    private String password;
    private boolean isAdmin;

}

