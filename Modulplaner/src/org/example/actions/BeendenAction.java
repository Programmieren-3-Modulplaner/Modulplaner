/*
 * Copyright 2022 Niels Fricke
 * <Niels.Fricke@t-online.de>
 */
package org.example.actions;

import java.awt.event.ActionEvent;
import java.io.IOException;
import javax.swing.AbstractAction;
import javax.swing.ImageIcon;
import org.example.DAO.ModuleDAO;
import org.example.Modulplaner;

/**
 * @author Niels Fricke <Niels.Fricke@t-online.de>
 */
public class BeendenAction extends AbstractAction {

    private Modulplaner parent;

    public BeendenAction(Modulplaner p, String text, ImageIcon icon, String beschreibung, Integer key) {
        super(text, icon);
        this.parent = p;
        putValue(SHORT_DESCRIPTION, beschreibung);
        putValue(MNEMONIC_KEY, key);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        ModuleDAO dao = new ModuleDAO(parent.getDateiName(), true, parent);
        try {
            dao.write(parent.module);
        } catch (IOException r) {
            System.out.println(r.getMessage());
        }
        dao.close();
        
        System.out.println("Beenden...");
        System.exit(0);
    }

}
