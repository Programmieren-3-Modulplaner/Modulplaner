package org.example.DAO;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import org.example.Modulplaner;

public class ModulManagerCSV {
    
    private Modulplaner parent;
    private ModulManager modulManager;
    private String file;
    
    public ModulManagerCSV(Modulplaner p, ModulManager m, String f)
    {
        this.parent = p;
        this.modulManager = m;
        this.file = f;
        
        String Trennzeichen = ";";
        
        try {
            FileWriter fileOut = new FileWriter(file);
            BufferedWriter bufout = new BufferedWriter(fileOut);
            PrintWriter out = new PrintWriter(bufout);
            
            String line = parent.sprache("Name") + Trennzeichen + parent.sprache("Professor") + Trennzeichen + 
                    parent.sprache("Note") + Trennzeichen + "Versuch" + Trennzeichen + "Kurs URL" + Trennzeichen + "Belegt";
            for (int i = 0; i < Modul.getAnzahlVeranstaltungen(); i++){
                line = line + Trennzeichen + parent.sprache("Tag") + Trennzeichen + parent.sprache("Block") + Trennzeichen + parent.sprache("Raum");
            }
            out.println(line);

            for (Modul s : modulManager) {
                line = s.getModulName() + Trennzeichen + s.getProfName() + Trennzeichen + s.getNoteString() + Trennzeichen + 
                        s.getVersuchString() + Trennzeichen + s.getKursURL() + Trennzeichen + s.isBelegt();
                for (int i = 0; i < Modul.getAnzahlVeranstaltungen(); i++){
                    line = line + Trennzeichen + s.getTag(i) + Trennzeichen + s.getBlock(i) + Trennzeichen + s.getRaum(i);
                }
                out.println(line);
            }
            out.close();
        } 
        catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
