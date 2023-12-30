/*
 * Copyright 2022 Niels Fricke
 * <Niels.Fricke@t-online.de>
 */
package org.example;

import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

/**
 * @author Niels Fricke <Niels.Fricke@t-online.de>
 */
public class About extends JDialog {

    
    private Modulplaner parent;

    public About(Modulplaner p) {
        super(p,true);
        this.parent = p;
        setTitle(parent.sprache("Über"));
        setSize(200, 200);
        setLocationRelativeTo(null);

        JPanel aboutPanel = new JPanel();
        aboutPanel.setLayout(new GridLayout(8, 1));
        aboutPanel.setBorder(new LineBorder(Color.BLACK));

        aboutPanel.add(createJLable(""));
        aboutPanel.add(createJLable("Modulplaner"));
        aboutPanel.add(createJLable("Version 1.0"));
        aboutPanel.add(createJLable("Copyright:"));
        aboutPanel.add(createJLable("Niels Fricke"));
        aboutPanel.add(createJLable("Daniel Grimm"));
        aboutPanel.add(createJLable("Tjark Maasberg"));
        aboutPanel.add(createJLable(""));

        add(aboutPanel);

        setVisible(true);
    }

    private JLabel createJLable(String name) {
        JLabel label = new JLabel(name);
        label.setHorizontalAlignment(JLabel.CENTER);
        return label;
    }
}
