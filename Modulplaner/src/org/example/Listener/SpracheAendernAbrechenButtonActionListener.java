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
 * Klasse zum Abbrechen des {@link org.example.SpracheAendern} Dialog
 * @author Niels Fricke {@literal <}Niels.Fricke{@literal @}t-online.de{@literal @}>
 */
public class SpracheAendernAbrechenButtonActionListener implements ActionListener {

    private Modulplaner parent;
    private SpracheAendern spracheAendern;

    /**
     * Konstruktor zum initialisieren des ActionListener
     * @param p Modulplaner als Parent
     * @param s Sprache ändern Dialog als Parent
     */
    public SpracheAendernAbrechenButtonActionListener(Modulplaner p, SpracheAendern s) {
        this.parent = p;
        this.spracheAendern = s;
    }

    /**
     * Schließt den {@link org.example.SpracheAendern} Dialog
     * @param e ActionEvent
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        spracheAendern.setVisible(false);
    }
}
