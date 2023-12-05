/*
 * Copyright 2022 Niels Fricke
 * <Niels.Fricke@t-online.de>
 */
package org.example.Listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import org.example.Modulplaner;
import org.example.Neu;

/**
 * @author Niels Fricke <Niels.Fricke@t-online.de>
 */
public class NeuAbrechenButtonActionListener implements ActionListener {

    private Modulplaner parent;
    private Neu neu;


    public NeuAbrechenButtonActionListener(Modulplaner p, Neu n) {
        this.parent = p;
        this.neu = n;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("Abbrechen");
        neu.setVisible(false);
    }
}
