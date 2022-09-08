package com.example.bookstoreproject.entity;

import com.example.bookstoreproject.dto.BookRequestDTO;
import lombok.Data;

import javax.persistence.*;

import java.time.LocalDate;
@Entity
@Data
@Table(name = "Book")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int bookId;
    private String name;
    private String author;
    private int price;
    private LocalDate arrivalDate;
    private String coverImage;
    private int quantity;



    public Book(BookRequestDTO bookRequestDTO) {
        this.name = bookRequestDTO.name;
        this.author = bookRequestDTO.author;
    }
    public Book()
    {

    }
}
