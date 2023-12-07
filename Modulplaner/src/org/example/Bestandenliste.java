/*
 * Copyright 2022 Niels Fricke
 * <Niels.Fricke@t-online.de>
 */

package org.example;

import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

/**
 * @author Niels Fricke <Niels.Fricke@t-online.de>
 */

public class Bestandenliste extends JPanel {
    
    private Modulplaner parent;
    
    public Bestandenliste(Modulplaner p) {
        this.parent = p;
        
        setBorder(BorderFactory.createTitledBorder("Bestandene Module: "));
        setLayout(new BorderLayout());
        setPreferredSize(new Dimension(200, 0));

        add(new JScrollPane(new JList(parent.module.bestadeneModule())), BorderLayout.CENTER);
        add(new JLabel("Durchschnit: " + parent.module.duchschnit()), BorderLayout.SOUTH);
    }
}