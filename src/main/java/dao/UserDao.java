package dao;

import model.Product;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDao {
    public UserDao() {
    }

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




        public void createProductDao(Product product) {
            String saveProduct = "INSERT INTO product(name,img,price) VALUES (?,?,?)";
            try{
                PreparedStatement preparedStatement = getConnection().prepareStatement(saveProduct);
                getConnection().setAutoCommit(false);
                preparedStatement.setString(1,product.getName());
                preparedStatement.setString(2,product.getImg());
                preparedStatement.setDouble(3,product.getPrice());
                preparedStatement.execute();
                getConnection().commit();
            }catch (SQLException e){
                printSQLException(e);
            }
        }


        public Product selectUser(int id) {
            return null;
        }


        public List<Product> showListUser() {
            String getall = "SELECT * FROM user ";
            List<Product> userList = new ArrayList<>();

            try (Connection connection = getConnection();
                 PreparedStatement preparedStatement = connection.prepareStatement(getall)) {
                ResultSet rs = preparedStatement.executeQuery();
                while (rs.next()) {
                    int id = rs.getInt("id");
                    String name = rs.getString("name");
                    String img = rs.getString("email");
                    double price = rs.getDouble("passWord");
                    userList.add(new Product(id, name, img, price));
                }
                return userList;
            } catch (SQLException e) {
                e.printStackTrace();
            }

            return null;
        }



        public void deleteProductDao(int id) {
            String deleteSQL = "DELETE  from product where id=?";
            try {
                PreparedStatement preparedStatement = getConnection().prepareStatement(deleteSQL);
                preparedStatement.setInt(1,id);
                preparedStatement.execute();
            }catch (Exception e){
                e.printStackTrace();
            }
        }




        public void updateProductDao(int id,Product product) throws SQLException {
            String editProduct = "update product set name = ?,img= ?, price =? where id = ?";

            try (Connection connection = getConnection();
                 PreparedStatement statement = connection.prepareStatement(editProduct)){
                statement.setString(1,product.getName());
                statement.setString(2,product.getImg());
                statement.setDouble(3,product.getPrice());
                statement.setInt(4,id);

                statement.execute();
            }

        }
        private void printSQLException(SQLException ex) {
            for (Throwable e : ex) {
                if (e instanceof SQLException) {
                    e.printStackTrace(System.err);
                    System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                    System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                    System.err.println("Message: " + e.getMessage());
                    Throwable t = ex.getCause();
                    while (t != null) {
                        System.out.println("Cause: " + t);
                        t = t.getCause();
                    }
                }
            }
        }
    }


