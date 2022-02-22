package com.example.webfastfood.service.impl;

import com.example.webfastfood.entity.customer.Customer;
import com.example.webfastfood.repository.ICustomeRepository;
import com.example.webfastfood.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ICustomerServiceImpl implements ICustomerService {
    @Autowired
    ICustomeRepository customerRepository;

    @Override
    public Customer getInfoCustomer(String username) {
        return customerRepository.getInfoCustomer(username);
    }
}
