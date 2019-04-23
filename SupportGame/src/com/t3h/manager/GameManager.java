package com.t3h.manager;

import com.t3h.gui.MyFrame;
import com.t3h.model.MapTank;
import com.t3h.model.Player;
import com.t3h.model.Tank;

import java.awt.*;
import java.util.ArrayList;

public class GameManager {

    private Player player;
    private ArrayList<MapTank> arrMap;
    private MapManager mapManager = new MapManager();

    public void initGame() {
        player = new Player(300, 200);
        arrMap = mapManager.readMap("map1.txt");
    }

    public void draw(Graphics2D g2d) {
        player.draw(g2d);

        for (MapTank map : arrMap) {
            map.draw(g2d);
        }
    }

    public void playerMove(int orient) {
        player.setOrient(orient);
        // doi anh
        player.changeImage();

        // kiểm tra kịch đầu -> di chuyển nhân vật
        if (orient == Tank.LEFT &&
                arrMap.get(0).getX() >= 0) {
            player.move(arrMap);
            return;
        }
        // kiểm tra kịch cuối -> di chuyển nhân vật
        if (orient == Tank.RIGHT &&
                arrMap.get(arrMap.size() - 1).getX() <= MyFrame.W_FRAME) {
            player.move(arrMap);
            return;
        }
        // Kiểm tra giữa
        if (player.getX() != MyFrame.W_FRAME / 2.5) {
            player.move(arrMap);
            return;
        }

        // di chuển map
        for (MapTank m : arrMap) {
            m.move(orient);
        }
    }


    public void playerJump() {
        player.jump();
    }

    public boolean AI() {
        // nhân vật tự động rơi
        player.fall(arrMap);
        return true;
    }
}
