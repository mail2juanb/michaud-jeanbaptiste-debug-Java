package com.hemebiotech.analytics;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

/**
 * Create a new file containing the data supplied
 * @author Jb Michaud - mail2juanb@yahoo.fr
 */
public class WriterDataToFile implements SymptomWriter {
    private final File file;

    /**
     * Register a File with filepath String, independently of the OS.
     * @param filepath a full or partial path to file with symptom strings in it, one per line
     */
    public WriterDataToFile(String filepath) {
        file = new File(filepath);
    }

    /**
     * Write sorted map in file
     * @param sortedMap a map with symptom as key and number of occurrences as value
     */
    public void writeToFile(Map<String, Integer> sortedMap) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(file, false));
            for(String key: sortedMap.keySet()){
                writer.write(key + " : " + sortedMap.get(key));
                writer.newLine();
            }
            writer.close();
        } catch (IOException e) {
            System.err.println("ERROR : IOException : Problem with destination file: Cannot find, create or modify");
        }
    }
}