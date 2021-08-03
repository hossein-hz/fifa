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

public class Pelaaja_tiedot implements Serializable {

    private static final long serialVersionUID = 1L;
    private String aika;
    private String pNimi;
    private String lNimi;
    private String jNimi;
    private String paikka;
    private String taso;

    public Pelaaja_tiedot(String aika, String pNimi, String lNimi, String jNimi, String paikka, String taso) {
        this.aika = aika;
        this.pNimi = pNimi;
        this.lNimi = lNimi;
        this.jNimi = jNimi;
        this.paikka = paikka;
        this.taso = taso;
    }

    public String annaAika() {
        return this.aika;
    }

    public String annapNimi() {
        return this.pNimi;
    }

    public String annalNimi() {
        return this.lNimi;
    }

    public String annajNimi() {
        return this.jNimi;
    }
    
    public String annapaikka() {
        return this.paikka;
    }
    
    public String annataso() {
        return this.taso;
    }

    @Override
    public String toString() {
        return new StringBuffer("")
                .append(this.aika).append(this.pNimi).append(this.lNimi)
                .append(this.jNimi).append(this.paikka).append(this.taso).toString();
    }
}
