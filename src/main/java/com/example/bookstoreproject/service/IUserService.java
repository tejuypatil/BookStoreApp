package com.example.bookstoreproject.service;

import com.example.bookstoreproject.dto.UserRequestDTO;
import com.example.bookstoreproject.entity.UserData;

public interface IUserService {
    UserData getUserData(int userId);
    UserData addUserDetails(UserRequestDTO userRequstDTO, int userId);

    UserData createUserDetails(UserRequestDTO userRequestDTO);
    void deleteUserDataById(int userId);
}
