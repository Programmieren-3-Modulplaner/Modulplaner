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
            for (int n = 0; n < this.get(i).getArraySize(); n++) {
                if (this.get(i).getTag(n) == tag && this.get(i).getBlock(n) == block) {
                    result.add(this.get(i));
                }
            }
        }
        return result;
    }

    public void printTest() {
        // Daten für alle Module ausgeben:
        for (org.example.DAO.Modul s : this) {
            System.out.println(s.getModulName());
            System.out.println(s.getProfName());
            System.out.println(s.getNote());
            System.out.println(s.isBelegt());
            for (int i = 0; i < 5; i++) {
                System.out.println("Tag" + i + ":   " + s.getTag(i));
                System.out.println("Block" + i + ": " + s.getBlock(i));
                System.out.println("Raum" + i + ":  " + s.getRaum(i));
            }
            System.out.println("-------");
        }
    }

}
