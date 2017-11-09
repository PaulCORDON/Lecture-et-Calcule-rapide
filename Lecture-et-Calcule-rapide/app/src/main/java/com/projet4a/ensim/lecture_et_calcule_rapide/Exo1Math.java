package com.projet4a.ensim.lecture_et_calcule_rapide;

/**
 * Created by Cordon Paul on 07/11/2017.
 */

public class Exo1Math extends Exercice {
    public int calculEnonce;

    public ParamEm1 param ;

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

}
