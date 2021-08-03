package servlet;

import bean.Customer;
import com.sun.org.apache.bcel.internal.generic.SimpleElementValueGen;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "CustomerServlet", urlPatterns = {"", "/customer"})
public class CustomerServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Customer> customerList = new ArrayList<>();
        customerList.add(new Customer("Lê Văn Diệp", "1991-4-15","Quảng Trị", "anh_bt2/diep.jpg"));
        customerList.add(new Customer("Trương Anh Quân", "1999-8-15","Đà Nẵng", "anh_bt2/anh.quan.jpg"));
        customerList.add(new Customer("Hồ Kỳ Tài", "1995-5-5","Đà Nẵng", "anh_bt2/kytai.jpg"));
        customerList.add(new Customer("Đồng Văn Nhật", "1997-9-25","Hà Tĩnh", "anh_bt2/dong.nhat.jpg"));

        request.setAttribute("customerListServlet", customerList);
        request.getRequestDispatcher("index.jsp").forward(request,response);

    }
}
