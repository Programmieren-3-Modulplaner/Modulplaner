package org.example.MenuBar;

import javax.swing.JMenuItem;
import org.example.Modulplaner;

/**
 * Klasse für das JMenuItem Beenden
 * <p>Siehe Action: {@link org.example.actions.BeendenAction}
 * @author Niels Fricke {@literal <}Niels.Fricke{@literal @}t-online.de{@literal @}>
 */
public class MenuItemBeenden extends JMenuItem{
    /**
     * Siehe Action: {@link org.example.actions.BeendenAction}
     * @param p Modulplaner als Parent
     */
    MenuItemBeenden (Modulplaner p){
        super(p.beendenAction);
    }
}