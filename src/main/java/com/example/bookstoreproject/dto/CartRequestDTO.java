package com.example.bookstoreproject.dto;

import com.example.bookstoreproject.entity.Book;
import lombok.Data;

import java.util.List;

@Data
public class CartRequestDTO {
    private int quantity;
    private List<Integer> bookIds;
}
