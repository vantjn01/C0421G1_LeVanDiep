package model.service;

import model.bean.Customer;
import model.repository.CustomerRepositoryImpl;
import model.repository.ICustomerRepository;

import java.sql.SQLException;

public class CustomerServiceImpl implements ICustomerService{
    ICustomerRepository iCustomerRepository = new CustomerRepositoryImpl();
        @Override
        public void addNewCustomer(Customer customer) throws SQLException {
            this.iCustomerRepository.addNewCustomer(customer);

        }
    }



