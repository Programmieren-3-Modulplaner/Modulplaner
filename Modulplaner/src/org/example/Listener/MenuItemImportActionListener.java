package org.example.Listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import org.example.Import;
import org.example.Modulplaner;

/**
 * Öffnet ein Öffnendialog für das einfügen einer Datei.
 *
 * @author Daniel Grimm
 */
public class MenuItemImportActionListener implements ActionListener {

    
    private Modulplaner parent;

    public MenuItemImportActionListener(Modulplaner p) {
        this.parent = p;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("Open öffnen");
        new Import(parent);
    }
}
