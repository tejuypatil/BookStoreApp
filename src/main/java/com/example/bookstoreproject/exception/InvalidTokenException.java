package com.example.bookstoreproject.exception;

public class InvalidTokenException extends RuntimeException{
    public InvalidTokenException(String token){
        super("Invalid Token:   "+token);
    }
}
