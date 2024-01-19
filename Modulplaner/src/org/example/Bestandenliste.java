/*
 * Copyright 2022 Niels Fricke
 * <Niels.Fricke@t-online.de>
 */

package org.example;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.util.Collections;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import org.example.DAO.ModulComparator;

/**
 * @author Niels Fricke <Niels.Fricke@t-online.de>
 */

public class Bestandenliste extends JPanel {
    
    private Modulplaner parent;
    
    public Bestandenliste(Modulplaner p) {
        this.parent = p;
        
        setBorder(BorderFactory.createTitledBorder(parent.sprache("TitelBestanden")+":"));
        setLayout(new BorderLayout(10, 10));
        setPreferredSize(new Dimension(200, 0));

        Collections.sort(parent.modulManager, new ModulComparator());
        add(new JScrollPane(new JList(parent.modulManager.bestadeneModule())), BorderLayout.CENTER);
        add(new JLabel(parent.sprache("Durchschnitt")+": " + parent.modulManager.durchschnitt()), BorderLayout.SOUTH);
    }
}