package com.example.bookstoreproject.entity;

import com.example.bookstoreproject.dto.BookRequestDTO;

import java.time.LocalDate;

public class Book {
    private String name;
    private String author;
    private int price;
    private LocalDate arrivalDate;
    private  String coverImage;
    private int quantity;
    public Book(BookRequestDTO bookRequestDTO) {
        this.name = bookRequestDTO.name;
    }
}
