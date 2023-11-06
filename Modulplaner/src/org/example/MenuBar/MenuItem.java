/*
 * Copyright 2022 Niels Fricke
 * <Niels.Fricke@t-online.de>
 */

package org.example.MenuBar;

import javax.swing.JMenuItem;
import org.example.Listener.MenuItemAboutActionListener;
import org.example.Listener.MenuItemBeendenActionListener;
import org.example.Listener.MenuItemImportActionListener;
import org.example.Listener.MenuItemNewActionListner;

/**
 * @author Niels Fricke <Niels.Fricke@t-online.de>
 */

public class MenuItem extends JMenuItem{
    public MenuItem(String name) {
        super(name);
        if (name.equals("About")){
            this.addActionListener(new MenuItemAboutActionListener());
        }
        else if (name.equals("Beenden")){
            this.addActionListener(new MenuItemBeendenActionListener());
        }
        else if (name.equals("Export")){
        }
        else if (name.equals("Import")){
            this.addActionListener(new MenuItemImportActionListener());
        }
        else if (name.equals("Hilfe")){
        }
        else if (name.equals("Neu")){
            this.addActionListener(new MenuItemNewActionListner());
        }
        else System.out.println("Keine MenuItem Names \"" + name + "\" vorhanden");
    }
}