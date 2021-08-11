package model.repository.impl;

import model.bean.User;
import model.repository.IUserRepository;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;
import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class UserRepositoryImpl implements IUserRepository {
    private static final String INSERT_USERS_SQL = "INSERT INTO users" + "  (name, email, country) VALUES " +
            " (?, ?, ?);";
    private static final String SELECT_USER_BY_ID = "select id,`name`,email,country from users where id =?";
    private static final String SELECT_USER_BY_COUNTRY = "select id,`name`,email,country from users where country =?";
    private static final String SELECT_ALL_USERS = "select id, name, email, country from users";
    private static final String DELETE_USERS_SQL = "delete from users where id = ?;";
    private static final String UPDATE_USERS_SQL = "update users set name = ?,email= ?, country =? where id = ?;";
    private static final String CALL_GET_USER_BY_ID = "call get_user_by_id(?);";
    private static final String SQL_INSERT = "INSERT INTO EMPLOYEE (NAME, SALARY, CREATED_DATE) VALUES (?,?,?)";
    private static final String SQL_UPDATE = "UPDATE EMPLOYEE SET SALARY=? WHERE NAME=?";
    private static final String SQL_TABLE_CREATE = "create table employee("
            +"ID serial,"
+"`NAME` varchar(100) NOT NULL,"
 + "SALARY numeric(15, 2) NOT NULL,"
  +  "CREATED_DATE timestamp,"
   + "PRIMARY KEY (ID)"
                    + ")";
    private static final String SQL_TABLE_DROP = "DROP TABLE IF EXISTS EMPLOYEE";


    private BaseRepository baseRepository = new BaseRepository();

    @Override
    public User selectUser(int id) {
        User user = null;
        try {
            CallableStatement callableStatement = baseRepository.getConnection().prepareCall(CALL_GET_USER_BY_ID);
            callableStatement.setInt(1,id);
//            preparedStatement.setInt(1, id);
//            System.out.println(preparedStatement);
            ResultSet rs = callableStatement.executeQuery();


            while (rs.next()) {
                String name = rs.getString("name");
                String email = rs.getString("email");
                String country = rs.getString("country");
                user = new User(id, name, email, country);
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return user;
    }

    @Override
    public void insertUser(User user) throws SQLException {

        System.out.println(INSERT_USERS_SQL);
        try {
            CallableStatement callableStatement = baseRepository.getConnection().prepareCall(INSERT_USERS_SQL);
            callableStatement.setString(1, user.getName());
            callableStatement.setString(2, user.getEmail());
            callableStatement.setString(3, user.getCountry());
            System.out.println(callableStatement);
            callableStatement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        }
    }

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
    public List<User> searchByCountry(String countrySearch) {
        List<User> users = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = baseRepository.getConnection().prepareStatement(SELECT_USER_BY_COUNTRY);
            preparedStatement.setString(1, countrySearch);

            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String email = rs.getString("email");
                String country = rs.getString("country");
                users.add(new User(id, name, email, country));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return users;
    }

    @Override
    public List<User> nameSort() {
        List<User> userList = new ArrayList<>();

        try {
            PreparedStatement preparedStatement = baseRepository.getConnection().prepareStatement
                    ("SELECT id,`name`,email,country FROM users \n" +
                    "order by name asc;");
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String email = rs.getString("email");
                String country = rs.getString("country");
                userList.add(new User(id, name, email, country));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return userList;
    }


    public void addUserTransaction(User user, int[] permision) {
        Connection connection = null;
        // for insert a new user
        PreparedStatement preparedStatement = null;
        // for assign permision to user
        PreparedStatement preparedStatement1 = null;
        // for getting user id
        ResultSet resultSet = null;
        try {
        connection = baseRepository.getConnection();
        // set auto commit to false
        connection.setAutoCommit(false);
        //

        // Insert user

        //
        preparedStatement = connection.prepareStatement(INSERT_USERS_SQL, Statement.RETURN_GENERATED_KEYS);

        preparedStatement.setString(1, user.getName());

       preparedStatement.setString(2, user.getEmail());

        preparedStatement.setString(3, user.getCountry());

        int rowAffected = preparedStatement.executeUpdate();

        // get user id

        resultSet = preparedStatement.getGeneratedKeys();

        int userId = 0;

        if (resultSet.next())

            userId = resultSet.getInt(1);

        //

        // in case the insert operation successes, assign permision to user

        //

        if (rowAffected == 1) {

            // assign permision to user

            String sqlPivot = "INSERT INTO user_permision(user_id,permision_id) "

                    + "VALUES(?,?)";

            preparedStatement1 = connection.prepareStatement(sqlPivot);

            for (int permisionId : permision) {

                preparedStatement1.setInt(1, userId);

                preparedStatement1.setInt(2, permisionId);

                preparedStatement1.executeUpdate();

            }

            connection.commit();

        } else {

            connection.rollback();

        }

    } catch (SQLException ex) {

        // roll back the transaction

        try {

            if (connection != null)

                connection.rollback();

        } catch (SQLException e) {

            System.out.println(e.getMessage());

        }

        System.out.println(ex.getMessage());

    } finally {

        try {

            if (resultSet != null) resultSet.close();

            if (preparedStatement != null) preparedStatement.close();

            if (preparedStatement1 != null) preparedStatement1.close();

            if (connection != null) connection.close();

        } catch (SQLException e) {

            System.out.println(e.getMessage());

        }

    }


}


    public void insertUpdateWithoutTransaction() {
        try (Connection conn = baseRepository.getConnection();
             Statement statement = conn.createStatement();
             PreparedStatement psInsert = conn.prepareStatement(SQL_INSERT);
             PreparedStatement psUpdate = conn.prepareStatement(SQL_UPDATE)) {
            // Run list of insert commands
            psInsert.setString(1, "Quynh");
            psInsert.setBigDecimal(2, new BigDecimal(10));
            psInsert.setTimestamp(3, Timestamp.valueOf(LocalDateTime.now()));
            psInsert.execute();
            psInsert.setString(1, "Ngan");
            psInsert.setBigDecimal(2, new BigDecimal(20));
            psInsert.setTimestamp(3, Timestamp.valueOf(LocalDateTime.now()));
            psInsert.execute();
            // Run list of update command
            // below line caused error, test transaction
            // org.postgresql.util.PSQLException: No value specified for parameter 1.
            psUpdate.setBigDecimal(2, new BigDecimal(999.99));
            //psUpdate.setBigDecimal(1, new BigDecimal(999.99));
            psUpdate.setString(2, "Quynh");
            psUpdate.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void insertUpdateUseTransaction() {
        try {

            Connection conn = baseRepository.getConnection();

            Statement statement = conn.createStatement();

            PreparedStatement psInsert = conn.prepareStatement(SQL_INSERT);

            PreparedStatement psUpdate = conn.prepareStatement(SQL_UPDATE);

            statement.execute(SQL_TABLE_DROP);
            System.out.println(statement);

            statement.execute(SQL_TABLE_CREATE);
            System.out.println(statement);

            psInsert.setString(1, "Quynh");

            psInsert.setBigDecimal(2, new BigDecimal(10));

            psInsert.setTimestamp(3, Timestamp.valueOf(LocalDateTime.now()));

            psInsert.execute();
            System.out.println(psInsert);

            psInsert.setString(1, "Ngan");

            psInsert.setBigDecimal(2, new BigDecimal(20));

            psInsert.setTimestamp(3, Timestamp.valueOf(LocalDateTime.now()));

            psInsert.execute();
            System.out.println(psInsert);

            psUpdate.setBigDecimal(1, new BigDecimal(999.99));

            psUpdate.setString(2, "Quynh");

            psUpdate.execute();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @Override
    public List<User> selectAllUsers() {
        List<User> userList = new ArrayList<>();

        try {
            PreparedStatement preparedStatement = baseRepository.getConnection().prepareStatement(SELECT_ALL_USERS);
            System.out.println(preparedStatement);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String email = resultSet.getString("email");
                String country = resultSet.getString("country");
                userList.add(new User(id, name, email, country));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return userList;
    }

    @Override
    public boolean deleteUser(int id) throws SQLException {
        boolean rowDeleted = false;
        try {
            PreparedStatement statement = baseRepository.getConnection().prepareStatement(DELETE_USERS_SQL);
            statement.setInt(1, id);
            rowDeleted = statement.executeUpdate() > 0;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return rowDeleted;
    }

    @Override
    public boolean updateUser(User user) {
        boolean rowUpdated = false;
        try {
            PreparedStatement statement = baseRepository.getConnection().prepareStatement(UPDATE_USERS_SQL);
            System.out.println(statement);
            statement.setString(1, user.getName());
            statement.setString(2, user.getEmail());
            statement.setString(3, user.getCountry());
            statement.setInt(4, user.getId());

            rowUpdated = statement.executeUpdate() > 0;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return rowUpdated;
    }


    private void showNameSorted(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<User> listUser = new ArrayList<>();
        request.setAttribute("listUser", listUser);
        RequestDispatcher dispatcher = request.getRequestDispatcher("user/sort.jsp");
        dispatcher.forward(request, response);
    }

}