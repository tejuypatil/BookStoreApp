package com.example.bookstoreproject.service;

import com.example.bookstoreproject.entity.Cart;

import java.util.List;

public interface ICartService {
    Cart addBookToCart(Long bookId, Integer order_quantity, long userId);

    String updateOrderQuantity(Long bookId, Integer orderQuantity);

    Cart addBookToCart(int bookId, Integer order_quantity, long userId);

    Cart addBookToCart(int bookId, Integer order_quantity, int userId);

    String updateOrderQuantity(int bookId, Integer orderQuantity);

    public List<Cart> listCartItems(long userId);

    void removeProduct(Long bookId,long userId);

    void removeProduct(int bookId, int userId);
}
