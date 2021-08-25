package code.codegym.service;

import code.codegym.model.Customer;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


public class CustomerServiceImpl implements CustomerService{
    private static final Map<Integer, Customer> customers;

    @Override
    public List<Customer> findAll() {
        return null;
    }

    @Override
    public void save(Customer customer) {

    }

    @Override
    public Customer findById(int id) {
        return null;
    }

    @Override
    public void update(int id, Customer customer) {

    }

    @Override
    public void remove(int id) {

    }
}
