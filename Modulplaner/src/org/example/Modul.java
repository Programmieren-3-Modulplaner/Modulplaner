/*
 * Copyright 2022 Niels Fricke
 * <Niels.Fricke@t-online.de>
 */

package org.example;

import javax.swing.JLabel;
import javax.swing.JPanel;
import java.util.ArrayList;

/**
 * @author Niels Fricke <Niels.Fricke@t-online.de>
 */

public class Modul {
    
    private String name;
    private String tag;
    private int anfang;
    private int ende;

    public Modul(String name, String tag, int anfang, int ende) {
        this.name = name;
        this.tag = tag;
        this.anfang = anfang;
        this.ende = ende;
    }
    

    public String getName() {
        return name;
    }

    public String getTag() {
        return tag;
    }

    public int getAnfang() {
        return anfang;
    }

    public int getEnde() {
        return ende;
    }
    
    
    
    public void setName(String name) {
        this.name = name;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public void setAnfang(int anfang) {
        this.anfang = anfang;
    }

    public void setEnde(int ende) {
        this.ende = ende;
    }
    
    public static void updateModulList(ArrayList<Modul> module, JPanel leftPanel, JPanel centerPanel) {
        leftPanel.removeAll();
        centerPanel.removeAll();
        
        JLabel kursoverview = new JLabel("Kursübersicht: ");
        leftPanel.add(kursoverview);

        for (Modul modul : module) {
            JLabel modulname = new JLabel(modul.getName());
            JLabel modultag = new JLabel(modul.getTag() + "; Beginn: " + modul.getAnfang() + " Uhr; " + "Ende: " + modul.getEnde() + " Uhr");
            leftPanel.add(modulname);
            centerPanel.add(modultag);
        }

        leftPanel.revalidate();
        centerPanel.revalidate();
    }
    
}