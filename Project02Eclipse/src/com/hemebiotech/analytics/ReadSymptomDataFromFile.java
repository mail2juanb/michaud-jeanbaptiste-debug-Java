package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Reads each line of a file and stores it in a list
 * @author Jb Michaud - mail2juanb@yahoo.fr
 */
public class ReadSymptomDataFromFile implements ISymptomReader {

	private final File file;

	/**
	 * Register a File with filepath String, independently of the OS.
	 * @param filepath a full or partial path to file with symptom strings in it, one per line
	 */
	public ReadSymptomDataFromFile(String filepath) {
		file = new File(filepath);
	}

	/**
	 * Put in ArrayList Symptoms in file specified
	 * @return a raw listing of all Symptoms obtained from a data source, duplicates are possible/probable, no sort.
	 */
	public List<String> getSymptoms() {
		ArrayList<String> result = new ArrayList<>();
		try {
			BufferedReader reader = new BufferedReader(new FileReader(file));
			String line = reader.readLine();
			while (line != null) {
				result.add(line);
				line = reader.readLine();
			}
                reader.close();
            } catch (FileNotFoundException e) {
                System.err.println("ERROR : FileNotFoundException : File not found");
            } catch (IOException e) {
                System.err.println("ERROR : IOException : Cannot read file contents");
        }
		if (result.isEmpty()) {
			System.err.println("File is empty");
		}
		return result;
	}
}