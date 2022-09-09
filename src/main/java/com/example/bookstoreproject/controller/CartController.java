package com.example.bookstoreproject.controller;

import com.example.bookstoreproject.dto.CartRequestDTO;
import com.example.bookstoreproject.dto.CartResponseDTO;
import com.example.bookstoreproject.entity.Book;
import com.example.bookstoreproject.entity.Cart;
import com.example.bookstoreproject.service.ICartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class CartController {
    @Autowired
    ICartService cartService;
    @PostMapping("/cartservice")
    public ResponseEntity<CartResponseDTO> createBookData(@RequestBody CartRequestDTO cartRequestDTO,@RequestHeader(name = "Authorization")String token){
        Cart cart = cartService.createCart(token,cartRequestDTO);
        return new ResponseEntity<CartResponseDTO>(new CartResponseDTO("Inserted Cart data successfully",cart), HttpStatus.OK);
    }

    @GetMapping("cartservice/{cartId}")
    public ResponseEntity<CartResponseDTO> getBookById(@PathVariable("cartId") int cartId,@RequestHeader(name = "Authorization")String token){
        Cart cart = cartService.getCart(cartId,token);
        return new ResponseEntity<CartResponseDTO>(new CartResponseDTO("Get call for Id successful",cart),HttpStatus.OK);

    }
    @PutMapping("/cartservice/{cartId}")
    public ResponseEntity<CartResponseDTO> updateBookById(@PathVariable("cartId")int cartId,@RequestBody CartRequestDTO cartRequestDTO,@RequestHeader(name = "Authorization")String token){
        Cart cart = cartService.updateCart(cartId,cartRequestDTO,token);
        return new ResponseEntity<CartResponseDTO>(new CartResponseDTO("Updated Cart data successfully",cart),HttpStatus.OK);
    }
    @DeleteMapping("/cartservice/{cartId}")
    public ResponseEntity<CartResponseDTO> deleteByBookId(@PathVariable("cartId") int cartId,@RequestHeader(name = "Authorization")String token){
        cartService.deleteCart(cartId,token);
        return new ResponseEntity<CartResponseDTO>(new CartResponseDTO("Deleted successfully",null),HttpStatus.OK);
    }
}

