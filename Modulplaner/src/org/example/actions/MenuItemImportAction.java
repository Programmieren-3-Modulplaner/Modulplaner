/*
 * Copyright 2022 Niels Fricke
 * <Niels.Fricke@t-online.de>
 */

package org.example.actions;

import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.ImageIcon;
import org.example.Import;
import org.example.Modulplaner;

/**
 * @author Niels Fricke <Niels.Fricke@t-online.de>
 */

public class MenuItemImportAction extends AbstractAction{

    private Modulplaner parent;
    
    public MenuItemImportAction(Modulplaner p, String text, ImageIcon icon, String desc, Integer mnemonic){
        super(text, icon);
        this.parent = p;
        putValue(SHORT_DESCRIPTION, desc);
        putValue(MNEMONIC_KEY, mnemonic);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
       System.out.println("Open öffnen");
       new Import(parent);
    }
    
}