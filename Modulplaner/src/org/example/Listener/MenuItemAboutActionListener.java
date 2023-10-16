/*
 * Copyright 2022 Niels Fricke
 * <Niels.Fricke@t-online.de>
 */
package org.example.Listener;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

/**
 * @author Niels Fricke <Niels.Fricke@t-online.de>
 */
public class MenuItemAboutActionListener implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("About öffnen");
        JFrame aboutFrame = new JFrame("About");
        aboutFrame.setSize(200, 200);
        aboutFrame.setLocationRelativeTo(null);

        JPanel aboutPanel = new JPanel();
        aboutPanel.setLayout(new GridLayout(6, 1));
        aboutPanel.setBorder(new LineBorder(Color.BLACK));
        
        aboutPanel.add(new JLabel("", FlowLayout.LEFT));
        aboutPanel.add(new JLabel("Modulplaner", FlowLayout.LEFT));
        aboutPanel.add(new JLabel("Version 1.0", FlowLayout.LEFT));
        aboutPanel.add(new JLabel("Copyright:", FlowLayout.LEFT));
        aboutPanel.add(new JLabel("Niels Fricke", FlowLayout.LEFT));

        aboutFrame.add(aboutPanel);

        aboutFrame.setVisible(true);
    }
}
