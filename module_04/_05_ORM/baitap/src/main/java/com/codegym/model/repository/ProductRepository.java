package com.codegym.model.repository;

import com.codegym.model.bean.Product;

import java.util.List;

public interface ProductRepository {
    List<Product> findAll();

    void save(Product product);

    Product findById(int id);

    void update( Product product);

    void remove(int id);

    List<Product> searchByName(String name);
}
