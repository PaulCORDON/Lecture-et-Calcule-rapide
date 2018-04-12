package com.projet4a.ensim.lecture_et_calcule_rapide.CalculRapide.Model;

import java.util.ArrayList;

public class borne{
    ArrayList<Integer> bornes;

    public borne(int nbBornes) {
        bornes = new ArrayList<>(nbBornes);
    }

    public void add(int borne) {
        bornes.add(borne);
    }

    public int size() {
        return bornes.size();
    }

    public int get(int j) {
        return bornes.get(j);
    }

    public void set(int j, int i) {
        bornes.set(j,i);
    }

    public int indexOf(int b) {
        return bornes.indexOf(b);
    }
}