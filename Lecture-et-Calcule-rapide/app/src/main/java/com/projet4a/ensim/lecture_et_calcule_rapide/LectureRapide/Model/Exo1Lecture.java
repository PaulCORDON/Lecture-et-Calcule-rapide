package com.projet4a.ensim.lecture_et_calcule_rapide.LectureRapide.Model;

import java.util.ArrayList;

/**
 * Created by Cordon Paul on 07/11/2017.
 */

public class Exo1Lecture {
    ArrayList<String> enonce= new ArrayList<String>();
    ArrayList<String> apparition= new ArrayList<String>();
    ParamEl1 paramEl1;

    public Exo1Lecture(ParamEl1 param){
        paramEl1=param;
        enonce=genererEnonce();
        apparition=genererApparition();

    }

    private ArrayList<String> genererApparition() {
        ArrayList<String> enonc = new ArrayList<String>();
        return enonc;
    }

    private ArrayList<String> genererEnonce() {
        return null;
    }
}
