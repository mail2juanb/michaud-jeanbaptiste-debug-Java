package com.hemebiotech.analytics;

public class AnalyticsCounter {

    final static String READ_FILEPATH = "Project02Eclipse/symptoms.txt";
    final static String WRITE_FILEPATH = "Project02Eclipse/result.out";

	public static void main(String[] args) {

        final ISymptomReader readSymptomDataFromFile = new ReadSymptomDataFromFile(READ_FILEPATH);
        final ISymptomWriter writeSymptomDataToFile = new WriteSymptomDataToFile(WRITE_FILEPATH);

        // A TERMINER - Coder la partie qui intègre la liste dans la map et qui compte les occurences.
    }
}
