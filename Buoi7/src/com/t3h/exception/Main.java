package com.t3h.exception;

public class Main {
    public static void main(String[] args) {
        try {
            int a = Integer.parseInt("3");
            System.out.println("Gia tri: " + a);
            String s = null;
            char c = s.charAt(10);
        }catch (Exception ex){
            ex.printStackTrace();
        }
        System.out.println("Ket thuc");
    }
}
