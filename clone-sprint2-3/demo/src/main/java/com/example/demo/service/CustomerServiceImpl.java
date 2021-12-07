package com.example.demo.service;

import com.example.demo.entity.Customer;
import com.example.demo.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl  implements CustomerService {
    @Autowired
    CustomerRepository customerRepository;

    @Override
    public Customer getInfoCustomer(String username) {
        return customerRepository.getInfoCustomer(username);
    }
}

