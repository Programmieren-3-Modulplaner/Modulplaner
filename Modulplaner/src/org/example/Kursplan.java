/*
 * Copyright 2022 Niels Fricke
 * <Niels.Fricke@t-online.de>
 */
package org.example;

import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

/**
 * @author Niels Fricke <Niels.Fricke@t-online.de>
 */
public class Kursplan extends JPanel {
    
    private Modulplaner parent;

    public Kursplan(Modulplaner p) {
        this.parent = p;

        int anzahlBloecke = parent.anzahlBloecke;
        int anzahlTage = Modulplaner.tage.values().length;
        setLayout(new GridLayout(anzahlBloecke + 1, anzahlTage + 1));

        JPanel[][] panelHolder = new JPanel[anzahlBloecke + 1][anzahlTage + 1];
        for (int i = 0; i <= anzahlBloecke; i++) {
            for (int n = 0; n <= anzahlTage; n++) {
                panelHolder[i][n] = new JPanel();
                panelHolder[i][n].setBorder(new LineBorder(Color.BLACK));
                add(panelHolder[i][n]);
            }
        }
        
        for (int i = 1; i <= anzahlTage; i++) {
            panelHolder[0][i].add(new JLabel(Modulplaner.tage.values()[i - 1].toString()));
        }
        for (int i = 1; i <= anzahlBloecke; i++) {
            panelHolder[i][0].add(new JLabel("Block " + i));
        }

        for (int i = 1; i <= anzahlBloecke; i++) {
            for (int n = 1; n <= anzahlTage; n++) {
                org.example.DAO.Module result = parent.module.getByTagBlock(n, i);

                panelHolder[i][n].setLayout(new GridLayout(2, result.size()));
                for (int m = 0; m < result.size(); m++) {
                    JLabel eintrag = new JLabel(result.get(m).getModulName(),0);
                    panelHolder[i][n].add(eintrag);
                    panelHolder[i][n].setBackground(Color.lightGray);
                }
                for (int m = 0; m < result.size(); m++) {
                    JLabel eintrag = new JLabel(result.get(m).getRaum(n, i),0);
                    panelHolder[i][n].add(eintrag);
                }
            }
        }
    }
}
