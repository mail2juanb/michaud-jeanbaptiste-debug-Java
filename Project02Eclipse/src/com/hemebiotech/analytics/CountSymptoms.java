package com.hemebiotech.analytics;

import java.util.List;
import java.util.Map;

/**
 * Counts the number of occurrences for each symptom retrieved from the list
 * Return a map of symptoms (sorted alphabetically) with the number of occurrences in the list.
 * @author Jb Michaud - mail2juanb@yahoo.fr
 */
public @FunctionalInterface interface CountSymptoms {

    Map<String, Integer> countSymptoms(List<String> symptoms);
}
