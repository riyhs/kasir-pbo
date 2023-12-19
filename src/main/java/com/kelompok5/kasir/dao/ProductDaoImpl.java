package com.kelompok5.kasir.dao;

import com.kelompok5.kasir.model.Product;
import com.kelompok5.kasir.util.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductDaoImpl implements ProductDao {

    static Connection con = DatabaseConnection.getConnection();

    @Override
    public int add(Product product) throws SQLException {
        String q = "INSERT INTO product(name,price,stock) VALUES (?, ?, ?)";
        PreparedStatement ps = con.prepareStatement(q);
        ps.setString(1, product.getName());
        ps.setDouble(2, product.getPrice());
        ps.setInt(3, product.getStock());
        return ps.executeUpdate();
    }

    @Override
    public void delete(int id) throws SQLException {
        String q = "DELETE FROM product WHERE id=?";
        PreparedStatement ps = con.prepareStatement(q);
        ps.setInt(1, id);
        ps.executeUpdate();
    }

    @Override
    public Product getProduct(int id) throws SQLException {
        String q = "SELECT * FROM product WHERE id=?";
        PreparedStatement ps = con.prepareStatement(q);
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            return new Product(rs.getInt("id"), rs.getDouble("price"), rs.getInt("stock"), rs.getString("name"));
        } else {
            return null;
        }
    }

    @Override
    public List<Product> getProducts() throws SQLException {
        String q = "SELECT * FROM product";
        PreparedStatement ps = con.prepareStatement(q);
        ResultSet rs = ps.executeQuery();
        List<Product> ls = new ArrayList<>();

        while (rs.next()) {
            Product product = new Product();
            product.setId(rs.getInt("id"));
            product.setName(rs.getString("name"));
            product.setPrice(rs.getDouble("price"));
            product.setStock(rs.getInt("stock"));
            ls.add(product);
        }

        return ls;
    }

    @Override
    public List<Product> getProducts(String name) throws SQLException {
        String q = "SELECT * FROM product WHERE name LIKE CONCAT('%',?,'%')";
        PreparedStatement ps = con.prepareStatement(q);
        ps.setString(1, name);
        ResultSet rs = ps.executeQuery();
        List<Product> ls = new ArrayList<>();

        while (rs.next()) {
            Product product = new Product();
            product.setId(rs.getInt("id"));
            product.setName(rs.getString("name"));
            product.setPrice(rs.getDouble("price"));
            product.setStock(rs.getInt("stock"));
            ls.add(product);
        }

        return ls;
    }

    @Override
    public void update(Product product) throws SQLException {
        String q = "UPDATE product SET name=?,price=?,stock=? WHERE id=?";
        PreparedStatement ps = con.prepareStatement(q);
        ps.setString(1, product.getName());
        ps.setDouble(2, product.getPrice());
        ps.setInt(3, product.getStock());
        ps.setInt(4, product.getId());
        ps.executeUpdate();
    }
}
