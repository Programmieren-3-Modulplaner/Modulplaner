package org.example.MenuBar;

import javax.swing.JMenuItem;
import org.example.Modulplaner;

/**
 * Klasse für das JMenuItem Neu
 * <p>Siehe Action: {@link org.example.actions.ModulNeuAction}
 * @author Niels Fricke {@literal <}Niels.Fricke{@literal @}t-online.de{@literal @}>
 */
public class MenuItemNeu extends JMenuItem{
    /**
     * Siehe Action: {@link org.example.actions.ModulNeuAction}
     * @param p Modulplaner als Parent
     */
    MenuItemNeu (Modulplaner p){
        super(p.modulNeuAction);
    }
}