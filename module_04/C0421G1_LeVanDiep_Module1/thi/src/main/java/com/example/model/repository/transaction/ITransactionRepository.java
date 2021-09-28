package com.example.model.repository.transaction;

import com.example.model.entity.transaction.Transaction;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ITransactionRepository extends JpaRepository<Transaction, Long> {

    @Query(value = "select * from transaction tran join " +
            "customer c on tran.customer_name = c.customer_id where c.customer_name like :customerName " +
            "  and  + tran.rent_trading like :rentTrading",nativeQuery = true)
    Page<Transaction> search(Pageable pageable, @Param("customerName") String customerName,
                             @Param("rentTrading") String rentTrading);

    Optional<Transaction> findByTransactionCode(String transactionCode);

}