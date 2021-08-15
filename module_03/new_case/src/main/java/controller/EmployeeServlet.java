package controller;

import model.bean.*;
import model.service.*;
import model.service.impl.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "EmployeeServlet", urlPatterns = {"/employee"})
public class EmployeeServlet extends HttpServlet {
        IEmployeeService iEmployeeService = new EmployeeServiceImpl();
   IEmployeePosRepoService iEmployeePosRepoService = new EmployeePosRepoServiceImpl();
    IEmployeeEduRepoService iEmployeeEduRepoService = new EmployeeEduRepoServiceImpl();
    IEmployeeDivRepoService iEmployeeDivRepoService = new EmployeeDivRepoServiceImpl();
    IUserService iUserService = new UserServiceImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action){
            case "create-employee":
                createEmployee(request, response);
                break;
            case "edit-employee":
                updateEmployee(request, response);
                break;
        }
    }

    private void updateEmployee(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("employee_id"));
        String name = request.getParameter("employee_name");
        String birthday = request.getParameter("employee_birthday");
        String card = request.getParameter("employee_id_card");
        double salary = Double.parseDouble(request.getParameter("employee_id_salary"));
        String phone = request.getParameter("employee_id_phone");
        String email = request.getParameter("employee_id_email");
        String address = request.getParameter("employee_id_address");
        int positionId = Integer.parseInt(request.getParameter("position_id"));
        int educationDegreeId = Integer.parseInt(request.getParameter("education_degree_id"));
        int divisionId = Integer.parseInt(request.getParameter("division_id"));
        String username = request.getParameter("username");
        Employee employee =  new Employee(id,name,birthday,card,salary,phone,email,address,positionId,educationDegreeId,divisionId,username);
        try {
            iEmployeeService.updateEmployee(employee);
            RequestDispatcher dispatcher = request.getRequestDispatcher("employee/edit.jsp");
            request.setAttribute("msg","edit successfully");
            try {
                dispatcher.forward(request,response);
            } catch (ServletException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

    private void createEmployee(HttpServletRequest request, HttpServletResponse response) {
        String name = request.getParameter("employee_name");
        String birthday = request.getParameter("employee_birthday");
        String card = request.getParameter("employee_id_card");
//        double salary = Double.parseDouble(request.getParameter("employee_id_salary"));
        double salary = Double.parseDouble(request.getParameter("employee_id_salary"));
        String phone = request.getParameter("employee_id_phone");
        String email = request.getParameter("employee_id_email");
        String address = request.getParameter("employee_id_address");
        int positionId = Integer.parseInt(request.getParameter("position_id"));
        int educationDegreeId = Integer.parseInt(request.getParameter("education_degree_id"));
        int divisionId = Integer.parseInt(request.getParameter("division_id"));
        String username = request.getParameter("username");
        Employee employee =  new Employee(name,birthday,card,salary,phone,email,address,positionId,educationDegreeId,divisionId,username);
        try {
            this.iEmployeeService.addNewEmployee(employee);
            RequestDispatcher dispatcher = request.getRequestDispatcher("employee/create.jsp");
            request.setAttribute("msg","Created successfully.");
            try {
                dispatcher.forward(request,response);
            } catch (ServletException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action){
            case "create-employee":
                showCreateEmployeeForm(request, response);
                break;

            case "list-employee":
                listEmployee(request, response);
                break;
            case "edit-employee":
                showEditEmployeeForm(request, response);
                break;

//            case "delete-customer":
//                deleteEmployee(request, response);
//                break;

            default :
                listEmployee(request,response);
        }
    }

    private void showEditEmployeeForm(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
//        Customer customer = iCustomerService.selectCustomer(id);
        Employee employee = iEmployeeService.selectEmployee(id);
//        List<CustomerType> customerTypes = iCustomerTypeService.selectAllType();
      List<EmployeePosition> employeePositions = iEmployeePosRepoService.selectAllPosition();
      request.setAttribute("positionList", employeePositions);
      List<EmployeeEducation> employeeEducations = iEmployeeEduRepoService.selectAllEducation();
      request.setAttribute("educationList", employeeEducations);
      List<EmployeeDivision> employeeDivisions = iEmployeeDivRepoService.selectAllDivision();
      request.setAttribute("divisionList", employeeDivisions);
      List<User> users = iUserService.selectAllUser();
      request.setAttribute("userList",users);
      RequestDispatcher dispatcher = request.getRequestDispatcher("employee/edit.jsp");
      request.setAttribute("employee", employee);
        try {
            dispatcher.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void listEmployee(HttpServletRequest request, HttpServletResponse response) {
        List<Employee> listEmployee = iEmployeeService.selectAllEmployee();
        request.setAttribute("listEmployee", listEmployee);
        RequestDispatcher dispatcher = request.getRequestDispatcher("employee/list.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
//
    private void showCreateEmployeeForm(HttpServletRequest request, HttpServletResponse response) {

        List<EmployeePosition> employeePositions = iEmployeePosRepoService.selectAllPosition();
        request.setAttribute("positionList", employeePositions);
        List<EmployeeEducation> employeeEducations = iEmployeeEduRepoService.selectAllEducation();
        request.setAttribute("educationList", employeeEducations);
        List<EmployeeDivision> employeeDivisions = iEmployeeDivRepoService.selectAllDivision();
        request.setAttribute("divisionList", employeeDivisions);
        List<User> userList = iUserService.selectAllUser();
        request.setAttribute("userList", userList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("employee/create.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
