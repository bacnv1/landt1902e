package com.t3h.model;

import com.t3h.gui.MyFrame;
import image.ImageLoader;

import java.awt.*;

public class Bullet {
    private int x;
    private int y;
    private Image image = ImageLoader.getImage("bullet.png");
    private int orient;

    public Bullet(int x, int y, int orient) {
        this.x = x - image.getWidth(null) / 2;
        this.y = y - image.getHeight(null) / 2;
        this.orient = orient;
    }

    public void draw(Graphics2D g2d) {
        g2d.drawImage(image, x, y, null);
    }

    public boolean move() {
        int speed = 2;
        switch (orient) {
            case Tank.LEFT:
                x -= speed;
                break;
            case Tank.RIGHT:
                x += speed;
                break;
            case Tank.UP:
                y -= speed;
                break;
            case Tank.DOWN:
                y += speed;
                break;
        }
        if (x < 0 || y < 0
                || x > MyFrame.W_FRAME
                || y > MyFrame.H_FRAME) {
            return false;
        }
        return true;
    }

    public Rectangle getRect() {
        Rectangle rect = new Rectangle(
                x, y,
                image.getWidth(null),
                image.getHeight(null)
        );
        return rect;
    }
}
