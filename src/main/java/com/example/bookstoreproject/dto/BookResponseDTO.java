package com.example.bookstoreproject.dto;

import com.example.bookstoreproject.entity.Book;
import lombok.Data;


public class BookResponseDTO {
    public String message;
    public Book book;
    public BookResponseDTO(String message, Book book) {
        this.message = message;
        this.book= book;
    }

    public BookResponseDTO(String message) {
        this.message = message;
    }


}
