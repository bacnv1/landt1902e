package com.t3h.demo.dashboard;

import com.t3h.demo.BaseFrame;
import com.t3h.demo.BasePanel;
import com.t3h.demo.login.LoginFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DashBoardPanel extends BasePanel implements ActionListener {
    private JLabel lbTitle;
    private JLabel lbContent;
    private JButton btnBack;
    private JButton btnExit;

    @Override
    protected void initComponents() {
        lbTitle = new JLabel();
        lbTitle.setText("Hello");
        lbTitle.setFont(new Font(null, Font.BOLD, 20));
        lbTitle.setBounds(0, 0, BaseFrame.W_FRAME, 100);
        lbTitle.setHorizontalAlignment(SwingConstants.CENTER);
        lbTitle.setForeground(Color.RED);
        add(lbTitle);

        lbContent = new JLabel();
        lbContent.setFont(new Font(null, Font.BOLD, 15));
        lbContent.setBounds(0, 120, BaseFrame.W_FRAME, 100);
        lbContent.setHorizontalAlignment(SwingConstants.CENTER);
        lbContent.setForeground(Color.BLACK);
        add(lbContent);

        btnBack = new JButton();
        btnBack.setText("Back");
        btnBack.setBounds(20, 240,
                BaseFrame.W_FRAME - 50, 30);
        btnBack.addActionListener(this);
        add(btnBack);

        btnExit = new JButton();
        btnExit.setText("Exit");
        btnExit.setBounds(20, 290,
                BaseFrame.W_FRAME - 50, 30);
        btnExit.addActionListener(this);
        add(btnExit);
    }

    public void setText(String userName, String password) {
        lbContent.setText(userName + "," + password);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(btnBack)){
            LoginFrame frame = new LoginFrame();
            frame.setVisible(true);
            SwingUtilities.getWindowAncestor(this).dispose();
        }else{
            System.exit(0);
        }
    }
}
