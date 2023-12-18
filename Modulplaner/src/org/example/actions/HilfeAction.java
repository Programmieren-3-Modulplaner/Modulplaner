/*
 * Copyright 2022 Niels Fricke
 * <Niels.Fricke@t-online.de>
 */
package org.example.actions;

import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.ImageIcon;
import org.example.Modulplaner;

/**
 * @author Niels Fricke <Niels.Fricke@t-online.de>
 */
public class HilfeAction extends AbstractAction {

    private Modulplaner parent;

    public HilfeAction(Modulplaner p, String text, ImageIcon icon, String beschreibung, Integer key) {
        super(text, icon);
        this.parent = p;
        putValue(SHORT_DESCRIPTION, beschreibung);
        putValue(MNEMONIC_KEY, key);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("Hilfe öffnen");
    }

}
