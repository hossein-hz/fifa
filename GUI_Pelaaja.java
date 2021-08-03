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
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.BorderFactory; 
import java.awt.*;
import java.awt.event.*;

public class GUI_Pelaaja implements Runnable {

    private JFrame frame;
    // Tiedoston käsittely
    private JTextField tiedostonNimi;

    // Oikea puoli
    private JTextField naytaAika;
    private JTextField naytaPnimi;
    private JTextField naytaLnimi;
    private JTextField naytaJnimi;
    private JTextField naytaPaikka;
    private JTextField naytaTaso;
    

    // Vasen puoli
    private JTextField uusiPvm;
    private JTextField uusiKlo;
    private JTextField uusiPnimi;
    private JTextField uusiLnimi;
    private JTextField uusiJnimi;
    private JTextField uusiPaikka;
    private JTextField uusiTaso;
    

    // Napit
    private JButton edellinen;
    private JButton seuraava;
    private JButton poista;
    private JButton lisaa;
    private JButton poistaKaikki;
    private JButton avaaTiedosto;
    private JButton talletaTiedosto;

    

    private PelaajaOhjain ohjain;
    private Tilaustietojen_käsittely kasittely;

    public GUI_Pelaaja(Tilausmalli malli) {
        this.ohjain = new PelaajaOhjain(malli, this);
        this.kasittely = new Tilaustietojen_käsittely(this, malli);
    }

    public PelaajaOhjain annaOhjain() {
        return this.ohjain;
    }

    public JFrame annaFrame() {
        return frame;
    }

    public void naytettavaAika(String aika) {
        naytaAika.setText(aika);
    }

    public String annaAika() {
        return naytaAika.getText();
    }

    public void naytettavaPnimi(String Pelaajanimi) {
        naytaPnimi.setText(Pelaajanimi);
    }

    public String annaPnimi() {
        return naytaPnimi.getText();
    }

    public void naytettavaLnimi(String Liigannimi) {
        naytaLnimi.setText(Liigannimi);
    }

    public String annaLnimi() {
        return naytaLnimi.getText();
    }

    public void naytettavaJnimi(String Juokunnimi) {
        naytaJnimi.setText(Juokunnimi);
    }

    public String annaJnimi() {
        return naytaJnimi.getText();
    }

    
    
    public void naytettavaPaikka(String paikka) {
        naytaPaikka.setText(paikka);
    }

    public String annaPaikka() {
        return naytaPaikka.getText();
    }

    
    public void naytettavaTaso(String taso) {
        naytaTaso.setText(taso);
    }

    public String annaTaso() {
        return naytaTaso.getText();
    }

    

    public void uusiPvm(String pvm) {
        uusiPvm.setText(pvm);
    }

    public void uusiKlo(String klo) {
        uusiKlo.setText(klo);
    }

    public String annaUusiPvm() {
        return uusiPvm.getText();
    }

    public String annaUusiKlo() {
        return uusiKlo.getText();
    }

    public String annaUusiPnimi() {
        return uusiPnimi.getText();
    }

    public String annaUusiLnimi() {
        return uusiLnimi.getText();
    }

    public String annaUusiJnimi() {
        return uusiJnimi.getText();
    }
    public String annaUusiPaikka() {
        return uusiPaikka.getText();
    }
    public String annaUusiTaso() {
        return uusiTaso.getText();
    }

    public void nollaaLisaysKentat() {
        uusiPnimi.setText("");
        uusiLnimi.setText("");
        uusiJnimi.setText("");
        uusiPaikka.setText("");
        uusiTaso.setText("");
    }

    public void Edellinen(boolean lukitus) {
        edellinen.setEnabled(!lukitus);
    }

    public void Seuraava(boolean lukitus) {
        seuraava.setEnabled(!lukitus);
    }

    public void poistaLista(boolean lukitus) {
        poista.setEnabled(!lukitus);
    }

    public String annaTiedostonNimi() {
        return tiedostonNimi.getText();
    }

