package com.t3h.demo;

import javax.swing.*;
import java.awt.*;

public abstract class BasePanel extends JPanel {

    public BasePanel() {
        setBackground(Color.WHITE);
        setLayout(null);
        initComponents();
    }

    protected abstract void initComponents();
}
