package com.t3h.manager;

import com.t3h.gui.MyFrame;
import com.t3h.model.Boss;
import com.t3h.model.MapTank;
import com.t3h.model.Player;

import java.awt.*;
import java.util.ArrayList;

public class GameManager {

    private Player player;
    private ArrayList<Boss> arrBoss;
    private ArrayList<MapTank> arrMap;
    private MapManager mapManager = new MapManager();

    public void initGame() {
        player = new Player(300, 400);

        arrBoss = new ArrayList<>();
        initBoss();

        arrMap = mapManager.readMap("map1.txt");
    }

    public void initBoss() {
        Boss b = new Boss(0, 0);
        arrBoss.add(b);
        Boss b1 = new Boss(MyFrame.W_FRAME / 2, 0);
        arrBoss.add(b1);
        Boss b2 = new Boss(MyFrame.W_FRAME - 100, 0);
        arrBoss.add(b2);
    }

    public void draw(Graphics2D g2d) {
        player.draw(g2d);

        for (Boss b : arrBoss) {
            b.draw(g2d);
        }

        for (MapTank map: arrMap) {
            map.draw(g2d);
        }
    }

    public void playerMove(int orient) {
        player.setOrient(orient);
        player.move();
    }

    public void AI() {
        for (int i = arrBoss.size() - 1; i >= 0; i--) {
            arrBoss.get(i).move();
        }
    }
}
