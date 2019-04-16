package com.t3h.manager;

import com.t3h.gui.MyFrame;
import com.t3h.model.Boss;
import com.t3h.model.Bullet;
import com.t3h.model.MapTank;
import com.t3h.model.Player;

import java.awt.*;
import java.util.ArrayList;

public class GameManager {

    private Player player;
    private ArrayList<Boss> arrBoss;
    private ArrayList<MapTank> arrMap;
    private ArrayList<Bullet> arrBossBullet;
    private ArrayList<Bullet> arrPlayerBullet;
    private MapManager mapManager = new MapManager();

    public void initGame() {
        player = new Player(300, 400);

        arrBossBullet = new ArrayList<>();
        arrPlayerBullet = new ArrayList<>();

        arrBoss = new ArrayList<>();
        initBoss();

        arrMap = mapManager.readMap("map1.txt");
    }

    public void initBoss() {
        if (arrBoss.size() > 2) return;
        Boss b = new Boss(0, 0);
        arrBoss.add(b);
        Boss b1 = new Boss(MyFrame.W_FRAME / 2, 0);
        arrBoss.add(b1);
        Boss b2 = new Boss(MyFrame.W_FRAME - 100, 0);
        arrBoss.add(b2);
    }

    public void draw(Graphics2D g2d) {
        for (Bullet b: arrBossBullet) {
            b.draw(g2d);
        }

        for (Bullet b: arrPlayerBullet) {
            b.draw(g2d);
        }

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
        player.move(arrMap);
    }

    public void playerFire(){
        player.fire(arrPlayerBullet);
    }

    private boolean handleBullet(ArrayList<Bullet> arrBullet){
        for (int i = arrBullet.size() - 1; i >= 0; i--) {
            boolean check = arrBullet.get(i).move();
            if (check == false){
                arrBullet.remove(i);
                continue;
            }
            for (int j = 0; j < arrMap.size(); j++) {
                Rectangle rect = arrBullet.get(i).getRect()
                        .intersection(arrMap.get(j).getRect());
                int bit = arrMap.get(j).getBit();
                if (bit == 4 || bit == 2) continue;
                if (rect.isEmpty() == false){
                    arrBullet.remove(i);
                    if (bit == 1){
                        arrMap.remove(j);
                    }else if (bit == 3){
                        return false;
                    }
                    break;
                }
            }
        }
        return true;
    }

    public boolean AI() {
        for (int i = arrBoss.size() - 1; i >= 0; i--) {
            arrBoss.get(i).fire(arrBossBullet);
            arrBoss.get(i).move(arrMap);
            boolean check = arrBoss.get(i).checkDie(arrPlayerBullet);
            if (check){
                arrBoss.remove(i);
                initBoss();
            }
        }
        boolean check1 = handleBullet(arrBossBullet);
        boolean check2 = handleBullet(arrPlayerBullet);
        if (check1 == false || check2 == false){
            return false;
        }
        return !player.checkDie(arrBossBullet);
    }
}
