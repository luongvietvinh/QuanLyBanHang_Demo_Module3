package controller;

import model.Product;
import dao.ProductDaoImpl;
import service.ProductService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(urlPatterns = "/product")
public class ProductSeverlet extends HttpServlet {
    ProductDaoImpl productDao = new ProductDaoImpl();
    ProductService productService = new ProductService();


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";

        }
        switch (action) {
            case "create":
                request.getRequestDispatcher("view/create.jsp").forward(request, response);
                break;
            case "edit":
                request.getRequestDispatcher("view/editProduct.jsp").forward(request, response);
                break;
            case "delete":
                try {
                    deleteProduct(request, response);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
            case "detai":
                break;
            default:
                showList(request, response);
        }

    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                try {
                    createProduct(request, response);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
            case "edit":
                try {
                    editProduct(request, response);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
            case "delete":

                break;
        }
    }


    private void createProduct(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {


        String name = request.getParameter("name");
        String img = request.getParameter("img");
        double price = Double.parseDouble(request.getParameter("price"));
        productService.add(new Product(name, img, price));
        try {
            response.sendRedirect("/product");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void editProduct(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {

        int id = Integer.parseInt(request.getParameter("id"));
        String newname = request.getParameter("name");
        String newImg = request.getParameter("img");
        double newPrice = Double.parseDouble(request.getParameter("price"));
        Product product = (new Product(newname, newImg, newPrice));
        productService.edit(id, product);

        response.sendRedirect("/product");
    }

    public void deleteProduct(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        productService.delete(id);

        response.sendRedirect("/product");
    }

    private void showList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("view/listProduct.jsp");
        List<Product> productList = productDao.showAllProductDao();
        request.setAttribute("products", productList);
        dispatcher.forward(request, response);
    }
}
