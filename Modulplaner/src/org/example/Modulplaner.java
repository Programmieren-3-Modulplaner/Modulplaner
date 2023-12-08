/*
 * Copyright 2022 Niels Fricke
 * <Niels.Fricke@t-online.de>
 */
package org.example;

import java.awt.BorderLayout;
import java.awt.event.KeyEvent;
import java.io.IOException;
import javax.swing.Action;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import org.example.DAO.Modul;
import org.example.DAO.ModuleDAO;
import org.example.Listener.WindowEventListener;
import org.example.MenuBar.MenuBar;
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
    private final int anzahlBloecke = 8;

    public Action menuItemNewAction, menuItemImportAction, menuItemExportAction, menuItemBeendenAction, menuItemAboutAction, menuItemHilfeAction;

    public org.example.DAO.Module module;
    private String dateiName;

    private JPanel kursplan, kursliste, info, bestandenliste;

    private boolean kursplanIsVisible = true, kurslisteIsVisible = true, infoIsVisible = true, bestandenlisteIsVisible = true;

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
        menuItemNewAction = new MenuItemNewAction(this, "Neu ", createIcon("/icons/60.gif"), "Erstellt ein neues Modul.", KeyEvent.VK_N);
        menuItemImportAction = new MenuItemImportAction(this, "Import ", createIcon("/icons/53.gif"), "Importieren von Modulen.", KeyEvent.VK_I);
        menuItemExportAction = new MenuItemExportAction(this, "Export ", createIcon("/icons/86.gif"), "Exportieren von Modulen.", KeyEvent.VK_E);
        menuItemBeendenAction = new MenuItemBeendenAction(this, "Beenden ", createIcon("/icons/33.gif"), "Programm beenden.", KeyEvent.VK_B);
        menuItemAboutAction = new MenuItemAboutAction(this, "About ", createIcon("/icons/72.gif"), "About Modulplaner", KeyEvent.VK_A);
        menuItemHilfeAction = new MenuItemHilfeAction(this, "Hilfe ", createIcon("/icons/73.gif"), "Hilfe, ich weiß nicht mehr weiter!", KeyEvent.VK_H);

        //---------------------------------------------
        //Initial Window Config's
        setTitle("Planer");
        addWindowListener(new WindowEventListener(this));
        setSize(1200, 600);
        setLocationRelativeTo(null);

        setJMenuBar(new MenuBar("Modulplaner", this));

        setLayout(new BorderLayout(10, 10));

        kursplan = new Kursplan(this);
        add(kursplan, BorderLayout.SOUTH);

        kursliste = new Kursliste(this);
        add(kursliste, BorderLayout.WEST);

        info = new Info(this, false, null);
        add(info, BorderLayout.CENTER);
        
        bestandenliste = new Bestandenliste(this);
        add(bestandenliste, BorderLayout.EAST);

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
        return anzahlBloecke;
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
}
