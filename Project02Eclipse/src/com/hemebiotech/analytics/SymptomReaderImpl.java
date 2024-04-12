package com.hemebiotech.analytics;		// Déclare le package auquel appartient la classe


import java.io.*;						// Importe toutes les classes du package java.io, qui sont nécessaires pour travailler avec les entrées/sorties, comme la lecture de fichiers.
import java.util.ArrayList;				// Importe la classe ArrayList du package java.util, qui est utilisée pour représenter une liste dynamique.
import java.util.List;					// Importe la classe List du package java.util, qui est utilisée pour représenter une liste d'objets.

// Javadoc - documentation associé à la classe
/**
 * Reads each line of a file and stores it in a list
 * @author Hemebiotech - Jb Michaud - mail2juanb@yahoo.fr
 */

// Déclare une classe Java nommée SymptomReaderImpl qui implémente l'interface SymptomReader.
public class SymptomReaderImpl implements SymptomReader {

	// Déclare une variable privée (portée juste la classe) nommée file, de type File.
	// Ce champ est final, ce qui signifie qu'il ne peut pas être réassigné après son initialisation.
	private final File file;

    /**
     * Register a File with filepath String, independently of the OS.
     * @param filepath a full or partial path to file with symptom strings in it, one per line
     */

	// Déclare un constructeur pour la classe SymptomReaderImpl prenant une chaîne de caractères filepath en tant que paramètre.
	// Ce constructeur est utilisé pour créer une instance de la classe SymptomReaderImpl avec le chemin d'accès au fichier spécifié.
	public SymptomReaderImpl(String filepath) {

		// Initialise la variable file avec un nouvel objet File créé à partir du chemin d'accès spécifié.
        file = new File(filepath);
    }

    /**
     * Read file and put in ArrayList Symptoms in file specified
     * @return a raw listing of all Symptoms obtained from a data source, duplicates are possible/probable, no sort.
     */

	// Implémente la méthode getSymptoms définie dans l'interface SymptomReader. Cette méthode lit le fichier spécifié et retourne une liste contenant chaque ligne du fichier.
	public List<String> getSymptoms() {

		// Crée une nouvelle instance de ArrayList appelée result pour stocker les symptômes lus à partir du fichier.
		ArrayList<String> result = new ArrayList<>();

		// Bloc try-catch utilisé pour gérer les exceptions
		try {
			// Crée un objet BufferedReader pour lire le fichier ligne par ligne à l'aide d'un objet FileReader qui lit à partir du fichier spécifié.
			// L'objet FileReader peut lever une exception de type FileNotFoundException (fichier introuvable)
			BufferedReader reader = new BufferedReader (new FileReader(file));
			// Déclare une variable line de type chaîne de caractères où l'on stock la ligne courante du fichier
			String line = reader.readLine();
			// boucle while qui continue tant que la ligne lue n'est pas nulle (c'est-à-dire tant qu'il reste des lignes à lire dans le fichier).
			while (line != null) {
				// Ajoute la ligne lue à la liste result.
				result.add(line);
				// Lit la prochaine ligne du fichier et la stock dans la variable line
				line = reader.readLine();
			}
			// Ferme le BufferedReader une fois la lecture terminée pour libérer les ressources.
			reader.close();

		// FileNotFoundException: Cette exception est levée si le fichier spécifié dans le constructeur n'est pas trouvé.
		} catch (FileNotFoundException e) {
            System.err.println("FileNotFoundException : File not found");

		// Cette exception est levée si une erreur survient pendant la lecture du fichier.
		} catch (IOException e) {
            System.err.println("IOException : Unable to read file content");
        }

		// Condition permettant de déterminer si le fichier est fichier est vide. Inutile de traiter un fichier vide !
		// Cette affirmation est déterminée grace au fait que la List est vide...
        if (result.isEmpty()) {                    // Only notice to user
            System.err.println("File is empty");
        }

		// Retourne la liste result contenant chaque ligne lue à partir du fichier.
		return result;
	}
}
