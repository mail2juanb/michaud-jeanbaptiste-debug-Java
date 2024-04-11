package com.hemebiotech.analytics;


import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Reads each line of a file and stores it in a list
 * @author Hemebiotech - Jb Michaud - mail2juanb@yahoo.fr
 */
public class SymptomReaderImpl implements SymptomReader {

	private final File file;

    /**
     * Register a File with filepath String, independently of the OS.
     * @param filepath a full or partial path to file with symptom strings in it, one per line
     */
	public SymptomReaderImpl(String filepath) {

        file = new File(filepath);
    }

    /**
     * Read file and put in ArrayList Symptoms in file specified
     * @return a raw listing of all Symptoms obtained from a data source, duplicates are possible/probable, no sort.
     */
	public List<String> getSymptoms() {

		ArrayList<String> result = new ArrayList<>();

		try {
			BufferedReader reader = new BufferedReader (new FileReader(file));
			String line = reader.readLine();
			while (line != null) {
				result.add(line);
				line = reader.readLine();
			}
			reader.close();
		} catch (FileNotFoundException e) {
            System.err.println("FileNotFoundException : File not found");
		} catch (IOException e) {
            System.err.println("IOException : Unable to read file content");
        }

        if (result.isEmpty()) {                    // Only notice to user
            System.err.println("File is empty");
        }

		return result;
	}
}
