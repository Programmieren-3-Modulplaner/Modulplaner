/*
 * Copyright 2022 Niels Fricke
 * <Niels.Fricke@t-online.de>
 */
package org.example;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import org.example.MenuBar.MenuBar;

/**
 * @author Niels Fricke <Niels.Fricke@t-online.de>
 */
public class About extends JFrame {

    public About() {
        setSize(200, 250);
        setLocationRelativeTo(null);
        setJMenuBar(new MenuBar("about"));

        JPanel aboutPanel = new JPanel();
        aboutPanel.setLayout(new GridLayout(8, 1));
        aboutPanel.setBorder(new LineBorder(Color.BLACK));

        aboutPanel.add(new JLabel("", FlowLayout.LEFT));
        aboutPanel.add(new JLabel("Modulplaner", FlowLayout.LEFT));
        aboutPanel.add(new JLabel("Version 1.0", FlowLayout.LEFT));
        aboutPanel.add(new JLabel("Copyright:", FlowLayout.LEFT));
        aboutPanel.add(new JLabel("Niels Fricke", FlowLayout.LEFT));
        aboutPanel.add(new JLabel("Daniel Grimm", FlowLayout.LEFT));
        aboutPanel.add(new JLabel("Tjark Maasberg", FlowLayout.LEFT));
        aboutPanel.add(new JLabel("", FlowLayout.LEFT));

        add(aboutPanel);

        setVisible(true);
    }
}
