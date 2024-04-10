package com.hemebiotech.analytics;


import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Simple brute force implementation
 */
public class ReadSymptomDataFromFile implements ISymptomReader {

	private final File file;

	/**
	 * @param filepath a full or partial path to file with symptom strings in it, one per line
	 */
	public ReadSymptomDataFromFile (String filepath) {

        file = new File(filepath);
    }

	public List<String> getSymptoms() {

		ArrayList<String> result = new ArrayList<>();

		try {
			BufferedReader reader = new BufferedReader (new FileReader(file));		// FileNotFoundException
			String line = reader.readLine();										// IOException
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

        if (result.isEmpty()) {														// Only notice to user
            System.err.println("File is empty");
        }

		return result;
	}
}
