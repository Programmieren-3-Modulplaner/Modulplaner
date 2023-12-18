/*
 * Copyright 2022 Niels Fricke
 * <Niels.Fricke@t-online.de>
 */
package org.example.Listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import org.example.Modulplaner;
import org.example.SpracheAendern;

/**
 * @author Niels Fricke <Niels.Fricke@t-online.de>
 */
public class SpracheAendernAbrechenButtonActionListener implements ActionListener {

    private Modulplaner parent;
    private SpracheAendern spracheAendern;


    public SpracheAendernAbrechenButtonActionListener(Modulplaner p, SpracheAendern s) {
        this.parent = p;
        this.spracheAendern = s;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("Abbrechen");
        spracheAendern.setVisible(false);
    }
}
