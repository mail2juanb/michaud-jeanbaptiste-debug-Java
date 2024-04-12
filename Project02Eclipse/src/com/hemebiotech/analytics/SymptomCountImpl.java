package com.hemebiotech.analytics;              // Déclare le package auquel appartient la classe

import java.util.List;                          // Importe la classe List du package java.util, qui est utilisée pour représenter une liste d'objets.
import java.util.Map;                           // Importe la classe Map du package java.util, qui est utilisée pour représenter une collection d'objets sous forme de paires clé-valeur.
import java.util.TreeMap;                       // Importe la classe TreeMap du package java.util, qui est utilisée pour stocker les symptômes dans un ordre trié par défaut (ordre naturel).

// Javadoc - documentation associé à la classe
/**
 * Count occurrences of each symptom retrieved from the list
 * @author Hemebiotech - Jb Michaud - mail2juanb@yahoo.fr
 */

// Déclare une classe Java nommée SymptomCountImpl qui implémente l'interface SymptomCount.
public class SymptomCountImpl implements SymptomCount {

    /**
     * Register each symptom from the list (no double entries), Counts the number of occurrences
     * @author Jb Michaud - mail2juanb@yahoo.fr
     * @return a Map of symptoms (sorted alphabetically) with occurrences in the list.
     */

    // Implémente la méthode countSymptoms définie dans l'interface SymptomCount.
    public Map<String, Integer> countSymptoms(List<String> symptoms) {

        // Crée une nouvelle instance de TreeMap pour stocker les symptômes. Comme TreeMap est utilisé, les symptômes seront automatiquement triés par ordre alphabétique.
        Map<String, Integer> sortedSymptoms = new TreeMap<>();

        // boucle qui itère pour chaque chaine de caractère nommée symptom contenue dans la list symtoms
        for (String symptom : symptoms) {
            // Déclare une variable nommée value qui enregistre une valeure de type Entier.
            // Cette variable est remplie par la récupération la valeur associée à la clé (au symptôme) dans la map sortedSymptoms.
            // Si la clé n'existe pas, la valeur par défaut est 0.
            int value = sortedSymptoms.getOrDefault(symptom, 0);
            // Ajoute à la Map sortedSymptoms la clef symptom et sa valeur incrémentée de 1.
            sortedSymptoms.put(symptom, value + 1);
        }
        // Renvoi la map sortedSymptoms contenant les clés symptômes triés par ordre naturel (alphabétique) avec leur valeur associée, le nombre d'occurrences de chaque symptôme.
        return sortedSymptoms;
    }
}
