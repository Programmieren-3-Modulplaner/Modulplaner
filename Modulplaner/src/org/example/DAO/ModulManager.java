/*
 * Copyright 2022 Niels Fricke
 * <Niels.Fricke@t-online.de>
 */

package org.example.DAO;

import java.util.ArrayList;

/**
 * Klasse für die verwaltung von {@link org.example.DAO.Modul}en als ArrayList
 * <p> Die Namen der Module müssen eindeutig sein!
 * <p> Siehe: {@link org.example.DAO.Modul}
 * @author Niels Fricke {@literal <}Niels.Fricke{@literal @}t-online.de{@literal @}>
 */
public class ModulManager extends ArrayList<Modul> {

    /**
     * Sucht das entsprechende Modul anhand des Modulnamen
     * @param name Name des gesuchten Modul
     * @return Index der ArrayList des Moduls (Nicht gefunden: -1)
     */
    public int getIndexByName(String name) {
        for (int i = 0; i < this.size(); i++) {
            if (this.get(i).getModulName() == name) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Erstellt ein Array mit den Namen und Räumen der Module die an dem Tag und Block stattfinden
     * @param tag Tag der suche
     * @param block Block der suche
     * @return String Array [modul][0: Name, 1: Raum, 2: Versuch]
     */
    public String[][] getByTagBlock(int tag, int block) {
        int size = 0;
        for (int i = 0; i < this.size(); i++) {
            for (int n = 0; n < this.get(i).getAnzahlVeranstaltungen(); n++) {
                if (this.get(i).getTag(n) == tag && this.get(i).getBlock(n) == block && this.get(i).isBelegt() == true) {
                    size = size + 1;
                }
            }
        }
        
        String[][] result = new String[size][3];
        int c = 0;
        for (int i = 0; i < this.size(); i++) {
            for (int n = 0; n < this.get(i).getAnzahlVeranstaltungen(); n++) {
                if (this.get(i).getTag(n) == tag && this.get(i).getBlock(n) == block && this.get(i).isBelegt() == true) {
                    result[c][0] = this.get(i).getModulName();
                    result[c][1] = this.get(i).getRaum(n);
                    result[c][2] = this.get(i).getVersuchString();
                    c = c + 1;
                }
            }
        }
        return result;
    }

    /**
     * Ausgabe aller Module auf der Komandozeile
     */
    public void printTest() {
        for (org.example.DAO.Modul s : this) {
            s.printTest();
        }
    }
    
    /**
     * Sucht alle Module Anahnd des Namens und Professors
     * @param suchString Zeichenkette die gesucht werden soll
     * @return Neuer ModulManager mit gefundenen Modulen
     */
    public ModulManager suchModule(String suchString){
        ModulManager ergebnis = new ModulManager();
        if (suchString == null) {
            return ergebnis;
        }
        
        for ( Modul s: this){
            if (s.getModulName().contains(suchString)){
                ergebnis.add(s);
            }else if (s.getProfName().contains(suchString)){
                ergebnis.add(s);
            }
        }
        return ergebnis;
    }
    
    /**
     * Prüft ob Modul im ModulManager vorhanden ist
     * @param name Name des Moduls
     * @return Boolean true / false
     */
    public boolean nameIstVorhanden(String name){
        for ( Modul s: this){
            if (s.getModulName().equals(name))
                return true;
        }
        return false;
    }
    
    /**
     * Erstellt eine Liste mit Modulen die eine gültige Note haben
     * @return String Array mit Modulnamen
     */
    public String[] bestadeneModule(){
        int size = 0;
        for ( Modul s: this){
            if (s.getNote() != 0.0 && s.getNote() != 5.0){
                size = size + 1;
            }
        }
        String[] ergebnis = new String[size];
        int i = 0;
        for ( Modul s: this){
            if (s.getNote() != 0.0 && s.getNote() != 5.0){
                ergebnis[i] = s.getModulName() + " | " + s.getNoteString();
                i = i + 1;
            }
        }
        return ergebnis;
    }
    
    /**
     * Errechnet die Durchschnitsnote aller Module mit einer gültigen Note
     * @return Durchschnit als Double mit zwei nachkommastellen
     */
    public double durchschnitt(){
        ModulManager ergebnis = new ModulManager();
        for ( Modul s: this){
            if (s.getNote() != 0.0 && s.getNote() != 5.0){
                ergebnis.add(s);
            }
        }
        double durchschnit = 0;
        for ( Modul s: ergebnis){
            durchschnit = durchschnit + s.getNote();
        }
        durchschnit = durchschnit / ergebnis.size();
        
        return Math.round(durchschnit * 100.0) / 100.0;
    }
}