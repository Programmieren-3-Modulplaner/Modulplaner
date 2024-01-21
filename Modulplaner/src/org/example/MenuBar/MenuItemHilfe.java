package org.example.MenuBar;

import javax.swing.JMenuItem;
import org.example.Modulplaner;

/**
 * Klasse für das JMenuItem Hilfe
 * <p>Siehe Action: {@link org.example.actions.HilfeAction}
 * @author Niels Fricke {@literal <}Niels.Fricke{@literal @}t-online.de{@literal @}>
 */
public class MenuItemHilfe extends JMenuItem{
    /**
     * Siehe Action: {@link org.example.actions.HilfeAction}
     * @param p Modulplaner als Parent
     */
    MenuItemHilfe (Modulplaner p){
        super(p.hilfeAction);
    }
}