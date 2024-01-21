package org.example.MenuBar;

import javax.swing.JCheckBoxMenuItem;
import org.example.Listener.MenuItemBestandenlisteItemListner;
import org.example.Modulplaner;

/**
 * Klasse für das JMenuItem zum anzeigen/ausblenden der Bestandenliste
 * <p>Siehe: {@link org.example.Bestandenliste}
 * <p>Listener: {@link org.example.Listener.MenuItemBestandenlisteItemListner}
 * @author Niels Fricke {@literal <}Niels.Fricke{@literal @}t-online.de{@literal @}>
 */
public class MenuItemBestandenlisteVisible extends JCheckBoxMenuItem{
    MenuItemBestandenlisteVisible (Modulplaner p, String t){
        super();
        this.setText(t);
        this.setSelected(p.isBestandenlisteIsVisible());
        this.addItemListener(new MenuItemBestandenlisteItemListner(p));
        setIcon(null);
    }
}