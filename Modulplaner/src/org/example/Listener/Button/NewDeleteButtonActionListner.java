
package org.example.Listener.Button;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;

import org.example.DAO.ModuleDAO;
import org.example.Modul;



public class NewDeleteButtonActionListner implements ActionListener {
 private ArrayList<Modul> datenListe;
 String ModulList = "data/ModulList.dat";

    public NewDeleteButtonActionListner(ArrayList<Modul> datenListe) {
        this.datenListe = datenListe;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            ModuleDAO delDAO = new ModuleDAO(ModulList, true);
            
            // Löschen Sie das letzte Modul
            delDAO.deleteLast(datenListe);
            
            
            
            System.out.println("Letzte Eintragung gelöscht");
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}