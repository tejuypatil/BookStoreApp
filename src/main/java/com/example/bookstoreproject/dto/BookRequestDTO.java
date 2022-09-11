package com.example.bookstoreproject.dto;

import lombok.Data;

@Data

public class BookRequestDTO {
    public String name;
    public String author;
    public int price;
    public int quantity;

}
