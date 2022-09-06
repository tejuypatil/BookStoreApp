package com.example.bookstoreproject.entity;

import java.time.LocalDate;

public class Book {
    private String name;
    private String author;
    private int price;
    private LocalDate arrivalDate;
    private  String coverImage;
    private int quantity;

    public Book(String name, String author, int price, LocalDate arrivalDate, String coverImage, int quantity) {
        this.name = name;
        this.author = author;
        this.price = price;
        this.arrivalDate = arrivalDate;
        this.coverImage = coverImage;
        this.quantity = quantity;
    }
}
