package product;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ProductServlet", urlPatterns = "/product_servlet")
public class ProductServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
int gia = Integer.parseInt(request.getParameter("gia"));
int phan_tram = Integer.parseInt(request.getParameter("phan_tram"));
// Discount Amount = List Price * Discount Percent * 0.01
double gia_ck = gia * phan_tram * 0.01;
double gia_sp = gia - gia_ck;
String tenSp = request.getParameter("ten_sp");
// tạo file result
request.setAttribute("gia_ck", gia_ck);
request.setAttribute("gia_sp", gia_sp);
request.setAttribute("ten_sp", tenSp);
request.getRequestDispatcher("result.jsp").forward(request,response);


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
