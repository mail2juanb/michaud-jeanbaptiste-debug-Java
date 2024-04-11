package com.hemebiotech.analytics;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * Count occurrences of each symptom retrieved from the list
 * @author Hemebiotech - Jb Michaud - mail2juanb@yahoo.fr
 */
public class CountSymptomsImpl implements CountSymptoms {

    /**
     * Register each symptom from the list (no double entries), Counts the number of occurrences
     * @author Jb Michaud - mail2juanb@yahoo.fr
     * @return a Map of symptoms (sorted alphabetically) with occurrences in the list.
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
