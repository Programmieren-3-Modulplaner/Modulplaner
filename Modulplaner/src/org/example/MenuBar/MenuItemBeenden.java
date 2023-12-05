/*
 * Copyright 2022 Niels Fricke
 * <Niels.Fricke@t-online.de>
 */

package org.example.MenuBar;

import javax.swing.JMenuItem;
import org.example.Listener.MenuItemBeendenActionListener;
import org.example.Modulplaner;

/**
 * @author Niels Fricke <Niels.Fricke@t-online.de>
 */

public class MenuItemBeenden extends JMenuItem{
    public MenuItemBeenden (Modulplaner p){
        super();
        this.setText("Beenden");
        this.addActionListener(new MenuItemBeendenActionListener(p));
        setIcon(null);
    }
}