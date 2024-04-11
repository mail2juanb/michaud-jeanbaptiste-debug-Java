package com.hemebiotech.analytics;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

/**
 * Create a new file containing the data supplied
 * @author Hemebiotech - Jb Michaud - mail2juanb@yahoo.fr
 */
public class SymptomWriterImpl implements SymptomWriter {

    private final File file;

    /**
     * Register a File with filepath String, independently of the OS.
     * @param filepath a full or partial path to file with symptom strings in it, one per line
     */
    public SymptomWriterImpl(String filepath) {
        file = new File(filepath);
    }

    /**
     * Write sorted map in file
     * @param symptoms a map with symptom as key and number of occurrences as value
     */
    public void writeSymptoms(Map<String, Integer> symptoms) {

        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(file, false));
            for(String key : symptoms.keySet()) {
                writer.write(key + ":" + symptoms.get(key));
                writer.newLine();
            }
            writer.close();
        } catch (IOException e) {
            System.err.println("IOException : Problem with destination file: Cannot find, create or modify");
        }
    }
}
