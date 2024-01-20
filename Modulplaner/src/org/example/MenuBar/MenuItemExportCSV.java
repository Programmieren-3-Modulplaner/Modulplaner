/*
 * Copyright 2022 Niels Fricke
 * <Niels.Fricke@t-online.de>
 */

package org.example.MenuBar;

import javax.swing.JMenuItem;
import org.example.Modulplaner;

/**
 * Klasse für das JMenuItem Export als CSV
 * <p>Siehe Action: {@link org.example.actions.ExportCSVAction}
 * @author Niels Fricke {@literal <}Niels.Fricke{@literal @}t-online.de{@literal @}>
 */
public class MenuItemExportCSV extends JMenuItem{
    /**
     * Siehe Action: {@link org.example.actions.ExportCSVAction}
     * @param p Modulplaner als Parent
     */
    MenuItemExportCSV (Modulplaner p){
        super(p.exportCSVAction);
    }
}