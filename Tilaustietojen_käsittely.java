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
import java.io.*;
import javax.swing.JFileChooser;
import javax.swing.JTextArea;

public class Tilaustietojen_käsittely {

    private GUI_Pelaaja nakyma;
    private Tilausmalli malli;

    public Tilaustietojen_käsittely(GUI_Pelaaja nakyma, Tilausmalli malli) {
        this.nakyma = nakyma;
        this.malli = malli;
    }

    public void talletaTiedosto() {
        try {
            JFileChooser fc = new JFileChooser();
            String thisLine;
            int returnVal = fc.showSaveDialog(nakyma.annaFrame());

            // String talletanPaikka = "C:\\NetBeans\\";
            // String file_name = nakyma.annaTiedostonNimi();
            FileWriter file = new FileWriter(fc.getSelectedFile().getPath());
            BufferedWriter out = new BufferedWriter(file);
            StringBuffer tiedostonNimi = new StringBuffer(nakyma.annaAika());

            tiedostonNimi.append(System.lineSeparator());
            tiedostonNimi.append(System.lineSeparator());
            tiedostonNimi.append(nakyma.annaPnimi());
            tiedostonNimi.append(System.lineSeparator());
            tiedostonNimi.append(nakyma.annaLnimi());
            tiedostonNimi.append(System.lineSeparator());
            tiedostonNimi.append(System.lineSeparator());
            tiedostonNimi.append(nakyma.annaJnimi());
            tiedostonNimi.append(System.lineSeparator());
            tiedostonNimi.append(nakyma.annaPaikka());
            tiedostonNimi.append(System.lineSeparator());
            tiedostonNimi.append(nakyma.annaTaso());

            out.write(tiedostonNimi.toString());
            out.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }

    public void avaaTiedosto() {
        try {
            nakyma.naytettavaJnimi("");
            JFileChooser fc = new JFileChooser();
            String thisLine;
            int returnVal = fc.showOpenDialog(nakyma.annaFrame());
            if (returnVal == JFileChooser.APPROVE_OPTION) {
                File file = fc.getSelectedFile();
                BufferedReader input = new BufferedReader(new InputStreamReader(
                        new FileInputStream(file)));
                int indeksi = 0;
                while ((thisLine = input.readLine()) != null) {
                    if (indeksi == 0) {
                        nakyma.naytettavaAika(thisLine);
                    } else if (indeksi == 2) {
                        nakyma.naytettavaPnimi(thisLine);
                    } else if (indeksi == 3) {
                        nakyma.naytettavaLnimi(thisLine);
                    } else if (indeksi == 4) {
                        nakyma.naytettavaJnimi(thisLine);
                    } else if (indeksi == 5) {
                        nakyma.naytettavaPaikka(thisLine);
                    } else if (indeksi > 6) {
                        nakyma.naytettavaTaso(nakyma.annaTaso().equals("") ? thisLine : nakyma.annaTaso() + System.lineSeparator() + thisLine);    
                    }
                    indeksi++;
                }

                malli.lisaaPelaaja(nakyma.annaAika(), nakyma.annaPnimi(), nakyma.annaLnimi(), nakyma.annaJnimi(), nakyma.annaPaikka(), nakyma.annaTaso());
                nakyma.poistaLista(false);
                indeksi = malli.annaListanMaara() - 1;
                if (indeksi > 0) {
                    nakyma.Edellinen(false);

                    nakyma.annaOhjain().talletaNaytettavaLista(indeksi);
                } else {
                    nakyma.Edellinen(true);
                    nakyma.Seuraava(true);
                }
            }

        } catch (IOException e) {
            System.out.println(e.getMessage());

        }
    }
}
