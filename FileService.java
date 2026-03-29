package com.ecoquest.services;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

// this is for file handling :)
public class FileService {
    private static final String DATA_DIR = "data";
    public static void ensureDataDirectory() {
        File dir = new File(DATA_DIR);
        if (!dir.exists()) {
            dir.mkdir();
        }
    }
    public static void saveToFile(String filename, String data, boolean append) {
        ensureDataDirectory();
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(DATA_DIR + "/" + filename, append))) {
            writer.write(data);
            writer.newLine();
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }
    }
    public static List<String> readFromFile(String filename) {
        ensureDataDirectory();
        List<String> lines = new ArrayList<>();
        File file = new File(DATA_DIR + "/" + filename);
        if (!file.exists()) return lines;

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                lines.add(line);
            }
        } catch (IOException e) {
            System.out.println("Error reading file.");
        }
        return lines;
    }
    public static void clearFile(String filename) {
        try {
            new FileWriter(DATA_DIR + "/" + filename, false).close();
        } catch (IOException e) { e.printStackTrace(); }
    }
}