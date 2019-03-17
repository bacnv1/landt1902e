package com.t3h.main;

import com.t3h.connguoi.NhanVien;

public class Main {
    public static void main(String[] args) {
        NhanVien nhanVien = new NhanVien("Nguyen Van A",
                12, true, "Ha Noi", "Giam Doc", 199999000);
        nhanVien.inThongTin();
    }

}
