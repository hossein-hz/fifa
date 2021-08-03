/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI_Pelaaja;

/**
 *
 * @author hossein
 */
import java.io.Serializable;
import java.util.ArrayList;

public class Tilausmalli implements Serializable {

    private ArrayList<Pelaaja_tiedot> listat;

    public Tilausmalli() {
        this.listat = new ArrayList<Pelaaja_tiedot>();
    }

    public int annaListanMaara() {
        return this.listat.size();
    }

    public String annaListanAika(int nro) {
        if (nro >= 0 && nro < annaListanMaara()) {
            return this.listat.get(nro).annaAika();
        } else {
            return null;
        }
    }

    public String annaListanpNimi(int nro) {
        if (nro >= 0 && nro < annaListanMaara()) {
            return this.listat.get(nro).annapNimi();
        } else {
            return null;
        }
    }

    public String annaListanlNimi(int nro) {
        if (nro >= 0 && nro < annaListanMaara()) {
            return this.listat.get(nro).annalNimi();
        } else {
            return null;
        }
    }

    public String annaListanjNimi(int nro) {
        if (nro >= 0 && nro < annaListanMaara()) {
            return this.listat.get(nro).annajNimi();
        } else {
            return null;
        }
    }
    
    public String annaListanpaikka(int nro) {
        if (nro >= 0 && nro < annaListanMaara()) {
            return this.listat.get(nro).annapaikka();
        } else {
            return null;
        }
    }
    
    public String annaListantaso(int nro) {
        if (nro >= 0 && nro < annaListanMaara()) {
            return this.listat.get(nro).annataso();
        } else {
            return null;
        }
    }

    public void lisaaPelaaja(String pvm, String klo, String pNimi, String lNimi, String jNimi, String paikka, String taso) {
        String aika = pvm + " klo " + klo;
        Pelaaja_tiedot l = new Pelaaja_tiedot(aika, pNimi, lNimi, jNimi, paikka, taso);
        this.listat.add(l);
    }

    public void lisaaPelaaja(String pvm, String pNimi, String lNimi, String jNimi, String paikka, String taso) {
        String aika = pvm;
        Pelaaja_tiedot l = new Pelaaja_tiedot(aika, pNimi, lNimi, jNimi, paikka, taso);
        this.listat.add(l);
    }

    public void poistaPelaaja(int index) {

        this.listat.remove(index);
    }
}
