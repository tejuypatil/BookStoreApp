package com.example.bookstoreproject.service;

import com.example.bookstoreproject.dto.UserRequestDTO;
import com.example.bookstoreproject.entity.UserData;

public interface IUserService {
    UserData getUserData(int userId);

    UserData addUserData(UserRequestDTO userRequstDTO, int userId);

    UserData createUserData(UserRequestDTO userRequestDTO);

    void deleteUserData(int userId);
}
