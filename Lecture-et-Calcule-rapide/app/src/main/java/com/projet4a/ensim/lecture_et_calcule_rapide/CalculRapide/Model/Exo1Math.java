package com.projet4a.ensim.lecture_et_calcule_rapide.CalculRapide.Model;

import com.projet4a.ensim.lecture_et_calcule_rapide.CalculRapide.Model.ParamEm1;
import com.projet4a.ensim.lecture_et_calcule_rapide.Exercice;

import java.util.ArrayList;

/**
 * Created by Cordon Paul on 07/11/2017.
 */

/*public class Exo1Math extends Exercice {

    private ArrayList<String> calculEnonce;

    private ParamEm1 param;

    private int resultat;


    public Exo1Math(ParamEm1 param )
    {
        this.param = param;
        calculEnonce = new ArrayList(this.param.getNbQuestions());

        int operandes[] = new int[2];
            operandes[0] = 0;
            operandes[1] = 0;

        for (int a=0; a <= this.param.getNbQuestions(); a++)
        {
            // choix de l'operateur //
            int choixOperateur = 4;

            while (!this.param.getOperateur()[choixOperateur])
            {
                choixOperateur = (int)Math.random()*5;
            }

            // choix des operande et calcul du resultat//
            do
            {
                for(int z=0; z<=1 ; z++)
                {
                    while (operandes[z]==0)
                    {
                        operandes[z]=(int)Math.random()*this.param.getValMax();
                    }
                }

                if (choixOperateur==2)
                    if(operandes[0]<operandes[1])
                    {
                        int tempo = operandes[0];
                        operandes[0]=operandes[1];
                        operandes[1]=tempo;
                    }

                resultat = calculResultat(operandes[0],operandes[1],choixOperateur);

            }while(resultat>this.param.getValMax() );

            calculEnonce.add("" + operandes[0] + choixOperateur + operandes[1]);
        }
    }


    public Boolean timeOut() {
        return false;
    }

    public Boolean verifierResult() {
        return false;
    }

    public int[] initBornes() {
        return null;
    }

    private int calculResultat (int valA, int valB, int operateur){

        switch (operateur){
            case 0 :
                return valA+valB;

            case 1 :
                return valA-valB;

            case 2 :
                return valA*valB;

            case 3 :
                return valA/valB;  // non utilisé pour le moment //

            default:
                return 0;

        }
    }

    public ArrayList<String> getCalculEnonce() {
        return calculEnonce;
    }

    public ParamEm1 getParam() {
        return param;
    }

    public int getResultat() {
        return resultat;
    }


    public void setCalculEnonce(ArrayList<String> calculEnonce) {
        this.calculEnonce = calculEnonce;
    }

    public void setParam(ParamEm1 param) {
        this.param = param;
    }

    public void setResultat(int resultat) {
        this.resultat = resultat;
    }
}
*/