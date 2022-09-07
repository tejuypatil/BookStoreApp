package com.example.bookstoreproject.service;

import com.example.bookstoreproject.dto.BookRequestDTO;
import com.example.bookstoreproject.entity.Book;
import com.example.bookstoreproject.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class BookService implements IBookService {
    @Autowired
    public BookRepository bookRepository;
    @Override
    public List<Book> getAllBooks()
    {
        List<Book> bookList = bookRepository.findAll();
        if (bookList.isEmpty()){
            return null;
        }
        return bookList;
    }

    @Override
    public Book createBook(BookRequestDTO bookRequestDTO) {
        Book book =null;
        book = new Book(bookRequestDTO);
        return bookRepository.save(book);
    }

    @Override
    public Book getBook(int bookId) {
        return bookRepository.findById(bookId).orElse(null);
    }

    @Override
    public Book updateBook(int bookId, BookRequestDTO bookRequestDTO) {
        Book book = this.getBook(bookId);
        book.updateBook(bookRequestDTO);
        return bookRepository.save(book);
    }
    @Override
    public void deleteBook(int bookId) {
        Book book = this.getBook(bookId);
        bookRepository.delete(book);

    }
}
