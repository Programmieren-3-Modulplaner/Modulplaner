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
    private int tag;
    private int block;
    public ArrayList<Modul> datenListe = new ArrayList<>();
    
    /**
     * Standardkonstruktor, macht gar nichts. brauchen wir aber für das
     * (ein)lesen von Objekten.
     */
    public Modul() {
    }
    
    //String name, String tag, int anfang, int ende
    public Modul(String name, int tag,int block) {
        this.name = name;
        this.tag = tag;
        this.block = block;
    }
    
    // get-Methoden
    public String getName() {
        return name;
    }

    public int getTag() {
        return tag;
    }

    public int getBlock() {
        return block;
    }

    
    
    //set-Methoden
    public void setName(String name) {
        this.name = name;
    }

    public void setTag(int tag) {
        this.tag = tag;
    }

    public void setBlock(int block) {
        this.block = block;
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