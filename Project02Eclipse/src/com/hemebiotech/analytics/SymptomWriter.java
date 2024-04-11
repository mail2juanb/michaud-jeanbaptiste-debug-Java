package com.hemebiotech.analytics;

import java.util.Map;

/**
 * Writing in a file
 * Use a sortedMap to write each key, value in a file
 * @author Hemebiotech - Jb Michaud - mail2juanb@yahoo.fr
 */
@FunctionalInterface
public interface SymptomWriter {

    void writeSymptoms(Map<String, Integer> symptoms);
}
