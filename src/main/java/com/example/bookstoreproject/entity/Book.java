package com.example.bookstoreproject.entity;

import com.example.bookstoreproject.dto.BookRequestDTO;
import lombok.Data;

import javax.persistence.*;

import java.time.LocalDate;
@Entity
@Data
@Table(name = "Book")
public class Book{
    private String name;
    private String author;
    private int price;
    private LocalDate arrivalDate;
    private  String coverImage;
    private int quantity;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    public Book(BookRequestDTO bookRequestDTO) {
        this.updateBook(bookRequestDTO);
    }

    public Book() {

    }

    public void updateBook(BookRequestDTO bookRequestDTO) {
        this.name = bookRequestDTO.name;
        this.author = bookRequestDTO.author;

    }
}
