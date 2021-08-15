package model.repository.impl;

import model.bean.Employee;
import model.repository.IEmployeeRepository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeRepositoryImpl implements IEmployeeRepository {
    private static final String INSERT_EMPLOYEE_SQL = "INSERT INTO employee" + "  " +
            "(employee_name,employee_birthday,employee_id_card,employee_id_salary,\n" +
            "employee_id_phone,employee_id_email,employee_id_address ,position_id ,education_degree_id ,\n" +
            "division_id ,username) VALUES " +
            " (?,?,?,?,?,?,?,?,?,?,?);";
    private static final String SELECT_ALL_EMPLOYEE = "select * from employee";
    private static final String SELECT_EMPLOYEE_BY_ID = "select * from employee where employee_id =?";
    private static final String UPDATE_EMPLOYEE_SQL = "update employee" +
            " set employee_name = ?,employee_birthday = ?,employee_id_card = ?," +
            "employee_id_salary = ?,employee_id_phone = ?,employee_id_email = ?,employee_id_address  = ?," +
            "position_id = ?,education_degree_id = ?,division_id ,username =? where employee_id = ?;";
    BaseRepository baseRepository = new BaseRepository();
    @Override
    public void addNewEmployee(Employee employee) throws SQLException {
        System.out.println(INSERT_EMPLOYEE_SQL);
        PreparedStatement preparedStatement = baseRepository.getConnection().prepareStatement(INSERT_EMPLOYEE_SQL);
        preparedStatement.setString(1,employee.getEmployee_name());
        preparedStatement.setString(2,employee.getEmployee_birthday());
        preparedStatement.setString(3,employee.getEmployee_id_card());
        preparedStatement.setDouble(4,employee.getEmployee_salary());
        preparedStatement.setString(5,employee.getEmployee_phone());
        preparedStatement.setString(6,employee.getEmployee_email());
        preparedStatement.setString(7,employee.getEmployee_address());
        preparedStatement.setInt(8,employee.getPosition_id());
        preparedStatement.setInt(9,employee.getEducation_degree_id());
        preparedStatement.setInt(10,employee.getDivision_id());
        preparedStatement.setString(11,employee.getUsername());
        System.out.println(preparedStatement);
        preparedStatement.executeUpdate();


    }

    @Override
    public Employee selectEmployee(int id) {
        Employee employee = null;
        try {
            PreparedStatement preparedStatement = baseRepository.getConnection().prepareStatement(SELECT_EMPLOYEE_BY_ID);
            preparedStatement.setInt(1,id);
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()){
                String name = rs.getString("employee_name");
                String birthday = rs.getString("employee_birthday");
                String card = rs.getString("employee_id_card");
                double salary = rs.getDouble("employee_id_salary");
                String phone = rs.getString("employee_id_phone");
                String email = rs.getString("employee_id_email");
                String address = rs.getString("employee_id_address");
                int positionId = rs.getInt("position_id");
                int educationDegreeId = rs.getInt("education_degree_id");
                int divisionId = rs.getInt("division_id");
                String username = rs.getString("username");
                employee = new Employee(name,birthday,card,salary,phone,email,address,positionId,educationDegreeId,divisionId,username);

//
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return employee;
    }

    @Override
    public List<Employee> selectAllEmployee() {
        List<Employee> employees = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = baseRepository.getConnection().prepareStatement(SELECT_ALL_EMPLOYEE);
            {
                System.out.println(preparedStatement);

                ResultSet rs = preparedStatement.executeQuery();
                while (rs.next()){
                    int id = rs.getInt("employee_id");
                    String name = rs.getString("employee_name");
                    String birthday = rs.getString("employee_birthday");
                    String card = rs.getString("employee_id_card");
                    double salary = rs.getDouble("employee_id_salary");
                    String phone = rs.getString("employee_id_phone");
                    String email = rs.getString("employee_id_email");
                    String address = rs.getString("employee_id_address");
                   int positionId = rs.getInt("position_id");
                    int educationDegreeId = rs.getInt("education_degree_id");
                    int divisionId = rs.getInt("division_id");
                    String username = rs.getString("username");
                   employees.add(new Employee(id,name,birthday,card,salary,phone,email,address,positionId,educationDegreeId,divisionId,username));

                }
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return employees;
    }

    @Override
    public boolean updateEmployee(Employee employee) throws SQLException {
        boolean rowUpdated = false;
        PreparedStatement preparedStatement = baseRepository.getConnection().prepareStatement(UPDATE_EMPLOYEE_SQL);
        {
            System.out.println(preparedStatement);

            preparedStatement.setString(1, employee.getEmployee_name());
            preparedStatement.setString(2, employee.getEmployee_birthday());
            preparedStatement.setString(3, employee.getEmployee_id_card());
            preparedStatement.setDouble(4, employee.getEmployee_salary());
            preparedStatement.setString(5, employee.getEmployee_phone());
            preparedStatement.setString(6, employee.getEmployee_email());
            preparedStatement.setString(7, employee.getEmployee_address());
            preparedStatement.setInt(8, employee.getPosition_id());
            preparedStatement.setInt(9, employee.getEducation_degree_id());
            preparedStatement.setInt(10, employee.getDivision_id());
            preparedStatement.setString(11, employee.getUsername());
            preparedStatement.setInt(12, employee.getEmployee_id());
            rowUpdated = preparedStatement.executeUpdate() > 0;
        }
        return rowUpdated;
    }
}
