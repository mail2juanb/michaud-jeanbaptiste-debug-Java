package com.hemebiotech.analytics;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

public class WriteSymptomDataToFile implements ISymptomWriter {

    private final File file;

    public WriteSymptomDataToFile(String filepath) {
        file = new File(filepath);
    }

    public void writeSymptoms(Map<String, Integer> symptoms) {

        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(file, false));
            for(String key : symptoms.keySet()) {
                writer.write(key + " : " + symptoms.get(key));
                writer.newLine();
            }
            writer.close();
        } catch (IOException e) {
            System.err.println("IOException : Problem with destination file: Cannot find, create or modify");
        }
    }
}
