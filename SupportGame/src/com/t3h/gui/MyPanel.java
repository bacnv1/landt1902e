package com.t3h.gui;

import com.t3h.manager.GameManager;
import com.t3h.model.Tank;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.BitSet;

public class MyPanel extends JPanel implements KeyListener, Runnable {

    private GameManager manager = new GameManager();
    private BitSet b = new BitSet(256);

    public MyPanel() {
        setBackground(Color.BLACK);
        manager.initGame();
        // set key listener
        setFocusable(true);
        addKeyListener(this);

        Thread t = new Thread(this);
        t.start();
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        super.paintComponent(g2d);
//        g2d.setColor(Color.RED);
//        g2d.setStroke(new BasicStroke(20));
//        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
//                RenderingHints.VALUE_ANTIALIAS_ON);
//        g2d.drawLine(0, 0, 100, 100);
//        g2d.drawRect(200, 200, 100, 100);
//        g2d.drawOval(400, 200, 50, 50);
        manager.draw(g2d);
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        b.set(e.getKeyCode());
    }

    @Override
    public void keyReleased(KeyEvent e) {
        b.clear(e.getKeyCode());
    }

    @Override
    public void run() {
        while (true) {
            if (b.get(KeyEvent.VK_LEFT) == true) {
                manager.playerMove(Tank.LEFT);
            } else if (b.get(KeyEvent.VK_RIGHT) == true) {
                manager.playerMove(Tank.RIGHT);
            }

            if (b.get(KeyEvent.VK_SPACE)){
                manager.playerJump();
            }

            boolean check = manager.AI();
            if (check == false) {
                int result = JOptionPane.showConfirmDialog(
                        null,
                        "Do you want to replay",
                        "Game over",
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.QUESTION_MESSAGE
                );
                if (result == JOptionPane.YES_OPTION){
                    manager.initGame();
                    b = new BitSet();
                }else{
                    System.exit(0);
                    return;
                }
            }
            repaint();
            try {
                Thread.sleep(7);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
