package com.hemebiotech.analytics;

import java.io.*;
import java.security.KeyStore;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AnalyticsCounter {

	public static void main(String[] args) {

		// Création d'une liste pour accueillir les items
		List<Item> symptomsArrayList = new ArrayList<>();

		// Utilisation du fichier txt
		try {
			// Création d'un fileReader pour lire le fichier
			FileReader fileReader = new FileReader("Project02Eclipse/symptoms.txt");

			// Création d'un bufferedReader qui utilise le fileReader
			BufferedReader reader = new BufferedReader(fileReader);

			// une fonction à essayer pouvant générer une erreur
			String line = reader.readLine();

			// initialise la variable qui va contenir le nombre de lignes
			int numberOfLines = 0;

			// lecture de chaque lignes
			while (line != null) {
				numberOfLines++;
				// affichage de la ligne
				System.out.println("ligne " + numberOfLines + " : " + line);

				// créé un nouvel objet item
				String currentLine = line;
				int currentQuantity = 1;
				Item currentItem = new Item(currentLine, currentQuantity);

				// vérifie s'il existe un symptom identique dans la liste
				String returnedMessage = "No";
				int keyFounded = 0;
				for (int i = 0; i < symptomsArrayList.size(); i++) {
					if (symptomsArrayList.get(i).getSymptom().equals(currentItem.getSymptom())) {
						returnedMessage = "Yes";
						break;
					}
					keyFounded ++;
				}
				if (returnedMessage == "Yes") {
					// si oui on augmente le compteur de l'élément concerné.
					System.out.println("already exist in List, key = " + keyFounded);
					int oldQuantity = symptomsArrayList.get(keyFounded).getQuantity();
					int newQuantity = oldQuantity + 1;
					System.out.println("Nouvelle quantité = " + newQuantity);
					symptomsArrayList.get(keyFounded).setQuantity(newQuantity);
				} else {
					// si non on ajoute cette nouvelle entrée
					System.out.println("Not exist in List yet");
					symptomsArrayList.add(currentItem);
					System.out.println("Item " + currentItem.getSymptom() + " a été ajouté à la liste.");
				}

				System.out.println(" ");
				// lecture de la prochaine ligne
				line = reader.readLine();
			}

			reader.close();

			System.out.println("\nLe fichier comporte donc : " + numberOfLines + " lignes.");

			// Affichage du contenu de la liste + tri des données par ordre alphabétique
			System.out.println("\nAffichage du contenu de la liste triée");
			System.out.println("\nLa liste comporte : " + symptomsArrayList.size() + " lignes.");

			Collections.sort(symptomsArrayList);

			int numberOfItems = 0;
			for (Item item : symptomsArrayList) {
				numberOfItems++;
				System.out.println("Symptom " + item.getSymptom().toUpperCase() + " = " + item.getQuantity());
			}

			// Ecriture dans le fichier txt
			System.out.println("\nEcriture dans le fichier result.out");

			// Création d'un fileWriter pour écrire dans un fichier
			FileWriter fileWriter = new FileWriter("Project02Eclipse/result.out", false);

			// Création d'un bufferedWriter qui utilise le fileWriter
			BufferedWriter writer = new BufferedWriter(fileWriter);

			// Parcours de la liste pour écrire ligne par ligne
			for (Item item : symptomsArrayList) {
				writer.newLine();
				writer.write("Symptom " + item.getSymptom().toUpperCase() + " = " + item.getQuantity());
			}

			writer.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
