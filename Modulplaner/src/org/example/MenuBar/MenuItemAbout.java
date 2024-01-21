package org.example.MenuBar;

import javax.swing.JMenuItem;
import org.example.Modulplaner;

/**
 * Klasse für das JMenuItem About
 * <p>Siehe Action: {@link org.example.actions.AboutAction}
 * @author Niels Fricke {@literal <}Niels.Fricke{@literal @}t-online.de{@literal @}>
 */
public class MenuItemAbout extends JMenuItem{
    /**
     * Siehe Action: {@link org.example.actions.AboutAction}
     * @param p Modulplaner als Parent
     */
    MenuItemAbout (Modulplaner p){
        super(p.aboutAction);
    }
}