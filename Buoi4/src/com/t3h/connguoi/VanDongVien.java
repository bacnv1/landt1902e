package com.t3h.connguoi;


import com.t3h.dongvat.Cho;

public class VanDongVien extends ConNguoi{
    private Cho cho;
    private int soBanThang;
    private String cauLacBo;
    private int soAo;

    public VanDongVien(String ten, int tuoi, String diaChi, String ngheNghiep, boolean gioiTinh, Cho cho, int soBanThang, String cauLacBo, int soAo) {
        super(ten, tuoi, diaChi, ngheNghiep, gioiTinh);
        this.cho = cho;
        this.soBanThang = soBanThang;
        this.cauLacBo = cauLacBo;
        this.soAo = soAo;
    }

    @Override
    public void inThongTin() {
        super.inThongTin();
        System.out.println("Cau Lac Bo: "+ cauLacBo);
        System.out.println("So Ban Thang: "+ soBanThang);
        System.out.println("So Ao: "+ soAo);
        cho.inThongTin();
        cho.sua();
    }

    @Override
    public void datDongVatDiDao() {
        System.out.println("Dat cho di dao cong vien");
    }
}
