package org.example.DAO;

import java.util.ArrayList;

/**
 * Diese Klasse stellt eine Liste von Module dar.
 */
public class Module extends ArrayList<Modul>{

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
    
    public int getIndexByName(String name){
        for ( int i = 0; i<this.size(); i++){
            if(this.get(i).getModulName() == name)
              return i;  
        }
        return -1;
    }

}
