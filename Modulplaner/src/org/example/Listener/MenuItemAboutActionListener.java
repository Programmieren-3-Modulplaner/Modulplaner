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
import org.example.About;
import org.example.MenuBar.MenuBar;

/**
 * @author Niels Fricke <Niels.Fricke@t-online.de>
 */
public class MenuItemAboutActionListener implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("About öffnen");
        
        About about = new About();
    }
}
