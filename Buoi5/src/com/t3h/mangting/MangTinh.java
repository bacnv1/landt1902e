package com.t3h.mangting;

import java.util.Arrays;
import java.util.Comparator;

public class MangTinh {
    private Integer[] arr = new Integer[5];

    public MangTinh() {
        arr[0] = 10;
        arr[1] = 2;
        arr[2] = 5;
        arr[3] = 0;
        arr[4] = 7;
    }

    public void inMang() {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + "\t");
        }
        System.out.println();
    }

    public void sapXep() {
        Arrays.sort(arr, comparator);
    }

    private Comparator<Integer> comparator = new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            if (o1 > o2) {
                return -1;
            }
            return 0;
        }
    };
}
