package com.hemebiotech.analytics;      // Déclare le package auquel appartient la classe

import java.io.BufferedWriter;          // Importe la classe BufferedWriter du package java.io, qui est utilisée pour écrire du texte dans un fichier de manière efficace en tamponnant (mémoire tampon) les données.
import java.io.File;                    // Importe la classe File du package java.io, qui est utilisée pour représenter un fichier ou un répertoire dans le système de fichiers.
import java.io.FileWriter;              // Importe la classe FileWriter du package java.io, qui est utilisée pour écrire dans un fichier de manière efficace.
import java.io.IOException;             // Importe la classe IOException du package java.io, qui est utilisée pour gérer les exceptions liées aux entrées/sorties.
import java.util.Map;                   // Importe la classe Map du package java.util, qui est utilisée pour représenter une collection d'objets sous forme de paires clé-valeur.

// Javadoc - documentation associé à la classe
/**
 * Create a new file containing the data supplied
 * @author Hemebiotech - Jb Michaud - mail2juanb@yahoo.fr
 */
// Déclare une classe Java nommée SymptomWriterImpl qui implémente l'interface SymptomWriter.
public class SymptomWriterImpl implements SymptomWriter {

    // Déclare une variable privée (portée juste la classe) nommée file, de type File.
    // Ce champ est final, ce qui signifie qu'il ne peut pas être réassigné après son initialisation.
    private final File file;

    /**
     * Register a File with filepath String, independently of the OS.
     * @param filepath a full or partial path to file with symptom strings in it, one per line
     */
    // Déclare un constructeur pour la classe SymptomWriterImpl prenant une chaîne de caractères filepath en tant que paramètre.
    // Ce constructeur est utilisé pour créer une instance de la classe SymptomWriterImpl avec le chemin d'accès au fichier spécifié.
    public SymptomWriterImpl(String filepath) {

        // Initialise la variable file avec un nouvel objet File créé à partir du chemin d'accès spécifié.
        file = new File(filepath);
    }

    /**
     * Write sorted map in file
     * @param symptoms a map with symptom as key and number of occurrences as value
     */

    // Implémente la méthode writeSymptoms définie dans l'interface SymptomWriter.
    // Cette méthode prend une Map contenant des paires clé-valeur où les clés sont des symptômes et
    // les valeurs sont le nombre d'occurrences de chaque symptôme.
    public void writeSymptoms(Map<String, Integer> symptoms) {

        // Bloc try-catch utilisé pour gérer les exceptions
        try {
            // Crée un objet BufferedWriter pour écrire dans le fichier spécifié.
            // Le deuxième argument de FileWriter (false) indique que nous n'ajoutons pas de nouvelles données à un fichier existant,
            // mais que nous écrasons le contenu du fichier s'il existe déjà.
            // L'objet FileWriter peut lever une exception de type IOException (fichier introuvable ou non modifiable/protégé ou impossible d'écrire)
            BufferedWriter writer = new BufferedWriter(new FileWriter(file, false));
            // Démarre une boucle for pour itérer à travers les clés de la map symptoms.
            for(String key : symptoms.keySet()) {
                // Écrit la clé (symptôme) suivie de : et de sa valeur (nombre d'occurrences) dans le fichier.
                writer.write(key + ":" + symptoms.get(key));
                // Ajoute une nouvelle ligne dans le fichier.
                writer.newLine();
            }
            // Ferme le BufferedWriter une fois l'écriture terminée pour libérer les ressources.
            writer.close();

        // Cette exception est levée si une erreur survient pendant l'écriture du fichier. Venant de FileWriter
        } catch (IOException e) {
            System.err.println("IOException : Problem with destination file: Cannot find, create or modify");
        }
    }
}
