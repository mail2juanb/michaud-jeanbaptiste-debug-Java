package com.hemebiotech.analytics;

// Inutile ici
//import java.io.BufferedReader;
//import java.io.File;
//import java.io.FileReader;
//import java.io.FileWriter;

//TODO Revoir le nom des éléments :
// - Mauvais nommage. Je propose de renommer ISymptomReader en SymptomReader.
// - Et donc la class SymptomReaderDataFromFile.
// TODO Remplacer le nom des variables/objets :
//  - r : ReadSymptomDataFromFile
//  - s : SortedMap
//  - v : variable de stockage
// TODO Supprimer les println
// TODO Supprimer les commentaires


import java.util.SortedMap;
import java.util.TreeMap;

public class AnalyticsCounter {

	/* Inutile
	private static int headacheCount = 0;	// initialize to 0
	private static int rashCount = 0;		// initialize to 0
	private static int pupilCount = 0;		// initialize to 0
	*/

	public static void main(String[] args) throws Exception {

		// initialiser les 3 classes
		// créer liste
		// compter
		// ecrire

		// Déclaration du chemin d'accès du fichier
		String filepath = "Project02Eclipse/symptoms.txt";

		// Instantiation de la classe ReadSymptomDataFromFile
		ReadSymptomDataFromFile r =	new ReadSymptomDataFromFile(filepath);

		// Je ne sais pas comment j'ai pu écrire cela, merci IntelliJ !
		for (String symptom : r.getSymptoms()) {
			System.out.println("symptom from file = " + symptom);
		}
		// Intégration de chaque ligne dans une map en faisant attention a ce qu'il n'y ai pas de doublons
		// Trouver quel map utiliser

		// Je vais utiliser une TreeMap afin de récupérer un ensemble trié (grace à l'implémentation de sortedMap dans TreeMap).
		// Le tri sera donc naturel par ordre alphabétique, pas besoin d'écrire un Comparator à la création de l'instance de la collection

		// Instantiation de la classe TreeMap qui implémente l'interface SortedMap
		SortedMap<String, Integer> s = new TreeMap<>();

		// Intégration des données de la liste récupérés avec le fichier source
		for (String symptom : r.getSymptoms()) {
			int v = 1;
			// Vérifie si la clef spécifiée existe ou non
			if (s.containsKey(symptom)){
				System.out.println("Le clef : " + symptom + " est déja présente");
				// On récupère la valeur de la clef correspondante
				v = s.get(symptom);
				System.out.println("La clef : " + symptom + " avait pour valeur : " + v);
				// On ajoute la nouvelle valeur dans la collection
				s.put(symptom, v += 1);
			} else {
				System.out.println("La clef : " + symptom + " n'est pas déjà présente");
				// On ajoute la nouvelle clef avec la valeur par defaut 1
				s.put(symptom,v);
			}
			System.out.println("La clef : " + symptom + " a pour valeur : " + s.get(symptom));
		}
		// Affichage des clef, valeur de la collection
		System.out.println(s);

		// On obtient donc bien une liste classée (alphabétiquement) du nombre d'occurence des symptoms contenus dans la liste du fichier source.

		// Reste à écrire le tout sur un fichier txt

		// Déclaration du chemin de sortie du fichier
		filepath = "Project02Eclipse/result.txt";

		// Instantiation de la classe ReadSymptomDataFromFile
		ReadSymptomDataFromFile r =	new ReadSymptomDataFromFile(filepath);

		/*
		// first get input
		BufferedReader reader = new BufferedReader (new FileReader("Project02Eclipse/symptoms.txt"));
		String line = reader.readLine();

		int i = 0;
		int headacheCount = 0;
		while (line != null) {
			i++;
			System.out.println("symptom from file: " + line);
			if (line.equals("headache")) {
				headacheCount++;
				System.out.println("number of headaches: " + headacheCount);
			}
			else if (line.equals("rush")) {
				rashCount++;
			}
			else if (line.contains("pupils")) {
				pupilCount++;
			}

			line = reader.readLine();
		}
		
		// next generate output
		FileWriter writer = new FileWriter ("result.out");
		writer.write("headache: " + headacheCount + "\n");
		writer.write("rash: " + rashCount + "\n");
		writer.write("dialated pupils: " + pupilCount + "\n");
		writer.close();
		 */
	}
}
