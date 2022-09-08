package com.example.bookstoreproject.service;

import com.example.bookstoreproject.dto.CartRequestDTO;
import com.example.bookstoreproject.entity.Book;
import com.example.bookstoreproject.entity.Cart;
import com.example.bookstoreproject.repository.BookRepository;
import com.example.bookstoreproject.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartService implements ICartService {
    @Autowired
    private CartRepository cartRepository;


    @Override
    public Cart createCart(CartRequestDTO cartRequestDTO) {
        Cart cart =new Cart(cartRequestDTO);
        return cartRepository.save(cart);
    }

    @Override
    public Cart getCart(int cartId) {
        return cartRepository.findById(cartId).get();
    }

    @Override
    public Cart updateCart(int cartId, CartRequestDTO cartRequestDTO) {
        Cart cart=cartRepository.getReferenceById(cartId);
        cart.setQuantity(cartRequestDTO.getQuantity());
        cart.setBookIds(cartRequestDTO.getBookIds());
        return cartRepository.save(cart);
    }

    @Override
    public void deleteCart(int cartId) {

        cartRepository.deleteById(cartId);
    }
}
