package model.repository;

import model.bean.Customer;

import java.sql.SQLException;

public interface ICustomerRepository {
    void addNewCustomer(Customer customer) throws SQLException;
}
