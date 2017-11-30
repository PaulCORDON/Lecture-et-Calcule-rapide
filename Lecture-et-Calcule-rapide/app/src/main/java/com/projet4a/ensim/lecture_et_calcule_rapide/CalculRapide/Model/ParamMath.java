package com.projet4a.ensim.lecture_et_calcule_rapide.CalculRapide.Model;

import java.sql.Time;

/**
 * Created by Cordon Paul on 07/11/2017.
 */

abstract class ParamMath
{
    private Long tempsRep;

    private Boolean pairOnly;

    private Boolean operateur[];
        // 0 : +
        // 1 : -
        // 2 : *
        // 3 : /

    ParamMath()
    {
        tempsRep=new Long(30);
        pairOnly=true;

        operateur = new Boolean[4];
            operateur[0]=true;
            operateur[1]=false;
            operateur[2]=true;
            operateur[3]=false;

    }

    ParamMath(Long t, Boolean p, Boolean[] o)
    {
        tempsRep=t;
        pairOnly=p;
        operateur=o;
    }

    public Long getTempsRep(){return tempsRep;}

    public Boolean getPairOnly(){return pairOnly;}


    public Boolean[] getOperateur() {return operateur;}


    public void setTempsRep(Long t){tempsRep=t;}

    public void setPairOnly(Boolean p){pairOnly=p;}

    public void setOperateur(Boolean[]o){operateur=o;}
}
