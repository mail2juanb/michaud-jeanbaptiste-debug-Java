// Cette interface, nommée SymptomCount, définit un contrat pour les classes qui sont capables de countSymptoms dans une liste de symptômes.

package com.hemebiotech.analytics;                  // Déclare le package auquel appartient l'interface

import java.util.List;                              // Importe la classe List du package java.util, qui est utilisée pour représenter une liste d'objets.
import java.util.Map;                               // Importe la classe Map du package java.util, qui est utilisée pour représenter une collection d'objets sous forme de paires clé-valeur.

// Javadoc - documentation associé à l'interface
/**
 * Count occurrences of each symptom retrieved from the list
 * Return a map of symptoms (sorted alphabetically) with occurrences in the list.
 * @author Hemebiotech - Jb Michaud - mail2juanb@yahoo.fr
 */

// annotation fonctionnelle indiquant que cette interface est une interface fonctionnelle,
// ce qui signifie qu'elle a exactement une seule méthode abstraite (countSymptoms dans ce cas).
// Cela indique aussi que cette interface peut-être utilisée pour définir une expression lambda.
// Les expressions lambda peuvent être utilisées pour créer des instances de cette interface en fournissant
// une implémentation concise de la méthode abstraite.
@FunctionalInterface
// Déclare une interface Java nommée SymptomCount
public interface SymptomCount {

    // Déclare une méthode abstraite countSymptoms prenant une liste de chaînes de caractères et
    // renvoyant une Map où les clés sont une chaînes de caractères et les valeurs sont des entiers.
    Map<String, Integer> countSymptoms(List<String> symptoms);
}
