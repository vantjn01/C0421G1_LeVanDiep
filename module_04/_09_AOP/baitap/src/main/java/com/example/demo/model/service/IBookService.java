package com.example.demo.model.service;

import com.example.demo.model.bean.Book;

import java.util.List;

public interface IBookService {
    List<Book> findAll();

    void save(Book book);

    Book findById(Integer id);

    void delete(Integer id);
}
