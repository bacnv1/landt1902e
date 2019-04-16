package com.t3h.model;

import image.ImageLoader;
import org.w3c.dom.css.Rect;

import java.awt.*;

public class MapTank {
    private int x;
    private int y;
    private int bit;
    private Image[] img = {
            ImageLoader.getImage("brick.png"),
            ImageLoader.getImage("water.png"),
            ImageLoader.getImage("bird.png"),
            ImageLoader.getImage("tree.png"),
            ImageLoader.getImage("rock.png"),
    };

    public MapTank(int x, int y, int bit) {
        this.x = x;
        this.y = y;
        this.bit = bit;
    }

    public void draw(Graphics2D g2d) {
        if (bit == 3) {
            g2d.drawImage(img[bit - 1], x, y, 38, 38, null);
        } else {
            g2d.drawImage(img[bit - 1], x, y, null);
        }
    }

    public Rectangle getRect(){
        int w = 38;
        int h = 38;
        if (bit != 3){
            w = img[bit - 1].getWidth(null);
            h = img[bit - 1].getHeight(null);
        }
        Rectangle rect = new Rectangle(
                x, y, w, h

        );
        return rect;
    }

    public int getBit() {
        return bit;
    }
}
