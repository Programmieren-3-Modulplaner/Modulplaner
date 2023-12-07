package org.example.DAO;

import java.util.ArrayList;

/**
 * Diese Klasse stellt eine Liste von Module dar.
 */
public class Module extends ArrayList<Modul> {

    /**
     * Die Liste hat package-Sichtbarkeit. Dadurch kann das Data Access Object
     * für die Klasse Studenten unmittelbar auf die Liste zugreifen.
     */

    /*/**
     * Fügt einen neues Module zur Liste hinzu.
     *
     * @param s Referenz auf Modul-Objekt.
     */
    //public void add(Modul s) {
    //    mudulListe.add(s);
    //}
    public int getIndexByName(String name) {
        for (int i = 0; i < this.size(); i++) {
            if (this.get(i).getModulName() == name) {
                return i;
            }
        }
        return -1;
    }

    public Module getByTagBlock(int tag, int block) {
        Module result = new Module();

        for (int i = 0; i < this.size(); i++) {
            for (int n = 0; n < this.get(i).getAnzahlVeranstaltungen(); n++) {
                if (this.get(i).getTag(n) == tag && this.get(i).getBlock(n) == block && this.get(i).isBelegt() == true) {
                    result.add(this.get(i));
                }
            }
        }
        return result;
    }

    public void printTest() {
        // Daten für alle Module ausgeben:
        for (org.example.DAO.Modul s : this) {
            s.printTest();
        }
    }
    
    
    public Module suchModule(String suchString){
        Module ergebnis = new Module();
        if (suchString == null) {
            return ergebnis;
        }
        
        for ( Modul s: this){
            if (s.getModulName().contains(suchString))
                ergebnis.add(s);
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
}
