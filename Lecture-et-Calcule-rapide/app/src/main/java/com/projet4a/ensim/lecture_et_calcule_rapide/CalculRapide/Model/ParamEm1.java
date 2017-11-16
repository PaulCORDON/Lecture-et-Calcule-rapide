package com.projet4a.ensim.lecture_et_calcule_rapide.CalculRapide.Model;


import com.projet4a.ensim.lecture_et_calcule_rapide.CalculRapide.Model.ParamMath;

/**
 * Created by Cordon Paul on 07/11/2017.
 */

public class ParamEm1 extends ParamMath {

    private int nbBornes;
    private int nbQuestions;
    private int scaleFrise;
    private Boolean calculDisparait;
    private String ordreApparition;
    private Boolean borneSelectionnable;
    private Boolean borneEqualsOp;
    private int valMax;


    public int getNbBornes() {
        return nbBornes;
    }

    public void setNbBornes(int nbBornes) {
        this.nbBornes = nbBornes;
    }

    public int getNbQuestions() {
        return nbQuestions;
    }

    public void setNbQuestions(int nbQuestions) {
        this.nbQuestions = nbQuestions;
    }

    public int getScaleFrise() {
        return scaleFrise;
    }

    public void setScaleFrise(int scaleFrise) {
        this.scaleFrise = scaleFrise;
    }

    public Boolean getCalculDisparait() {
        return calculDisparait;
    }

    public void setCalculDisparait(Boolean calculDisparait) {
        this.calculDisparait = calculDisparait;
    }

    public String getOrdreApparition() {
        return ordreApparition;
    }

    public void setOrdreApparition(String ordreApparition) {
        this.ordreApparition = ordreApparition;
    }

    public Boolean getBorneSelectionnable() {
        return borneSelectionnable;
    }

    public void setBorneSelectionnable(Boolean borneSelectionnable) {
        this.borneSelectionnable = borneSelectionnable;
    }

    public Boolean getBorneEqualsOp() {
        return borneEqualsOp;
    }

    public void setBorneEqualsOp(Boolean borneEqualsOp) {
        this.borneEqualsOp = borneEqualsOp;
    }

    public int getValMax() {
        return valMax;
    }

    public void setValMax(int valMax) {
        this.valMax = valMax;
    }



}
