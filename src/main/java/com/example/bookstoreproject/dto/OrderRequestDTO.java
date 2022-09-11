package com.example.bookstoreproject.dto;

import com.example.bookstoreproject.entity.Book;
import lombok.Data;


@Data
public class OrderRequestDTO {
    private int quantity;
    private  String address;
    private Book book;
}
