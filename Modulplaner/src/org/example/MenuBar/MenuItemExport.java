/*
 * Copyright 2022 Niels Fricke
 * <Niels.Fricke@t-online.de>
 */

package org.example.MenuBar;

import javax.swing.JMenuItem;
import org.example.Modulplaner;

/**
 * @author Niels Fricke {@literal <}Niels.Fricke{@literal @}t-online.de{@literal @}>
 */

public class MenuItemExport extends JMenuItem{
    MenuItemExport (Modulplaner p){
        super(p.exportAction);
        //setIcon(null);
    }
}