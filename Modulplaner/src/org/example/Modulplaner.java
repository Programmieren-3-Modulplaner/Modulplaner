/*
 * Copyright 2022 Niels Fricke
 * <Niels.Fricke@t-online.de>
 */
package org.example;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.io.IOException;
import javax.swing.JFrame;
import org.example.DAO.ModuleDAO;
import org.example.Listener.WindowEventListener;
import org.example.MenuBar.MenuBar;

/**
 * @author Niels Fricke <Niels.Fricke@t-online.de>
 */
public class Modulplaner extends JFrame {

    /**
     * @param args the command line arguments
     */
    //public static Modulplaner app;
    //private ArrayList<Modul> module = new ArrayList();
    //public org.example.DAO.Module module;

    public enum tage {
        Montag, Dienstag, Mittwoch, Donnerstag, Freitag
    };
    public int anzahlBloecke = 8;
    
    public org.example.DAO.Module module;
    public String dateiName;
    
    public boolean kursplanIsVisible = true;
    
    public Kursplan kursplan;
    public Kursliste kursliste;

    public Modulplaner() {

        dateiName = "src/org/example/DAO/module.dat";
        module = new org.example.DAO.Module();

        // Module Initial einlesen aus Datei
        ModuleDAO daoInitialRead = new ModuleDAO(dateiName, false); // Lesen
        try {
            daoInitialRead.read(module);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        daoInitialRead.close();

        //module.printTest();
        
        //Initial Window Config's
        setTitle("Planer");
        addWindowListener(new WindowEventListener(this));
        setSize(1200, 600);
        setLocationRelativeTo(null);

        setJMenuBar(new MenuBar("Modulplaner",this));

        setLayout(new BorderLayout(0, 10));

        kursplan = new Kursplan(this);
        add(kursplan, BorderLayout.SOUTH);
        
        kursliste = new Kursliste(this);
        kursliste.setPreferredSize(new Dimension(200, 0)); //breite, höhe (nicht verstellbar bei WEST)
        add(kursliste, BorderLayout.WEST);

        setVisible(true);

    }

    public static void main(String[] args) {

        // Macht es etwas hübscher wenn es auf einem MAC gestartet wird.
        /*if (System.getProperty("os.name") != null && System.getProperty("os.name").toLowerCase().indexOf("mac") != -1) {
            //System.getProperties().put("apple.laf.useScreenMenuBar", "true");
            System.setProperty("apple.laf.useScreenMenuBar", "true");
        }*/
        
        new Modulplaner();
    }
    
    public void KursplanAktualisieren(){
        setVisible(false);
        this.remove(kursplan);
        if(kursplanIsVisible == true){
            kursplan = new Kursplan(this);
            add(kursplan, BorderLayout.SOUTH);
        }
        setVisible(true);
    }
    public void KurslisteAktualisieren(){
        setVisible(false);
        this.remove(kursliste);
        kursliste = new Kursliste(this);
        kursliste.setPreferredSize(new Dimension(200, 0)); //breite, höhe (nicht verstellbar bei WEST)
        add(kursliste, BorderLayout.WEST);
        setVisible(true);
    }

}
