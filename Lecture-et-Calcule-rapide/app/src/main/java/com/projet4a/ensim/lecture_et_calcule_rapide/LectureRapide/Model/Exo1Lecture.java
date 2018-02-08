package com.projet4a.ensim.lecture_et_calcule_rapide.LectureRapide.Model;

import android.util.Log;

import com.projet4a.ensim.lecture_et_calcule_rapide.LectureRapide.Activity.LectureAccueilActivity;
import com.projet4a.ensim.lecture_et_calcule_rapide.LectureRapide.Activity.LectureExo1Activity;

import java.io.FileNotFoundException;
import java.util.ArrayList;

/**
 * Created by Cordon Paul on 07/11/2017.
 */

/**
 * Classe servant de model pour LectureExo1Activity.
 */
public class Exo1Lecture {
    /**
     * Chaine de caractère contenant l'énoncé de l'exercice qui sera afficher en haut de l'écran.
     */
    String enonce= new String();

    /**
     * Tableau de chaine de caractère contenant l'énoncé et des mots similaires.
     * Les chaines de caractère contenues dans ce tableau serviront de propositions de réponce pour l'élève.
     */
    ArrayList<String> apparition= new ArrayList<>();

    /**
     * On instancie la classe ParamEl1 pour pouvoir charger les paramètres.
     */
    ParamEl1 paramEl1;//TODO serialisation des paramètres pour les passées en paramètre du constructeur.


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
    public Exo1Lecture(ParamEl1 param) throws FileNotFoundException {
        paramEl1=param;
        enonce=genererEnonce();
        apparition=genererApparition();

    }

    /**
     * Methode qui génère le tableau des apparition.
     * @return Tableau de chaine de caractère contenant l'énoncé et des mots similaires.
     */
    private ArrayList<String> genererApparition() throws FileNotFoundException {
        //TODO Il peut il y avoir des beugs avec les indices qui peuvent sortir du tableau



        ParseDB parseDB = new ParseDB("database.txt");
        parseDB.execute();
        int index = LectureExo1Activity.tirageAleatoireEntre1EtLeNombreMitEnParam(parseDB.listMot.size());
        ArrayList<String> enonc = new ArrayList<>();
        for (int i =index; i<index+6 ; i++ ) {
            if (i< parseDB.listMot.size()) {
                enonc.add(parseDB.listMot.get(i));
                Log.d("parse", "le mot est : " + enonc.get(i));
            }

        }
        return enonc;
    }

    /**
     * Methode qui génère l'énoncé de l'exercice.
     * @return Enoncé de l'exercice qui sera afficher en haut de l'écran
     */
    private String genererEnonce() {
        return "chat";
    }
}
