/*
 * Copyright 2022 Niels Fricke
 * <Niels.Fricke@t-online.de>
 */
package org.example;

import java.awt.BorderLayout;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.util.*;
import javax.swing.Action;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import org.example.DAO.Modul;
import org.example.DAO.ModulManager;
import org.example.DAO.ModulManagerDAO;
import org.example.Listener.WindowEventListener;
import org.example.MenuBar.MenuBar;
import org.example.MenuBar.ToolBar;
import org.example.actions.AboutAction;
import org.example.actions.BeendenAction;
import org.example.actions.ExportAction;
import org.example.actions.ExportCSVAction;
import org.example.actions.HilfeAction;
import org.example.actions.ImportAction;
import org.example.actions.ModulNeuAction;
import org.example.actions.SpracheAendernAction;

/**
 * Haupt Klasse für den Modulplaner
 * @author Niels Fricke {@literal <}Niels.Fricke{@literal @}t-online.de{@literal @}>
 */
public class Modulplaner extends JFrame {

    /**
     * Enum für die Tage (Config der Tage)
     */
    public enum tage {
        Montag, Dienstag, Mittwoch, Donnerstag, Freitag, Samstag
    };
    private String[] bloecke = {"8:15-9:45", "10:15-11:45", "12:15-13:45", "14:15-15:45", "16:00-17:30", "17:45-19:15", "19:30-20:45"};
    private int maxAnzahlVersuche = 3;
    
    /**
     * Programm Actions für die Menubar und Toolbar
     */
    public Action modulNeuAction, importAction, exportAction, beendenAction, aboutAction, hilfeAction, spracheAendernAction, exportCSVAction;

    /**
     * Arraylist für die gespeicherten Module
     */
    public ModulManager modulManager;
    private String dateiName;

    private Kursliste kursliste;
    private Kursplan kursplan;
    private Info info;
    private Bestandenliste bestandenliste;
    private MenuBar menubar;
    private ToolBar toolbar;

    private boolean kursplanIsVisible = true, kurslisteIsVisible = true, infoIsVisible = true, bestandenlisteIsVisible = true;
    //private spracheDAO sprache;
    private int language = -1;
    private String[] availableLanguages = {"de","en","fr","klingonisch"};
    
