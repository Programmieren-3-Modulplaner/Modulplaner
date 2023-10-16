/*
 * Copyright 2022 Niels Fricke
 * <Niels.Fricke@t-online.de>
 */

package org.example.MenuBar;

import javax.swing.JMenu;

/**
 * @author Niels Fricke <Niels.Fricke@t-online.de>
 */

public class FileMenu extends JMenu{

    public FileMenu() {
        super("File");
        this.add(new MenuItemOpen());
        this.addSeparator();
        this.add(new MenuItemClose());
    }
}