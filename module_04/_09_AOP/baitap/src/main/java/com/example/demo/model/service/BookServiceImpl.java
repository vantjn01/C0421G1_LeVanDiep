package com.example.demo.model.service;

import com.example.demo.model.bean.Book;
import com.example.demo.model.repository.IBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class BookServiceImpl implements IBookService{
    @Autowired
    private IBookRepository iBookRepository;
    @Override
    public List<Book> findAll() {
        return this.iBookRepository.findAll();
    }

    @Override
    public void save(Book book) {
        this.iBookRepository.save(book);

    }

    @Override
    public Book findById(Integer id) {
        return this.iBookRepository.findById(id).get();
    }

    @Override
    public void delete(Integer id) {
        this.iBookRepository.deleteById(id);

    }


}



