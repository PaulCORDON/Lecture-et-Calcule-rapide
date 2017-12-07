package com.projet4a.ensim.lecture_et_calcule_rapide.LectureRapide.Model;

/**
 * Created by Cordon Paul on 07/11/2017.
 */

import java.sql.Time;
public class ParamEl1 extends ParamLecture{

    private int nbEnonce;
    private Long tempsApparution;
    private int nbApparution;
    private Boolean multipleApparution;
    private Boolean enonceDisparait;


    public ParamEl1(){}

    public ParamEl1(int nbEnonce,Long tempsApparution, int nbApparution,Boolean multipleApparution,Boolean enonceDisparait ){
        this.enonceDisparait = enonceDisparait;
        this.multipleApparution = multipleApparution;
        this.nbApparution = nbApparution;
        this.tempsApparution = tempsApparution;
        this.nbEnonce = nbEnonce;

    }

    //getters
    public int getNbEnonce() {return nbEnonce;}
    public Long getTempsApparution() {return tempsApparution;}
    public int getNbApparution() {return nbApparution;}
    public Boolean getMultipleApparution() {return multipleApparution;}
    public Boolean getEnonceDisparait() {return enonceDisparait;}

    //setters
    public void setNbEnonce(int nbEnonce) {this.nbEnonce = nbEnonce;}
    public void setTempsApparution(Long tempsApparution) {this.tempsApparution = tempsApparution;}
    public void setNbApparution(int nbApparution) {this.nbApparution = nbApparution;}
    public void setMultipleApparution(Boolean multipleApparution) {this.multipleApparution = multipleApparution;}
    public void setEnonceDisparait(Boolean enonceDisparait) {this.enonceDisparait = enonceDisparait;}


}
