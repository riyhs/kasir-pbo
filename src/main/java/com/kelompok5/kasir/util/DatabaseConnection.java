package com.kelompok5.kasir.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private static Connection con = null;
 
    static
    {
        String url = "jdbc:mysql:// localhost:3306/kasirpbo";
        String user = "root";
        String pass = "";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(url, user, pass);
        }
        catch (ClassNotFoundException | SQLException e) {
            System.err.println("DB Connection Error");
        }
    }
    public static Connection getConnection()
    {
        return con;
    }
}
