package com.example.bookstoreproject.dto;

import lombok.Data;

@Data
public class UserLoginRequestDTO {
    private String loginId;
    private String password;
}
