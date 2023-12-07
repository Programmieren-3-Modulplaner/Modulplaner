package org.example.DAO;

import java.io.IOException;

public class Test {

    public static void main(String[] args) {

        String dateiName = "src/org/example/DAO/module.dat";

        // Drei Module erzeugen, zu Liste hinzufügen und Liste speichern:

        //Modul m1 = new Modul("P1", "Gudenkauf", 2.0, false, 1, 1, "123", 2, 2, "1234", 0, 0, "");//, 0, 0, "", 0, 0, "");
        //Modul m2 = new Modul("P2", "Gudenkauf", 0, true, 1, 2, "12345", 2, 3, "12t3", 3, 2, "123");//, 4, 2, "123", 5, 2, "123");
        //Modul m3 = new Modul("P3", "Gudenkauf", 2.3, false, 1, 2, "1", 2, 4, "12a3", 0, 0, "");//, 0, 0), "", 0, 0, "");
        //Modul m4 = new Modul("Mathe1", "Karabek", 1.7, true, 1, 8, "W11", 2, 5, "1n23", 5, 1, "TEST");//, 0, 0, "bla", 0, 0, "blaaaaa");
        /*
        Modul m1 = new Modul("P1", "Gudenkauf", 2.0, true, 1, 1, "1 1", 2, 1, "2 1", 3, 1, "3 1");//, 4, 1, "4 1", 5, 1, "5 1");
        Modul m2 = new Modul("P2", "Gudenkauf", 0.0, true, 1, 2, "1 2", 1, 5, "1 5", 5, 2, "5 2");//, 5, 5, "5 5", 2, 1, "2 1");
        Modul m3 = new Modul("P3", "Gudenkauf", 2.3, true, 1, 3, "1 3", 1, 6, "1 6", 5, 3, "5 3");//, 5, 6, "5 6", 3, 8, "3 8");
        Modul m4 = new Modul("Mathe1", "Karabek", 1.7, true, 1, 4, "1 4", 1, 7, "1 7", 5, 4, "5 4");//, 5, 7, "5 7", 3, 8, "3 8");
        Modul m5 = new Modul("Mathe2", "Karabek", 1.7, false, 1, 8, "1 8", 2, 8, "2 8", 3, 8, "3 8");//, 4, 8, "4 8", 5, 8, "5 8");
        Modul m6 = new Modul("Datenbanken", "Wulf", 1.7, true , 2, 3, "2 3", 2, 6, "2 6", 4, 5, "4 5");//, 0, 0, "", 0, 0, "");
        */
        
        Module moduleTest = new Module();
        //moduleTest.add(m1);
        //moduleTest.add(m2);
        //moduleTest.add(m3);
        //moduleTest.add(m4);
        //moduleTest.add(m5);
        //moduleTest.add(m6);

        //moduleTest.remove(moduleTest.getIndexByName("Mathe1"));
        //moduleTest.remove();
        // Module speichern
        ModuleDAO dao = new ModuleDAO(dateiName, true); // Schreiben
        try {
            dao.write(moduleTest);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        dao.close();

        // Nun Liste von Datei wieder herstellen und Studentendaten auf Konsole ausgeben:
        Module moduleTest2 = new Module();
        ModuleDAO dao2 = new ModuleDAO(dateiName, false); // Lesen
        try {
            dao2.read(moduleTest2);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        dao2.close();

        // Daten für alle Module ausgeben:
        for (Modul s : moduleTest2) {
            System.out.println(s.getModulName());
            System.out.println(s.getProfName());
            System.out.println(s.getNote());
            System.out.println(s.isBelegt());
            for (int i = 0; i < Modul.getAnzahlVeranstaltungen(); i++) {
                System.out.println("Tag" + i + ":   " + s.getTag(i));
                System.out.println("Block" + i + ": " + s.getBlock(i));
                System.out.println("Raum" + i + ":  " + s.getRaum(i));
            }
            System.out.println("-------");
        }
    }
}
