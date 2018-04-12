package com.projet4a.ensim.lecture_et_calcule_rapide.EnvoiResultat;

public class Critere {

    private int nbQuestion = 0;
    private int bonneReponse = 0;

    private float pourcentageReussite;

    public void update (boolean reponseBonne){
        nbQuestion ++;
        if(reponseBonne) bonneReponse++;
        pourcentageReussite = bonneReponse/nbQuestion;
    }

    public float getPourcentageReussite() {
        return pourcentageReussite;
    }

    public int getNbQuestion() {
        return nbQuestion;
    }

    /* nom des criteres :
Criteres sur les opérandes :
    ContientNbImpair : il y a un nombre impair dans le calcul;
    ContientNbSupDix : il y a un nombre supérieur à 10;

Criteres sur le type de nombre sur lequel l'élève a des problème.
    PbTrois;
    PbSept;
    PbHuit;
    PbNeuf;


Criteres sur les opérations :
    CalculMultiplication : le calcul est une multiplication;
    CalculDivision : le calcul est une division;
    CalculSoustraction : le calcul est une soustraction;
    CalculAddition : le calcul est une addition;




     */
}
