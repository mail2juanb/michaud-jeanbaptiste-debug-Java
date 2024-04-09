package com.hemebiotech.analytics;

import java.io.*;
import java.util.ArrayList;
import java.util.List;


/*
BufferedReader
            --> synchrone
            --> thread-safe
            --> lecture de chaine de caractères (String)
            --> tampon de 8192 caractères

            - read() : lire un caractère
            - readLine() : lire une chaine
            - skip(n) : ignore N caractères
*/

// Nom de la class devrait être : SymptomReaderDataFromFile ?

/**
 * Simple brute force implementation
 * @author Jb Michaud - mail2juanb@yahoo.fr
 * @since 1.0
 * @version 1.0
 */

/*
Mise en œuvre simple par force brute ??
	-> Une attaque brute force consiste en un processus d’essais-erreurs
 */

public class ReadSymptomDataFromFile implements ISymptomReader {

	private String filepath;
	private File file;

	/**
	 * Register a File with filepath String, independently of the OS.
	 * @param filepath a full or partial path to file with symptom strings in it, one per line
	 */
	// Pas bien compris cette phrase, pourquoi "un par ligne" ?

	public ReadSymptomDataFromFile(String filepath) {
		// pourquoi on ne met pas void sur la méthode vu qu'elle ne revoi rien. Elle ne fait que remplir la variable file.

		// La classe File permet de déclarer un chemin de fichier indépendamment du systeme d'exploitation
		File file = new File(filepath);
		System.out.println("ReadSymptomDataFromFile(String \"" + file.toString() + "\") --- déclenché");

		this.file = file;
		// la variable privée file est remplie
	}
	
	//@Override
	/*
	L'annotation @Override indique au compilateur qu'une méthode donnée est
	la redéfinition d'une méthode de la superclasse. Or il n'y a pas de méthode getSymptoms dans l'interface.
	On peut donc supprimer
	 */

	/**
	 * Put in ArrayList Symptoms of file specified
	 * @return a raw listing of all Symptoms obtained from a data source, duplicates are possible/probable, no sort.
	 */
	public List<String> getSymptoms() {
		System.out.println("getSymptoms() --- déclenché");
		ArrayList<String> result = new ArrayList<String>();

		// La gestion des erreurs du remplissage du chemin d'accès du fichier est dans le try catch.
		// Pas besoin de mettre un if, c'est le boulot du try catch
		//TODO Refaire l'indentation propre
		//if (filepath != null) {
            try {
                BufferedReader reader = new BufferedReader(new FileReader(file)); // FileNotFoundException

                String line = reader.readLine();	// IOException

                while (line != null) {
                    result.add(line);
                    line = reader.readLine();
                }
                reader.close();
            } catch (FileNotFoundException e) {
                System.err.println("ERROR : FileNotFoundException : Le fichier est introuvable");
                //e.printStackTrace();
            } catch (IOException e) {
				// Je n'arrive pas à déclencher l'erreur ----
                System.err.println("ERROR : IOException : Impossible de lire le contenu du fichier");
                //e.printStackTrace();
            }
		//}
			if (result.isEmpty()){
				System.err.println("Le fichier est vide !");
			}
		return result;
	}

}

//En Java, System.out.println() imprime sur la sortie standard du système que vous utilisez. En revanche, System.err.println() affichera l'erreur standard.
//Il existe aussi printf au lieu de println (Il est utilisé pour imprimer des chaînes formatées à l'aide de divers spécificateurs de format.)
