/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package layanan;

import eksepsi.KoleksiSedangDipinjamException;
import eksepsi.KoleksiTidakLayakException;
import eksepsi.PustakaException;
import model.Koleksi;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 *
 * @author Nala
 */

public class KatalogPerpustakaan {
    private final List<Koleksi> daftarKoleksi = new ArrayList<>();

    public void tambah(Koleksi koleksi) {
        daftarKoleksi.add(koleksi);
    }

    public List<Koleksi> getDaftarKoleksi() {
        return Collections.unmodifiableList(daftarKoleksi);
    }

    /** Memproses seluruh koleksi secara polimorfik (tanpa percabangan tipe). */
    public void cetakStatus() {
        for (Koleksi k : daftarKoleksi) {
            String status = k.layakDipinjam() ? "LAYAK DIPINJAM" : "TIDAK LAYAK";
            String dipinjam = k.isSedangDipinjam() ? " | sedang dipinjam" : "";
            System.out.println(k.deskripsi() + " => " + status + dipinjam);
        }
    }

    /** Aturan pengurutan ditentukan dari luar lewat Comparator. */
    public void urut(Comparator<? super Koleksi> pembanding) {
        daftarKoleksi.sort(pembanding);
    }

    /** Meminjam koleksi berdasarkan kode; melempar eksepsi sesuai keadaan. */
    public void pinjam(String kode) throws PustakaException {
        Koleksi koleksi = cari(kode);
        if (koleksi == null) {
            throw new PustakaException("Maaf, koleksi dengan kode " + kode
                    + " tidak ditemukan di katalog.");
        }
        if (koleksi.isSedangDipinjam()) {
            throw new KoleksiSedangDipinjamException(koleksi.getJudul());
        }
        if (!koleksi.layakDipinjam()) {
            throw new KoleksiTidakLayakException(koleksi.getJudul(), koleksi.alasanTidakLayak());
        }
        koleksi.tandaiDipinjam();
    }

    private Koleksi cari(String kode) {
        for (Koleksi k : daftarKoleksi) {
            if (k.getKode().equalsIgnoreCase(kode)) {
                return k;
            }
        }
        return null;
    }
}
