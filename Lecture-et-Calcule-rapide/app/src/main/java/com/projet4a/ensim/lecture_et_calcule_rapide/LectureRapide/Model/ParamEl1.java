package com.projet4a.ensim.lecture_et_calcule_rapide.LectureRapide.Model;

import java.io.Serializable;

public class ParamEl1 extends ParamLecture implements Serializable {

    /**
     * Nombre de mots contenue dans l'émoncé
     */
    private int nbEnonce;

    /**
     * Temps d'apparition de chaque proposition de réponces
     */
    private Long tempsApparution;

    /**
     * Nombre de proposition qui seront faite à l'élève
     */
    private int nbApparution;

    /**
     * Vrai : Les propositions pourront apparaitre en meme temps ou pendant qu'une autre est encore affichée.
     * Faux : Les propositions apparaitront les unes apprait les autres.
     */
    private Boolean multipleApparution;

    /**
     * Si multipleApparution est égale à vrai on pourra choisir le nombre d'apparition simultanée
     */
    private int nbAparitionSimultanee;

    /**
     * Vrai : L'énoncé disparaitra au bout d'un certain temps.
     * Faux : L'énoncé ne disparaitra pas.
     */
    private Boolean enonceDisparait;

    /**
     * Temps au bout duquel l'énoncé disparaitra si elle peut disparaitre.
     */
    private long tempsEnonce;

    /**
     * Constructeur bidon de ParamEl1 qui permet de tester facilement l'exercice.
     */
    public ParamEl1() {
        nbEnonce = 2;
        tempsApparution = new Long(5000);
        nbApparution = 10;
        multipleApparution = false;
        enonceDisparait = false;
        nbAparitionSimultanee = 2;
    }

    /**
     * Constructeur de ParamEl1 il permet de récupérer les infos saisi dans ModifParamEl1Activity.
     *
     * @param nbEnonce           Nombre de mots contenue dans l'émoncé
     * @param tempsApparution    Temps d'apparition de chaque proposition de réponces
     * @param nbApparution       Nombre de proposition qui seront faite à l'élève
     * @param multipleApparution Vrai : Les propositions pourront apparaitre en meme temps ou pendant qu'une autre est encore affichée.
     *                           Faux : Les propositions apparaitront les unes apprait les autres.
     * @param enonceDisparait    Vrai : L'énoncé disparaitra au bout d'un certain temps.
     *                           Faux : L'énoncé ne disparaitra pas.
     */
    public ParamEl1(int nbEnonce, Long tempsApparution, int nbApparution, Boolean multipleApparution, Boolean enonceDisparait, int nbAparitionSimultanee) {
        this.enonceDisparait = enonceDisparait;
        this.multipleApparution = multipleApparution;
        this.nbApparution = nbApparution;
        this.tempsApparution = tempsApparution;
        this.nbEnonce = nbEnonce;
        this.nbAparitionSimultanee = nbAparitionSimultanee;
    }

    //getters
    public int getNbEnonce() {
        return nbEnonce;
    }

    public Long getTempsApparution() {
        return tempsApparution;
    }

    public int getNbApparution() {
        return nbApparution;
    }

    public Boolean getMultipleApparution() {
        return multipleApparution;
    }

    public Boolean getEnonceDisparait() {
        return enonceDisparait;
    }

    public int getNbAparitionSimultanee() {
        return nbAparitionSimultanee;
    }
}
