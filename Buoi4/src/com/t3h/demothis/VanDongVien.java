package com.t3h.demothis;

public class VanDongVien {
    private String ten;
    private int tuoi;

    public VanDongVien(String ten) {
        this.ten = ten;
    }

    class NguoiMau{
        private int tuoi;

        public void soSanh(){
            if (VanDongVien.this.tuoi > tuoi){
                System.out.println("VDV lon hon");
            }else if (VanDongVien.this.tuoi < tuoi){
                System.out.println("Nguoi mau lon hon");
            }else{
                System.out.println("Bang nhau");
            }
        }
    }
}
