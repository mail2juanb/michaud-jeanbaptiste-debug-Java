// Cette classe est la classe principale de l'application.

package com.hemebiotech.analytics;              // Déclare le package auquel appartient la classe

import java.util.List;                          // Importe la classe List du package java.util, qui est utilisée pour représenter une liste d'objets.
import java.util.Map;                           // Importe la classe Map du package java.util, qui est utilisée pour représenter une collection d'objets sous forme de paires clé-valeur.

// Javadoc - documentation associé à la classe
/**
 * Application to count occurrences of symptoms retrieved from a file and create file with result.
 * @author Hemebiotech - Jb Michaud - mail2juanb@yahoo.fr
 * @since 1.0                                   // version de l'application depuis laquelle cette classe est présente
 * @version 1.0                                 // version de cette classe spécifique
 */

// Classe principale de l'application
public class AnalyticsApp {

    // Déclaration des variables constantes pour les accès aux fichiers d'entrée et de sortie.
    final static String READ_FILEPATH = "Project02Eclipse/symptoms.txt";
    final static String WRITE_FILEPATH = "Project02Eclipse/result.out";

    // Déclare une méthode main, qui est la méthode principale exécutée lors du lancement de l'application.
    // Elle prend un tableau de chaînes de caractères args en tant que paramètre, bien que dans ce cas, il n'est pas utilisé.
	public static void main(String[] args) {

        // Crée une instance de la classe SymptomReaderImpl pour lire les symptômes à partir du fichier spécifié par READ_FILEPATH.
        final SymptomReader readSymptomDataFromFile = new SymptomReaderImpl(READ_FILEPATH);

        //Crée une instance de la classe SymptomCountImpl, pour compter le nombre d'occurrences de chaque symptôme.
        final SymptomCount symptomCount = new SymptomCountImpl();

        // Crée une instance de la classe SymptomReaderImpl pour lire les symptômes à partir du fichier spécifié par WRITE_FILEPATH.
        final SymptomWriter writeSymptomDataToFile = new SymptomWriterImpl(WRITE_FILEPATH);

        // Utilise l'instance de SymptomReaderImpl pour lire les symptômes à partir du fichier et les stocker
        // dans une liste de chaînes de caractères symptomList.
        final List<String> symptomList = readSymptomDataFromFile.getSymptoms();

        // Utilise l'instance de SymptomCountImpl pour compter le nombre d'occurrences de chaque symptôme dans la liste symptomList
        // et stocker les résultats dans une Map où les clés sont les symptômes et les valeurs sont le nombre d'occurrences.
        // La map résultante est stockée dans sortedMap.
        final Map<String, Integer> sortedMap = symptomCount.countSymptoms(symptomList);

        // Utilise l'instance de SymptomWriterImpl pour écrire les symptômes et leurs occurrences dans le fichier spécifié par WRITE_FILEPATH,
        // en utilisant les données de la Map sortedMap.
        writeSymptomDataToFile.writeSymptoms(sortedMap);
    }
}
