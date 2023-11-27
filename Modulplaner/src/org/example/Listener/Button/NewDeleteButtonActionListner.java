
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
        // Erstellen Sie eine Instanz von ModulDAO und rufen Sie deleteLast auf
        //ModuleDAO delDAO = new ModuleDAO(ModulList, false); // Verwenden Sie den richtigen Dateinamen
        try {
            ModuleDAO delDAO = new ModuleDAO(ModulList, false); // Verwenden Sie den richtigen Dateinamen
            Modul modul = new Modul();
            delDAO.read(modul);
            delDAO.close();
            
            //delDAO.deleteLast(modul);
            
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
            System.out.println("Letzte Eintragung gelöscht");
    }    
}