package org.example.Listener.Button;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JPanel;
import javax.swing.JTextField;
import org.example.Modul;

public class NewSpeicherButtonActionListener implements ActionListener {
    private JTextField modulnameField;
    private JTextField modultagField;
    private JTextField timeFieldAnfang;
    private JTextField timeFieldEnde;
    private ArrayList<Modul> datenListe;
    private JPanel leftPanel;
    private JPanel centerPanel;

    public NewSpeicherButtonActionListener(JTextField modulnameField, JTextField modultagField, JTextField timeFieldAnfang, JTextField timeFieldEnde, ArrayList<Modul> datenListe) {
        this.modulnameField = modulnameField;
        this.modultagField = modultagField;
        this.timeFieldAnfang = timeFieldAnfang;
        this.timeFieldEnde = timeFieldEnde;
        this.datenListe = datenListe;
        this.leftPanel = leftPanel;
        this.centerPanel = centerPanel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Holen Sie die eingegebenen Daten aus den Textfeldern
        String modulname = modulnameField.getText();
        String modultag = modultagField.getText();
        int anfang = Integer.parseInt(timeFieldAnfang.getText());
        int ende = Integer.parseInt(timeFieldEnde.getText());

        // Erstellen Sie ein Modul-Objekt und fügen Sie es zur Liste hinzu
        Modul neuesModul = new Modul(modulname, modultag, anfang, ende);
        datenListe.add(neuesModul);

        // Hier können Sie weitere Aktionen für das Speichern ausführen oder die Liste anzeigen.
        System.out.println("Modul gespeichert: " + neuesModul.getName() + ", Anfang: " + neuesModul.getAnfang() + ", Ende: " + neuesModul.getEnde());
        
        // Modulliste wird aktualisiert und angezeigt
        Modul.updateModulList(datenListe, leftPanel, centerPanel);

        // Optional: Setzen Sie die Textfelder zurück
        modulnameField.setText("");
        modultagField.setText("");
        timeFieldAnfang.setText("");
        timeFieldEnde.setText("");
    }
}