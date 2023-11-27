package org.example.Listener.Button;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JTextField;

import org.example.DAO.ModuleDAO;
import org.example.Modul;

public class NewSpeicherButtonActionListener implements ActionListener {
    private JTextField modulnameField;
    private JTextField modultagField;
    private JTextField timeFieldAnfang;
    private JTextField timeFieldEnde;
   
    String ModulList = "data/ModulList.dat";
    
    public Modul modul = new Modul();

   public NewSpeicherButtonActionListener(JTextField modulnameField, JTextField modultagField, JTextField timeFieldAnfang, JTextField timeFieldEnde) {
        this.modulnameField = modulnameField;
        this.modultagField = modultagField;
        this.timeFieldAnfang = timeFieldAnfang;
        this.timeFieldEnde = timeFieldEnde;
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
       
    try {
        // Holen der eingegebenen Daten aus den Feldern
        String modulname = modulnameField.getText();
        String modultag = modultagField.getText();
        int anfang = Integer.parseInt(timeFieldAnfang.getText());
        int ende = Integer.parseInt(timeFieldEnde.getText());

        // Initalisierung des neuen Moduls
        Modul neuesModul = new Modul(modulname, modultag, anfang, ende);

        // Lesen aller vorhandenen Module aus der Datei
        Modul modul = new Modul();
        ModuleDAO dao = new ModuleDAO(ModulList, false); // Lesen
        
        //Prüfung ob die Datei leer ist. Wenn ja, wird das Modul direkt in die Datei geschrieben
        //    Wenn Nein, wird erst gelesen und dann wird erst das Modul hinzugefügt
        if (dao.in.available() > 0) {
        dao.read(modul);
        }
        
        dao.close();

        // Fügen Sie das neue Modul zur Datenliste hinzu
        modul.addModul(neuesModul);

        // Schreiben Sie die gesamte Datenliste zurück in die Datei
        ModuleDAO schreibDAO = new ModuleDAO(ModulList, true); // Schreiben
        schreibDAO.write(modul);
        schreibDAO.close();

        // Debug-Ausgabe (optional)
        System.out.println("Alle Module nach dem Schreiben:");
        for (Modul m : modul.datenListe) {
            System.out.println(m.getName());
            System.out.println(m.getTag());
            System.out.println(m.getAnfang());
            System.out.println(m.getEnde());
            System.out.println("-------");
        }

        // Zurücksetzen der Textfelder
        modulnameField.setText("");
        modultagField.setText("");
        timeFieldAnfang.setText("");
        timeFieldEnde.setText("");
    } catch (IOException ex) {
        ex.printStackTrace();
        System.out.println("Fehler beim Speichern des Moduls: " + ex.getMessage());
    }
    }
}
