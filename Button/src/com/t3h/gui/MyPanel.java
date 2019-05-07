package com.t3h.gui;

import javax.swing.*;
import java.awt.*;

public class MyPanel extends JPanel {
    private MenuButton btnOk;
    public MyPanel() {
        setLayout(null);
        initComponents();
    }

    private void initComponents() {
        btnOk = new MenuButton("button_ok_normal.png", "button_ok_select.png");
        btnOk.setLocation(100, 100);
        add(btnOk);
    }
}
