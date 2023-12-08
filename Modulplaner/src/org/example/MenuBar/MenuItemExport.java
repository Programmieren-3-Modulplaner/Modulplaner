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

public class MenuItemExport extends JMenuItem{
    MenuItemExport (Modulplaner p){
        super(p.exportAction);
        //setIcon(null);
    }
}