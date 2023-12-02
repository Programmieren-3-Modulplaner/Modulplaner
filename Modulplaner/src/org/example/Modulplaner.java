/*
 * Copyright 2022 Niels Fricke
 * <Niels.Fricke@t-online.de>
 */
package org.example;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextField;
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
        setTitle("Kurplaner der Jade Hochschule");
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
        ui.setLayout(new BorderLayout(15,15));
        String[] kurse = {"Mathe 1", "Mathe 2", "Programmieren 1", "Programmieren 2", "Programmieren 3", "Statistik"};
        String[] bestandeneKurse ={"Statistik", "KLR"};
        String[] note ={"2.2", "4.0"};
        
        JList liste = new JList(kurse);
        JList liste2 = new JList(bestandeneKurse);
        JList liste3 = new JList(note);
        
        JPanel links = new JPanel();
        links.setLayout(new BorderLayout(10,5));
        //links.setBorder(BorderFactory.createLineBorder(Color.black));
        JLabel u1 = new JLabel("Kurse",2);
        //u1.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 2, Color.black));
        u1.setSize(5, 10);
        //u1.setBorder(BorderFactory.createLineBorder(Color.black));
        links.add(u1,BorderLayout.NORTH);
        links.add(liste,BorderLayout.CENTER);
                    
        //
        JPanel bestanden = new JPanel();
        bestanden.setLayout(new BorderLayout());
        //links.setBorder(BorderFactory.createLineBorder(Color.black));
        JLabel u2 = new JLabel("Bestanden",2);
        u2.setSize(5, 10);
        //u1.setBorder(BorderFactory.createLineBorder(Color.black));
        
        JPanel schnitt = new JPanel();
        schnitt.add(new JLabel("Notenschnitt"));
        schnitt.add(new JTextField("3.1"));
        
        bestanden.add(u2,BorderLayout.NORTH);
        bestanden.add(liste2,BorderLayout.CENTER);
        bestanden.add(liste3,BorderLayout.EAST);
        bestanden.add(schnitt,BorderLayout.PAGE_END);
        
        
        ui.add(links, BorderLayout.WEST);
        ui.add(new Info(), BorderLayout.CENTER);
        ui.add(new Plan(), BorderLayout.PAGE_END);
        ui.add(bestanden, BorderLayout.EAST);
        
        
        
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
