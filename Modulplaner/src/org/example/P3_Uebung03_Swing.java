/*
 * Copyright 2022 Niels Fricke
 * <Niels.Fricke@t-online.de>
 */
package org.example;

import javax.swing.JFrame;
import org.example.Listener.WindowEventListener;
import org.example.MenuBar.MenuBar;

/**
 * @author Niels Fricke <Niels.Fricke@t-online.de>
 */
public class P3_Uebung03_Swing extends JFrame {
    
    public P3_Uebung03_Swing(){
        
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        if (System.getProperty("os.name") != null && System.getProperty("os.name").toLowerCase().indexOf("mac") != -1) {
            //System.getProperties().put("apple.laf.useScreenMenuBar", "true");
            System.setProperty("apple.laf.useScreenMenuBar", "true");
        }
        
        P3_Uebung03_Swing mainWindow = new P3_Uebung03_Swing();
        mainWindow.setTitle("Das ist ein Fenster!");
        mainWindow.addWindowListener(new WindowEventListener());
        mainWindow.setSize(500, 300);
        mainWindow.setLocationRelativeTo(null);
        
        mainWindow.setJMenuBar(new MenuBar("main"));

        mainWindow.setVisible(true);
    }
}
