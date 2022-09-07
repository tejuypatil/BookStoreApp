package com.example.bookstoreproject.service;

import com.example.bookstoreproject.entity.Book;
import com.example.bookstoreproject.entity.Cart;
import com.example.bookstoreproject.repository.BookRepository;
import com.example.bookstoreproject.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class CartService implements ICartService {
    @Autowired
    private CartRepository cartRepository;
    @Autowired
    private BookRepository bookRepository;
    private int order_quantity;


    @Override
    public Cart addBookToCart(Long bookId, Integer order_quantity, long userId) {
        return null;
    }

    @Override
    public String updateOrderQuantity(Long bookId, Integer orderQuantity) {
        return null;
    }

    @Override
    public Cart addBookToCart(int bookId, Integer order_quantity, long userId) {
        return null;
    }

    @Override
    public Cart addBookToCart(int bookId, Integer order_quantity, int userId) {

        Book book = bookRepository.findById(bookId).orElse(null);
        if (book == null || book.getQuantity() == 0)
            return null;
        else {


            Cart cartItem = cartRepository.findByUserIdAndBookId(userId, bookId);

            if (cartItem != null) {
                cartItem.setOrderQuantity(order_quantity);
            } else {
                cartItem = new Cart();
                cartItem.setOrderQuantity(order_quantity);

                cartItem.setBook(book);
                bookRepository.updateQuantityAfterOrder(book.getQuantity() - order_quantity, bookId);

            }
            cartRepository.save(cartItem);
            return cartItem;
        }
    }

    @Override
    public String updateOrderQuantity(int bookId, Integer orderQuantity) {
        //Long userId = JwtGenerator.decodeJWT(token);
        Book book = bookRepository.findById(bookId).orElse(null);
        if (book == null)
            return null;
        else {
            double subtotal = 0;

            if (book.getQuantity() >= order_quantity) {
                cartRepository.updateOrderQuantity(order_quantity, bookId);
                subtotal = book.getPrice() * order_quantity;
                bookRepository.updateQuantityAfterOrder(book.getQuantity() - order_quantity+1, bookId);
                return String.valueOf(subtotal);
            } else {
                return "Last "+book.getQuantity()+" are left.";
            }
        }
    }

    @Override
    public List<Cart> listCartItems(long userId) {
        return cartRepository.findByUserId(userId);
    }

    @Override
    public void removeProduct(Long bookId, long userId) {

    }

    @Override
    public void removeProduct(int bookId, int userId) {
        Book book = bookRepository.findById(bookId).orElse(null);
        if (book == null)
            return ;
        Cart cartItem = cartRepository.findByUserIdAndBookId(userId, bookId);
        bookRepository.updateQuantityAfterOrder(book.getQuantity() + cartItem.getOrderQuantity(), bookId);
        cartRepository.deleteByUserAndBook(userId, bookId);
    }
}
