package com.t3h.model;

import com.t3h.gui.MyFrame;

import java.awt.*;
import java.util.ArrayList;

public class Tank {
    public static final int LEFT = 0;
    public static final int RIGHT = 1;
    public static final int JUMP_LEFT = 2;
    public static final int JUMP_RIGHT = 3;
    private int index = 0;
    private int count = 0;

    protected int x;
    protected int y;
    protected int orient;
    protected int speed = 1;
    protected ArrayList<Image[]> images = new ArrayList<>();

    public Tank(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void draw(Graphics2D g2d) {
        g2d.drawImage(images.get(orient)[index], x, y, null);
    }

    public void changeImage() {
        count++;
        if (count < 10) {
            return;
        }
        count = 0;
        index++;
        if (index >= images.get(orient).length) {
            index = 0;
        }
    }

    public void move(ArrayList<MapTank> arrMap) {
        int xR = x;
        int yR = y;
        switch (orient) {
            case LEFT:
            case JUMP_LEFT:
                x -= speed;
                break;
            case RIGHT:
            case JUMP_RIGHT:
                x += speed;
                break;
        }
        if (checkMap(arrMap) == false) {
            x = xR;
            y = yR;
            return;
        }

        // kiem tra
        if (x <= 0 ||
                x >= MyFrame.W_FRAME - images.get(orient)[index].getWidth(null) - 20) {
            x = xR;
        }
        if (y <= 0 ||
                y >= MyFrame.H_FRAME - images.get(orient)[index].getHeight(null) - 40) {
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
        // xác định ảnh khi đang nhẩy
        if (orient == LEFT && jump != 0) {
            orient = JUMP_LEFT;
        } else if (orient == RIGHT && jump != 0) {
            orient = JUMP_RIGHT;
        }
        // reset index ảnh khi đổi hướng khác
        if (orient != this.orient) {
            index = 0;
        }
        this.orient = orient;
    }


    public Rectangle getRect() {
        Rectangle rect = new Rectangle(
                x, y,
                images.get(orient)[index].getWidth(null),
                images.get(orient)[index].getHeight(null)
        );
        return rect;
    }

    public int getX() {
        return x;
    }

    public void fall(ArrayList<MapTank> arr) {
        int yR = y;
        // thay đổi y khi đang nhẩy
        if (jump > 0) {
            y--;
            jump--;
        } else {
            // thay đổi y khi rơi
            jump = -1;
            y++;
        }
        // va trạm map thì dừng lại
        boolean check = checkMap(arr);
        if (check == false) {
            y = yR;
            jump = 0;
        }
    }

    int jump = 0;

    public void jump() {
        if (jump == 0) {
            jump = 100;
        }
    }
}
