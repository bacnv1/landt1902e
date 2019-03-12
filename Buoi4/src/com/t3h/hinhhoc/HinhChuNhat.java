package com.t3h.hinhhoc;

public class HinhChuNhat extends HinhHoc{
    private float chieuDai;
    private float chieuRong;

    public HinhChuNhat(String tenHinh, float chieuDai, float chieuRong) {
        super(tenHinh);
        this.chieuDai = chieuDai;
        this.chieuRong = chieuRong;
    }

    @Override
    public void tinhDienTich() {
        double dienTich = chieuDai * chieuRong;
        System.out.println("Dien tich la: "+ dienTich);
    }

    @Override
    public void tinhChuVi() {
        double chuVi = (chieuDai + chieuRong) * 2;
        System.out.println("Chu vi la: "+ chuVi);
    }

    @Override
    public void inThongTin() {
        super.inThongTin();
        System.out.println("Chieu dai: "+ chieuDai);
        System.out.println("Chieu rong: "+ chieuRong);
    }
}
