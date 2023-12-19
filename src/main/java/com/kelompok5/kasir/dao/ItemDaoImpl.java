package com.kelompok5.kasir.dao;

import com.kelompok5.kasir.model.Item;
import com.kelompok5.kasir.util.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ItemDaoImpl implements ItemDao{

    static Connection con = DatabaseConnection.getConnection();

    @Override
    public int add(Item item) throws SQLException {
        String q = "INSERT INTO item(price,qty,name,total,transactionId,productId) VALUES (?, ?, ?, ?, ?, ?)";
        PreparedStatement ps = con.prepareStatement(q);
        ps.setDouble(1, item.getPrice());
        ps.setInt(2, item.getQty());
        ps.setString(3, item.getName());
        ps.setDouble(4, item.getTotal());
        ps.setInt(5, item.getTransactionId());
        ps.setInt(6, item.getProductId());
        return ps.executeUpdate();
    }

    @Override
    public void delete(int id) throws SQLException {

    }

    @Override
    public Item getItem(int id) throws SQLException {
        return null;
    }

    @Override
    public List<Item> getItems() throws SQLException {
        return null;
    }

    @Override
    public List<Item> getItems(int transactionId) throws SQLException {
        String q = "SELECT * FROM item WHERE transactionId=?";
        PreparedStatement ps = con.prepareStatement(q);
        ps.setInt(1, transactionId);
        ResultSet rs = ps.executeQuery();
        List<Item> ls = new ArrayList<>();

        while (rs.next()) {
            Item item = new Item();
            item.setId(rs.getInt("id"));
            item.setPrice(rs.getDouble("price"));
            item.setQty(rs.getInt("qty"));
            item.setName(rs.getString("name"));
            item.setTotal(rs.getDouble("total"));
            item.setTransactionId(rs.getInt("transactionId"));
            item.setProductId(rs.getInt("productId"));
            ls.add(item);
        }

        return ls;
    }

    @Override
    public void update(Item item) throws SQLException {

    }
}
