/*
 * Copyright 2022 Niels Fricke
 * <Niels.Fricke@t-online.de>
 */

package org.example.MenuBar;

import javax.swing.JMenuItem;
import org.example.Modulplaner;

/**
 * Klasse für das JMenuItem Export
 * <p>Siehe Action: {@link org.example.actions.ExportAction}
 * @author Niels Fricke {@literal <}Niels.Fricke{@literal @}t-online.de{@literal @}>
 */
public class MenuItemExport extends JMenuItem{
    /**
     * Siehe Action: {@link org.example.actions.ExportAction}
     * @param p Modulplaner als Parent
     */
    MenuItemExport (Modulplaner p){
        super(p.exportAction);
        //setIcon(null);
    }
}