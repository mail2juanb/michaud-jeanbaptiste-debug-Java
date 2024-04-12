package com.hemebiotech.analytics;          // Déclare le package auquel appartient l'interface

import java.util.Map;                       // Importe la classe Map du package java.util, qui est utilisée pour représenter une collection d'objets sous forme de paires clé-valeur.

// Javadoc - documentation associé à l'interface
/**
 * Writing in a file
 * Use a sortedMap to write each key, value in a file
 * @author Hemebiotech - Jb Michaud - mail2juanb@yahoo.fr
 */

// annotation fonctionnelle indiquant que cette interface est une interface fonctionnelle,
// ce qui signifie qu'elle a exactement une seule méthode abstraite (getSymptoms dans ce cas).
// Cela indique aussi que cette interface peut-être utilisée pour définir une expression lambda.
// Les expressions lambda peuvent être utilisées pour créer des instances de cette interface en fournissant
// une implémentation concise de la méthode abstraite.
@FunctionalInterface
// Déclare une interface Java nommée SymptomWriter.
public interface SymptomWriter {

    // Déclare une méthode abstraite (forcement c'est une interface) writeSymptoms qui prend une Map
    // contenant des paires clé-valeur où les clés sont des chaines de caractères (symptômes) et les valeurs sont des entiers (le nombre d'occurrences de chaque symptôme).
    void writeSymptoms(Map<String, Integer> symptoms);
}