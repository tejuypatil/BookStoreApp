package com.example.bookstoreproject.dto;

import com.example.bookstoreproject.entity.Book;
import com.example.bookstoreproject.entity.UserData;
import lombok.Data;

import java.util.List;

@Data
public class CartRequestDTO {
    private int quantity;
    private List<Integer> bookIds;
    private UserData userData;
}
