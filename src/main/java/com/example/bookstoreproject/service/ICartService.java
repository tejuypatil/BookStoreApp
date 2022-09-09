package com.example.bookstoreproject.service;

import com.example.bookstoreproject.dto.CartRequestDTO;
import com.example.bookstoreproject.entity.Cart;

import java.util.List;

public interface ICartService {


    Cart createCart(String token,CartRequestDTO cartRequestDTO);

    Cart getCart(int cartId,String token);

    Cart updateCart(int cartId, CartRequestDTO cartRequestDTO,String token);

    void deleteCart(int bookId,String token);
}
