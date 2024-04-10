package com.hemebiotech.analytics;

import java.util.Map;

/**
 * Writing in a file
 * Use a sortedMap to write each key, value in a file
 * @author Jb Michaud - mail2juanb@yahoo.fr
 */
public @FunctionalInterface interface SymptomWriter {

    void writeToFile(Map<String, Integer> sortedMap);
}

