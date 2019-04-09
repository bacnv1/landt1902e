package com.t3h.manager;

import com.t3h.model.MapTank;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.util.ArrayList;

public class MapManager {

    public ArrayList<MapTank> readMap(String name) {
        ArrayList<MapTank> arr = new ArrayList<>();
        try {
            File f = new File("src/map_tank/" + name);
            FileReader reader = new FileReader(f);
            BufferedReader buffer = new BufferedReader(reader);
            int j = 0;
            String line = buffer.readLine();
            while (line != null) {
                for (int i = 0; i < line.length(); i++) {
                    int bit = Integer.parseInt(line.charAt(i) + "");
                    if (bit > 0) {
                        int x = 19 * i;
                        int y = 19 * j;
                        MapTank map = new MapTank(x, y, bit);
                        arr.add(map);
                    }
                }
                j++;
                line = buffer.readLine();
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return arr;
    }

}
