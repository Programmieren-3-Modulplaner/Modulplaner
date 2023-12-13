/*
 * Copyright 2022 Niels Fricke
 * <Niels.Fricke@t-online.de>
 */
package org.example;

import java.awt.BorderLayout;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.*;
import javax.swing.Action;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import org.example.DAO.Modul;
import org.example.DAO.ModuleDAO;
import org.example.Listener.WindowEventListener;
import org.example.MenuBar.MenuBar;
import org.example.MenuBar.ToolBar;
import org.example.actions.MenuItemAboutAction;
import org.example.actions.MenuItemBeendenAction;
import org.example.actions.MenuItemExportAction;
import org.example.actions.MenuItemHilfeAction;
import org.example.actions.MenuItemImportAction;
import org.example.actions.MenuItemNewAction;

/**
 * @author Niels Fricke <Niels.Fricke@t-online.de>
 */
public class Modulplaner extends JFrame {

    /**
     * @param args the command line arguments
     */
    public enum tage {
        Montag, Dienstag, Mittwoch, Donnerstag, Freitag, Samstag
        
    };
    private String[] bloecke = {"8:15-9:45", "10:15-11:45", "12:15-13:45", "14:15-15:45", "16:00-17:30", "17:45-19:15", "19:30-20:45"};
    
    public Action modulNeuAction, importAction, exportAction, beendenAction, aboutAction, hilfeAction;

    public org.example.DAO.Module module;
    private String dateiName;

    private JPanel kursplan, kursliste, info, bestandenliste;

    private boolean kursplanIsVisible = true, kurslisteIsVisible = true, infoIsVisible = true, bestandenlisteIsVisible = true;
    //public config dateiname;
    
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
        //---------------------------------------------
        //Actions erstellen:
        modulNeuAction = new MenuItemNewAction(this, sprache("Neu"), createIcon("/icons/60.gif"), sprache("NeuText"), KeyEvent.VK_N);
        importAction = new MenuItemImportAction(this, sprache("Import"), createIcon("/icons/53.gif"), sprache("ImportText"), KeyEvent.VK_I);
        exportAction = new MenuItemExportAction(this, sprache("Export"), createIcon("/icons/86.gif"), sprache("ExportText"), KeyEvent.VK_E);
        beendenAction = new MenuItemBeendenAction(this, sprache("Beenden"), createIcon("/icons/33.gif"), sprache("BeendenText"), KeyEvent.VK_B);
        aboutAction = new MenuItemAboutAction(this, sprache("Über"), createIcon("/icons/72.gif"), sprache("ÜberText"), KeyEvent.VK_A);
        hilfeAction = new MenuItemHilfeAction(this, sprache("Hilfe"), createIcon("/icons/73.gif"), sprache("HilfeText"), KeyEvent.VK_H);

        //---------------------------------------------
        //Initial Window Config's
        setTitle(sprache("Titel"));
        addWindowListener(new WindowEventListener(this));

        setJMenuBar(new MenuBar("Modulplaner", this));
        
        setLayout(new BorderLayout(10, 10));
        
        add(new ToolBar(this), BorderLayout.NORTH);

        kursplan = new Kursplan(this);
        add(kursplan, BorderLayout.SOUTH);

        kursliste = new Kursliste(this);
        add(kursliste, BorderLayout.WEST);

        info = new Info(this, false, null);
        add(info, BorderLayout.CENTER);
        
        bestandenliste = new Bestandenliste(this);
        add(bestandenliste, BorderLayout.EAST);

        pack();
        setLocationRelativeTo(null);
        
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
    
    /**
     * Setzen der Sprache und abrufen des jeweiligen Sprachenattributs anhand des Keys
     * Mögliche Sprachen sind (de/en/fr/klingonisch)
     * @param key
     * @return 
     */
    public String sprache(String key){
        
        String language = "de";
        
        Locale currentLocale;
        ResourceBundle messages;

        currentLocale = new Locale(language);

        messages = ResourceBundle.getBundle("i18n/Bundle", currentLocale);
        return messages.getString(key);
        
    }
    
    public void KursplanAktualisieren() {
        this.remove(kursplan);
        if (kursplanIsVisible == true) {
            kursplan = new Kursplan(this);
            add(kursplan, BorderLayout.SOUTH);
        }
        SwingUtilities.updateComponentTreeUI(this);
    }

    public void KurslisteAktualisieren() {
        this.remove(kursliste);
        if (kurslisteIsVisible == true) {
            kursliste = new Kursliste(this);
            add(kursliste, BorderLayout.WEST);
        }
        SwingUtilities.updateComponentTreeUI(this);
    }

    public void InfoAktualisieren(boolean isEnable, Modul modul) {
        this.remove(info);
        if (infoIsVisible == true) {
            info = new Info(this, isEnable, modul);
            add(info, BorderLayout.CENTER);
        }
        SwingUtilities.updateComponentTreeUI(this);
    }

    public void BestandenlisteAktualisieren() {
        this.remove(bestandenliste);
        if (bestandenlisteIsVisible == true) {
            bestandenliste = new Bestandenliste(this);
            add(bestandenliste, BorderLayout.EAST);
        }
        SwingUtilities.updateComponentTreeUI(this);
    }

    public ImageIcon createIcon(String filePath) {
        java.net.URL imgURL = getClass().getResource(filePath);

        if (imgURL == null) {
            System.err.println("Resource not found: " + imgURL);
            return null;
        } else {
            return new ImageIcon(imgURL);
        }
    }

    public String getDateiName() {
        return dateiName;
    }

    public int getAnzahlBloecke() {
        return bloecke.length;
    }

    public boolean isKursplanIsVisible() {
        return kursplanIsVisible;
    }

    public boolean isKurslisteIsVisible() {
        return kurslisteIsVisible;
    }

    public boolean isInfoIsVisible() {
        return infoIsVisible;
    }

    public boolean isBestandenlisteIsVisible() {
        return bestandenlisteIsVisible;
    }
    
    public void setKursplanIsVisible(boolean kursplanIsVisible) {
        this.kursplanIsVisible = kursplanIsVisible;
    }

    public void setKurslisteIsVisible(boolean kurslisteIsVisible) {
        this.kurslisteIsVisible = kurslisteIsVisible;
    }

    public void setInfoIsVisible(boolean infoIsVisible) {
        this.infoIsVisible = infoIsVisible;
    }

    public void setBestandenlisteIsVisible(boolean bestandenlisteIsVisible) {
        this.bestandenlisteIsVisible = bestandenlisteIsVisible;
    }

    public String[] getBloecke() {
        return bloecke;
    }
}
