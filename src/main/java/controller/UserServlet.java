package controller;

import dao.UserDao;
import model.Product;
import model.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(urlPatterns = "/login")
public class UserServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";

        }
        switch (action) {
            case "create":
                request.getRequestDispatcher("view/createAccount.jsp").forward(request, response);
                break;
            case "edit":
                request.getRequestDispatcher("view/editProduct.jsp").forward(request, response);
                break;
            case "delete":
                try {
                    deleteProduct(request, response);
                } catch ( Exception e) {
                    e.printStackTrace();
                }
                break;
            case "detai":
                break;
            default:
                RequestDispatcher requestDispatcher = request.getRequestDispatcher("view/login.html");
                requestDispatcher.forward(request,response);
        }

    }

    private void deleteProduct(HttpServletRequest request, HttpServletResponse response) {
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        if (username.equals("vinh") && password.equals("vinh")){
            response.sendRedirect("/product");
        }else {
            RequestDispatcher dispatcher = request.getRequestDispatcher("view/login.html");
            dispatcher.forward(request,response);
        }
    }
    }

