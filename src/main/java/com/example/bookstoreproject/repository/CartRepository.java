package com.example.bookstoreproject.repository;

import com.example.bookstoreproject.entity.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CartRepository extends JpaRepository<Cart,Integer> {
    Cart findByUserIdAndBookId(long userId, int bookId);

    void updateOrderQuantity(int order_quantity, int bookId);

    List<Cart> findByUserId(long userId);

    void deleteByUserAndBook(int userId, int bookId);
}
