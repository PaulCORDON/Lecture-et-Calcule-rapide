package com.projet4a.ensim.lecture_et_calcule_rapide.LectureRapide.Model;

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
    ParamEl1 paramEl1= new ParamEl1();//TODO serialisation des paramètres pour les passées en paramètre du constructeur.


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
    public Exo1Lecture(ParamEl1 param){
        paramEl1=param;
        enonce=genererEnonce();
        apparition=genererApparition();

    }

    /**
     * Methode qui génère le tableau des apparition.
     * @return Tableau de chaine de caractère contenant l'énoncé et des mots similaires.
     */
    private ArrayList<String> genererApparition() {
        //TODO réaliser la méthode genererAparition grace à une BDD.

        double rand = Math.random();
        //ParseDB parseDB = new ParseDB("database");
        //parseDB.execute();

        ArrayList<String> enonc = new ArrayList<>();
        enonc.add("cha");
        enonc.add("chat");
        enonc.add("cat");
        enonc.add("caht");
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
