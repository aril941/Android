package com.example.uts;

public class PayModel {
    private String nama;
    private int gambar;

    public PayModel(String nama, int gambar) {
        this.nama = nama;
        this.gambar = gambar;
    }

    public PayModel(){}

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public int getGambar() {
        return gambar;
    }

    public void setGambar(int gambar) {
        this.gambar = gambar;
    }
}
