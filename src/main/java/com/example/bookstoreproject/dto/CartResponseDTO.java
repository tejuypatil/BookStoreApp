package com.example.bookstoreproject.dto;

import com.example.bookstoreproject.entity.Cart;
import lombok.Data;

@Data
public class CartResponseDTO {
    public String message;
    public Cart cart;
    public CartResponseDTO(String message, Cart cart) {
        this.message = message;
        this.cart= cart;
    }


}
