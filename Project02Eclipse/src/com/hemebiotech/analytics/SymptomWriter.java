package com.hemebiotech.analytics;

import java.util.SortedMap;

/**
 * Writing in a file
 * Use a sortedMap to write each key, value in a file
 * @author Jb Michaud - mail2juanb@yahoo.fr
 * @since 1.0
 * @version 1.0
 */
public interface SymptomWriter {
    void writeToFile(SortedMap<String, Integer> s);
}

