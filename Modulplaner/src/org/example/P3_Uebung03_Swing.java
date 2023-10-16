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
    
    /**
     * @param args the command line arguments
     */
    
    public static P3_Uebung03_Swing app;
    
    public P3_Uebung03_Swing(){
        setTitle("Das ist ein Fenster!");
        addWindowListener(new WindowEventListener());
        setSize(500, 300);
        setLocationRelativeTo(null);
        
        setJMenuBar(new MenuBar("main"));
        
        

        setVisible(true);
    }

    
    public static void main(String[] args) {
        
        if (System.getProperty("os.name") != null && System.getProperty("os.name").toLowerCase().indexOf("mac") != -1) {
            //System.getProperties().put("apple.laf.useScreenMenuBar", "true");
            System.setProperty("apple.laf.useScreenMenuBar", "true");
        }
        
        app = new P3_Uebung03_Swing();
    }
}
