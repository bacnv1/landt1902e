package com.t3h.demo.main;

import com.t3h.demo.login.LoginFrame;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(
                    "javax.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (Exception e) {
            e.printStackTrace();
        }
        LoginFrame loginFrame = new LoginFrame();
        loginFrame.setVisible(true);
    }
}
