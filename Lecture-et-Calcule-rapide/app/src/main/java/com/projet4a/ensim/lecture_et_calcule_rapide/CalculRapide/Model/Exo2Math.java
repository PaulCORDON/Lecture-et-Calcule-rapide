package com.projet4a.ensim.lecture_et_calcule_rapide.CalculRapide.Model;

import android.util.Log;

import java.io.Serializable;
import java.util.ArrayList;

public class Exo2Math implements Serializable {

    /**
     * liste des calculs
     */
    private ArrayList<Calcul> enoncees = new ArrayList<>();

    private ParamEm2 param;

    private int op1;
    private int op2;
    private int choixOp;


    private boolean choixOpVali = true;
    /**
     * si les bornes sont validée alors on passe à false
     */
    private static boolean Nvalide = true;
    private  int a = 0;
    public Exo2Math(ParamEm2 param) {
        this.param = param;

        while (a < this.param.getNbCalcul()){


                Log.w("création operande","opeeeeeeerrrrrrrrrrrandeeeeeeeee");
                op1 = (int) (Math.random() * param.getValMaxOperande());
                op2 = (int) (Math.random() * param.getValMaxOperande());
                op1 = op1+1;
                op2 = op2+1;
                Log.w("création operande","NUm question : " + a + " 1 :" + op1 + "   2 : " + op2);
                if(param.getNombrePair()){
                    if(op1%2 == 0 && op2%2==0){
                        choixOpVali = true;
                        do{
                            choixOp = (int) (Math.random() * 4);
                            if (param.getOperateur()[choixOp]){
                                choixOpVali = false;
                            }
                        }while (choixOpVali);

                        switch (choixOp){
                            case 0:
                                enoncees.add(new Calcul(op1, op2, '+'));
                                break;
                            case 1:
                                enoncees.add(new Calcul(op1, op2, '-'));
                                break;
                            case 2:
                                enoncees.add(new Calcul(op1, op2, '*'));
                                break;
                            case 3 :
                                enoncees.add(new Calcul(op1,op2,'/'));
                                break;


                        }

                        a++;
                    }
                }
                else{
                    choixOpVali = true;
                    do{
                        choixOp = (int) (Math.random() * 5);
                        if (param.getOperateur()[choixOp]){
                            choixOpVali = false;
                        }
                    }while (choixOpVali);

                    switch (choixOp){
                        case 0:
                            enoncees.add(new Calcul(op1, op2, '+'));
                            break;
                        case 1:
                            enoncees.add(new Calcul(op1, op2, '-'));
                            break;
                        case 2:
                            enoncees.add(new Calcul(op1, op2, '*'));
                            break;
                        case 3 :
                            enoncees.add(new Calcul(op1,op2,'/'));
                            break;


                    }

                    a++;
                }


        }
    }

    /**
     * @return la réponse du calcul sous forme de string
     */
    public ArrayList<Calcul> getCalcul() {
        return enoncees;
    }

    /**
     * @return le type de reponse que l'élève doit donner
     */
    public ParamEm2 getParam() {
        return param;
    }
}
