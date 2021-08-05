package model.service;

import model.bean.Product;
import model.repository.IProductRepository;
import model.repository.ProductRepository;
import model.service.IProductService;

import java.util.List;


public class ProductServiceImpl implements IProductService {

    private IProductRepository iProductRepository = new ProductRepository();

    @Override
    public List<Product> findAll() {
        return this.iProductRepository.findAll();
    }

    @Override
    public void save(Product product) {
        this.iProductRepository.save(product);
    }

    @Override
    public Product findByName(String name) {
        return this.iProductRepository.findByName(name);
    }

    @Override
    public void update(int id, Product product) {
        this.iProductRepository.update(id, product);
    }

    @Override
    public void remove(int id) {
        this.iProductRepository.remove(id);
    }

    @Override
    public Product findById(int id) {
        return this.iProductRepository.findById(id);
    }
}