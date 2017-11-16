package com.projet4a.ensim.lecture_et_calcule_rapide;

import java.util.ArrayList;

/**
 * Created by Cordon Paul on 07/11/2017.
 */

public class Exo1Math extends Exercice {

   public ArrayList<String> calculEnonce;

    public ParamEm1 param;

    public int resultat;


    public Exo1Math(ParamEm1 param ){
        this.param = param;
        calculEnonce = new ArrayList(this.param.nbQuestions);

        int operandes[] = new int[2];
            operandes[0] = 0;
            operandes[1] = 0;

        for (int a=0; a <= this.param.nbQuestions; a++){
            // choix de l'operateur //
            int choixOperateur = 4;
            while (this.param.operateur[choixOperateur]){
                choixOperateur = (int)Math.random()*5;
            }


            // choix des operande //

            int alea1, alea2;
            do{

                for(int z=0; z<=1 ; z++){
                    resultat = calculResultat(operandes[0],operandes[1],choixOperateur);
                    while ( operandes[0] == 0 &&  operandes[1] == 0 && resultat<0 && resultat>this.param.valMax ){
                        alea1=(int)Math.random()*this.param.valMax;
                        alea2=(int)Math.random()*this.param.valMax;
                    }
                }

            }while();
            // calcul du resultat //



        }


    }

    public String generateCalcul(){
        return null;

    }

    public String  generateBornes (){

        for(int i = 0; i<param.nbBornes;i++){

            param.bornes[i] = (int) (Math.random()*(20-10));

        }
        String res = param.bornes[0]+ "\t";
        return res;


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
                break;
            case 1 :
                return valA-valB;
                break;
            case 2 :
                return valA*valB;
                break;
            case 3 :
                return valA/valB;  // non utilisé pour le moment //
                break;
        }
    }

    private int

}
