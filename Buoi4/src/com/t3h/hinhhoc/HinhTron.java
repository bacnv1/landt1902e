package com.t3h.hinhhoc;

public class HinhTron extends HinhHoc{
    private float banKinh;

    public HinhTron(String tenHinh, float banKinh) {
        super(tenHinh);
        this.banKinh = banKinh;
    }

    @Override
    public void tinhDienTich() {
        double dienTich = 3.14 * banKinh * banKinh;
        System.out.println("Dien tich: "+ dienTich);
    }

    @Override
    public void tinhChuVi() {
        double chuVi = 6.28 * banKinh;
        System.out.println("Chu vi: "+ chuVi);
    }

    @Override
    public void inThongTin() {
        super.inThongTin();
        System.out.println("Ban kinh: "+ banKinh);
    }
}
