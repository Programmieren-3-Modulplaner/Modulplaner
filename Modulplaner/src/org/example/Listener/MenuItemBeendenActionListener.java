/*
 * Copyright 2022 Niels Fricke
 * <Niels.Fricke@t-online.de>
 */

package org.example.Listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author Niels Fricke <Niels.Fricke@t-online.de>
 */

public class MenuItemBeendenActionListener implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("Beenden...");
        System.exit(0);
    }
}