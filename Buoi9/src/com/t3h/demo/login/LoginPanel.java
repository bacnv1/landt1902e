package com.t3h.demo.login;

import com.t3h.demo.BaseFrame;
import com.t3h.demo.BasePanel;
import com.t3h.demo.dashboard.DashBoardFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginPanel extends BasePanel implements ActionListener {
    private JLabel lbTitle;
    private JTextField tfUserName;
    private JTextField tfPassword;
    private JButton btnOk;

    @Override
    protected void initComponents() {
        lbTitle = new JLabel();
        lbTitle.setText("Login");
        lbTitle.setBounds(0, 0, BaseFrame.W_FRAME, 100);
        lbTitle.setHorizontalAlignment(SwingConstants.CENTER);
        lbTitle.setForeground(Color.RED);
        lbTitle.setFont(new Font(null, Font.BOLD, 20));
        add(lbTitle);

        tfUserName = new JTextField();
        tfUserName.setBounds(20, 120,
                BaseFrame.W_FRAME - 50, 30);
        add(tfUserName);

        tfPassword = new JTextField();
        tfPassword.setBounds(20, 170,
                BaseFrame.W_FRAME - 50, 30);
        add(tfPassword);

        btnOk = new JButton();
        btnOk.setText("Ok");
        btnOk.setBounds(20, 210,
                BaseFrame.W_FRAME - 50, 30);
        btnOk.addActionListener(this);
        add(btnOk);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String userName = tfUserName.getText();
        String password = tfPassword.getText();
        DashBoardFrame frame = new DashBoardFrame();
        frame.setText(userName, password);
        frame.setVisible(true);
        // Close current frame
        SwingUtilities.getWindowAncestor(this).dispose();
    }
}
