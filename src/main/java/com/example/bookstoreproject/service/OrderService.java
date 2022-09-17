package com.example.bookstoreproject.service;

import com.example.bookstoreproject.dto.OrderRequestDTO;
import com.example.bookstoreproject.entity.Book;
import com.example.bookstoreproject.entity.Order;
import com.example.bookstoreproject.entity.UserData;
import com.example.bookstoreproject.exception.InvalidTokenException;
import com.example.bookstoreproject.repository.BookRepository;
import com.example.bookstoreproject.repository.OrderRepository;
import com.example.bookstoreproject.repository.UserRepository;
import com.example.bookstoreproject.util.TokenUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;
@Service
public class OrderService implements IOrderService{

    @Autowired
    TokenUtility tokenUtility;

    @Autowired
    UserRepository userRepository;

    @Autowired
    OrderRepository orderRepository;

    @Autowired
    BookRepository bookRepository;
    @Override
    public Order createOrder(String token, OrderRequestDTO orderRequestDTO) {
        int userId= tokenUtility.decodeToken(token);
        Optional<UserData> optionalUserData = userRepository.findById(userId);
        if(optionalUserData.isPresent())
        {
            Order order = new Order(orderRequestDTO);
            UserData loggedInUserData = optionalUserData.get();
            order.setUser(loggedInUserData);
            order.setLocalDate(LocalDate.now());

            Book book=bookRepository.findById(order.getBook().getBookId()).get();
            order.setPrice(order.getQuantity() * book.getPrice());
            book.setQuantity( book.getQuantity()- order.getQuantity());
            bookRepository.save(book);
            order.setBook(book);
            return orderRepository.save(order);
        }
        else {
            throw new InvalidTokenException(token);
        }
    }

    @Override
    public Order getOrder(int orderId, String token) {
        int userId= tokenUtility.decodeToken(token);
        Optional<UserData> optionalUserData = userRepository.findById(userId);
        if(optionalUserData.isPresent())
        {
            return orderRepository.findById(orderId).get();
        }
        else {
            throw new InvalidTokenException(token);
        }
    }

    @Override
    public Order cancelOrder(int orderId,String token) {
        int userId= tokenUtility.decodeToken(token);
        Optional<UserData> optionalUserData = userRepository.findById(userId);
        if(optionalUserData.isPresent()) {
                Order order = new Order();
                order.setCanceled(true);
                Book book = bookRepository.findById(order.getBook().getBookId()).get();
                book.setQuantity(book.getQuantity() + order.getQuantity());
                bookRepository.save(book);
                order.setBook(book);
                return orderRepository.save(order);
        }
        else
        {
            throw new InvalidTokenException(token);
        }
    }
}
