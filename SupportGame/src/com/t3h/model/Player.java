package com.t3h.model;

import image.ImageLoader;

import java.awt.*;

public class Player extends Tank {

    public Player(int x, int y) {
        super(x, y);
        orient = RIGHT;
        images.add(new Image[]{
                ImageLoader.getImage("mario_move_left_1.png"),
                ImageLoader.getImage("mario_move_left_2.png"),
                ImageLoader.getImage("mario_move_left_3.png")
        });
        images.add(new Image[]{
                ImageLoader.getImage("mario_move_right_1.png"),
                ImageLoader.getImage("mario_move_right_2.png"),
                ImageLoader.getImage("mario_move_right_3.png"),
        });
        images.add(new Image[]{
                ImageLoader.getImage("mario_jump_left.png")
        });
        images.add(new Image[]{
                ImageLoader.getImage("mario_jump_right.png")
        });
    }
}
