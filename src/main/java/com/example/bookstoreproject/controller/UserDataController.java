package com.example.bookstoreproject.controller;

import com.example.bookstoreproject.dto.BookRequestDTO;
import com.example.bookstoreproject.dto.BookResponseDTO;
import com.example.bookstoreproject.dto.UserRequestDTO;
import com.example.bookstoreproject.dto.UserResponseDTO;
import com.example.bookstoreproject.entity.Book;
import com.example.bookstoreproject.entity.UserData;
import com.example.bookstoreproject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@RestController
public class UserDataController {
    @Autowired
    public UserService userService;
    @PostMapping("/userservice")
    public ResponseEntity<UserResponseDTO> createUserDetails(@RequestBody UserRequestDTO userRequestDTO){
        UserData userData = userService.createUserDetails(userRequestDTO);
        return new ResponseEntity<UserResponseDTO>(new UserResponseDTO("Inserted book data successfully",userData), HttpStatus.OK);
    }

    @GetMapping("userservice/{userId}")
    public ResponseEntity<UserResponseDTO> getUserById(@PathVariable("userId") int userId){
        UserData userData = userService.getUserData(userId);
        return new ResponseEntity<UserResponseDTO>(new UserResponseDTO("Get call for Id successful",userData),HttpStatus.OK);

    }
    @PutMapping("/userservice/{userId}")
    public ResponseEntity<UserResponseDTO> updateUserById(@PathVariable("userId")int userId,@RequestBody UserRequestDTO userRequestDTO){
        UserData userData = userService.addUserDetails(userRequestDTO,userId);
        return new ResponseEntity<UserResponseDTO>(new UserResponseDTO("Updated book data successfully",userData),HttpStatus.OK);
    }
    @DeleteMapping("/userservice/{userId}")
    public ResponseEntity<BookResponseDTO> deleteByBookId(@PathVariable("bookId") int bookId){
        userService.deleteUserDataById(bookId);
        return new ResponseEntity<BookResponseDTO>(new BookResponseDTO("Deleted successfully",bookId),HttpStatus.OK);
    }
}

