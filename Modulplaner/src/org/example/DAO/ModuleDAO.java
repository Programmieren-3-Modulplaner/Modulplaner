package org.example.DAO;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.example.Modul;

public class ModuleDAO extends DAO {
    
    public ModuleDAO(String datenListe, boolean openForWrite) {
        super(datenListe, openForWrite);
    }

    public void write(Object obj) throws IOException {
        if (out != null) {
            Modul modul = (Modul) obj;
            
            out.writeUTF(modul.getName());
            out.writeUTF(modul.getTag());
            out.writeInt(modul.getAnfang());
            out.writeInt(modul.getEnde());
            
            // Anzahl Module speichern:
            

            // Nun die einzelnen Studenten speichern:
           ModulDAO modDAO = new ModulDAO(null, out);

            for (Modul m: modul.datenListe) {
                modDAO.write(m);
            }
        }
    }

    public void read(Object obj) throws IOException {
        if (in != null) {
            Modul modul = (Modul) obj;

            // Anzahl Studenten lesen:
            int nmodul = in.readInt();

            // Nun die einzelnen Studenten lesen:
            ModulDAO modDAO = new ModulDAO(in, null);
            for (int i = 0; i < nmodul; ++i) {
                Modul m = new Modul();
                modDAO.read(m);
                m.addModul(m);
            }
        }
    }
}