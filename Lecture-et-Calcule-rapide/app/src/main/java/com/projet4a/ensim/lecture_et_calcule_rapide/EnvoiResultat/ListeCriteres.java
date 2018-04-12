package com.projet4a.ensim.lecture_et_calcule_rapide.EnvoiResultat;

import java.util.HashMap;

public class ListeCriteres {

    public HashMap<String, Critere> getListeCritere() {
        return listeCritere;
    }

    private HashMap<String,Critere> listeCritere;

    public void update(String key, boolean reponseBonne){
        if(listeCritere.containsKey(key)) listeCritere.get(key).update(reponseBonne);
    }
}
