package com.example.bookstoreproject.exception;

public class UserIsNotAdmin extends RuntimeException{
    public UserIsNotAdmin()
    {
        super("User is not Admin");
    }
}
