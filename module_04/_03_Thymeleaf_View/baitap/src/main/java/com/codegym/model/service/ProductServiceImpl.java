package com.codegym.model.service;

import com.codegym.model.bean.Product;
import com.codegym.model.service.ProductService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductServiceImpl implements ProductService {
    private static final Map<Integer, Product> products;
    static {
        products = new HashMap<>();
        products.put(1, new Product(1,"Fish",1000, "Tươi", "QT"));
        products.put(2, new Product(2, "Crab", 2000, "Chết", "Danang"));
        products.put(3, new Product(3, "muc", 3000,"Sống", "Saigon"));
        products.put(4, new Product(4, "oc chó", 4000,"Chết", "Beijin"));
        products.put(5, new Product(5, "Ghẹ",5000, "Sống", "Miami"));

    }
    @Override
    public List<Product> findAll() {
        return new ArrayList<>(products.values());
    }

    @Override
    public void save(Product product) {
        products.put(product.getId(), product);

    }

    @Override
    public Product findById(int id) {
        return products.get(id);
    }

    @Override
    public void update(int id, Product product) {
        products.put(id, product);

    }

    @Override
    public void remove(int id) {
        products.remove(id);

    }

    @Override
    public List<Product> searchByName(String name) {
        return this.searchByName(name);
    }
}
