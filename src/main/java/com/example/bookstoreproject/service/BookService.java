package com.example.bookstoreproject.service;

import com.example.bookstoreproject.dto.BookRequestDTO;
import com.example.bookstoreproject.entity.Book;
import com.example.bookstoreproject.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class BookService implements IService {
    @Autowired
    public BookRepository bookRepository;
    @Override
    public List<Object> getAll()
    {
        List<Object> bookList = bookRepository.findAll();
        if (bookList.isEmpty()){
            return null;
        }
        return bookList;
    }

    @Override
    public Object create(Object inputDTO) {
        Book book = null;
        book = new Book((BookRequestDTO) inputDTO);
        return bookRepository.save(book);
    }

    @Override
    public Object get(int id) {
        return null;
    }

    @Override
    public Object update(int id, Object inputDTO) {
        return null;
    }

    @Override
    public void delete(int id) {

    }
}
