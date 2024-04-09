package com.hemebiotech.analytics;

import java.util.List;
/*
Le nom de l'interface devrait être simplement SymptomReader Le I est superflu
 */

/**
 * Anything that will read symptom data from a source
 *
 * @author Jb Michaud - mail2juanb@yahoo.fr
 * @return a raw listing of all Symptoms obtained from a data source, duplicates are possible/probable, no sort.
 * If no data is available, return an empty List.
 * @since 1.0
 * @version 1.0
 */
// Le return est-il au bon endroit ? 0 return dans le coin !
public interface ISymptomReader {
    // Faut-il ajouter ici de la javadoc ? c'est une méthode ?
    List<String> getSymptoms();
}
