package org.example.Listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import org.example.Modulplaner;
import org.example.New;

/**
 *
 * @author Tjark Maasberg
 */
public class MenuItemNewActionListner implements ActionListener {

    private Modulplaner parent;

    public MenuItemNewActionListner(Modulplaner p) {
        this.parent = p;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("Neu öffnen");
        new New(parent);
    }
}
