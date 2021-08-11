package model.repository;

import model.bean.Customer;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CustomerRepositoryImpl implements ICustomerRepository{
    private static final String INSERT_CUSTOMER_SQL = "insert into customer (customer_id,customer_code," +
            "customer_type_id,customer_name,customer_birthday,customer_gender,\n" +
            "customer_id_card,customer_phone,customer_email,customer_address)\n" +
            "values(?,?,?,?,?,?,?,?,?,?);";
    BaseRepository baseRepository = new BaseRepository();

    @Override
    public void addNewCustomer(Customer customer) throws SQLException {
        System.out.println(INSERT_CUSTOMER_SQL);
        PreparedStatement preparedStatement = baseRepository.getConnection().prepareStatement(INSERT_CUSTOMER_SQL);
        preparedStatement.setInt(1,customer.getCustomerId());
        preparedStatement.setString(2,customer.getCustomerCode());
        preparedStatement.setInt(3,customer.getCustomerTypeId());
        preparedStatement.setString(4,customer.getCustomerName());
        preparedStatement.setString(5,customer.getCustomerBirthday());
        preparedStatement.setString(6,customer.getCustomerGender());
        preparedStatement.setString(7,customer.getCustomerIdCard());
        preparedStatement.setInt(8,customer.getCustomerPhone());
        preparedStatement.setString(9,customer.getCustomerEmail());
        preparedStatement.setString(10,customer.getCustomerAddress());

    }
}
