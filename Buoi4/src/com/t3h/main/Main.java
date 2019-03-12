package com.t3h.main;

import com.t3h.connguoi.ConNguoi;
import com.t3h.connguoi.NguoiMau;
import com.t3h.connguoi.VanDongVien;
import com.t3h.dongvat.Cho;
import com.t3h.dongvat.DongVat;
import com.t3h.dongvat.Meo;

public class Main {
    public static void main(String[] args) {
        Cho cho = new Cho("Cucu", 2, true, "Tay tang");
        VanDongVien vdv = new VanDongVien("Nguyen Van A",
                23, "Ha Noi",
                "Van dong vien bong da",
                true, cho, 100, "Mu", 10);
        vdv.inThongTin();
        vdv.datDongVatDiDao();
        System.out.println("=====================");
        Meo meo = new Meo("Kiki",1,false, "Tam the");
        NguoiMau nm = new NguoiMau("Nguyen Thi B",
                20,"Ha Noi", "Nguoi Mau",
                false, "ABC", meo);
        nm.inThongTin();
        nm.datDongVatDiDao();
    }
}
