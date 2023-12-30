/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.example.DAO;

import java.io.*;

/**
 * Noch nicht funktionell
 * @author Daniel
 */
public class spracheDAO {
     private static final String FILE_NAME = "config.txt";

    public void saveSprache(String dirache) {
        try (FileWriter fileWriter = new FileWriter(FILE_NAME)) {
            fileWriter.write(dirache);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String readSprache() {
        StringBuilder dirache = new StringBuilder();

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                dirache.append(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return dirache.toString();
    }
}
