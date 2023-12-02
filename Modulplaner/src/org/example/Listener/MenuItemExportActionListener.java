/*
 * Copyright 2022 Niels Fricke
 * <Niels.Fricke@t-online.de>
 */

package org.example.Listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import org.example.Export;
import org.example.Modulplaner;

/**
 * @author Niels Fricke <Niels.Fricke@t-online.de>
 */

public class MenuItemExportActionListener implements ActionListener {

    private Modulplaner parent;

    public MenuItemExportActionListener(Modulplaner p) {
        this.parent = p;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("Open öffnen");
        new Export(parent);
    }
}