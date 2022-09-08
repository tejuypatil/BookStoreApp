package com.example.bookstoreproject.dto;

import lombok.Data;

@Data
public class UserRequestDTO {
    private String firstName;
    private String lastName;
    private String address;
    private String email;
    private String loginId;
    private boolean isAdmin;

}

