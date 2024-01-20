/*
 * Copyright 2022 Niels Fricke
 * <Niels.Fricke@t-online.de>
 */

package org.example.MenuBar;

import javax.swing.JToolBar;
import org.example.Modulplaner;

/**
 * Klasse für die erstellung der JToolBar
 * @author Niels Fricke {@literal <}Niels.Fricke{@literal @}t-online.de{@literal @}>
 */
public class ToolBar extends JToolBar{
    
    private Modulplaner parent;
    
    /**
     * Generiert die ToOlbar mit den Actions von Parent
     * @param p Modulplaner als Parent
     */
    public ToolBar(Modulplaner p){
        this.parent = p;
       
        add(parent.modulNeuAction);
        addSeparator();
        add(parent.importAction);
        add(parent.exportAction);
        add(parent.exportCSVAction);
        addSeparator();
        add(parent.beendenAction);
        addSeparator();
        add(parent.spracheAendernAction);
        addSeparator();
        add(parent.hilfeAction);
        addSeparator();
        add(parent.aboutAction);
    }
}