package org.example.MenuBar;

import javax.swing.JMenuItem;
import org.example.Modulplaner;

/**
 * Klasse für das JMenuItem Sprache Ändern
 * <p>Siehe Action: {@link org.example.actions.SpracheAendernAction}
 * @author Niels Fricke {@literal <}Niels.Fricke{@literal @}t-online.de{@literal @}>
 */
public class MenuItemSpracheAendern extends JMenuItem{
    /**
     * Siehe Action: {@link org.example.actions.SpracheAendernAction}
     * @param p Modulplaner als Parent
     */
    MenuItemSpracheAendern (Modulplaner p){
        super(p.spracheAendernAction);
    }
}