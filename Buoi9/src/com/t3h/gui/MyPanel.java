package com.t3h.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyPanel extends JPanel implements ActionListener {
    private JLabel lbTitle;
    private JTextField tfInput;
    private JButton btnOk;

    public MyPanel() {
        setBackground(Color.BLUE);
        setLayout(null);
        initComponents();
    }

    private void initComponents() {
        lbTitle = new JLabel();
        lbTitle.setText("Hello world");
        lbTitle.setForeground(Color.WHITE);
        lbTitle.setFont(new Font(null, Font.BOLD, 20));
        lbTitle.setBounds(0, 0, MyFrame.W_FRAME, 100);
        lbTitle.setHorizontalAlignment(SwingConstants.CENTER);
        add(lbTitle);

        tfInput = new JTextField();
        tfInput.setBounds(20, 110, 200, 30);
        add(tfInput);

        btnOk = new JButton();
        btnOk.setText("Ok");
        btnOk.setBounds(20, 150, 200, 30);
        btnOk.addActionListener(this);
        add(btnOk);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String value = tfInput.getText();
        JOptionPane.showMessageDialog(
                null, value, "Click!",
                JOptionPane.INFORMATION_MESSAGE
        );
    }
}
