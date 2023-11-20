package org.example.Listener.Button;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JTextField;
import org.example.DAO.ModuleDAO;
import org.example.Modul;

public class NewSpeicherButtonActionListener implements ActionListener {
    private JTextField modulnameField;
    private JTextField modultagField;
    private JTextField timeFieldAnfang;
    private JTextField timeFieldEnde;
    private ArrayList<Modul> datenListe;
    String ModulList = "data/ModulList.dat";

    public NewSpeicherButtonActionListener(JTextField modulnameField, JTextField modultagField, JTextField timeFieldAnfang, JTextField timeFieldEnde, ArrayList<Modul> datenListe) {
        this.modulnameField = modulnameField;
        this.modultagField = modultagField;
        this.timeFieldAnfang = timeFieldAnfang;
        this.timeFieldEnde = timeFieldEnde;
        this.datenListe = datenListe;
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Holen Sie die eingegebenen Daten aus den Textfeldern
        String modulname = modulnameField.getText();
        String modultag = modultagField.getText();
        int anfang = Integer.parseInt(timeFieldAnfang.getText());
        int ende = Integer.parseInt(timeFieldEnde.getText());

        // Erstellen Sie ein Modul-Objekt und fügen Sie es zur Liste hinzu
        Modul modul = new Modul();
        datenListe.add(modul);

        // Erstellen Sie ein ModulDAO-Objekt
        ModuleDAO moduleDAO = new ModuleDAO(ModulList, true);

        try {
            // Füge das Modul zur Liste hinzu und speichere in Datei
            moduleDAO.write(modul);
        } catch (IOException ex) {
            ex.printStackTrace();
            System.out.println("Fehler beim Speichern des Moduls: " + ex.getMessage());
        } finally {
            // Schließe das ModulDAO-Objekt
            moduleDAO.close();
        }

        // Hier können Sie weitere Aktionen für das Speichern ausführen oder die Liste anzeigen.
        
        // Optional: Setzen Sie die Textfelder zurück
        modulnameField.setText("");
        modultagField.setText("");
        timeFieldAnfang.setText("");
        timeFieldEnde.setText("");
    }

}