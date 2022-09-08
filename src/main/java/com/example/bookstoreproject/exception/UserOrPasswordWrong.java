package com.example.bookstoreproject.exception;

public class UserOrPasswordWrong extends RuntimeException{
    public UserOrPasswordWrong(String loginId) {
        super("Login id or password is wrong. Given "+loginId+" as login id");
    }
}
