package com.example.bookstoreproject.service;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class BookService implements IService {
    @Autowired
    public BookService bookService;
    @Override
    public List<Object> getAll()
    {
        return null;
    }

    @Override
    public Object create(Object inputDTO) {
        return null;
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
