
package org.example.Listener.Button;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import org.example.Modul;



public class NewDeleteButtonActionListner implements ActionListener {
 private ArrayList<Modul> datenListe;

    public NewDeleteButtonActionListner(ArrayList<Modul> datenListe) {
        this.datenListe = datenListe;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("Datengelöscht: " + datenListe);
        datenListe.clear();    }
    
}
