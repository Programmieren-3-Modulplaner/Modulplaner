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
 * @author Niels Fricke {@literal <}Niels.Fricke{@literal @}t-online.de{@literal @}>
 */
public class SpracheAendernSpeichernButtonActionListener implements ActionListener {

    private Modulplaner parent;
    private SpracheAendern spracheAendern;
    private JComboBox auswahl;


    public SpracheAendernSpeichernButtonActionListener(Modulplaner p, SpracheAendern s, JComboBox a) {
        this.parent = p;
        this.spracheAendern = s;
        this.auswahl = a;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("Speichern");
        
        parent.setLanguage(this.auswahl.getSelectedIndex());
        
        parent.SpracheAktualisieren();
        
        spracheAendern.setVisible(false);
    }
}
