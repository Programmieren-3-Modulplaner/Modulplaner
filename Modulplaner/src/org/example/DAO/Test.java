package org.example.DAO;

import java.io.IOException;

public class Test {

    public static void main(String[] args) {

        String dateiName = "src/org/example/DAO/module.dat";

        // Drei Module erzeugen, zu Liste hinzufügen und Liste speichern:

        Modul m1 = new Modul("P1", "Gudenkauf", 2.0, false, 1, 1, "123", 2, 2, "123", 0, 0, "", 0, 0, "", 0, 0, "");
        Modul m2 = new Modul("P2", "Gudenkauf", 0, true, 1, 2, "123", 2, 3, "123", 3, 2, "123", 4, 2, "123", 5, 2, "123");
        Modul m3 = new Modul("P3", "Gudenkauf", 2.3, false, 1, 3, "123", 2, 4, "123", 0, 0, "", 0, 0, "", 0, 0, "");
        Modul m4 = new Modul("Mathe1", "Karabek", 1.7, true, 1, 4, "123", 2, 5, "123", 5, 1, "123", 0, 0, "", 0, 0, "");
        
        Module moduleTest = new Module();
        moduleTest.add(m1);
        moduleTest.add(m2);
        moduleTest.add(m3);
        moduleTest.add(m4);
        
        moduleTest.remove(moduleTest.getIndexByName("Mathe1"));
        
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
            for(int i = 0; i<5; i++){
                System.out.println("Tag" + i + ":   " + s.getTag(i));
                System.out.println("Block" + i + ": " + s.getBlock(i));
                System.out.println("Raum" + i + ":  " + s.getRaum(i));
            }
            System.out.println("-------");
        }
    }
}
