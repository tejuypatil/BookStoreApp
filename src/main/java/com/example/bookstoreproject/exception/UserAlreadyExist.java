package com.example.bookstoreproject.exception;

import com.example.bookstoreproject.dto.UserRegisterRequestDTO;
import com.example.bookstoreproject.entity.UserData;

public class UserAlreadyExist extends RuntimeException{
    public UserAlreadyExist(UserRegisterRequestDTO userRegisterRequestDTO)
    {
        super("User "+userRegisterRequestDTO.getEmail()+" already exists");
    }
}
