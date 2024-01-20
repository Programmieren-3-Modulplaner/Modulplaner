/*
 * Copyright 2022 Niels Fricke
 * <Niels.Fricke@t-online.de>
 */
package org.example.Listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JComboBox;
import org.example.Modulplaner;
import org.example.SpracheAendern;

/**
 * Klasse zum setzen der ausgewählten Sprache des {@link org.example.SpracheAendern} Dialog
 * @author Niels Fricke {@literal <}Niels.Fricke{@literal @}t-online.de{@literal @}>
 */
public class SpracheAendernSpeichernButtonActionListener implements ActionListener {

    private Modulplaner parent;
    private SpracheAendern spracheAendern;
    private JComboBox auswahl;

    /**
     * Konstruktor zum initialisieren des ActionListener
     * @param p Modulplaner als Parent
     * @param s Sprache ändern als Parent
     * @param a Auswahl der neuen Sprache
     */
    public SpracheAendernSpeichernButtonActionListener(Modulplaner p, SpracheAendern s, JComboBox a) {
        this.parent = p;
        this.spracheAendern = s;
        this.auswahl = a;
    }

    /**
     * Setzt die ausgewählte Sprache von Parent, aktualisiert diesen und schließt den {@link org.example.SpracheAendern} Dialog
     * @param e ActionEvent
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        
        parent.setLanguage(this.auswahl.getSelectedIndex());
        
        parent.SpracheAktualisieren();
        
        spracheAendern.setVisible(false);
    }
}
