/*
 * Copyright 2022 Niels Fricke
 * <Niels.Fricke@t-online.de>
 */

package org.example.MenuBar;

import javax.swing.JToolBar;
import org.example.Modulplaner;

/**
 * @author Niels Fricke <Niels.Fricke@t-online.de>
 */

public class ToolBar extends JToolBar{
    
    Modulplaner parent;
    
    public ToolBar(Modulplaner p){
        this.parent = p;
        
        add(parent.modulNeuAction);
        addSeparator();
        add(parent.importAction);
        add(parent.exportAction);
        addSeparator();
        add(parent.aboutAction);
        addSeparator();
        add(parent.beendenAction);
        
        System.out.println("ToolBar");
    }
}