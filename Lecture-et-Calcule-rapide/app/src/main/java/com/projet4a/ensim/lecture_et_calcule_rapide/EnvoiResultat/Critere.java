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
}
