/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package model;

/**
 *
 * @author Nala
 */

public abstract class Koleksi {
    private final String kode;
    private final String judul;
    private final int tahunTerbit;
    private boolean sedangDipinjam;

    protected Koleksi(String kode, String judul, int tahunTerbit) {
        this.kode = kode;
        this.judul = judul;
        this.tahunTerbit = tahunTerbit;
        this.sedangDipinjam = false;
    }

    public abstract boolean layakDipinjam();

    public String alasanTidakLayak() {
        return "tidak memenuhi syarat peminjaman";
    }

    public String deskripsi() {
        return "[" + kode + "] " + judul + " (" + tahunTerbit + ")";
    }

    public String getKode() { return kode; }
    public String getJudul() { return judul; }
    public int getTahunTerbit() { return tahunTerbit; }
    public boolean isSedangDipinjam() { return sedangDipinjam; }

    public void tandaiDipinjam() { this.sedangDipinjam = true; }
    public void tandaiDikembalikan() { this.sedangDipinjam = false; }
}
