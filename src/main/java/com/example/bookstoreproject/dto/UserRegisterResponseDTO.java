package com.example.bookstoreproject.dto;

import com.example.bookstoreproject.entity.UserData;
import lombok.Data;

@Data
public class UserRegisterResponseDTO {
    private String message;
    private String email;
    private String loginId;

    public UserRegisterResponseDTO(UserData userData,String message)
    {
        this.message=message;
        this.email=userData.getEmail();
        this.loginId=userData.getLoginId();
    }
}
