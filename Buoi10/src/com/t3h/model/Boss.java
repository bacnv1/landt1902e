package com.t3h.model;

import image.ImageLoader;

import java.util.Random;

public class Boss extends Tank {

    private Random rd = new Random();

    public Boss(int x, int y) {
        super(x, y);
        orient = DOWN;
        images[LEFT] = ImageLoader.getImage("bossyellow_left.png");
        images[RIGHT] = ImageLoader.getImage("bossyellow_right.png");
        images[UP] = ImageLoader.getImage("bossyellow_up.png");
        images[DOWN] = ImageLoader.getImage("bossyellow_down.png");
    }

    private void createOrient(){
        int percent = rd.nextInt(101);
        if (percent < 95){
            return;
        }
        int newOrient = rd.nextInt(4);
        setOrient(newOrient);
    }

    @Override
    public void move() {
        createOrient();
        super.move();
    }
}
