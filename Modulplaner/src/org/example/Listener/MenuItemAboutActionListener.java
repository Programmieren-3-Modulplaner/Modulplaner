/*
 * Copyright 2022 Niels Fricke
 * <Niels.Fricke@t-online.de>
 */
package org.example.Listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import org.example.About;
import org.example.Modulplaner;

/**
 * @author Niels Fricke <Niels.Fricke@t-online.de>
 */
public class MenuItemAboutActionListener implements ActionListener {

    private Modulplaner parent;

    public MenuItemAboutActionListener(Modulplaner p) {
        this.parent = p;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("About öffnen");
        new About(parent);
    }
}
