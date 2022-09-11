package com.example.bookstoreproject.service;
import com.example.bookstoreproject.dto.CartRequestDTO;
import com.example.bookstoreproject.entity.Cart;
import com.example.bookstoreproject.entity.UserData;
import com.example.bookstoreproject.exception.InvalidTokenException;
import com.example.bookstoreproject.repository.CartRepository;
import com.example.bookstoreproject.repository.UserRepository;
import com.example.bookstoreproject.util.TokenUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CartService implements ICartService {
    @Autowired
    private CartRepository cartRepository;

    @Autowired
    TokenUtility tokenUtility;
    @Autowired
    UserRepository userRepository;
    @Override
    public Cart createCart(String token,CartRequestDTO cartRequestDTO) {
        int userId= tokenUtility.decodeToken(token);
        Optional<UserData> optionalUserData = userRepository.findById(userId);
        if(optionalUserData.isPresent())
        {
            Cart cart =new Cart(cartRequestDTO);
            UserData loggedInUserData = optionalUserData.get();
            cart.setUserData(loggedInUserData);
            return cartRepository.save(cart);
        }
        else {
            throw new InvalidTokenException(token);
        }
    }

    @Override
    public Cart getCart(int cartId,String token) {
        int userId= tokenUtility.decodeToken(token);
        Optional<UserData> optionalUserData = userRepository.findById(userId);
        if(optionalUserData.isPresent())
        {
            return cartRepository.findById(cartId).get();
        }
        else {
            throw new InvalidTokenException(token);
        }
    }

    @Override
    public Cart updateCart(int cartId, CartRequestDTO cartRequestDTO,String token) {
        int userId= tokenUtility.decodeToken(token);
        Optional<UserData> optionalUserData = userRepository.findById(userId);
        if(optionalUserData.isPresent())
        {
            Cart cart=cartRepository.getReferenceById(cartId);
            cart.setQuantity(cartRequestDTO.getQuantity());
            cart.setBookIds(cartRequestDTO.getBookIds());
            return cartRepository.save(cart);
        }
        else {
            throw new InvalidTokenException(token);
        }
    }

    @Override
    public void deleteCart(int cartId,String token) {
        int userId= tokenUtility.decodeToken(token);
        Optional<UserData> optionalUserData = userRepository.findById(userId);
        if(optionalUserData.isPresent())
        {
            cartRepository.deleteById(cartId);
        }
        else {
            throw new InvalidTokenException(token);
        }
    }
}
