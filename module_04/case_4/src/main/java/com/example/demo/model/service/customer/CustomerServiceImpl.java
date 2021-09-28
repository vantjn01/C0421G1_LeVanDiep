package com.example.demo.model.service.customer;

import com.example.demo.model.entity.Customer;
import com.example.demo.model.repository.customer.ICustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements ICustomerService{
    @Autowired
    private ICustomerRepository customerRepository;

    @Override
    public Customer findByCustomerId(Long id) {
        return customerRepository.findByCustomerId(id);
    }

    @Override
    public Page<Customer> findAllByCustomerNameContaining(Pageable pageable, String name) {
        return customerRepository.findAllByCustomerNameContaining(pageable, "%"+name+"%");
    }

    @Override
    public void save(Customer customer) {
        customerRepository.save(customer);
    }

    @Override
    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    @Override
    public Page<Customer> findAllCustomerUserService(Pageable pageable, String name) {
        return customerRepository.findAllCustomerUserService(pageable,"%"+name+"%");
    }

    @Override
    public void delete(Customer customer) {
        this.customerRepository.delete(customer);
    }
}
