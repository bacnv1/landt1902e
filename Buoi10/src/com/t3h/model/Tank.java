package com.t3h.model;

import com.t3h.gui.MyFrame;
import org.w3c.dom.css.Rect;

import java.awt.*;
import java.util.ArrayList;

public class Tank {
    public static final int LEFT = 0;
    public static final int RIGHT = 1;
    public static final int UP = 2;
    public static final int DOWN = 3;

    protected int x;
    protected int y;
    protected int orient;
    protected int speed = 1;
    protected Image[] images = new Image[4];

    private long t;

    public Tank(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void draw(Graphics2D g2d) {
        g2d.drawImage(images[orient], x, y, null);
    }

    public void move(ArrayList<MapTank> arrMap) {
        int xR = x;
        int yR = y;
        switch (orient) {
            case LEFT:
                x -= speed;
                break;
            case RIGHT:
                x += speed;
                break;
            case UP:
                y -= speed;
                break;
            case DOWN:
                y += speed;
                break;
        }
        if (checkMap(arrMap) == false) {
            x = xR;
            y = yR;
            return;
        }

        // kiem tra
        if (x <= 0 ||
                x >= MyFrame.W_FRAME - images[orient].getWidth(null) - 20) {
            x = xR;
        }
        if (y <= 0 ||
                y >= MyFrame.H_FRAME - images[orient].getHeight(null) - 40) {
            y = yR;
        }
    }

    private boolean checkMap(ArrayList<MapTank> arrMap) {
        for (MapTank map : arrMap) {
            if (map.getBit() == 4) continue;
            Rectangle rect = map.getRect().intersection(getRect());
            if (rect.isEmpty() == false) {
                return false;
            }
        }

        return true;
    }

    public void setOrient(int orient) {
        this.orient = orient;
    }


    public Rectangle getRect() {
        int instanceW = 0;
        int instanceH = 0;
        if (orient == UP || orient == DOWN) {
            instanceW = 2;
        } else {
            instanceH = 2;
        }
        Rectangle rect = new Rectangle(
                x, y,
                images[orient].getWidth(null) - instanceW,
                images[orient].getHeight(null) - instanceH
        );
        return rect;
    }

    public void fire(ArrayList<Bullet> arr) {
        long T = System.currentTimeMillis();
        if (T - t < 500) {
            return;
        }
        t = T;

        int xB = x + images[orient].getWidth(null) / 2;
        int yB = y + images[orient].getHeight(null) / 2;
        Bullet b = new Bullet(xB, yB, orient);
        arr.add(b);
    }

    public boolean checkDie(ArrayList<Bullet> arr) {
        for (int i = 0; i < arr.size(); i++) {
            Rectangle rect = arr.get(i).getRect()
                    .intersection(getRect());
            if (rect.isEmpty() == false) {
                arr.remove(i);
                return true;
            }
        }
        return false;
    }

}
