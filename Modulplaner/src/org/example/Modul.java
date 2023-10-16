/*
 * Copyright 2022 Niels Fricke
 * <Niels.Fricke@t-online.de>
 */

package org.example;

/**
 * @author Niels Fricke <Niels.Fricke@t-online.de>
 */

class Modul {
    
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
    
    
}