package model.service;

import model.bean.Customer;

import java.sql.SQLException;

public interface ICustomerService {
    void addNewCustomer(Customer customer) throws SQLException;
}
