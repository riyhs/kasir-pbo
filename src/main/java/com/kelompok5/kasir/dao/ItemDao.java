package com.kelompok5.kasir.dao;

import com.kelompok5.kasir.model.Item;

import java.sql.SQLException;
import java.util.List;

public interface ItemDao {
    public int add(Item item)
            throws SQLException;
    public void delete(int id)
            throws SQLException;
    public Item getItem(int id)
            throws SQLException;
    public List<Item> getItems()
            throws SQLException;
    public List<Item> getItems(int transactionId)
            throws SQLException;
    public void update(Item item)
            throws SQLException;
}
