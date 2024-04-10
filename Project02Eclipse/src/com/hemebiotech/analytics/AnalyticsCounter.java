package com.hemebiotech.analytics;

import java.util.List;
import java.util.Map;

/**
 * Application to count the number of occurrences of symptoms retrieved from a file
 * and create a file containing the result.
 * @author Jb Michaud - mail2juanb@yahoo.fr
 * @since 1.0
 * @version 1.0
 */
public class AnalyticsCounter {

    final static String SYMPTOM_FILEPATH = "Project02Eclipse/symptoms.txt";
    final static String RESULT_FILEPATH = "Project02Eclipse/result.txt";

    public static void main(String[] args) {

        final ISymptomReader readSymptomDataFromFile = new ReadSymptomDataFromFile(SYMPTOM_FILEPATH);
        final CountSymptoms countSymptoms = new CountSymptomsImpl();
        final SymptomWriter writerDataToFile = new WriterDataToFile(RESULT_FILEPATH);

        final List<String> symptomList = readSymptomDataFromFile.getSymptoms();
        final Map<String, Integer> sortedMap = countSymptoms.countSymptoms(symptomList);
        writerDataToFile.writeToFile(sortedMap);
	}
}
