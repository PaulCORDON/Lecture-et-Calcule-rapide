package com.projet4a.ensim.lecture_et_calcule_rapide.LectureRapide.Model;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Cette classe recupère tous les mots contenu dans un fichier txt et les mets dans une ArrayList
 */

public class ParseDB {

    File database;
    ArrayList<String> listMot;

    ParseDB(String path) {
        database = new File(path);
        listMot = new ArrayList<>();
    }

    public void execute() throws FileNotFoundException {
        try (Scanner sc = new Scanner(database)) {
            String mot = "a";
            do {
                mot = sc.nextLine();
                listMot.add(mot);
            } while (!mot.equals("-1"));
        }
    }
}







