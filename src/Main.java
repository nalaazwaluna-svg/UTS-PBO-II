/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import eksepsi.PustakaException;
import layanan.EksporKatalog;
import layanan.KatalogPerpustakaan;
import layanan.UrutLayakLaluJudul;
import model.BerkasDigital;
import model.BukuCetak;
import model.Majalah;

import java.io.IOException;
import java.util.Comparator;

/**
 *
 * @author Nala
 */

public class Main {
    public static void main(String[] args) {
        KatalogPerpustakaan katalog = new KatalogPerpustakaan();

        BukuCetak bk1 = new BukuCetak("BK-001", "Java How to Program", 2022, 620, "A-12", 1, false);
        BukuCetak bk2 = new BukuCetak("BK-002", "Basis Data Relasional", 2021, 410, "B-04", 2, true);
        Majalah mj1 = new Majalah("MJ-001", "Info Teknologi Edisi 88", 2026, 88, "Agustus", true, "M-01", 1);
        Majalah mj2 = new Majalah("MJ-002", "Info Teknologi Edisi 87", 2026, 87, "Juli", false, "M-02", 1);

        katalog.tambah(bk1);
        katalog.tambah(bk2);
        katalog.tambah(mj1);
        katalog.tambah(mj2);
        katalog.tambah(new BerkasDigital("BD-001", "Panduan Pemrograman Java", 2024, 15, "unduh.polmed.ac.id/bd001"));
        katalog.tambah(new BerkasDigital("BD-002", "Jurnal Rekayasa Perangkat", 2025, 8, "unduh.polmed.ac.id/bd002"));

        System.out.println("=== 1. Status Koleksi (polimorfik) ===");
        katalog.cetakStatus();

        System.out.println("\n=== 2. Ringkasan Arsip (interface Terarsip) ===");
        System.out.println(bk1.getKode() + " -> " + bk1.ringkasanArsip());
        System.out.println(bk2.getKode() + " -> " + bk2.ringkasanArsip());
        System.out.println(mj1.getKode() + " -> " + mj1.ringkasanArsip());
        System.out.println(mj2.getKode() + " -> " + mj2.ringkasanArsip());

        System.out.println("\n=== 3. Urut: layak dulu, lalu judul ===");
        katalog.urut(new UrutLayakLaluJudul());
        katalog.cetakStatus();

        System.out.println("\n=== 4. Urut: tahun terbit (Comparator lain dari luar) ===");
        katalog.urut(Comparator.comparingInt(k -> k.getTahunTerbit()));
        katalog.cetakStatus();

        System.out.println("\n=== 5. Peminjaman ===");
        String[] percobaan = {"BK-001", "BK-001", "BK-002", "MJ-001", "MJ-002", "BD-001", "XX-999"};
        for (String kode : percobaan) {
            try {
                katalog.pinjam(kode);
                System.out.println("Berhasil: koleksi " + kode + " berhasil dipinjam.");
            } catch (PustakaException e) {
                System.out.println("Gagal   : " + e.getMessage());
            }
        }

        System.out.println("\n=== 6. Ekspor ke katalog.txt ===");
        try {
            new EksporKatalog().ekspor(katalog, "katalog.txt");
            System.out.println("Berkas katalog.txt berhasil dibuat.");
        } catch (IOException e) {
            System.out.println("Gagal menulis berkas: " + e.getMessage());
        }
    }
}
