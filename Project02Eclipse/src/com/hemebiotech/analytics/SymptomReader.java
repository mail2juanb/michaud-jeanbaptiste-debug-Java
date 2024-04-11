package com.hemebiotech.analytics;

import java.util.List;

/**
 * Anything that will read symptom data from a source
 * Return a raw listing of all Symptoms obtained from a data source, duplicates are possible/probable, no sort.
 * If no data is available, return an empty List.
 * @author Hemebiotech - Jb Michaud - mail2juanb@yahoo.fr
 */
@FunctionalInterface
public interface SymptomReader {

	/**
	 * If no data is available, return an empty List
	 * @return a raw listing of all Symptoms obtained from a data source, duplicates are possible/probable
	 */
	List<String> getSymptoms();
}
