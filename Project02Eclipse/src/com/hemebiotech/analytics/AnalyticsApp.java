package com.hemebiotech.analytics;

import java.util.List;
import java.util.Map;

/**
 * Application to count occurrences of symptoms retrieved from a file and create file with result.
 * @author Hemebiotech - Jb Michaud - mail2juanb@yahoo.fr
 * @since 1.0
 * @version 1.0
 */
public class AnalyticsApp {

    final static String READ_FILEPATH = "Project02Eclipse/symptoms.txt";
    final static String WRITE_FILEPATH = "Project02Eclipse/result.out";

	public static void main(String[] args) {

        final SymptomReader readSymptomDataFromFile = new SymptomReaderImpl(READ_FILEPATH);
        final CountSymptoms countSymptoms = new CountSymptomsImpl();
        final SymptomWriter writeSymptomDataToFile = new SymptomWriterImpl(WRITE_FILEPATH);

        final List<String> symptomList = readSymptomDataFromFile.getSymptoms();
        final Map<String, Integer> sortedMap = countSymptoms.countSymptoms(symptomList);
        writeSymptomDataToFile.writeSymptoms(sortedMap);
    }
}
