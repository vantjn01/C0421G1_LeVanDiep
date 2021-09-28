package com.example.model.service;

import com.example.model.entity.transaction.Transaction;
import com.example.model.entity.transaction.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface ITransactionService {


    Page<Transaction> search(Pageable pageable, @Param("customerName") String customerName, @Param("rentTrading") String rentTrading);

    Optional<Transaction> findByTransactionCode(String transactionCode);

    Optional<Transaction> findById(Long id);

    void save(Transaction transaction);

    void remove(Long id);

    List<Customer> findAllCustomer();

}