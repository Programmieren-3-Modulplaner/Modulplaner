package org.example.DAO;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

/**
 * Data Access Object für die Klasse {@link org.example.DAO.Modul}
 */
public class MudulDAO extends DAO {

    /**
     * Konstruktor um das Data Access Object mit einem Dateinamen zu
     * initialisieren.
     *
     * @param dateiName Dateiname
     * @param openForWrite true wenn geschrieben werden soll
     */
    public MudulDAO(String dateiName, boolean openForWrite) {
        super(dateiName, openForWrite);
    }

    /**
     * Konstruktor um das Data Access Object mit bereits vorhandenen Streams zu
     * initialisieren.
     *
     * @param in InputStream oder null
     * @param out OutputStream oder null
     */
    public MudulDAO(DataInputStream in, DataOutputStream out) {
        super(in, out);
    }

    /**
     * Daten des übergebenen Modul-Objekts schreiben. Das Data Access Object
     * muss dazu zum Schreiben bereit sein.
     *
     * @param obj Referenz auf Modul-Objekt
     * @throws IOException
     */
    public void write(Object obj) throws IOException {
        if (out != null) {
            Modul s = (Modul) obj;
            out.writeUTF(s.getModulName());
            out.writeUTF(s.getProfName());
            out.writeDouble(s.getNote());
            out.writeInt(s.getVersuch());
            out.writeUTF(s.getKursURL());
            out.writeBoolean(s.isBelegt());
            for (int i = 0; i < Modul.getAnzahlVeranstaltungen(); i++) {
                out.writeInt(s.getTag(i));
            }
            for (int i = 0; i < Modul.getAnzahlVeranstaltungen(); i++) {
                out.writeInt(s.getBlock(i));
            }
            for (int i = 0; i < Modul.getAnzahlVeranstaltungen(); i++) {
                if (s.getRaum(i) == null) {
                    out.writeUTF("");
                }
                out.writeUTF(s.getRaum(i));
            }
        }
    }

    /**
     * Daten des übergebenen Modul-Objekts lesen. Das Data Access Objekt muss
     * dazu zum Lesen bereit sein.
     *
     * @param obj Referenz auf Modul-Objekt
     * @throws IOException
     */
    public void read(Object obj) throws IOException {
        if (in != null) {
            Modul s = (Modul) obj;
            s.setModulName(in.readUTF());
            s.setProfName(in.readUTF());
            s.setNote(in.readDouble());
            s.setVersuch(in.readInt());
            s.setKursURL(in.readUTF());
            s.setBelegt(in.readBoolean());
            for (int i = 0; i < Modul.getAnzahlVeranstaltungen(); i++) {
                s.setTag(in.readInt(), i);
            }
            for (int i = 0; i < Modul.getAnzahlVeranstaltungen(); i++) {
                s.setBlock(in.readInt(), i);
            }
            for (int i = 0; i < Modul.getAnzahlVeranstaltungen(); i++) {
                s.setRaum(in.readUTF(), i);
            }
        }
    }
}