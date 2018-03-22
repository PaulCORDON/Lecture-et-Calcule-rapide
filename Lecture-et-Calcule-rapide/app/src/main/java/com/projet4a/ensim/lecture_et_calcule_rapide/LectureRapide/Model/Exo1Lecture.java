package com.projet4a.ensim.lecture_et_calcule_rapide.LectureRapide.Model;

import android.app.Application;
import android.content.Context;
import android.util.Log;

import com.projet4a.ensim.lecture_et_calcule_rapide.LectureRapide.Activity.LectureExo1Activity;
import com.projet4a.ensim.lecture_et_calcule_rapide.R;

import java.io.FileNotFoundException;
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
        Log.d("Exo1Lecture", "On est dans le constructeur");
        paramEl1 = param;
        apparition = genererApparition(listeMots);
        enonce = genererEnonce();
    }

    /**
     * Methode qui génère le tableau des apparition.
     *
     * @return Tableau de chaine de caractère contenant l'énoncé et des mots similaires.
     */
    private ArrayList<String> genererApparition(String [] listeMots){
        //TODO Il peut il y avoir des bugs avec les indices qui peuvent sortir du tableau

        String[] tousLesMots = listeMots;
        for(String s: tousLesMots) Log.w("Liste String", "Affichage des mots " + s);
        int i=LectureExo1Activity.tirageAleatoireEntre1EtLeNombreMitEnParam(tousLesMots.length-5);
        ArrayList<String> enonce=new ArrayList<>();
        enonce.add(tousLesMots[i]);
        enonce.add(tousLesMots[i+1]);
        enonce.add(tousLesMots[i+2]);
        enonce.add(tousLesMots[i+3]);
        enonce.add(tousLesMots[i+4]);
        for(String s: enonce) Log.w("Liste String", "Affichage des mots de l enonce " + s);
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
