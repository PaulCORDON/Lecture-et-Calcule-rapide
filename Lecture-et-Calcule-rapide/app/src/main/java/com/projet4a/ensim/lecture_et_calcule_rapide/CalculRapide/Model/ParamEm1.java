package com.projet4a.ensim.lecture_et_calcule_rapide.CalculRapide.Model;


import com.projet4a.ensim.lecture_et_calcule_rapide.CalculRapide.Model.ParamMath;

import java.sql.Time;

/**
 * Created by Cordon Paul on 07/11/2017.
 */

public class ParamEm1 extends ParamMath {

    private int nbBornes;
    private int nbQuestions;
    private Boolean calculDisparait;
    private Boolean ordreApparition;
    private Boolean borneSelectionnable;
    private Boolean borneEqualsOp;
    private int valMax;

    ParamEm1()
    {
        super();
        nbBornes=2;
        nbQuestions=5;
        calculDisparait=false;
        ordreApparition=true;
        borneSelectionnable=false;
        borneEqualsOp=false;
        valMax=50;
    }

    ParamEm1(Time t, Boolean p, Boolean[] c, Boolean[] o, int nbb, int nbq, Boolean cd, Boolean oa, Boolean bs, Boolean beo, int vm)
    {
        super(t, p, c, o);
        nbBornes=nbb;
        nbQuestions=nbq;
        calculDisparait=cd;
        ordreApparition=oa;
        borneSelectionnable=bs;
        borneEqualsOp=beo;
        valMax=vm;
    }

    public int getNbBornes(){return nbBornes;}

    public int getNbQuestions(){return nbQuestions;}

    public Boolean getCalculDisparait(){return calculDisparait;}

    public Boolean getOrdreApparition(){return ordreApparition;}

    public Boolean getBorneSelectionnable(){return borneSelectionnable;}

    public Boolean getBorneEqualsOp(){return borneEqualsOp;}

    public int getValMax(){return valMax;}


    public void setNbBornes(int nbBornes) {
        this.nbBornes = nbBornes;
    }

    public void setNbQuestions(int nbQuestions) {
        this.nbQuestions = nbQuestions;
    }

    public void setCalculDisparait(Boolean calculDisparait){this.calculDisparait = calculDisparait;}

    public void setOrdreApparition(Boolean ordreApparition){this.ordreApparition = ordreApparition;}

    public void setBorneSelectionnable(Boolean borneSelectionnable){this.borneSelectionnable = borneSelectionnable;}

    public void setBorneEqualsOp(Boolean borneEqualsOp){this.borneEqualsOp = borneEqualsOp;}

    public void setValMax(int valMax){this.valMax = valMax;}

}
