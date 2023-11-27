package org.example.DAO;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

import org.example.Modul;
import org.example.DAO.ModulDAO;

public class ModuleDAO{
    public DataInputStream in;
    public DataOutputStream out;
    
    String ModulList = "data/ModulList.dat";


    public ModuleDAO (String dateiName, boolean openForWrite) {
        try {
            if (openForWrite) {
                out = new DataOutputStream(new FileOutputStream(dateiName));
            } else {
                in = new DataInputStream(new FileInputStream(dateiName));
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public void close() {
        try {
            if (in != null) {
                in.close();
            }
            if (out != null) {
                out.close();
            }
        } catch (IOException e) {
        }
    }

    //Modul = class "Modul"!
    public void write(Modul modul) throws IOException {
        if (out != null) {

            // Anzahl Module speichern:
            out.writeInt(modul.datenListe.size());

            // Nun die einzelne Module speichern:
            ModulDAO modDAO = new ModulDAO(null, out);

            for (Modul m : modul.datenListe) {
                modDAO.write(m);
            }
        }
    }

    public void read(Modul modul) throws IOException {
        if (in != null) {

            // Anzahl Module lesen:
            int nModule = in.readInt();

            // Nun die einzelnen Module lesen:
            ModulDAO modDAO = new ModulDAO(in, null);
            for (int i = 0; i < nModule; ++i) {
                Modul m = new Modul();
                modDAO.read(m);
                modul.addModul(m);
            }
           
        }
    }}
        
  /*public void deleteLast(Modul modul) throws IOException {
    if (out != null) {
        // Schließen Sie den Datenstrom, um die Datei zu verkleinern
        out.close();

        // Lesen Sie alle vorhandenen Module
        Modul existingModules = new Modul();
        ModulDAO readDAO = new ModulDAO(ModulList, false);
        if (readDAO.in.available() > 0) {
            readDAO.read(existingModules);
        }
        readDAO.close();

        // Entfernen Sie das letzte Modul
        existingModules.removeLast(); 
        }
    }
  }*/


