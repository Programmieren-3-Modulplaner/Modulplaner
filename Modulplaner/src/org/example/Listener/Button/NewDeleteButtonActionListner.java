
package org.example.Listener.Button;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;



public class NewDeleteButtonActionListner implements ActionListener {
 private ArrayList<String> datenListe;

    public NewDeleteButtonActionListner(ArrayList<String> datenListe) {
        this.datenListe = datenListe;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("Datengelöscht: " + datenListe);
        datenListe.clear();    }
    
}