    /**
     * Konstruktor liest die gespeicherten Module und generiert das Hauptfenster
     */
    public Modulplaner() {

        dateiName = new File(System.getProperty("user.home"))+"/Modulplaner.dat";
        modulManager = new ModulManager();

        ModulManagerDAO daoInitialRead = new ModulManagerDAO(dateiName, false, this);
        try {
            daoInitialRead.read(modulManager);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        daoInitialRead.close();

        //modulManager.printTest();
         
        actionsErstellen();

        //Initial Window Config's
        setTitle(sprache("Titel"));
        
        String iconPfad = "src/icons/planer_49.png";
        setIconImage(new ImageIcon(iconPfad).getImage());
        
        addWindowListener(new WindowEventListener(this));

        menubar = new MenuBar("Modulplaner", this);
        setJMenuBar(menubar);
        
        setLayout(new BorderLayout(10, 10));
        
        toolbar = new ToolBar(this);
        add(toolbar, BorderLayout.NORTH);
        
        kursliste = new Kursliste(this);
        add(kursliste, BorderLayout.WEST);

        kursplan = new Kursplan(this);
        add(kursplan, BorderLayout.SOUTH);

        info = new Info(this, false, null);
        add(info, BorderLayout.CENTER);
        
        bestandenliste = new Bestandenliste(this);
        add(bestandenliste, BorderLayout.EAST);

        pack();
        setLocationRelativeTo(null);
        
        setVisible(true);

    }

    /**
     * Ruft den Modulplaner() Konstruktor auf und konfiguriert die Menubar für Mac PC's
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        if (System.getProperty("os.name") != null && System.getProperty("os.name").toLowerCase().indexOf("mac") != -1) {
            //System.getProperties().put("apple.laf.useScreenMenuBar", "true");
            System.setProperty("apple.laf.useScreenMenuBar", "true");
        }
        new Modulplaner();
    }
    
    /**
     * Setzen der Sprache und abrufen des jeweiligen Sprachenattributs anhand des Keys
     * Mögliche Sprachen sind (de/en/fr/klingonisch)
     * @param key Int wert für die Sprache (Index von private String[] availableLanguages)
     * @return Übersetzung
     */
    public String sprache(String key){
        Locale currentLocale;
        ResourceBundle messages;

        currentLocale = new Locale(availableLanguages[language]);

        messages = ResourceBundle.getBundle("i18n/Bundle", currentLocale);
        return messages.getString(key);
        
    }
    
    /**
     * Baut den Kursplan neu und ersetzt diesen: {@link org.example.Kursplan}
     * 
     */
    public void KursplanAktualisieren() {
        this.remove(kursplan);
        if (kursplanIsVisible == true) {
            kursplan = new Kursplan(this);
            add(kursplan, BorderLayout.SOUTH);
        }
        SwingUtilities.updateComponentTreeUI(this);
    }

    /**
     * Baut die Kursliste neu und ersetzt diesen: {@link org.example.Kursliste}
     */
    public void KurslisteAktualisieren() {
        this.remove(kursliste);
        if (kurslisteIsVisible == true) {
            kursliste = new Kursliste(this);
            add(kursliste, BorderLayout.WEST);
        }
        SwingUtilities.updateComponentTreeUI(this);
    }

    /**
     * Baut die Info neu und ersetzt diesen: {@link org.example.Info}
     * @param isEnable Siehe {@link org.example.Info}
     * @param modul Siehe {@link org.example.Info}
     */
    public void InfoAktualisieren(boolean isEnable, Modul modul) {
        this.remove(info);
        if (infoIsVisible == true) {
            info = new Info(this, isEnable, modul);
            add(info, BorderLayout.CENTER);
        }
        SwingUtilities.updateComponentTreeUI(this);
    }

    /**
     * Baut die Bestandenliste neu und ersetzt diesen: {@link org.example.Bestandenliste}
     */
    public void BestandenlisteAktualisieren() {
        this.remove(bestandenliste);
        if (bestandenlisteIsVisible == true) {
            bestandenliste = new Bestandenliste(this);
            add(bestandenliste, BorderLayout.EAST);
        }
        SwingUtilities.updateComponentTreeUI(this);
    }
 
    /**
     * Baut alle Panels des Modulplaners, sowie die Actions, die Menubar und die Toolbar neu 
     * <p>{@link org.example.MenuBar}
     * <p>{@link org.example.actions}
     * <p>{@link org.example.MenuBar.ToolBar}
     */
    public void SpracheAktualisieren() {
        
        actionsErstellen();
        KurslisteAktualisieren();
        KursplanAktualisieren();
        InfoAktualisieren(true, info.getModul());
        BestandenlisteAktualisieren();
        
        this.remove(menubar);
        menubar = new MenuBar("Modulplaner", this);
        setJMenuBar(menubar);
        
        this.remove(toolbar);
        toolbar = new ToolBar(this);
        add(toolbar, BorderLayout.NORTH);
        
        setTitle(sprache("Titel"));
        
        SwingUtilities.updateComponentTreeUI(this);
    }
    
    /**
     * Erstellt (überschreibt) die ModulNeuAction, ImportAction, ExportAction, BeendenAction, AboutAction, HilfeAction, SpracheAendernAction und ExportCSVAction
     */
    public void actionsErstellen (){
        modulNeuAction = new ModulNeuAction(this, sprache("Neu"), createIcon("/icons/60.gif"), sprache("NeuText"), KeyEvent.VK_N);
        importAction = new ImportAction(this, sprache("Import"), createIcon("/icons/52.gif"), sprache("ImportText"), KeyEvent.VK_I);
        exportAction = new ExportAction(this, sprache("Export"), createIcon("/icons/22.gif"), sprache("ExportText"), KeyEvent.VK_E);
        beendenAction = new BeendenAction(this, sprache("Beenden"), createIcon("/icons/33.gif"), sprache("BeendenText"), KeyEvent.VK_B);
        aboutAction = new AboutAction(this, sprache("Über"), createIcon("/icons/72.gif"), sprache("ÜberText"), KeyEvent.VK_A);
        hilfeAction = new HilfeAction(this, sprache("Hilfe"), createIcon("/icons/73.gif"), sprache("HilfeText"), KeyEvent.VK_H);
        spracheAendernAction = new SpracheAendernAction(this, sprache("TitelSprache"), createIcon("/icons/48.gif"), sprache("TitelSprache"), KeyEvent.VK_L);
        exportCSVAction = new ExportCSVAction(this, sprache("CSV"), createIcon("/icons/86.gif"), sprache("ExportTextCSV"), KeyEvent.VK_E);
        
    }

    /**
     * Erstellt Icons 
     * @param filePath Speicherort des Icons
     * @return Icon
     */
    public ImageIcon createIcon(String filePath) {
        java.net.URL imgURL = getClass().getResource(filePath);

        if (imgURL == null) {
            System.err.println("Resource not found: " + imgURL);
            return null;
        } else {
            return new ImageIcon(imgURL);
        }
    }

    //-------------------------------

    public String getDateiName() {
        return dateiName;
    }

    public int getAnzahlBloecke() {
        return bloecke.length;
    }

    public String[] getBloecke() {
        return bloecke;
    }

    public int getMaxAnzahlVersucheInt() {
        return maxAnzahlVersuche;
    }
    
    public String getMaxAnzahlVersucheString() {
        return String.valueOf(maxAnzahlVersuche);
    }

    public int getLanguageInt() {
        return language;
    }
    
    public String getLanguageString() {
        return availableLanguages[language];
    }

    public String[] getAvailableLanguages() {
        return availableLanguages;
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
    
    //----------------------------------
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

    /**
     * Setzt die Sprache (language) im Modulplaner sowie das Locale
     * @param l Int wert für die Sprache (Index von private String[] availableLanguages)
     */
    public void setLanguage(int l) {
        if (l >= 0 && l < availableLanguages.length) {
            this.language = l;
            
            Locale newLocale;
            newLocale = switch (l) {
                case 0 -> Locale.GERMANY;
                case 1 -> Locale.ENGLISH;
                case 2 -> Locale.FRANCE;
                default -> Locale.getDefault();
            }; // Add more cases as needed
        Locale.setDefault(newLocale);
        JComponent.setDefaultLocale(newLocale);
        }
    }
    
}
