package dao;

import model.Product;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CategoryDao {
    protected Connection getConnection() {
        String jdbcURL = "jdbc:mysql://localhost:3306/dbproduct";
        String jdbcUsername = "root";
        String jdbcPassword = "12345678";

        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return connection;
    }


    public List<Product> showAllCategoryDao() {
        String getall = "SELECT * FROM product";
        List<Product> userList = new ArrayList<>();

        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(getall)) {
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String img = rs.getString("img");
                double price = rs.getDouble("price");
                userList.add(new Product(id, name, img, price));
            }
            return userList;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

}
