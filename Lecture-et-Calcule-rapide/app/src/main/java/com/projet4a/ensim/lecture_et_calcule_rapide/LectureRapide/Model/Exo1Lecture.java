package com.projet4a.ensim.lecture_et_calcule_rapide.LectureRapide.Model;

import android.util.Log;

import com.projet4a.ensim.lecture_et_calcule_rapide.LectureRapide.Activity.LectureExo1Activity;

import java.util.ArrayList;

/**
 * Classe servant de model pour LectureExo1Activity.
 */
public class Exo1Lecture {
    /**
     * Chaine de caractère contenant l'énoncé de l'exercice qui sera afficher en haut de l'écran.
     */
    String enonce = new String();

    /**
     * Tableau de chaine de caractère contenant l'énoncé et des mots similaires.
     * Les chaines de caractère contenues dans ce tableau serviront de propositions de réponce pour l'élève.
     */
    ArrayList<String> apparition = new ArrayList<>();

    /**
     * On instancie la classe ParamEl1 pour pouvoir charger les paramètres.
     */
    ParamEl1 paramEl1;


    public String getEnonce() {
        return enonce;
    }

    public ArrayList<String> getApparition() {
        return apparition;
    }

    /**
     * Constructeur de la classe Exo1Lecture.
     * Elle charge les paramètres et génere l'énoncé ainsi que le tableau des apparition.
     */
    public Exo1Lecture(ParamEl1 param, String[] listeMots) {
        Log.d("Exo1Lecture", "On est dans le constructeur avec un énonce d'un mot");
        paramEl1 = param;
        apparition = genererApparition(listeMots);
        enonce = genererEnonce();
    }

    public Exo1Lecture(ParamEl1 param, String[] listeMots, String[] listeMots2) {
        Log.d("Exo1Lecture", "On est dans le constructeur avec un énoncé de deux mots");
        paramEl1 = param;
        apparition = genererApparition(listeMots, listeMots2);
        enonce = genererEnonce();
    }

    /**
     * Methode qui génère le tableau des apparition.
     *
     * @return Tableau de chaine de caractère contenant l'énoncé et des mots similaires.
     */
    private ArrayList<String> genererApparition(String[] listeMots) {
        //TODO Il peut il y avoir des bugs avec les indices qui peuvent sortir du tableau
        String[] tousLesMots = listeMots;

        int i = LectureExo1Activity.tirageAleatoireEntre1EtLeNombreMitEnParam(tousLesMots.length - 5);
        ArrayList<String> enonce = new ArrayList<>();
        enonce.add(tousLesMots[i]);
        enonce.add(tousLesMots[i + 1]);
        enonce.add(tousLesMots[i + 2]);
        enonce.add(tousLesMots[i + 3]);
        enonce.add(tousLesMots[i + 4]);
        for (String s : enonce) Log.w("Liste String", "Affichage des mots de l enonce " + s);
        return enonce;
    }

    private ArrayList<String> genererApparition(String[] listeMots, String[] listeMots2) {
        //TODO Il peut il y avoir des bugs avec les indices qui peuvent sortir du tableau
        String[] tousLesNom = listeMots2;
        String[] tousLesDeterminant = listeMots;
        Log.i("tout les noms taille = ", tousLesNom.length + "");
        Log.i("tout les deters = ", tousLesDeterminant.length + "");
        int i = LectureExo1Activity.tirageAleatoireEntre1EtLeNombreMitEnParam(tousLesNom.length - 3);
        Log.i("i = ", i + "");
        ArrayList<String> enonce = new ArrayList<>();
        int index = LectureExo1Activity.tirageAleatoireEntre1EtLeNombreMitEnParam(tousLesDeterminant.length - 3);
        Log.i("index = ", index + "");
        for (int j = index; j < index + 3; j++) {
            enonce.add(tousLesDeterminant[j] + " " + tousLesNom[i]);
            enonce.add(tousLesDeterminant[j] + " " + tousLesNom[i + 1]);
            enonce.add(tousLesDeterminant[j] + " " + tousLesNom[i + 2]);
        }

        for (String s : enonce) Log.w("Liste String", "Affichage des mots de l enonce " + s);
        return enonce;
    }

    /**
     * Methode qui génère l'énoncé de l'exercice.
     *
     * @return Enoncé de l'exercice qui sera afficher en haut de l'écran
     */
    private String genererEnonce() {
        return apparition.get(0);
    }
}
