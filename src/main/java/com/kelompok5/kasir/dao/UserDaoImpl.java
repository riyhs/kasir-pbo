package com.kelompok5.kasir.dao;

import com.kelompok5.kasir.model.User;
import com.kelompok5.kasir.util.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class UserDaoImpl implements UserDao {
    static Connection con = DatabaseConnection.getConnection();
    @Override
    public int add(User user) throws SQLException {
        return 0;
    }

    @Override
    public void delete(int id) throws SQLException {

    }

    @Override
    public User getUser(int id) throws SQLException {
        return null;
    }

    @Override
    public User getUser(String username) throws SQLException {
        String q = "SELECT * FROM user WHERE username= ?";
        PreparedStatement ps = con.prepareStatement(q);
        ps.setString(1,username);
        User user = new User();
        ResultSet rs = ps.executeQuery();
        boolean check = false;

        while (rs.next()) {
            check = true;
            user.setId(rs.getInt("id"));
            user.setName(rs.getString("name"));
            user.setUsername(rs.getString("username"));
            user.setPassword(rs.getString("password"));
        }

        if(check) {
            return user;
        } else {
            return null;
        }
    }

    @Override
    public List<User> getUsers() throws SQLException {
        return null;
    }

    @Override
    public void update(User user) throws SQLException {

    }
}
