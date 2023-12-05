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

public class MenuItemImport extends JMenuItem{
    public MenuItemImport (Modulplaner p){
        super(p.menuItemImportAction);
        //setIcon(null);
    }
}