/*
 * Copyright 2022 Niels Fricke
 * <Niels.Fricke@t-online.de>
 */

package org.example.MenuBar;

import java.awt.PopupMenu;
import javax.swing.JMenuItem;
import org.example.Listener.MenuItemBeendenActionListener;
import org.example.Listener.MenuItemImportActionListener;

/**
 * @author Niels Fricke <Niels.Fricke@t-online.de>
 */

public class MenuItemImport extends JMenuItem {

    public MenuItemImport() {
        super("Import");
         this.addActionListener(new MenuItemImportActionListener());
    }
}