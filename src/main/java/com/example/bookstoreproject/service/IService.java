package com.example.bookstoreproject.service;

import java.util.List;

public interface IService {
    public List<Object> getAll();
    public Object create(Object inputDTO);
    public Object get(int id);
    public Object update(int id, Object inputDTO);
    public void delete(int id);
}
