package dao;

import model.Product;

import java.sql.SQLException;
import java.util.List;

public interface IproductDao {

    public void createProductDao(Product product) throws SQLException;

    public Product selectUser(int id);

    public List<Product> showAllProductDao();

    public void deleteProductDao(int id) throws SQLException;

    public void updateProductDao(int id,Product product) throws SQLException;
}
