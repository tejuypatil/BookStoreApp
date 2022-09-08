package com.example.bookstoreproject.dto;

public class ExceptionResponse {
    public String errorMessage;

    public ExceptionResponse(String message) {
        this.errorMessage = message;
    }
}
