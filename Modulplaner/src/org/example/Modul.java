/*
 * Copyright 2022 Niels Fricke
 * <Niels.Fricke@t-online.de>
 */

package org.example;

import java.util.ArrayList;



/**
 * @author Niels Fricke <Niels.Fricke@t-online.de>
 */

public class Modul {
    
    private String name;
    private String tag;
    private int anfang;
    private int ende;
    public ArrayList<Modul> datenListe = new ArrayList<>();
    
    /**
     * Standardkonstruktor, macht gar nichts. brauchen wir aber für das
     * (ein)lesen von Objekten.
     */
    public Modul() {
    }
    
    //String name, String tag, int anfang, int ende
    public Modul(String name, String tag, int anfang, int ende) {
        this.name = name;
        this.tag = tag;
        this.anfang = anfang;
        this.ende = ende;
    }
    
    // get-Methoden
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
    
    
    //set-Methoden
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
    
    public void addModul(Modul m) {
        datenListe.add(m);
    }
    
    public void removeLast() {
        if (!datenListe.isEmpty()) {
            datenListe.remove(datenListe.size() - 1);
        }
        
    }
    
}