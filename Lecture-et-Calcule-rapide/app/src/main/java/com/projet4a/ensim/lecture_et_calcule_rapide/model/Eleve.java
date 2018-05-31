package com.projet4a.ensim.lecture_et_calcule_rapide.model;

import java.util.Date;

public class Eleve {

    public Eleve(@NotEmpty String nomPrenom, Date dateDeNaissance) {
        super();
        this.nomPrenom = nomPrenom;
        this.dateDeNaissance = dateDeNaissance;
    }
    public Eleve() {
        super();
    }

    @NotEmpty
    private String nomPrenom;
    private Date dateDeNaissance;
    private int classeId;
    private String classeName;
    private ArrayList<Competence> listeCompetence;


    public String getClasseName() {
        return classeName;
    }
    public void setClasseName(String classeName) {
        this.classeName = classeName;
    }
    public int getClasseId() {
        return classeId;
    }
    public void setClasseId(int classeId) {
        this.classeId = classeId;
    }
    public Eleve( String nomPrenom, Date dateDeNaissance,String classeName) {
        this.nomPrenom = nomPrenom;
        this.dateDeNaissance = dateDeNaissance;
        this.classeName=classeName;
    }
    public Eleve( String nomPrenom, Date dateDeNaissance,String classeName,int classeId) {
        this.nomPrenom = nomPrenom;
        this.dateDeNaissance = dateDeNaissance;
        this.classeName=classeName;
        this.classeId=classeId;
    }
    public String getNomPrenom() {
        return nomPrenom;
    }
    public void setNomPrenom(String nomPrenom) {
        this.nomPrenom = nomPrenom;
    }
    public Date getDateDeNaissance() {
        return dateDeNaissance;
    }
    public void setDateDeNaissance(Date dateDeNaissance) {
        this.dateDeNaissance = dateDeNaissance;
    }
}
