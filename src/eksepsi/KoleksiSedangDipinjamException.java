/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package eksepsi;

/**
 *
 * @author Nala
 */

public class KoleksiSedangDipinjamException extends PustakaException {
    public KoleksiSedangDipinjamException(String judul) {
        super("Maaf, \"" + judul + "\" sedang dipinjam oleh anggota lain. "
                + "Silakan coba lagi setelah koleksi dikembalikan.");
    }
}
