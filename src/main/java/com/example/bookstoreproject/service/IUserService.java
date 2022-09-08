package com.example.bookstoreproject.service;


import com.example.bookstoreproject.dto.UserLoginRequestDTO;
import com.example.bookstoreproject.dto.UserRegisterRequestDTO;
import com.example.bookstoreproject.entity.UserData;

public interface IUserService
{

    UserData registerUser(UserRegisterRequestDTO userRegisterRequestDTO);

    String login(UserLoginRequestDTO userLoginRequestDTO);
}
