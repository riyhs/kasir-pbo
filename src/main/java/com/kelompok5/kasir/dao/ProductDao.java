package com.kelompok5.kasir.dao;

import com.kelompok5.kasir.model.Product;

import java.sql.SQLException;
import java.util.List;

public interface ProductDao {
    public int add(Product product)
            throws SQLException;
    public void delete(int id)
            throws SQLException;
    public Product getProduct(int id)
            throws SQLException;
    public List<Product> getProducts()
            throws SQLException;
    public List<Product> getProducts(String name)
            throws SQLException;
    public void update(Product product)
            throws SQLException;
}
