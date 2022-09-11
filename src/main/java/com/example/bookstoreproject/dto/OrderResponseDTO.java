package com.example.bookstoreproject.dto;

import com.example.bookstoreproject.entity.Order;

public class OrderResponseDTO {
    public String message;
    public Order order;
    public OrderResponseDTO(String message, Order order) {
        this.message = message;
        this.order= order;
    }
}
