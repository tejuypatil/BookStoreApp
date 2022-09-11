package com.example.bookstoreproject.service;

import com.example.bookstoreproject.dto.BookRequestDTO;
import com.example.bookstoreproject.dto.OrderRequestDTO;
import com.example.bookstoreproject.entity.Book;
import com.example.bookstoreproject.entity.Order;

public interface IOrderService {

    public Order createOrder(String token, OrderRequestDTO orderRequestDTO);

    Order getOrder(int orderId, String token);
}
