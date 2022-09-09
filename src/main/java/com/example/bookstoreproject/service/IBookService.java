package com.example.bookstoreproject.service;

import com.example.bookstoreproject.dto.BookRequestDTO;
import com.example.bookstoreproject.entity.Book;

import java.util.List;

public interface IBookService {
    public List<Book> getAllBooks(String token);

    public Book createBook(String token,BookRequestDTO bookRequestDTO);

    public Book getBook(int bookId,String token);

    public Book updateBook(int bookId, BookRequestDTO bookRequestDTO,String token);

    public void deleteBook(int bookId,String token);

}
