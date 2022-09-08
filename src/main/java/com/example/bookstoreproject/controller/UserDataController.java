package com.example.bookstoreproject.controller;

import com.example.bookstoreproject.dto.UserLoginRequestDTO;
import com.example.bookstoreproject.dto.UserLoginResponseDTO;
import com.example.bookstoreproject.dto.UserRegisterRequestDTO;
import com.example.bookstoreproject.dto.UserRegisterResponseDTO;
import com.example.bookstoreproject.entity.UserData;
import com.example.bookstoreproject.service.UserService;
import com.example.bookstoreproject.util.TokenUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@RestController
public class UserDataController {
    @Autowired
    public UserService userService;

    @Autowired
    TokenUtility tokenUtility;

    @PostMapping("/userservice/register")
    public ResponseEntity<UserRegisterResponseDTO> registerUser(@RequestBody UserRegisterRequestDTO userRegisterRequestDTO) {
        UserData userData=userService.registerUser(userRegisterRequestDTO);
        UserRegisterResponseDTO userRegisterResponseDTO=new UserRegisterResponseDTO(userData,"User registered successfully");
        return new ResponseEntity<UserRegisterResponseDTO>(userRegisterResponseDTO, HttpStatus.OK);
    }

    @PostMapping("userservice/login")
    public ResponseEntity<UserLoginResponseDTO> loginUser(@RequestBody UserLoginRequestDTO userLoginRequestDTO) {
        String token = userService.login(userLoginRequestDTO);
        return new ResponseEntity<UserLoginResponseDTO>(new UserLoginResponseDTO("Token Generated",token),HttpStatus.OK);
    }
}

