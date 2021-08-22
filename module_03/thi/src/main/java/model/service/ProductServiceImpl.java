package model.service;

import model.bean.Product;
import model.repository.IProductRepository;
import model.repository.impl.ProductRepositoryImpl;

import java.sql.SQLException;
import java.util.List;

public class ProductServiceImpl implements IProductService{

    IProductRepository iProductRepository = new ProductRepositoryImpl();
    @Override
    public void addNew(Product product) throws SQLException {
this.iProductRepository.addNew(product);
    }

    @Override
    public Product selectProduct(int id) {
        return this.iProductRepository.selectProduct(id);
    }

    @Override
    public List<Product> selectAll() {
        return this.iProductRepository.selectAll();
    }

    @Override
    public boolean deleteProduct(int id) throws SQLException {
        return false;
    }

    @Override
    public boolean updateProduct(Product product) throws SQLException {
        return false;
    }

    @Override
    public List<Product> searchByName(String name, String address) throws SQLException {
        return null;
    }
}
