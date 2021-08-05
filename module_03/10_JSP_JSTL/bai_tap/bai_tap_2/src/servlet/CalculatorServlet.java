package servlet;

import bean.Calculator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "CalculatorServlet", urlPatterns = "/calculator")
public class CalculatorServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        float n1 = Float.parseFloat(request.getParameter("first"));
        float n2 = Float.parseFloat(request.getParameter("second"));
        float result=0;
        String massage=null;
        String op = request.getParameter("op");
        try {
            result= Calculator.calculate(n1,n2,op);
        }catch (Exception e){
            massage=e.getMessage();
        }

        request.setAttribute("result", result);
        request.setAttribute("massage", massage);
        request.getRequestDispatcher("result.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
