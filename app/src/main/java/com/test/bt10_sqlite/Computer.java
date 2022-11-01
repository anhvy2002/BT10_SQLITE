package com.test.bt10_sqlite;

public class Computer {
    private  int maMay;
    private String tenMay;
    private String gia;
    private String maLoai;

    public Computer(int maMay, String tenMay, String gia, String maLoai) {
        this.maMay = maMay;
        this.tenMay = tenMay;
        this.gia = gia;
        this.maLoai = maLoai;
    }

    public int getMaMay() {
        return maMay;
    }

    public void setMaMay(int maMay) {
        this.maMay = maMay;
    }

    public String getTenMay() {
        return tenMay;
    }

    public void setTenMay(String tenMay) {
        this.tenMay = tenMay;
    }

    public String getGia() {
        return gia;
    }

    public void setGia(String gia) {
        this.gia = gia;
    }

    public String getMaLoai() {
        return maLoai;
    }

    public void setMaLoai(String maLoai) {
        this.maLoai = maLoai;
    }
}
