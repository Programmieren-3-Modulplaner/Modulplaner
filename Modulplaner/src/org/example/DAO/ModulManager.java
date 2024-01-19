package org.example.DAO;

import java.util.ArrayList;

public class ModulManager extends ArrayList<Modul> {

    public int getIndexByName(String name) {
        for (int i = 0; i < this.size(); i++) {
            if (this.get(i).getModulName() == name) {
                return i;
            }
        }
        return -1;
    }

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

    public void printTest() {
        // Daten für alle ModulManager ausgeben:
        for (org.example.DAO.Modul s : this) {
            s.printTest();
        }
    }
    
    
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
    
    public boolean nameIstVorhanden(String name){
        for ( Modul s: this){
            if (s.getModulName().equals(name))
                return true;
        }
        return false;
    }
    
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
        
        //return durchschnit;
        
        return Math.round(durchschnit * 100.0) / 100.0;
    }
}