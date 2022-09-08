package com.example.bookstoreproject.service;

import com.example.bookstoreproject.dto.UserRequestDTO;
import com.example.bookstoreproject.email.EmailService;
import com.example.bookstoreproject.entity.UserData;
import com.example.bookstoreproject.repository.UserRepository;
import com.example.bookstoreproject.util.TokenUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService implements IUserService{
    @Autowired
    public UserRepository userRepository;

    @Autowired
    EmailService emailService;

    @Override
    public UserData getUserData(int userId) {
        Optional<UserData> userData = userRepository.findById(userId);
        return userData.get();
    }

    @Override
    public UserData addUserData(UserRequestDTO userRequestDTO, int userId) {
        UserData userData = new UserData(userRequestDTO);
        userData.setUserId(userId);
        return userRepository.save(userData);
    }

    @Override
    public UserData createUserData(UserRequestDTO userRequestDTO) {
        UserData userData = new UserData(userRequestDTO);
        userRepository.save(userData);
        emailService.sendEmail(userRequestDTO.getEmail(),"User created","successfully signup");
        return userData;
    }

    @Override
    public void deleteUserData(int userId) {
        UserData userData = this.getUserData(userId);
        userRepository.delete(userData);

    }
}
