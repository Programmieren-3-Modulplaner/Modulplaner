package org.example.DAO;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import org.example.Modul;


public class ModulDAO {

    private DataInputStream in;
    private DataOutputStream out;

    
    public ModulDAO(String dateiName, boolean openForWrite) {

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

    /**
     * Konstruktor um das Data Access Object mit bereits vorhandenen Streams zu
     * initialisieren.
     *
     * @param in InputStream oder null
     * @param out OutputStream oder null
     */
    public ModulDAO(DataInputStream in, DataOutputStream out) {
        this.in = in;
        this.out = out;
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

    /**
     * Daten des übergebenen Student-Objekts schreiben. Das Data Access Object
     * muss dazu zum Schreiben bereit sein.
     *
     * @param s Referenz auf Student-Objekt
     * @throws IOException
     */
    public void write(Modul m) throws IOException {
        if (out != null) {
            out.writeUTF(m.getName());
            out.writeUTF(m.getTag());
            out.writeInt(m.getAnfang());
            out.writeInt(m.getEnde());
        }
    }

    /**
     * Daten des übergebenen Student-Objekts lesen. Das Data Access Objekt muss
     * dazu zum Lesen bereit sein.
     *
     * @param s Referenz auf Student-Objekt
     * @throws IOException
     */
    public void read(Modul m) throws IOException {
        if (in != null) {
            m.setName(in.readUTF());
            m.setTag(in.readUTF());
            m.setAnfang(in.readInt());
            m.setEnde(in.readInt());
        }
    }
}