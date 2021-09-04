package com.example.demo.model.service;

import com.example.demo.model.bean.Customer;
import com.example.demo.model.repository.ICustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CustomerServiceImpl implements ICustomerService {
    @Autowired
    private ICustomerRepository iCustomerRepository;
    @Override
    public List<Customer> findAll() {
        return this.iCustomerRepository.findAll();
    }

    @Override
    public void insertWithStoredProcedure(String firstName, String lastName) {
        this.iCustomerRepository.insertWithStoredProcedure(firstName,lastName);

    }
}
