package com.t3h.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MenuButton extends JButton implements MouseListener {
    private ImageIcon imNormal;
    private ImageIcon imSelect;

    public MenuButton(String imNormalName, String imSelectName) {
        imNormal = new ImageIcon(getClass().getResource("/images/"+imNormalName));
        imSelect = new ImageIcon(getClass().getResource("/images/"+imSelectName));
        setIcon(imNormal);
        setSize(imNormal.getImage().getWidth(null),
                imNormal.getImage().getHeight(null));

        addMouseListener(this);
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {
        setIcon(imSelect);
    }

    @Override
    public void mouseExited(MouseEvent e) {
        setIcon(imNormal);
    }
}
