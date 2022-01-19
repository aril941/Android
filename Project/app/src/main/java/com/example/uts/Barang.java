package com.example.uts;

public class Barang {
//    private int id;
    private String judul;
    private String harga;
    private String deskripsi;
    private int gambar;


    public void barang(){

    }

    public Barang( String judul, String harga, String deskripsi, int gambar) {
//        this.id = id;
        this.judul = judul;
        this.harga = harga;
        this.deskripsi = deskripsi;
        this.gambar = gambar;
    }

    public String getJudul() {
        return judul;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }

    public String getHarga() {
        return harga;
    }

    public void setHarga(String harga) {
        this.harga = harga;
    }

    public String getDeskripsi() {
        return deskripsi;
    }

    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
    }

    public int getGambar() {
        return gambar;
    }

    public void setGambar(int gambar) {
        this.gambar = gambar;
    }

//    public int getId() {
//        return id;
//    }
//
//    public void setId(int id) {
//        this.id = id;
//    }
}
