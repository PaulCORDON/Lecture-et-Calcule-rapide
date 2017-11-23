package com.projet4a.ensim.lecture_et_calcule_rapide.CalculRapide.Model;

import com.projet4a.ensim.lecture_et_calcule_rapide.CalculRapide.Model.ParamEm1;
import com.projet4a.ensim.lecture_et_calcule_rapide.Exercice;

import java.util.ArrayList;
import java.util.Comparator;

/**
 * Created by Cordon Paul on 07/11/2017.
 */

public class Exo1Math extends Exercice {

    private ArrayList<String> calculEnonce;

    private ArrayList<ArrayList<Integer>> bornes;

    private ParamEm1 param;

    private int resultat;




    public Exo1Math(ParamEm1 param )
    {
        this.param = param;
        calculEnonce = new ArrayList<String>(this.param.getNbQuestions());
        bornes = new ArrayList<ArrayList<Integer>>(this.param.getNbQuestions());

        int operandes[] = new int[2];

        for (int a=0; a <= this.param.getNbQuestions(); a++)
        {
            // choix de l'operateur //
            int choixOperateur = 4;

            while (!this.param.getOperateur()[choixOperateur])
            {
                choixOperateur = (int)(Math.random()*5);
            }

            // choix des operande et calcul du resultat//
            do
            {
                operandes[0] = 0;
                operandes[1] = 0;

                for(int z=0; z<=1 ; z++)
                {
                    while (operandes[z]==0)
                    {
                        operandes[z]=(int)(Math.random()*this.param.getValMax());
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

            switch (choixOperateur)
            {
                case 0 :
                    calculEnonce.add("" + operandes[0] + " + " + operandes[1]);
                    break;
                case 1 :
                    calculEnonce.add("" + operandes[0] + " - " + operandes[1]);
                    break;
                case 2 :
                    calculEnonce.add("" + operandes[0] + " x " + operandes[1]);
                    break;
                case 3 :
                    calculEnonce.add("" + operandes[0] + " / " + operandes[1]);
                    break;
                default:
                    break;
            }

            //initialisation des bornes

            ArrayList<Integer> bornestempo = new ArrayList<>(param.getNbBornes());

            if(param.getBorneEqualsOp())
            {
                //TODO ajout creation borne quand egale
            }
            else
            {
                for(int i = 0 ; i<param.getNbBornes() ; i++)
                {
                    bornestempo.add((int)(Math.random()*param.getValMax()));
                }
                //TODO ajout methode sort()
                //bornestempo.sort(Comparator.<Integer>naturalOrder());
            }

            bornes.add(bornestempo);
        }
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

    public ArrayList<int[]> getBornes() {return bornes;}


    public void setCalculEnonce(ArrayList<String> calculEnonce){this.calculEnonce = calculEnonce;}

    public void setParam(ParamEm1 param) {
        this.param = param;
    }

    public void setResultat(int resultat) {
        this.resultat = resultat;
    }

    public void setBornes(ArrayList<int[]> bornes) {this.bornes = bornes;}
}
