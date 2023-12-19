package com.kelompok5.kasir.dao;

import com.kelompok5.kasir.model.Product;
import com.kelompok5.kasir.model.Transaction;
import com.kelompok5.kasir.util.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TransactionDaoImpl implements TransactionDao{
    static Connection con = DatabaseConnection.getConnection();

    @Override
    public int add(Transaction transaction) throws SQLException {
        String q = "INSERT INTO transaction(total,datetime) VALUES (?, ?)";
        PreparedStatement ps = con.prepareStatement(q);
        ps.setDouble(1, transaction.getTotal());
        ps.setTimestamp(2, transaction.getDatetime());
        return ps.executeUpdate();
    }

    @Override
    public void delete(int id) throws SQLException {
    }

    @Override
    public Transaction getTransaction(int id) throws SQLException {
        String q = "SELECT * FROM transaction WHERE id =?";
        PreparedStatement ps = con.prepareStatement(q);
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            return new Transaction(rs.getInt("id"), rs.getDouble("total"), rs.getTimestamp("datetime"));
        } else {
            return null;
        }
    }

    @Override
    public Transaction getLatestTransaction() throws SQLException {
        String q = "SELECT * FROM transaction ORDER BY id DESC LIMIT 1";
        PreparedStatement ps = con.prepareStatement(q);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            return new Transaction(rs.getInt("id"), rs.getDouble("total"), rs.getTimestamp("datetime"));
        } else {
            return null;
        }
    }

    @Override
    public List<Transaction> getTransactions() throws SQLException {
        String q = "SELECT * FROM transaction";
        PreparedStatement ps = con.prepareStatement(q);
        ResultSet rs = ps.executeQuery();
        List<Transaction> ls = new ArrayList<>();

        while (rs.next()) {
            Transaction transaction = new Transaction();
            transaction.setId(rs.getInt("id"));
            transaction.setTotal(rs.getDouble("total"));
            transaction.setDatetime(rs.getTimestamp("datetime"));
            ls.add(transaction);
        }

        return ls;
    }

    @Override
    public void update(Transaction transaction) throws SQLException {

    }
}
