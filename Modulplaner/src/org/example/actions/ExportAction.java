/*
 * Copyright 2022 Niels Fricke
 * <Niels.Fricke@t-online.de>
 */

package org.example.actions;

import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.ImageIcon;
import org.example.Export;
import org.example.Modulplaner;

/**
 * @author Niels Fricke {@literal <}Niels.Fricke{@literal @}t-online.de{@literal @}>
 */

public class ExportAction extends AbstractAction{

    private Modulplaner parent;
    
    public ExportAction(Modulplaner p, String text, ImageIcon icon, String beschreibung, Integer key){
        super(text, icon);
        this.parent = p;
        putValue(SHORT_DESCRIPTION, beschreibung);
        putValue(MNEMONIC_KEY, key);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
       System.out.println("Save öffnen");
       new Export(parent);
    }
    
}