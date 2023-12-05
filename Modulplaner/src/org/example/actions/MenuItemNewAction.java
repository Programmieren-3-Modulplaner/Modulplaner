/*
 * Copyright 2022 Niels Fricke
 * <Niels.Fricke@t-online.de>
 */

package org.example.actions;

import org.example.Neu;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.ImageIcon;
import org.example.Modulplaner;

/**
 * @author Niels Fricke <Niels.Fricke@t-online.de>
 */

public class MenuItemNewAction extends AbstractAction{

    private Modulplaner parent;
    
    public MenuItemNewAction(Modulplaner p, String text, ImageIcon icon, String desc, Integer mnemonic){
        super(text, icon);
        this.parent = p;
        putValue(SHORT_DESCRIPTION, desc);
        putValue(MNEMONIC_KEY, mnemonic);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
       new Neu(parent);
       System.out.println("Neues Modul");
    }
    
}