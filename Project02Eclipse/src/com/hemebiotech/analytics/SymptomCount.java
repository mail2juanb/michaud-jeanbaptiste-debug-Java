package com.hemebiotech.analytics;

import java.util.List;
import java.util.Map;

/**
 * Count occurrences of each symptom retrieved from the list
 * Return a map of symptoms (sorted alphabetically) with occurrences in the list.
 * @author Hemebiotech - Jb Michaud - mail2juanb@yahoo.fr
 */
@FunctionalInterface
public interface SymptomCount {

    Map<String, Integer> countSymptoms(List<String> symptoms);
}
