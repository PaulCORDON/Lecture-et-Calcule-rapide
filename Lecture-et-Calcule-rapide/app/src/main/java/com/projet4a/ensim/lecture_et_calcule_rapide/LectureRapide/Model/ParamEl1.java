package com.projet4a.ensim.lecture_et_calcule_rapide.LectureRapide.Model;

/**
 * Created by Cordon Paul on 07/11/2017.
 */

import java.sql.Time;
public class ParamEl1 extends ParamLecture{

    private int nbEnonce;
    private Time tempsApparution;
    private int nbApparution;
    private Boolean multipleApparution;
    private int nbBonneRep;
    private Boolean enonceDisparait;


    ParamEl1(){


    }

    //getters
    public int getNbEnonce() {return nbEnonce;}
    public Time getTempsApparution() {return tempsApparution;}
    public int getNbBonneRep() {return nbBonneRep;}
    public int getNbApparution() {return nbApparution;}
    public Boolean getMultipleApparution() {return multipleApparution;}
    public Boolean getEnonceDisparait() {return enonceDisparait;}

    //setters
    public void setNbEnonce(int nbEnonce) {this.nbEnonce = nbEnonce;}
    public void setTempsApparution(Time tempsApparution) {this.tempsApparution = tempsApparution;}
    public void setNbApparution(int nbApparution) {this.nbApparution = nbApparution;}
    public void setMultipleApparution(Boolean multipleApparution) {this.multipleApparution = multipleApparution;}
    public void setNbBonneRep(int nbBonneRep) {this.nbBonneRep = nbBonneRep;}
    public void setEnonceDisparait(Boolean enonceDisparait) {this.enonceDisparait = enonceDisparait;}




}
