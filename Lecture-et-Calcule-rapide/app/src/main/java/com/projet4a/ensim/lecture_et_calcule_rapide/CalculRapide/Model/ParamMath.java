package com.projet4a.ensim.lecture_et_calcule_rapide.CalculRapide.Model;

import java.sql.Time;

/**
 * Created by Cordon Paul on 07/11/2017.
 */

abstract class ParamMath
{
    private Time tempsRep;

    private Boolean pairOnly;

    private Boolean chiffres[];

    private Boolean operateur[];
        // 0 : +
        // 1 : -
        // 2 : *
        // 3 : /

    ParamMath()
    {
        tempsRep=new Time(30);
        pairOnly=true;
        chiffres= new Boolean[10];
        for(int i=0;i<10;i++)
        {
            if(i%2==0) chiffres[i]=true;
            else chiffres[i]=false;
        }
        operateur = new Boolean[5];
            operateur[0]=true;
            operateur[1]=false;
            operateur[2]=true;
            operateur[3]=false;
            operateur[4]=false;
    }

    public Time getTempsRep(){return tempsRep;}

    public Boolean getPairOnly(){return pairOnly;}

    public Boolean[] getChiffres(){return chiffres;}

    public Boolean[] getOperateur() {return operateur;}


    public void setTempsRep(Time t){tempsRep=t;}

    public void setPairOnly(Boolean p){pairOnly=p;}

    public void setChiffres(Boolean[]c){chiffres=c;}

    public void setOperateur(Boolean[]o){operateur=o;}
}
