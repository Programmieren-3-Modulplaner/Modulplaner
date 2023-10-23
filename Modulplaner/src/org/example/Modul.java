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
    private Integer anfang;
    private Integer ende;

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

    public Integer getAnfang() {
        return anfang;
    }
    
    public String getAnfangtoString() {
        return anfang.toString();
    }

    public Integer getEnde() {
        return ende;
    }
    
    public String getEndetoString() {
        return ende.toString();
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