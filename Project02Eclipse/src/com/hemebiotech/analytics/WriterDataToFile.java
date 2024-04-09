package com.hemebiotech.analytics;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.SortedMap;

/*
    BufferedWriter est une sous-classe de Writer, qui est utilisée pour simplifier l'écriture de texte
    dans un flux de sortie de caractères (character output stream) et améliorer les performances du programme.
 */

/**
 * Simple brute force implementation
 * @author Jb Michaud - mail2juanb@yahoo.fr
 * @since 1.0
 * @version 1.0
 */
public class WriterDataToFile implements SymptomWriter {

    private final File file;


    /**
     * Register a File with filepath String, independently of the OS.
     * @param filepath a full or partial path to file with symptom strings in it, one per line
     */
    // Pas bien compris cette phrase, pourquoi "un par ligne" ?

    public WriterDataToFile(String filepath) {

        // La classe File permet de déclarer un chemin de fichier indépendamment du systeme d'exploitation
        File file = new File(filepath);
        System.out.println("WriterDataToFile(String \"" + file + "\") --- déclenché");

        this.file = file;
        // la variable privée file est remplie
    }

    /**
     * Write sorted collection in file
     */
    public void writeToFile(SortedMap<String, Integer> s) {
        System.out.println("writeToFile(SortedMap<String, Integer> s) --- déclenché");

        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(file, false));
            // Le false est là pour remplacer le contenu du fichier

            // Boucle pour parcourir l'ensemble des clefs présentes dans la map et les intégrer au fichier
            for(String key: s.keySet()){
                System.out.println("La valeur de " + key + " est: " + s.get(key));
                writer.write(key + " : " + s.get(key));
                writer.newLine();
            }
            writer.close();

        } catch (IOException e) {
            System.err.println("ERROR : IOException : Problème avec le fichier de destination : Impossible de trouver, créer, modifier le fichier");
        }
    }
}