    @Override
    public void run() {
        frame = new JFrame("FIFA.COM");

        Komponentit(frame.getContentPane());

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        ohjain.UusinLista();

        frame.setResizable(false);

        ohjain.UusinLista();

        ActionListener aikaMittaus = new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                ohjain.aikaNyt();
            }
        };

        Timer ajastin = new Timer(1000, aikaMittaus);
        ajastin.setInitialDelay(0);
        ajastin.start();

        frame.pack();
        frame.setVisible(true);

    }

    private void Komponentit(Container sailio) {

        // Tiedosto paneeli
        tiedostonNimi = new JTextField(40);

        // Aika paneeli
        naytaAika = new JTextField(20);
        naytaAika.setEditable(false);

        // Pelaajan nimi, Ligaan nimi, Joukoen nimi, Paikka, taso
        naytaPnimi = new JTextField(20);
        naytaPnimi.setEditable(false);
        naytaLnimi = new JTextField(20);
        naytaLnimi.setEditable(false);
        naytaJnimi = new JTextField(20);
        naytaJnimi.setEditable(false);
        naytaPaikka = new JTextField(20);
        naytaPaikka.setEditable(false);
        naytaTaso = new JTextField(5);
        naytaTaso.setEditable(false);

        // Varaosien pvm,klo ja paikka
        uusiPvm = new JTextField(6);
        uusiPvm.setEditable(false);
        uusiKlo = new JTextField(6);
        uusiKlo.setEditable(false);
        uusiPnimi = new JTextField(15);
        uusiPnimi.setBorder(BorderFactory.createEtchedBorder(0));
        uusiLnimi = new JTextField(15);
        uusiLnimi.setBorder(BorderFactory.createEtchedBorder(0));
        uusiJnimi = new JTextField(15);
        uusiJnimi.setBorder(BorderFactory.createEtchedBorder(0));
        uusiPaikka = new JTextField(15);
        uusiPaikka.setBorder(BorderFactory.createEtchedBorder(0));
        uusiTaso = new JTextField(5);
        uusiTaso.setBorder(BorderFactory.createEtchedBorder(0));
        

        // Painonapit
        edellinen = new JButton("<< Edellinen");
        edellinen.setBackground(Color.yellow);
        seuraava = new JButton("Seuraava >>");
        seuraava.setBackground(Color.yellow);
        poista = new JButton(" Poista Pelaaja ");
        poista.setBackground(Color.yellow);
        lisaa = new JButton(" Lisää Pelaaja ");
        lisaa.setBackground(Color.green);
        poistaKaikki = new JButton(" Pois kaikki ");
        poistaKaikki.setBackground(Color.green);
        avaaTiedosto = new JButton(" Avaa ");
        avaaTiedosto.setBackground(Color.white);
        talletaTiedosto = new JButton(" Talleta ");
        talletaTiedosto.setBackground(Color.white);

        // Nappia
        edellinen.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ohjain.edellinenLista();

            }
        });

        seuraava.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ohjain.seuraavaLista();

            }
        });

        poista.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ohjain.poistaLista();

            }
        });

        lisaa.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ohjain.lisaaPelaaja();

            }
        });

        poistaKaikki.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                uusiPnimi.setText("");
                uusiLnimi.setText("");
                uusiJnimi.setText("");
                uusiPaikka.setText("");
                uusiTaso.setText("");
            }
        });

        talletaTiedosto.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                kasittely.talletaTiedosto();

            }
        });

        avaaTiedosto.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                kasittely.avaaTiedosto();

            }
        });
        

        // Vasen paneeli 
        JPanel vasen = new JPanel();
        BoxLayout vasenAsemointi = new BoxLayout(vasen, BoxLayout.PAGE_AXIS);
        vasen.setLayout(vasenAsemointi);
        vasen.setBorder(BorderFactory.createRaisedBevelBorder());

        // Oikean paneeli
        JPanel oikea = new JPanel();
        BoxLayout oikeaAsemointi = new BoxLayout(oikea, BoxLayout.PAGE_AXIS);
        oikea.setLayout(oikeaAsemointi);
        oikea.setBorder(BorderFactory.createRaisedBevelBorder());

        // Tiedosto paneeli
        JPanel tiedosto = new JPanel();
        BoxLayout tiedostoAsemointi = new BoxLayout(tiedosto, BoxLayout.PAGE_AXIS);
        tiedosto.setLayout(tiedostoAsemointi);
        tiedosto.setBorder(BorderFactory.createRaisedBevelBorder());

        // Tiedoston käsittely napit
        JPanel tiedostoPaneeli = new JPanel();
        tiedostoPaneeli.add(avaaTiedosto);
        tiedostoPaneeli.add(talletaTiedosto);
        tiedostoPaneeli.add(tiedostonNimi);
        tiedostonNimi.setBorder(BorderFactory.createEtchedBorder(0));

        tiedosto.add(tiedostoPaneeli);

        // Vasen puoli
        JPanel aikaPaneeliO = new JPanel(new FlowLayout(FlowLayout.LEADING));
        JPanel pNimiPaneeliO = new JPanel(new FlowLayout(FlowLayout.LEADING));
        JPanel lNimiPaneeliO = new JPanel(new FlowLayout(FlowLayout.LEADING));
        JPanel jNimiPaneeliO = new JPanel(new FlowLayout(FlowLayout.LEADING));
        JPanel paikkaPaneeliO = new JPanel(new FlowLayout(FlowLayout.LEADING));
        JPanel tasoPaneeliO = new JPanel(new FlowLayout(FlowLayout.LEADING));
        

        // Klo, pvm, auton merkki ja rekisterinomero
        JLabel pvmLabelO = new JLabel("Pvm: ");
        JLabel kloLabelO = new JLabel("   Klo: ");
        JLabel pNimiLabelO = new JLabel("Pelaajan nimi:       ");
        JLabel lNimiLabelO = new JLabel("Liigan nimi:            ");
        JLabel jNimiLabelO = new JLabel("Joukun nimi:         ");
        JLabel paikkaLabelO = new JLabel("Paikka:                   ");
        JLabel tasoLabelO = new JLabel("taso:                       ");

        aikaPaneeliO.add(pvmLabelO);
        aikaPaneeliO.add(uusiPvm);
        aikaPaneeliO.add(kloLabelO);
        aikaPaneeliO.add(uusiKlo);
        pNimiPaneeliO.add(pNimiLabelO);
        pNimiPaneeliO.add(uusiPnimi);
        lNimiPaneeliO.add(lNimiLabelO);
        lNimiPaneeliO.add(uusiLnimi);
        jNimiPaneeliO.add(jNimiLabelO);
        jNimiPaneeliO.add(uusiJnimi);
        paikkaPaneeliO.add(paikkaLabelO);
        paikkaPaneeliO.add(uusiPaikka);
        tasoPaneeliO.add(tasoLabelO);
        tasoPaneeliO.add(uusiTaso);
        
        vasen.add(aikaPaneeliO);
        vasen.add(pNimiPaneeliO);
        vasen.add(lNimiPaneeliO);
        vasen.add(jNimiPaneeliO);
        vasen.add(paikkaPaneeliO);
        vasen.add(tasoPaneeliO);        

        // Oikean aikapaneeli
        JPanel aikaPaneeliV = new JPanel(new FlowLayout(FlowLayout.LEADING));
        JLabel aikaLabelV = new JLabel("Aika:                        ");
        aikaPaneeliV.add(aikaLabelV);
        aikaPaneeliV.add(naytaAika);
        oikea.add(aikaPaneeliV);

        // Oikean auton merkki ja rekisterinumero paneeli
        JLabel pNimiLabelV = new JLabel("Pelaajan nimi:       ");
        JPanel pNimiPaneeliV = new JPanel(new FlowLayout(FlowLayout.LEADING));
        pNimiPaneeliV.add(pNimiLabelV);
        pNimiPaneeliV.add(naytaPnimi);
        oikea.add(pNimiPaneeliV);

        JLabel lNimiLabelV = new JLabel("Liigan nimi:            ");
        JPanel lNimiPaneeliV = new JPanel(new FlowLayout(FlowLayout.LEADING));
        lNimiPaneeliV.add(lNimiLabelV);
        lNimiPaneeliV.add(naytaLnimi);
        oikea.add(lNimiPaneeliV);
        
        JLabel jNimiLabelV = new JLabel("Joukun nimi:          ");
        JPanel jNimiPaneeliV = new JPanel(new FlowLayout(FlowLayout.LEADING));
        jNimiPaneeliV.add(jNimiLabelV);
        jNimiPaneeliV.add(naytaJnimi);
        oikea.add(jNimiPaneeliV);
        
        JLabel paikkaLabelV = new JLabel("Paikka:                   ");
        JPanel paikkaPaneeliV = new JPanel(new FlowLayout(FlowLayout.LEADING));
        paikkaPaneeliV.add(paikkaLabelV);
        paikkaPaneeliV.add(naytaPaikka);
        oikea.add(paikkaPaneeliV);
        
        JLabel tasoLabelV = new JLabel("Taso:                       ");
        JPanel tasoPaneeliV = new JPanel(new FlowLayout(FlowLayout.LEADING));
        tasoPaneeliV.add(tasoLabelV);
        tasoPaneeliV.add(naytaTaso);
        oikea.add(tasoPaneeliV);

        // Varaosien tulospaneeli 
        /*JPanel tulosPaneeliV = new JPanel(new FlowLayout(FlowLayout.LEADING));
        JLabel tulosLabelV = new JLabel("Varaosia: ");
        tulosPaneeliV.add(tulosLabelV);
        JScrollPane naytaTulosScroll = new JScrollPane(naytaJnimi);
        naytaTulosScroll.setBorder(new LineBorder(Color.BLACK, 0));
        tulosPaneeliV.setBackground(Color.LIGHT_GRAY);
        oikea.add(tulosPaneeliV);
        oikea.add(naytaTulosScroll);*/

        // Oikea nappit
        JPanel nappiPaneeliV = new JPanel(new FlowLayout(FlowLayout.LEFT));
        nappiPaneeliV.setBackground(Color.LIGHT_GRAY);
        nappiPaneeliV.add(edellinen);
        nappiPaneeliV.add(seuraava);
        nappiPaneeliV.add(poista);
        oikea.add(nappiPaneeliV);

        // Vasen varaosien paneeli
        /*JPanel tulosPaneeliO = new JPanel(new FlowLayout(FlowLayout.LEADING));
        JLabel tulosLabelO = new JLabel("Varaosia: ");
        tulosPaneeliO.add(tulosLabelO);
        JScrollPane uusiTulosScroll = new JScrollPane(uusiJnimi);
        uusiTulosScroll.setBorder(new LineBorder(Color.BLACK, 0));
        tulosPaneeliO.setBackground(Color.LIGHT_GRAY);
        vasen.add(tulosPaneeliO);
        vasen.add(uusiTulosScroll);*/

        // Luo vasen nappit
        JPanel nappiPaneeliO = new JPanel(new FlowLayout(FlowLayout.LEFT));
        nappiPaneeliO.setBackground(Color.LIGHT_GRAY);
        nappiPaneeliO.add(lisaa);
        vasen.add(nappiPaneeliO);

        nappiPaneeliO.add(poistaKaikki);
        vasen.add(nappiPaneeliO);

        // Vasen puoli
        JPanel vasenWrapper = new JPanel();
        vasenWrapper.setBorder(new EmptyBorder(5, 5, 5, 5));
        vasenWrapper.add(vasen);

        // Oikea puoli
        JPanel oikeaWrapper = new JPanel();
        oikeaWrapper.setBorder(new EmptyBorder(5, 5, 5, 5));
        oikeaWrapper.add(oikea);

        // Kokoa tiedosto osa
        JPanel tiedostoWrapper = new JPanel();
        tiedostoWrapper.setBorder(new EmptyBorder(5, 5, 5, 5));
        tiedostoWrapper.add(tiedosto);

        // Näytä tiedosto
        sailio.add(tiedostoWrapper, BorderLayout.AFTER_LAST_LINE);

        // Näytä oikea puoli
        sailio.add(vasenWrapper, BorderLayout.WEST);

        // Näytä vasen puoli
        sailio.add(oikeaWrapper, BorderLayout.EAST);

    }

    public static void main(String[] args) {

        Tilausmalli malli = new Tilausmalli();
        GUI_Pelaaja varaosa = new GUI_Pelaaja(malli);

        // laittaa sovelluksen suoritusjonoon odottamaan vuoroaan
        SwingUtilities.invokeLater(varaosa);
    }
}
