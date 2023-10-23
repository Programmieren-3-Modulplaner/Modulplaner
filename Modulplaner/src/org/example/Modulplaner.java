/*
 * Copyright 2022 Niels Fricke
 * <Niels.Fricke@t-online.de>
 */
package org.example;

import java.awt.BorderLayout;
import java.util.ArrayList;
import javax.swing.JFrame;
import org.example.Listener.WindowEventListener;
import org.example.MenuBar.MenuBar;

/**
 * @author Niels Fricke <Niels.Fricke@t-online.de>
 */
public class Modulplaner extends JFrame {

    /**
     * @param args the command line arguments
     */
    //public static Modulplaner app;
    private ArrayList<Modul> module = new ArrayList();

    public Modulplaner() {
        setTitle("Modulplaner");
        addWindowListener(new WindowEventListener());
        setSize(500, 300);
        setLocationRelativeTo(null);

        setJMenuBar(new MenuBar("modulplaner"));

        module.add(new Modul("P3", "Montag", 8, 9));
        System.out.println(module.get(0).getName());

        setLayout(new BorderLayout());

        setVisible(true);
    }

    public static void main(String[] args) {

        /*
        if (System.getProperty("os.name") != null && System.getProperty("os.name").toLowerCase().indexOf("mac") != -1) {
            //System.getProperties().put("apple.laf.useScreenMenuBar", "true");
            System.setProperty("apple.laf.useScreenMenuBar", "true");
        }*/
        //app = new Modulplaner();
        new Modulplaner();
        
        //new About();
    }
}
