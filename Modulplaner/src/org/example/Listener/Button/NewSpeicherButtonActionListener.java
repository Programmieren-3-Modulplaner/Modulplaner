package org.example.Listener.Button;


import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.swing.BorderFactory;
import javax.swing.JComboBox;
import javax.swing.JTextField;


import org.example.DAO.ModuleDAO;
import org.example.Modul;

public class NewSpeicherButtonActionListener implements ActionListener {
    private JTextField modulnameField;
    private JComboBox tagBox;
    private JComboBox blockBox;
   
    String ModulList = "data/ModulList.dat";
    
    public Modul modul = new Modul();

   public NewSpeicherButtonActionListener(JTextField modulnameField, JComboBox tagBox, JComboBox blockBox) {
        this.modulnameField = modulnameField;
        this.tagBox = tagBox;
        this.blockBox = blockBox;
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
       
    try {
        // Holen der eingegebenen Daten aus den Feldern
        String modulname = modulnameField.getText();
        
        int tag = tagBox.getSelectedIndex();
        int block = blockBox.getSelectedIndex();
        
        //Überprüfung ob die Felder ausgefüllt sind -> Makierung in Rot falls nicht
        if (modulname.isEmpty() || tag == 0 || block == 0) {
            
            System.out.println("Bitte alle Felder ausfüllen.");
            
            if (modulname.isEmpty()) {
                modulnameField.setBorder(BorderFactory.createLineBorder(Color.RED));
            }   else     {
                modulnameField.setBorder(null);
            }
            
            if (tag== 0) {
                tagBox.setBorder(BorderFactory.createLineBorder(Color.RED));
            } else {
                tagBox.setBorder(null);
            }
            
            if (block == 0) {
                blockBox.setBorder(BorderFactory.createLineBorder(Color.RED));
            } else{ 
                blockBox.setBorder(null);
            }
                // Beende die Methode, da die Eingabe nicht gültig ist
                return;
        }
        
        // Initalisierung des neuen Moduls
        Modul neuesModul = new Modul(modulname, tag, block);

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
            System.out.println(m.getBlock());
            System.out.println("-------");
        }

        // Zurücksetzen der Textfelder: 1. Border Fare; 2. Inhalt der Felder
        modulnameField.setBorder(null);
        tagBox.setBorder(null);
        blockBox.setBorder(null);
        
        modulnameField.setText("");
        tagBox.setSelectedIndex(0);
        blockBox.setSelectedIndex(0);
        
    } catch (IOException ex) {
        ex.printStackTrace();
        System.out.println("Fehler beim Speichern des Moduls: " + ex.getMessage());
    }
    }
}
