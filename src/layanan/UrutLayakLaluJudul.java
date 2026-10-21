/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package layanan;

import model.Koleksi;

import java.util.Comparator;

/**
 *
 * @author Nala
 */

public class UrutLayakLaluJudul implements Comparator<Koleksi> {
    private final Comparator<Koleksi> berlapis =
            Comparator.comparing((Koleksi k) -> !k.layakDipinjam())   // false (layak) lebih dulu
                      .thenComparing(Koleksi::getJudul, String.CASE_INSENSITIVE_ORDER);

    @Override
    public int compare(Koleksi a, Koleksi b) {
        return berlapis.compare(a, b);
    }
}
