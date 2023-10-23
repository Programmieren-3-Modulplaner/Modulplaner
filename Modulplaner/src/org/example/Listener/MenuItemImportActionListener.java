package org.example.Listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import org.example.Import;


/**
 * Öffnet ein Öffnendialog für das einfügen einer Datei.
 * @author Daniel Grimm
 */
public class MenuItemImportActionListener  implements ActionListener{
    
    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("Open öffnen");
        new Import();
        /*JFileChooser chooser = new JFileChooser();
        // Dialog zum Oeffnen von Dateien anzeigen
        chooser.showOpenDialog(null);
        */
    }
}
