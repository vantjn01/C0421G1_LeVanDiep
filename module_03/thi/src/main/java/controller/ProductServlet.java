package controller;

import model.bean.Product;
import model.service.IProductService;
import model.service.ProductServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "ProductServlet", urlPatterns = {"","/product"})
public class ProductServlet extends HttpServlet {

    IProductService iProductService = new ProductServiceImpl();
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
                case "create-product":
                    createProduct(request, response);
                    break;
    }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }

        try {
            switch (action) {

                case "create-product":
                    showCreateProductForm(request, response);
                    break;

                case "list-product":
                    listProduct(request, response);
                    break;

//                case "edit-customer":
//                    showEditProductForm(request, response);
//                    break;

//                case "delete-customer":
//                    deleteCustomer(request, response);
//                    break;
                default :
                    listProduct(request,response);
//                    break;
//                case "list-employee":
//                    listEmployee(request, response);
//                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }
    private void listProduct(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        List<Product> productList = iProductService.selectAll();
        request.setAttribute("listProduct", productList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("product/list.jsp");
        dispatcher.forward(request, response);
    }

    private void showCreateProductForm (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        List<CustomerType> customerTypes = iCustomerTypeService.selectAllType();
//        request.setAttribute("typeList", customerTypes);
        RequestDispatcher dispatcher = request.getRequestDispatcher("product/create.jsp");
        dispatcher.forward(request, response);
    }

    private void createProduct(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
//        int id = Integer.parseInt(request.getParameter("id"));
        String product_name = request.getParameter("product_name");
        double price = Double.parseDouble(request.getParameter("price"));
        int quantity = Integer.parseInt(request.getParameter("quantity"));
        String color = request.getParameter("color");
        String description = request.getParameter("description");

        Product product = new Product( product_name, price, quantity, color, description);
        this.iProductService.addNew(product);
        RequestDispatcher dispatcher = request.getRequestDispatcher("product/create.jsp");
        request.setAttribute("msg", "Created successfully.");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
