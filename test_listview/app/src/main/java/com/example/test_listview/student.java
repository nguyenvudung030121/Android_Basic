package com.example.test_listview;

public class student {
   private String ten;
   private String lop;
   private String masv;
   private int hinh;

    public student(String ten, String lop, String masv, int hinh) {
        this.ten = ten;
        this.lop = lop;
        this.masv = masv;
        this.hinh = hinh;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getLop() {
        return lop;
    }

    public void setLop(String lop) {
        this.lop = lop;
    }

    public String getMasv() {
        return masv;
    }

    public void setMasv(String masv) {
        this.masv = masv;
    }

    public int getHinh() {
        return hinh;
    }

    public void setHinh(int hinh) {
        this.hinh = hinh;
    }
}
