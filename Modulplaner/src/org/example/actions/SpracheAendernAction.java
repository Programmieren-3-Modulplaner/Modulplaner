/*
 * Copyright 2022 Niels Fricke
 * <Niels.Fricke@t-online.de>
 */

package org.example.actions;

import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.ImageIcon;
import org.example.Modulplaner;
import org.example.SpracheAendern;

/**
 * @author Niels Fricke {@literal <}Niels.Fricke{@literal @}t-online.de{@literal @}>
 */

public class SpracheAendernAction extends AbstractAction{

    private Modulplaner parent;
    
    public SpracheAendernAction(Modulplaner p, String text, ImageIcon icon, String beschreibung, Integer key){
        super(text, icon);
        this.parent = p;
        putValue(SHORT_DESCRIPTION, beschreibung);
        putValue(MNEMONIC_KEY, key);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
       new SpracheAendern(parent);
       System.out.println("Sprache Ändern");
    }
    
}