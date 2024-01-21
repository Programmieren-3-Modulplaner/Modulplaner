package org.example.MenuBar;

import javax.swing.JCheckBoxMenuItem;
import org.example.Listener.MenuItemKursplanItemListner;
import org.example.Modulplaner;

/**
 * Klasse für das JMenuItem zum anzeigen/ausblenden des Kursplans
 * <p>Siehe: {@link org.example.Kursplan}
 * <p>Listener: {@link org.example.Listener.MenuItemKursplanItemListner}
 * @author Niels Fricke {@literal <}Niels.Fricke{@literal @}t-online.de{@literal @}>
 */
public class MenuItemKursplanVisible extends JCheckBoxMenuItem{
    MenuItemKursplanVisible (Modulplaner p, String t){
        super();
        this.setText(t);
        this.setSelected(p.isKursplanIsVisible());
        this.addItemListener(new MenuItemKursplanItemListner(p));
        setIcon(null);
    }
}