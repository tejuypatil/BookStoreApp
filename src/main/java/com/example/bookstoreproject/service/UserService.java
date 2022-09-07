package com.example.bookstoreproject.service;

import com.example.bookstoreproject.dto.UserRequestDTO;
import com.example.bookstoreproject.entity.UserData;
import com.example.bookstoreproject.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService implements IUserService{
    @Autowired
    public UserRepository userRepository;

    @Override
    public UserData getUserData(int userId) {
        Optional<UserData> userData = userRepository.findById(userId);
        return userData.get();
    }

    @Override
    public UserData addUserDetails(UserRequestDTO userRequestDTO, int userId) {
        UserData userData = new UserData(userRequestDTO);
        userData.setUserId(userId);
        return userRepository.save(userData);
    }

    @Override
    public UserData createUserDetails(UserRequestDTO userRequestDTO) {
        UserData userData = null;
        userData = new UserData(userRequestDTO);
        return userRepository.save(userData);
    }

    @Override
    public void deleteUserDataById(int userId) {
        UserData userData = this.getUserData(userId);
        userRepository.delete(userData);

    }
}
