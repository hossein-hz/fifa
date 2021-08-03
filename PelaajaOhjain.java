/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI_Pelaaja;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import javax.swing.JFileChooser;

/**
 *
 * @author hossein
 */
public class PelaajaOhjain {

    private GUI_Pelaaja nakyma;
    private Tilausmalli malli;
    private int naytettavaLista;

    public PelaajaOhjain(Tilausmalli malli, GUI_Pelaaja nakyma) {
        this.malli = malli;
        this.nakyma = nakyma;
        naytettavaLista = 0;

    }

    public void talletaNaytettavaLista(int lista) {
        this.naytettavaLista = lista;
    }

    public void aikaNyt() {
        LocalDateTime nyt = LocalDateTime.now();
        String tunnit, minuutit, sekunnit;

        if (nyt.getHour() < 10) {
            tunnit = "0" + nyt.getHour();
        } else {
            tunnit = "" + nyt.getHour();
        }

        if (nyt.getMinute() < 10) {
            minuutit = "0" + nyt.getMinute();
        } else {
            minuutit = "" + nyt.getMinute();
        }

        if (nyt.getSecond() < 10) {
            sekunnit = "0" + nyt.getSecond();
        } else {
            sekunnit = "" + nyt.getSecond();
        }

        String pvm = nyt.getDayOfMonth() + "." + nyt.getMonthValue() + "." + nyt.getYear();
        String klo = tunnit + ":" + minuutit + ":" + sekunnit;
        nakyma.uusiPvm(pvm);
        nakyma.uusiKlo(klo);

    }

    public void lisaaPelaaja() {
        
        
        String pvm = nakyma.annaUusiPvm();
        String klo = nakyma.annaUusiKlo();
        String pelaajannimi = nakyma.annaUusiPnimi();
        String liigannimi = nakyma.annaUusiLnimi();
        String joukunnimi = nakyma.annaUusiJnimi();
        String paikka = nakyma.annaUusiPaikka();
        String taso = nakyma.annaUusiTaso();

        
        malli.lisaaPelaaja(pvm, klo, pelaajannimi, liigannimi, joukunnimi, paikka, taso);
        nakyma.nollaaLisaysKentat();
        UusinLista();
        nakyma.poistaLista(false);

    }

    public void UusinLista() {
        int indeksi = malli.annaListanMaara() - 1;
        if (indeksi == -1) {		// ei mittauksia
            nakyma.naytettavaAika("");
            nakyma.naytettavaPnimi("");
            nakyma.naytettavaLnimi("");
            nakyma.naytettavaTaso("");
            nakyma.Edellinen(true);
            nakyma.Seuraava(true);
            nakyma.poistaLista(true);
            return;
        }

        nakyma.naytettavaAika(malli.annaListanAika(indeksi));
        nakyma.naytettavaPnimi(malli.annaListanpNimi(indeksi));
        nakyma.naytettavaLnimi(malli.annaListanlNimi(indeksi));
        nakyma.naytettavaJnimi(malli.annaListanjNimi(indeksi));
        nakyma.naytettavaPaikka(malli.annaListanpaikka(indeksi));
        nakyma.naytettavaTaso(malli.annaListantaso(indeksi));

        if (indeksi > 0) {
            nakyma.Edellinen(false);
        } else {
            nakyma.Edellinen(true);
        }

        nakyma.Seuraava(true);

        this.naytettavaLista = indeksi;
    }

    public void seuraavaLista() {
        int indeksi = this.naytettavaLista + 1;

        if (indeksi >= malli.annaListanMaara()) {
            return;
        }

        nakyma.naytettavaAika(malli.annaListanAika(indeksi));
        nakyma.naytettavaPnimi(malli.annaListanpNimi(indeksi));
        nakyma.naytettavaLnimi(malli.annaListanlNimi(indeksi));
        nakyma.naytettavaJnimi(malli.annaListanjNimi(indeksi));
        nakyma.naytettavaPaikka(malli.annaListanpaikka(indeksi));
        nakyma.naytettavaTaso(malli.annaListantaso(indeksi));

        if (indeksi == (malli.annaListanMaara() - 1)) {
            nakyma.Seuraava(true);
        }

        this.naytettavaLista = indeksi;
        nakyma.Edellinen(false);
    }

    public void edellinenLista() {
        int indeksi = this.naytettavaLista - 1;

        if (indeksi < 0) {
            return;
        }

        nakyma.naytettavaAika(malli.annaListanAika(indeksi));
        nakyma.naytettavaPnimi(malli.annaListanpNimi(indeksi));
        nakyma.naytettavaLnimi(malli.annaListanlNimi(indeksi));
        nakyma.naytettavaJnimi(malli.annaListanjNimi(indeksi));
        nakyma.naytettavaPaikka(malli.annaListanpaikka(indeksi));
        nakyma.naytettavaTaso(malli.annaListantaso(indeksi));

        if (indeksi == 0) {
            nakyma.Edellinen(true);
        }

        this.naytettavaLista = indeksi;
        nakyma.Seuraava(false);
    }

    public void poistaLista() {
        int indeksi = this.naytettavaLista;

        if (indeksi >= malli.annaListanMaara()) {
            return;
        }

        malli.poistaPelaaja(indeksi);

        UusinLista();

    }
}
