package com.example.bookstoreproject.exception;

import com.example.bookstoreproject.dto.ExceptionResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class BookStoreExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<ExceptionResponse> userAlreadyExists(UserAlreadyExist userAlreadyExist)
    {
        ExceptionResponse exceptionResponse = new ExceptionResponse(userAlreadyExist.getMessage());
        return new ResponseEntity<ExceptionResponse>(exceptionResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler
    public ResponseEntity<ExceptionResponse> userOrPasswordWrong(UserOrPasswordWrong userOrPasswordWrong){
        ExceptionResponse exceptionResponse = new ExceptionResponse(userOrPasswordWrong.getMessage());
        return new ResponseEntity<ExceptionResponse>(exceptionResponse,HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler
    public ResponseEntity<ExceptionResponse> invalidTokenException(InvalidTokenException invalidTokenException){
        ExceptionResponse exceptionResponse = new ExceptionResponse(invalidTokenException.getMessage());
        return new ResponseEntity<ExceptionResponse>(exceptionResponse,HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler
    public ResponseEntity<ExceptionResponse> userIsNotAdmin(UserIsNotAdmin userIsNotAdmin){
        ExceptionResponse exceptionResponse = new ExceptionResponse(userIsNotAdmin.getMessage());
        return new ResponseEntity<ExceptionResponse>(exceptionResponse,HttpStatus.BAD_REQUEST);
    }
}

