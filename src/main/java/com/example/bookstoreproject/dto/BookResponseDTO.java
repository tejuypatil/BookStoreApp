package com.example.bookstoreproject.dto;

import com.example.bookstoreproject.entity.Book;

public class BookResponseDTO {
    public int bookId;
    public String message;
    public Book book;
    public BookResponseDTO(String message, Book book) {
        this.message = message;
        this.book= book;
    }

    public BookResponseDTO(String message, int bookId) {
        this.message = message;
        this.bookId = bookId;
    }


}
