package com.projet4a.ensim.lecture_et_calcule_rapide.CalculRapide.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


import com.projet4a.ensim.lecture_et_calcule_rapide.CalculRapide.Model.Exo1Math;
import com.projet4a.ensim.lecture_et_calcule_rapide.Menu.MenuActivity;
import com.projet4a.ensim.lecture_et_calcule_rapide.R;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;


public class ExoMath1Resultat extends AppCompatActivity {

    /**
     * tableau des reponses de l'élève
     */
    private static boolean[] reponseJuste;

    /**
     * nombre de bonne reponse de l'élève
     */
    private int bonneRep;

    /**
     * numero de la question qui est actuellement affiché à l'ecran
     */
    private int numQuestCorr = -1;


    private Exo1Math exoMath = null;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exo_math1_resultat);
        Intent intent = getIntent();

        // on récupere le tableau contenant les réponses données par l'élève :
        reponseJuste = intent.getBooleanArrayExtra("ReponseDonnee");


        //on récupere l'exercice :

        try {
            FileInputStream fis = openFileInput("ExoM1.txt");
            ObjectInputStream ois = new ObjectInputStream(fis);
            exoMath = (Exo1Math) ois.readObject();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }



        //  lien avec le vue

        final TextView nbRep = (TextView) findViewById(R.id.score);
        final TextView nbQuest = (TextView) findViewById(R.id.nbQuestion);
        final Button acceuil = (Button) findViewById(R.id.Acceuil);
        final TextView numQuCorrig = (TextView) findViewById(R.id.calcul);
        final TextView reponse = (TextView) findViewById(R.id.reponse);
        final Button nextQuest = (Button) findViewById(R.id.nextQuest);
        final TextView score = (TextView) findViewById(R.id.Score);
        final TextView slash = (TextView) findViewById(R.id.slash);

        acceuil.setText("Acceuil");
        nextQuest.setText("Voir la correction");

        // calcul du score de l'élève :
        for(boolean b : reponseJuste){
            if(b){

                bonneRep++;
            }
        }

        nbRep.setText(""+bonneRep);
        nbQuest.setText(""+reponseJuste.length);


          //Affichage de la correction pour chaque question jusqu'a ce que l'on appuie sur correction suivante

            nextQuest.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(numQuestCorr == -1 ){
                        numQuestCorr ++;
                        if(reponseJuste[0]){
                            score.setText("VRAI");
                            reponse.setVisibility(View.INVISIBLE);
                        }else{
                            score.setText("FAUX");
                            reponse.setVisibility(View.VISIBLE);
                            reponse.setText(correction(exoMath.getBornes().get(0), exoMath.getResultats()[0]));
                        }
                        acceuil.setVisibility(View.INVISIBLE);
                        nextQuest.setText("Correction suivante");
                        slash.setText("Question "+ (numQuestCorr) + " : ");
                        numQuCorrig.setText(exoMath.getCalculEnonce().get(0) + " = " + exoMath.getResultats()[0]);

                    }

                    if (numQuestCorr > -1 && numQuestCorr < reponseJuste.length +1) {
                        numQuestCorr ++;
                        if(reponseJuste[numQuestCorr-1]){
                            score.setText("VRAI");
                            reponse.setVisibility(View.INVISIBLE);
                        }else{
                            score.setText("FAUX");
                            reponse.setVisibility(View.VISIBLE);
                            reponse.setText(correction(exoMath.getBornes().get(numQuestCorr-1), exoMath.getResultats()[numQuestCorr-1]));
                        }
                        slash.setText("Question "+ (numQuestCorr) + " : ");
                        numQuCorrig.setText(exoMath.getCalculEnonce().get(numQuestCorr-1)+ " = " + exoMath.getResultats()[numQuestCorr-1]);

                    }

                    if(numQuestCorr == reponseJuste.length){
                        score.setText("Ton score");
                        nextQuest.setText("Acceuil");
                        nextQuest.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Intent intent2 = new Intent( ExoMath1Resultat.this ,MenuActivity.class);
                                startActivity(intent2);

                            }

                        });
                    }

                }

            });


         // bouton pour revenir à l'ecran d'acceuil visible uniquement avant l'affichage de la correction et apres ( pas pendant que les correction sont affichées).

        if(numQuestCorr == -1 || numQuestCorr == reponseJuste.length+1 ){
            acceuil.setVisibility(View.VISIBLE);
            acceuil.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent2 = new Intent( ExoMath1Resultat.this ,MenuActivity.class);
                    startActivity(intent2);
                }
            });
        }

    }

    private String correction(ArrayList<Integer> bornes, int resultat){

            if(bornes.size() == 1){
                if(resultat< bornes.get(0)){
                    return " _ " +resultat + " _ < _ " + bornes.get(0) + " _ ";
                }
                else{
                    return " _ " +bornes.get(0) + " _ < _ " + resultat + " _ ";
                }
            }


            if(bornes.size() == 2){
                if(resultat < bornes.get(0)){
                    return " _ " +resultat + " < " + bornes.get(0) + " < " + bornes.get(1) + " _";
                }
                if(resultat > bornes.get(1)){
                    return " _ " +bornes.get(0) + " < " + bornes.get(1) + " < " + resultat + " _";
                }
                return "_ " + bornes.get(0) + " < " + resultat + " < " + bornes.get(1) + " _";
            }
            if(bornes.size() == 3){
                if(resultat < bornes.get(0)){
                    return resultat + " < " + bornes.get(0) + " < " + bornes.get(1) + " < " + bornes.get(2);
                }
                if(resultat > bornes.get(2)){
                    return   bornes.get(0) + " < " + bornes.get(1) + " < " + bornes.get(2) + " < " + resultat;
                }
                if(resultat< bornes.get(1)){
                    return bornes.get(0) + " < " + resultat + " < " + bornes.get(1) + " < " + bornes.get(2);
                }
                else{
                    return  bornes.get(0) + " < " + bornes.get(1) + " < " + resultat + " < " + bornes.get(2);
                }
            }



        return "" + bornes.size();
    }


}
