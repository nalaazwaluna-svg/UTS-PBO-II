/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package eksepsi;

/**
 *
 * @author Nala
 */

public class KoleksiTidakLayakException extends PustakaException {
    public KoleksiTidakLayakException(String judul, String alasan) {
        super("Maaf, \"" + judul + "\" belum dapat dipinjam karena " + alasan + ".");
    }
}
