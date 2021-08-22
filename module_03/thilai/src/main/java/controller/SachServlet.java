package controller;

import model.bean.Sach;
import model.service.ISachService;
import model.service.SachServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "SachServlet", urlPatterns = "/sach")
public class SachServlet extends HttpServlet {
    ISachService iSachService = new SachServiceImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }

        try {
            switch (action) {

//                case "create-employee":
//                    createEmployee(request, response);
//                    break;
                case "create-sach":
                    createSach(request, response);
                    break;
                case "edit-sach":
                    updateSach(request, response);
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }

    private void updateSach(HttpServletRequest request, HttpServletResponse response) throws SQLException{
        int id_sach = Integer.parseInt(request.getParameter("id_sach"));
        String ten_sach = request.getParameter("ten_sach");
//        int type = Integer.parseInt(request.getParameter("type"));
        String tac_gia = request.getParameter("tac_gia");
        String mo_ta = request.getParameter("mo_ta");
        int so_luong = Integer.parseInt(request.getParameter("so_luong"));

        Sach sach = new Sach(id_sach,ten_sach,tac_gia,mo_ta,so_luong);
//        iCustomerService.updateCustomer(customer);
        iSachService.updateSach(sach);
        RequestDispatcher dispatcher = request.getRequestDispatcher("sach/edit.jsp");
        request.setAttribute("msg","edit successfully");
        try {
            dispatcher.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    private void createSach(HttpServletRequest request, HttpServletResponse response) throws SQLException{
        //        int id = Integer.parseInt(request.getParameter("id"));
        String ten_sach = request.getParameter("ten_sach");
        String tac_gia = request.getParameter("tac_gia");
        String mo_ta = request.getParameter("mo_ta");
        int so_luong = Integer.parseInt(request.getParameter("so_luong"));

       Sach sach = new Sach(ten_sach,tac_gia,mo_ta,so_luong);
        try {
            this.iSachService.addNewSach(sach);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        RequestDispatcher dispatcher = request.getRequestDispatcher("customer/create.jsp");
        request.setAttribute("msg", "Created successfully.");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }

        switch (action) {

            case "create-sach":
                showCreateSachForm(request, response);
                break;
//                case "create-employee":
//                    showCreateEmployeeForm(request, response);
//                    break;
            case "list-sach":
                listSach(request, response);
                break;


            default :
                listSach(request,response);
//                    break;
//                case "list-employee":
//                    listEmployee(request, response);
//                    break;
        }
    }

    private void showCreateSachForm(HttpServletRequest request, HttpServletResponse response) {
//        List<CustomerType> customerTypes = iCustomerTypeService.selectAllType();
//        request.setAttribute("typeList", customerTypes);
        RequestDispatcher dispatcher = request.getRequestDispatcher("sach/create.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void listSach(HttpServletRequest request, HttpServletResponse response) {
        List<Sach> sachList = iSachService.selectSach();
        request.setAttribute("listSach", sachList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("sach/list.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
