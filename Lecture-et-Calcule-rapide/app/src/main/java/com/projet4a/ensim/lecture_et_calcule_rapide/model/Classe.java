package com.projet4a.ensim.lecture_et_calcule_rapide.model;

import java.util.ArrayList;


/** Classe représentant une classe  comporte un nom, un id et une liste d'èlève
 *
 * @param
 *
 *
 * */
public class Classe {

    private String nom;
    private ArrayList<Eleve> listeEleve;
    private int id;

    /**
     * retourne l'id de la classe
     *
     * @return l'id de a classe
     */
    public int getId() {
        return id;
    }

    /**
     *
     * setter de l'id de la classe
     * @param id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     *
     * constructeur avec le nom de la classe et la liste des élèves
     * @param nom
     * @param listeEleve
     */
    public Classe(String nom, ArrayList<Eleve> listeEleve) {
        this.nom = nom;
        this.listeEleve = new ArrayList<Eleve>();
    }

    /**
     *
     * constructeur par défaut
     */
    public Classe() {
    }

    /**
     * getter nom de la classe
     * @return le nom de la classe
     */
    public String getNom() {
        return nom;
    }

    /**
     * setter nom de la classe
     * @param nom
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     *
     * @return la liste des élèves de la classe
     */
    public ArrayList<Eleve> getListeEleve() {
        return listeEleve;
    }

    /**
     *
     *  setter de la liste d'élève
     * @param listeEleve
     */
    public void setListeEleve(ArrayList<Eleve> listeEleve) {
        this.listeEleve = listeEleve;
    }

    /**
     *
     * Méthode pour ajouter un élève a la classe
     *
     * @param el , un élève a ajoute
     */
    public void addEleve(Eleve el) {
        this.listeEleve.add(el);
    }
}
