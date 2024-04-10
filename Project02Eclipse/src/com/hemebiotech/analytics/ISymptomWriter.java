package com.hemebiotech.analytics;

import java.util.Map;

public @FunctionalInterface interface ISymptomWriter {

    void writeSymptoms(Map<String, Integer> symptoms);
}
