/*
 * Copyright 2022 Niels Fricke
 * <Niels.Fricke@t-online.de>
 */

package org.example.MenuBar;

import javax.swing.JMenuItem;
import org.example.Modulplaner;

/**
 * @author Niels Fricke <Niels.Fricke@t-online.de>
 */

public class MenuItemHilfe extends JMenuItem{
    MenuItemHilfe (Modulplaner p){
        super(p.menuItemHilfeAction);
        //setIcon(null);
    }
}