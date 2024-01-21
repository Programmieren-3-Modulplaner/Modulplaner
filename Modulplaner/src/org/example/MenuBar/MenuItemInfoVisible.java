package org.example.MenuBar;

import javax.swing.JCheckBoxMenuItem;
import org.example.Listener.MenuItemInfoItemListner;
import org.example.Modulplaner;

/**
 * Klasse für das JMenuItem zum anzeigen/ausblenden der Info
 * <p>Siehe: {@link org.example.Info}
 * <p>Listener: {@link org.example.Listener.MenuItemInfoItemListner}
 * @author Niels Fricke {@literal <}Niels.Fricke{@literal @}t-online.de{@literal @}>
 */
public class MenuItemInfoVisible extends JCheckBoxMenuItem{
    MenuItemInfoVisible (Modulplaner p, String t){
        super();
        this.setText(t);
        this.setSelected(p.isInfoIsVisible());
        this.addItemListener(new MenuItemInfoItemListner(p));
        setIcon(null);
    }
}