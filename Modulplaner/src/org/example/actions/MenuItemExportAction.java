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
 * @author Niels Fricke <Niels.Fricke@t-online.de>
 */

public class MenuItemExportAction extends AbstractAction{

    private Modulplaner parent;
    
    public MenuItemExportAction(Modulplaner p, String text, ImageIcon icon, String beschreibung, Integer key){
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