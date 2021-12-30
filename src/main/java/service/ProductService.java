package service;

import dao.ProductDaoImpl;
import model.Product;

import java.sql.SQLException;
import java.util.List;

public class ProductService {
    ProductDaoImpl productDao = new ProductDaoImpl();

    List<Product> list = productDao.showAllProductDao();

    public void add(Product product) {
        productDao.createProductDao(product);
        list = productDao.showAllProductDao();
    }

    public void delete (int id) {
        productDao.deleteProductDao(id);
        productDao.showAllProductDao();
    }

    public void edit(int id ,Product product) throws SQLException {
        productDao.updateProductDao(id,product);
        productDao.showAllProductDao();
    }



public Product detaiById(int id){
    for (int i = 0; i < list.size(); i++) {
        if (list.get(i).getId()==id){
            return list.get(i);
        }
    }
    return null;
}


    public int findById(int id){
        for (int i = 0; i < list.size(); i++) {
            if (id==list.get(i).getId())
                return i;
        }
        return -1;
    }
}
