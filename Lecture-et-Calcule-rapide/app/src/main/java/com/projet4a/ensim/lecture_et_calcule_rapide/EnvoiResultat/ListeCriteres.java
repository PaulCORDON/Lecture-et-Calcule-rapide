package com.projet4a.ensim.lecture_et_calcule_rapide.EnvoiResultat;

import java.util.HashMap;

public class ListeCriteres {

    public static HashMap<String, Critere> getListeCritere() {
        return listeCritere;
    }

    private static HashMap<String,Critere> listeCritere = new HashMap<>();

    public static void update(String key, boolean reponseBonne){
        if(!listeCritere.containsKey(key)) listeCritere.put(key,new Critere());

        listeCritere.get(key).update(reponseBonne);
    }
}
