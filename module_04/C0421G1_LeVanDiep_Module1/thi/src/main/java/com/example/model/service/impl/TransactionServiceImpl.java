package com.example.model.service.impl;

import com.example.model.entity.transaction.Customer;
import com.example.model.entity.transaction.Transaction;
import com.example.model.repository.transaction.ICustomerRepository;
import com.example.model.repository.transaction.ITransactionRepository;
import com.example.model.service.ITransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;
@Service
public class TransactionServiceImpl implements ITransactionService {
    @Autowired
    private ITransactionRepository transactionRepository;
    @Autowired
    private ICustomerRepository customerRepository;

    @Override
    public Page<Transaction> search(Pageable pageable ,String customerName, String rentTrading) {
        return transactionRepository.search(pageable, "%" + customerName + "%", "%" + rentTrading + "%");
    }

    @Override
    public Optional<Transaction> findByTransactionCode(String transactionCode) {
        return transactionRepository.findByTransactionCode(transactionCode);
    }

    @Override
    public Optional<Transaction> findById(Long id) {
        return transactionRepository.findById(id);
    }



    @Override
    public void save(Transaction transaction) {
         transactionRepository.save(transaction);
    }

    @Override
    public void remove(Long id) {
       transactionRepository.deleteById(id);
    }

    @Override
    public List<Customer> findAllCustomer() {
        return customerRepository.findAll();
    }
}
