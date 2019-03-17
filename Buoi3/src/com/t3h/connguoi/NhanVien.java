package com.t3h.connguoi;

public class NhanVien extends ConNguoi {
    String chucVu;
    int luong;

    public NhanVien(String ten, int tuoi, boolean gioiTinh, String diaChi,
                    String chucVu, int luong) {
        super.nhap(ten, tuoi, gioiTinh, diaChi);
        this.chucVu = chucVu;
        this.luong = luong;
    }


    @Override
    public void inThongTin() {
        super.inThongTin();
        System.out.println("Chuc Vu: " + chucVu);
        System.out.println("Luong: " + luong);
    }

    void lamViec() {
        System.out.println("Lam viec kiem tien");
    }

    void hop() {
        System.out.println("Hop giai quyet cong viec");
    }
}
