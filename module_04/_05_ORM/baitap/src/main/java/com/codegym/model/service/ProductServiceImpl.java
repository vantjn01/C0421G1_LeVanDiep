package com.codegym.model.service;

import com.codegym.model.bean.Product;
import com.codegym.model.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<Product> findAll() {
        return this.productRepository.findAll();
    }

    @Override
    public void save(Product product) {
        this.productRepository.save(product);

    }

    @Override
    public Product findById(int id) {
       return productRepository.findById(id);
    }

    @Override
    public void update( Product product) {
        this.productRepository.update(product);

    }

    @Override
    public void remove(int id) {
        this.productRepository.remove(id);

    }

    @Override
    public List<Product> searchByName(String name) {
        return this.productRepository.searchByName(name);
    }
}
