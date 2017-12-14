package com.projet4a.ensim.lecture_et_calcule_rapide.LectureRapide.Model;

import java.util.ArrayList;

/**
 * Created by Cordon Paul on 07/11/2017.
 */

public class Exo1Lecture {
    String enonce= new String();
    ArrayList<String> apparition= new ArrayList<>();
    ParamEl1 paramEl1;

    public String getEnonce() {
        return enonce;
    }

    public void setEnonce(String enonce) {
        this.enonce = enonce;
    }

    public ArrayList<String> getApparition() {
        return apparition;
    }

    public void setApparition(ArrayList<String> apparition) {
        this.apparition = apparition;
    }

    public Exo1Lecture(ParamEl1 param){
        paramEl1=param;
        enonce=genererEnonce();
        apparition=genererApparition();

    }

    private ArrayList<String> genererApparition() {
        ArrayList<String> enonc = new ArrayList<>();
        return enonc;
    }

    private String genererEnonce() {
        return null;
    }
}
