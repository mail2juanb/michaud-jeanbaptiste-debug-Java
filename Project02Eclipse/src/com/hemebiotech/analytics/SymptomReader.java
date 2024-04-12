package com.hemebiotech.analytics;			// Déclare le package auquel appartient l'interface

import java.util.List;						// Importe la classe List du package java.util, qui est utilisée pour représenter une liste d'objets.

// Javadoc - documentation associé à l'interface
/**
 * Anything that will read symptom data from a source
 * Return a raw listing of all Symptoms obtained from a data source, duplicates are possible/probable, no sort.
 * If no data is available, return an empty List.
 * @author Hemebiotech - Jb Michaud - mail2juanb@yahoo.fr
 */

// annotation fonctionnelle indiquant que cette interface est une interface fonctionnelle,
// ce qui signifie qu'elle a exactement une seule méthode abstraite (getSymptoms dans ce cas).
// Cela indique aussi que cette interface peut-être utilisée pour définir une expression lambda.
// Les expressions lambda peuvent être utilisées pour créer des instances de cette interface en fournissant
// une implémentation concise de la méthode abstraite.
@FunctionalInterface
// Déclare une interface Java nommée SymptomReader.
public interface SymptomReader {

	/**
	 * If no data is available, return an empty List
	 * @return a raw listing of all Symptoms obtained from a data source, duplicates are possible/probable
	 */

	// Déclare une méthode abstraite getSymptoms qui ne prend aucun argument et retourne une liste de chaînes de caractères.
	List<String> getSymptoms();
}
