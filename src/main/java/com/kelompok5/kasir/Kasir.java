package com.kelompok5.kasir;

import com.formdev.flatlaf.FlatDarkLaf;
import com.kelompok5.kasir.ui.AuthListener;
import com.kelompok5.kasir.ui.Login;
import com.kelompok5.kasir.ui.Main;

import javax.swing.*;
import java.sql.SQLException;

public class Kasir implements AuthListener {

    public static void main(String[] args) throws SQLException {
        FlatDarkLaf.setup();

        SwingUtilities.invokeLater(Kasir::showMainPage);
    }

    public static void showLoginPage() {
        Login loginPage = new Login();
        loginPage.setAuthListener(new Kasir());
        loginPage.setLocationRelativeTo(null);
        loginPage.setVisible(true);
    }

    public static void showMainPage() {
        Main mainPage = new Main();
        mainPage.setLocationRelativeTo(null);
        mainPage.setVisible(true);
    }

    @Override
    public void onAuthenticationSuccess(String username) {
        SwingUtilities.invokeLater(Kasir::showMainPage);
    }
}
