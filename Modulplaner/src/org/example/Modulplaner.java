/*
 * Copyright 2022 Niels Fricke
 * <Niels.Fricke@t-online.de>
 */
package org.example;

import java.awt.BorderLayout;
import java.awt.Color;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
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
        setTitle("Planer");
        addWindowListener(new WindowEventListener());
        setSize(600, 600);
        setLocationRelativeTo(null);

        setJMenuBar(new MenuBar("Modulplaner"));
/*
        module.add(new Modul("P3", "Montag", 8, 9));
        System.out.println(module.get(0).getName());

        setLayout(new BorderLayout());
        */
        JPanel ui = new JPanel();
        ui.setLayout(new BorderLayout(0,10));
        String[] kurse = {"Mathe 1", "Mathe 2", "Programmieren 1", "Programmieren 2", "Programmieren 3", "Statistik"};
        String[] block = {"1.Block", "2. Block", "3. Block","4. Block","5.Block"};
        String[] tage = {"Montage","Dienstag","Mittwoch","Donnerstag","Freitag"};
        JList liste = new JList(kurse);
        
        JPanel links = new JPanel();
        links.setLayout(new BoxLayout(links,BoxLayout.Y_AXIS));
        links.setBorder(BorderFactory.createLineBorder(Color.black));
        links.add(new JLabel("Kurse"));
        links.add(liste);
                    
        //
                    
        ui.add(links, BorderLayout.WEST);
        ui.add(new Info(), BorderLayout.CENTER);
        ui.add(new Plan(), BorderLayout.PAGE_END);
        ui.add(new JLabel("Kursplaner der Jade Hochschule"), BorderLayout.NORTH);
        this.add(ui);

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
