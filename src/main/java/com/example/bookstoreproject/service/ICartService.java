package com.example.bookstoreproject.service;

import com.example.bookstoreproject.dto.CartRequestDTO;
import com.example.bookstoreproject.entity.Cart;

import java.util.List;

public interface ICartService {


    Cart createCart(CartRequestDTO cartRequestDTO);

    Cart getCart(int cartId);

    Cart updateCart(int cartId, CartRequestDTO cartRequestDTO);

    void deleteCart(int bookId);
}
