package com.example.bookstoreproject.service;

import com.example.bookstoreproject.dto.BookRequestDTO;
import com.example.bookstoreproject.entity.Book;

import java.util.List;

public interface IBookService {
    public List<Book> getAllBooks();

    public Book createBook(String token,BookRequestDTO bookRequestDTO);

    public Book getBook(int bookId);

    public Book updateBook(int bookId, BookRequestDTO bookRequestDTO);

    public void deleteBook(int bookId);

}
