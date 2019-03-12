package com.t3h.connguoi;

import com.t3h.dongvat.Meo;

public class NguoiMau extends ConNguoi{
    private String cty;
    private Meo meo;

    public NguoiMau(String ten, int tuoi, String diaChi, String ngheNghiep, boolean gioiTinh, String cty, Meo meo) {
        super(ten, tuoi, diaChi, ngheNghiep, gioiTinh);
        this.cty = cty;
        this.meo = meo;
    }

    @Override
    public void datDongVatDiDao() {
        System.out.println("Dat meo di shopping");
    }

    @Override
    public void inThongTin() {
        super.inThongTin();
        System.out.println("Cong ty: "+ cty);
        meo.inThongTin();
        meo.batChuot();
    }
}
