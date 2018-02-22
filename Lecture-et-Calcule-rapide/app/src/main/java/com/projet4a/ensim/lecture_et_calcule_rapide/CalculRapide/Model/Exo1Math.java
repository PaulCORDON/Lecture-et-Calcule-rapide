package com.projet4a.ensim.lecture_et_calcule_rapide.CalculRapide.Model;

import android.content.Context;

import com.projet4a.ensim.lecture_et_calcule_rapide.Exercice;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.ArrayList;


public class Exo1Math extends Exercice implements Serializable
        /**
         * Classe contenant la liste d'énoncé avec la liste des bornes correspondantes
         * Ces listes sont créées en fonction des paramètres de l'exercice
         */
{
    private ArrayList<String> calculEnonce;
    /**
     * Liste des énoncés
     */

    private ArrayList<ArrayList<Integer>> bornes;
    /**
     * Liste des listes de bornes
     */

    private int[] resultats;
    /**
     * Liste des résultats
     */

    private ParamEm1 param;
    /**
     * paramètre selon lesquels les listes sont créées
     */


    public Exo1Math(ParamEm1 param )
    /**
     * constructeur de l'exercice
     * créé les enoncés et les bornes corespondantes
     * @param param paramètres de l'exercice
     */
    {
        //initialisation

        this.param = param;
        calculEnonce = new ArrayList<String>(this.param.getNbQuestions());
        bornes = new ArrayList<ArrayList<Integer>>(this.param.getNbQuestions());
        resultats = new int[param.getNbQuestions()];

        //variables
        int operandes[] = new int[2];

        //pour chaque question
        for (int a=0; a < this.param.getNbQuestions(); a++)
        {
            // choix de l'operateur
            int choixOperateur = 4;

            //tant que l'opérateur ne correspond pas aux paramètres
            while (!this.param.getOperateur()[choixOperateur])
            {
                //on attribue un operateur
                choixOperateur = (int)(Math.random()*5);
            }

            //faire... , choix des operandes et calcul du resultat
            do
            {
                //initialisation
                operandes[0] = 0;
                operandes[1] = 0;

                //pour chaque operande
                for(int z=0; z<=1 ; z++)
                {
                    //tant qu'il est null
                    while (operandes[z]==0)
                    {
                        //on génère un entier correspondant aux paramètres
                        operandes[z]=(int)(Math.random()*this.param.getValMax());
                        if(param.getPairOnly() && operandes[z]%2!=0) operandes[z]=0;
                    }
                }

                //si on est dans le cas d'une soustraction
                if (choixOperateur==2)
                    //on ordonne les opérandes pour que le résultat ne soit pas négatif
                    if(operandes[0]<operandes[1])
                    {
                        int tempo = operandes[0];
                        operandes[0]=operandes[1];
                        operandes[1]=tempo;
                    }

                //on calcul le résultat
                resultats[a] = calculResultat(operandes[0],operandes[1],choixOperateur);

            //...tant que, résultat ne correspond pas aux paramètres
            }while(resultats[a]>this.param.getValMax() );

            //on construit l'énoncé selon l'opérateur puis on l'ajoute à la liste
            switch (choixOperateur)
            {
                case 0 :
                    calculEnonce.add("" + operandes[0] + " + " + operandes[1]);
                    break;
                case 1 :
                    if(operandes[0]<operandes[1]){
                        int swap = operandes[0];
                        operandes[0] = operandes[1];
                        operandes[1] = swap;
                    }
                    calculEnonce.add("" + operandes[0] + " - " + operandes[1]);
                    break;
                case 2 :
                    calculEnonce.add("" + operandes[0] + " x " + operandes[1]);
                    break;
                case 3 :
                    int swap = resultats[a];
                    resultats[a] = operandes[0];
                    operandes[0] = swap;
                    calculEnonce.add("" + operandes[0] + " / " + operandes[1]);
                    break;
                default:
                    break;
            }

            //initialisation des bornes
            ArrayList<Integer> bornestempo = new ArrayList<Integer>(param.getNbBornes());

            //pour chaque borne
            for(int i = 0 ; i<param.getNbBornes() ; i++)
            {
                //on génère un entier correspondant aux paramètres
                int borne;
                boolean correct;
                do {
                    correct=true;
                    borne = (int)(Math.random()*param.getValMax());
                    if((!param.getBorneSelectionnable() && borne==resultats[a]) || borne==0) correct = false;
                    for (int test:bornestempo) {
                        if(borne==test) correct = false;
                    }
                }while (!correct);
                bornestempo.add(borne);
            }

            boolean trie = false;
            //tant que la liste n'est pas triée
            while(!trie)
            {
                //on pars du principe qu'elle est triée si il n'y a pas de changements
                trie=true;

                //on parcours la liste d'entier
                for (int i = 0 ; i<bornestempo.size()-1 ; i++)
                {
                    Integer swap;

                    //si il ne sont pas dans l'ordre on les interchange
                    if(bornestempo.get(i)>bornestempo.get(i+1))
                    {
                        swap=bornestempo.get(i);
                        bornestempo.set(i,bornestempo.get(i+1));
                        bornestempo.set(i+1,swap);

                        //on a fait un changement, il faut revérifier le début
                        trie=false;
                    }
                }
            }

            //si le paramètre indique qu'une borne doit être égale à +/- 1 à un opérande
            if(param.getBorneEqualsOp())
            {
                int min=param.getValMax();
                int numborne=0;
                int numope=0;

                //on cherche la borne la plus proche de la valeur d'un opérande
                for (int b : bornestempo)
                {
                    if(Math.abs(b-operandes[0])<min)
                    {
                        min=Math.abs(b-operandes[0]);
                        numborne=bornestempo.indexOf(b);
                        numope=0;
                    }
                    if(Math.abs(b-operandes[1])<min)
                    {
                        min=Math.abs(b-operandes[1]);
                        numborne=bornestempo.indexOf(b);
                        numope=1;
                    }
                }

                //TODO paramètre distance entre borne et opérande
                //on modifie la borne afin qu'elle corresponde aux paramètres
                int bt;
                do
                {
                    bt=operandes[numope] + (int) (Math.random() * 3) - 1;
                }while((bt==resultats[a] && param.getBorneSelectionnable())||bt==0);

                bornestempo.set(numborne,bt);
            }

            //on ajoute les bornes à la liste
            bornes.add(bornestempo);
        }
    }

    /**
     * calcul le resultat de l'opération "valA operateur valB" et retourne le resultat
     * @param valA
     * @param valB
     * @param operateur
     * @return resultat
     */
    private int calculResultat (int valA, int valB, int operateur)
    {
        switch (operateur)
        {
            case 0 :
                return valA+valB;

            case 1 :
                return valA-valB;

            case 2 :
                return valA*valB;

            case 3 :
                return valA*valB;

            default:
                return 0;
        }
    }

    /**
     * @return calculEnonce
     */
    public ArrayList<String> getCalculEnonce() {
        return calculEnonce;
    }

    /**
     * @return param
     */
    public ParamEm1 getParam() {
        return param;
    }

    /**
     * @return bornes
     */
    public ArrayList<ArrayList<Integer>> getBornes() {return bornes;}

    /**
     * @return resultats
     */
    public int[] getResultats() {return resultats;}
}
