package com.projet4a.ensim.lecture_et_calcule_rapide.model;

import java.util.Date;

/**
 *
 * class modélisant un élève
 */
public class Eleve {
    /**
     *
     * constructeur prenant une chaine de caractère pour le nom le prénom et une date de naissance
     * @param nomPrenom , le nom et le prénom
     * @param dateDeNaissance
     */
    public Eleve(String nomPrenom, Date dateDeNaissance) {
        super();
        this.nomPrenom = nomPrenom;
        this.dateDeNaissance = dateDeNaissance;
    }

    /**
     *
     * constructeur par défaut
     */
    public Eleve() {
        super();
    }


    private String nomPrenom;
    private Date dateDeNaissance;
    private int classeId;
    private String classeName;
   // private ArrayList<Competence> listeCompetence;

    /**
     *
     * setter pour le nom de la classe de l'élève
     * @param classeName
     */
    public void setClasseName(String classeName) {
        this.classeName = classeName;
    }

    /**
     *
     * getter pour le nom de la classe de l'élève
     * @return le nom de la classe de l'élève
     */
    public int getClasseId() {
        return classeId;
    }

    /**
     *
     * setter de l'id de la classe de l'élève
     * @param classeId
     */
    public void setClasseId(int classeId) {
        this.classeId = classeId;
    }

    /**
     * constructeur avec 3 paramètres , le nom et prénom de l'évève, sa date de naissance et le nom de sa classe
     * @param nomPrenom
     * @param dateDeNaissance
     * @param classeName
     */
    public Eleve( String nomPrenom, Date dateDeNaissance,String classeName) {
        this.nomPrenom = nomPrenom;
        this.dateDeNaissance = dateDeNaissance;
        this.classeName=classeName;
    }

    /**
     *
     *  constructeur avec 4 paramètres , le nom et prénom de l'évève, sa date de naissance, le nom de sa classe  et l'id de la classe
     *
     * @param nomPrenom
     * @param dateDeNaissance
     * @param classeName
     * @param classeId
     */
    public Eleve( String nomPrenom, Date dateDeNaissance,String classeName,int classeId) {
        this.nomPrenom = nomPrenom;
        this.dateDeNaissance = dateDeNaissance;
        this.classeName=classeName;
        this.classeId=classeId;
    }

    /**
     *
     * getter pour le nom et prennom de l'évève
     * @return nomPrenom
     */
    public String getNomPrenom() {
        return nomPrenom;
    }

    /**
     *
     * setter nom et prenom de l'élève
     * @param nomPrenom
     */
    public void setNomPrenom(String nomPrenom) {
        this.nomPrenom = nomPrenom;
    }

    /**
     *
     * getter pour la date de naisssance de l'élève
     * @return la date de naissance de l'élève
     */
    public Date getDateDeNaissance() {
        return dateDeNaissance;
    }

    /**
     *
     * setter pour la date de naissance de l'élève
     * @param dateDeNaissance
     */
    public void setDateDeNaissance(Date dateDeNaissance) {
        this.dateDeNaissance = dateDeNaissance;
    }
}
