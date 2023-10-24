
package org.example.Listener.Button;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JTextField;

public class NewSpeicherButtonActionListener implements ActionListener {
    private JTextField modulnameField;
    private JTextField timeField;
    private ArrayList<String> datenListe;

    public NewSpeicherButtonActionListener(JTextField modulnameField, JTextField uhrzeitField, ArrayList<String> datenListe) {
        this.modulnameField = modulnameField;
        this.timeField = uhrzeitField;
        this.datenListe = datenListe;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Holen Sie die eingegebenen Daten aus den Textfeldern
        String modulname = modulnameField.getText();
        String uhrzeit = timeField.getText();

        // Füge die Daten zur Liste hinzu
        String datensatz = "Modulname: " + modulname + ", Uhrzeit: " + uhrzeit;
        datenListe.add(datensatz);

        // Hier kannst du weitere Aktionen für das Speichern ausführen oder die Liste anzeigen.
        System.out.println("Daten gespeichert: " + datensatz);
    }
}
