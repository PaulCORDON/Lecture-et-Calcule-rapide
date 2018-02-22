package com.projet4a.ensim.lecture_et_calcule_rapide.CalculRapide.Model;

import java.util.ArrayList;

/**
 * Created by kilian on 15/02/2018.
 */

public class Exo2Math {

    /**
     * liste des calculs
     */
    private ArrayList<Calcul> enoncees = new ArrayList<>();

    private ParamEm2 param;

    private int op1;
    private int op2;

    public Exo2Math(ParamEm2 param){
    this.param = param;

    for (int a =0; a<this.param.getNbQuestions() ; a++){
        op1 = (int)(Math.random()*10);
        op2 = (int)(Math.random()*10);

        enoncees.add(new Calcul(op1,op2,'*'));
    }


    }



    /**
     *
     * @return la réponse du calcul sous forme de string
     */
    public ArrayList<Calcul> getCalcul(){
        return enoncees;
    }

    /**
     *
     * @return le type de reponse que l'élève doit donner
     */
    public ParamEm2 getParam(){
        return param;
    }


}
