package org.example.MenuBar;

import javax.swing.JMenuItem;
import org.example.Modulplaner;

/**
 * Klasse für das JMenuItem Import
 * <p>Siehe Action: {@link org.example.actions.ImportAction}
 * @author Niels Fricke {@literal <}Niels.Fricke{@literal @}t-online.de{@literal @}>
 */
public class MenuItemImport extends JMenuItem{
    /**
     * Siehe Action: {@link org.example.actions.ImportAction}
     * @param p Modulplaner als Parent
     */
    MenuItemImport (Modulplaner p){
        super(p.importAction);
    }
}