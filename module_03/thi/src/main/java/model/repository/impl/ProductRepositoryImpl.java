package model.repository.impl;

import model.bean.Product;
import model.repository.IProductRepository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductRepositoryImpl implements IProductRepository {
    private static final String INSERT_PRODUCT_SQL = "INSERT INTO product" + "  (id," +
            " product_name, price, quantity, color, " +
            "category) VALUES " +
            " (?, ?, ?, ?, ?, ?);";
    private static final String SELECT_ALL_PRODUCT = "select * from product";
    private static final String SELECT_PRODUCT_BY_ID = "select id,product_name,price,quantity,color,category from product where id =?";
    BaseRepository baseRepository = new BaseRepository();

    private void printSQLException(SQLException ex) {
        for (Throwable e : ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }


    @Override
    public void addNew(Product product) throws SQLException {
        System.out.println(INSERT_PRODUCT_SQL);
        try {
            PreparedStatement preparedStatement = baseRepository.getConnection().prepareStatement(INSERT_PRODUCT_SQL);
            preparedStatement.setInt(1, product.getId());
            preparedStatement.setString(2, product.getProduct_name());
            preparedStatement.setDouble(3, product.getPrice());
            preparedStatement.setInt(4, product.getQuantity());
            preparedStatement.setString(5, product.getColor());
            preparedStatement.setString(6, product.getCategory());
//            preparedStatement.setString(7, product.getAction());

            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        }
    }

    @Override
    public Product selectProduct(int id) {
        Product product = null;
        try {
            PreparedStatement preparedStatement = baseRepository.getConnection().prepareStatement(SELECT_PRODUCT_BY_ID);
            preparedStatement.setInt(1, id);
            System.out.println(preparedStatement);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                String product_name = resultSet.getString("product_name");
                double price = resultSet.getDouble("price");
                int quantity = resultSet.getInt("quantity");
                String color = resultSet.getString("color");
                String category = resultSet.getString("category");
               product = new Product(id, product_name, price, quantity, color, category);
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return product;
    }

    @Override
    public List<Product> selectAll() {
        List<Product> productList = new ArrayList<>();

        try {
            PreparedStatement preparedStatement = baseRepository.getConnection().prepareStatement(SELECT_ALL_PRODUCT);
            System.out.println(preparedStatement);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String product_name = resultSet.getString("product_name");
                double price = resultSet.getDouble("price");
                int quantity = resultSet.getInt("quantity");
                String color = resultSet.getString("color");
                String category = resultSet.getString("category");
                productList.add(new Product(id,product_name,price,quantity,color,category));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return productList;
    }

    @Override
    public boolean deleteProduct(int id) throws SQLException {
        return false;
    }

    @Override
    public boolean updateProduct(Product product) throws SQLException {
        return false;
    }

    @Override
    public List<Product> searchByName(String name, String address) throws SQLException {
        return null;
    }
}
