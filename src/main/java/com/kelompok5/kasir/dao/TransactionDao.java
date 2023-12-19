package com.kelompok5.kasir.dao;

import com.kelompok5.kasir.model.Transaction;

import java.sql.SQLException;
import java.util.List;

public interface TransactionDao {
    public int add(Transaction transaction)
            throws SQLException;
    public void delete(int id)
            throws SQLException;
    public Transaction getTransaction(int id)
            throws SQLException;
    public Transaction getLatestTransaction()
            throws SQLException;
    public List<Transaction> getTransactions()
            throws SQLException;
    public void update(Transaction transaction)
            throws SQLException;
}
