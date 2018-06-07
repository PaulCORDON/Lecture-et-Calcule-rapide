package com.projet4a.ensim.lecture_et_calcule_rapide.model;

import java.util.ArrayList;

public class Classe {

    private String nom;
    private ArrayList<Eleve> listeEleve;
    private int id;

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public Classe(String nom, ArrayList<Eleve> listeEleve) {
        this.nom = nom;
        this.listeEleve = new ArrayList<Eleve>();
    }
    public Classe() {
    }

    public String getNom() {
        return nom;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }
    public ArrayList<Eleve> getListeEleve() {
        return listeEleve;
    }
    public void setListeEleve(ArrayList<Eleve> listeEleve) {
        this.listeEleve = listeEleve;
    }
    public void addEleve(Eleve el) {
        this.listeEleve.add(el);
    }
}
