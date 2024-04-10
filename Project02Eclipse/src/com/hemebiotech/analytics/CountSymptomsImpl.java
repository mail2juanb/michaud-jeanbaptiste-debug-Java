package com.hemebiotech.analytics;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * Counts the number of occurrences for each symptom retrieved from the list
 * @author Jb Michaud - mail2juanb@yahoo.fr
 */
public class CountSymptomsImpl implements CountSymptoms {

    /**
     * Register each symptoms from the list (no double entries), Counts the number of occurrences
     * @author Jb Michaud - mail2juanb@yahoo.fr
     * @return a Map of symptoms (sorted alphabetically) with the number of occurrences in the list.
     */
    public Map<String, Integer> countSymptoms(List<String> symptoms) {

        Map<String, Integer> sortedSymptoms = new TreeMap<>();
        for (String symptom : symptoms) {
            int value = sortedSymptoms.getOrDefault(symptom, 0);
            sortedSymptoms.put(symptom, value + 1);
        }
        return sortedSymptoms;
    }
}
