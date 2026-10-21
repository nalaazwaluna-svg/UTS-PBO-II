/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package layanan;

import model.Koleksi;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 *
 * @author Nala
 */

public class EksporKatalog {

    public void ekspor(KatalogPerpustakaan katalog, String namaBerkas) throws IOException {
        List<Koleksi> data = katalog.getDaftarKoleksi();

        int lebarJenis = "Jenis".length();
        int lebarKode = "Kode".length();
        int lebarJudul = "Judul".length();
        for (Koleksi k : data) {
            lebarJenis = Math.max(lebarJenis, k.getClass().getSimpleName().length());
            lebarKode = Math.max(lebarKode, k.getKode().length());
            lebarJudul = Math.max(lebarJudul, k.getJudul().length());
        }

        String format = "%-" + lebarJenis + "s  %-" + lebarKode + "s  %-" + lebarJudul
                + "s  %5s  %-14s%n";

        try (PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(namaBerkas)))) {
            out.printf(format, "Jenis", "Kode", "Judul", "Tahun", "Layak Pinjam");
            out.println(garis(lebarJenis + lebarKode + lebarJudul + 5 + 14 + 8));
            for (Koleksi k : data) {
                out.printf(format, k.getClass().getSimpleName(), k.getKode(), k.getJudul(),
                        k.getTahunTerbit(), k.layakDipinjam() ? "Ya" : "Tidak");
            }
        }
    }

    private String garis(int panjang) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < panjang; i++) {
            sb.append('-');
        }
        return sb.toString();
    }
}
