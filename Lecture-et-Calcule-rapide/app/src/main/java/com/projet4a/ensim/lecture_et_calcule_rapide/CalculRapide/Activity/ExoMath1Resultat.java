package com.projet4a.ensim.lecture_et_calcule_rapide.CalculRapide.Activity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.projet4a.ensim.lecture_et_calcule_rapide.CalculRapide.Model.Exo1Math;
import com.projet4a.ensim.lecture_et_calcule_rapide.CalculRapide.Model.Exo2Math;
import com.projet4a.ensim.lecture_et_calcule_rapide.EnvoiResultat.GenerateQRCodeActivity;
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

    /**
     * le type d'exercice de math que l'on a fait avant
     */
    private int type = 0;

    /**
     * les exercices que l'on a fait avant que l'on va récuperer selon le type
     */
    private Exo1Math exoMath = null;
    private Exo2Math exo2Math = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exo_math1_resultat);
        Intent intent = getIntent();

        // on récupere le tableau contenant les réponses données par l'élève :
        reponseJuste = intent.getBooleanArrayExtra("ReponseDonnee");
        type = intent.getIntExtra("TypeExo",1);

Log.w("passage activités :","valeur de type ::::::::::::::::::::::::::::::::::::: " + type);
        //on récupere l'exercice avec la bonne instance :
switch(type){
    case 1 :
        try {
            FileInputStream fis = openFileInput("ExoM1.txt");
            ObjectInputStream ois = new ObjectInputStream(fis);
            exoMath = (Exo1Math) ois.readObject();
            Log.w("récupération ","On récupere bien les valeurs de exo1Math " + type);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        break;

    case 2:
        try {
            FileInputStream fis = openFileInput("ExoM2.txt");
            ObjectInputStream ois = new ObjectInputStream(fis);
            exo2Math = (Exo2Math) ois.readObject();
            Log.w("récupération ","On récupere bien les valeurs de exo2Math  " + type);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        break;

}
        Log.w("récupération ","On a passé la récupération !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! " + type);


        //  lien avec le vue
        final TextView nbRep = (TextView) findViewById(R.id.score);
        final TextView nbQuest = (TextView) findViewById(R.id.nbQuestion);
        final Button accueil = (Button) findViewById(R.id.Acceuil);
        final TextView numQuCorrig = (TextView) findViewById(R.id.calcul);
        final TextView reponse1 = (TextView) findViewById(R.id.reponse1);
        final TextView reponse2 = (TextView) findViewById(R.id.reponse2);
        final TextView reponse3 = (TextView) findViewById(R.id.reponse3);
        final Button nextQuest = (Button) findViewById(R.id.nextQuest);
        final Button btnqrcode = (Button) findViewById(R.id.BtnQRCode);
        final TextView score = (TextView) findViewById(R.id.Score);
        final TextView slash = (TextView) findViewById(R.id.slash);


        btnqrcode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ExoMath1Resultat.this, GenerateQRCodeActivity.class);
                intent.putExtra("exo","Mathematiques exercice 1");
                intent.putExtra("bonneRep",bonneRep);
                intent.putExtra("nbRep",reponseJuste.length);
                startActivity(intent);
            }
        });


        acceuil.setText("Acceuil");
        nextQuest.setText("Voir la correction");

        // La réponse est affichée en vert pour plus de visiblité
        reponse2.setTextColor(Color.GREEN);

        // calcul du score de l'élève :
        for (boolean b : reponseJuste) {
            if (b) {
                Log.w("correction","juste");
                bonneRep++;
            }
        }
        nbRep.setText("" + bonneRep);
        nbQuest.setText("" + reponseJuste.length);

        //Affichage de la correction pour chaque question jusqu'a ce que l'on appuie sur correction suivante
        nextQuest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (numQuestCorr == -1) {
                    numQuestCorr++;
                    if (reponseJuste[0]) {
                        score.setText("VRAI");
                        reponse2.setVisibility(View.INVISIBLE);
                        reponse1.setVisibility(View.INVISIBLE);
                        reponse3.setVisibility(View.INVISIBLE);
                    } else {
                        score.setText("FAUX");
                        reponse2.setVisibility(View.VISIBLE);
                        switch (type){
                            case 2:
                                reponse1.setText(""+exo2Math.getCalcul().get(0).ToString());
                                Log.w("calcul.toString() :","voilà ce que l'on a : " + exo2Math.getCalcul().get(0).ToString());

                                break;
                            default:
                                reponse1.setText(correction(exoMath.getBornes().get(0), exoMath.getResultats()[0]).get(0));
                                break;

                        }

                    }
                    accueil.setVisibility(View.INVISIBLE);
                    nextQuest.setText("Correction suivante");
                    slash.setText("Question " + (numQuestCorr) + " : ");
                    switch (type){
                        case 2:
                           numQuCorrig.setText( "" + exo2Math.getCalcul().get(0).ToString());
                            Log.w("calcul.toString() :","voilà ce que l'on a : " + exo2Math.getCalcul().get(0).toString());

                            break;
                        default:
                            numQuCorrig.setText(exoMath.getCalculEnonce().get(0) + " = " + exoMath.getResultats()[0]);
                            break;

                    }

                }
                if (numQuestCorr > -1 && numQuestCorr < reponseJuste.length + 1) {
                    numQuestCorr++;
                    if (reponseJuste[numQuestCorr - 1]) {
                        score.setText("VRAI");
                        reponse2.setVisibility(View.INVISIBLE);
                        reponse1.setVisibility(View.INVISIBLE);
                        reponse3.setVisibility(View.INVISIBLE);
                    } else {
                        score.setText("FAUX");
                        reponse2.setVisibility(View.VISIBLE);

                        switch (type){
                            case 2:
                               reponse1.setText("" + exo2Math.getCalcul().get(numQuestCorr - 1).ToString());
                                Log.w("calcul.toString() :","voilà ce que l'on a : " + exo2Math.getCalcul().get(numQuestCorr - 1).toString());

                                break;
                            default:
                                reponse2.setText(correction(exoMath.getBornes().get(numQuestCorr - 1), exoMath.getResultats()[numQuestCorr - 1]).get(0));
                                reponse1.setVisibility(View.VISIBLE);
                                reponse1.setText(correction(exoMath.getBornes().get(numQuestCorr - 1), exoMath.getResultats()[numQuestCorr - 1]).get(1));
                                reponse3.setVisibility(View.VISIBLE);
                                reponse3.setText(correction(exoMath.getBornes().get(numQuestCorr - 1), exoMath.getResultats()[numQuestCorr - 1]).get(2));
                                break;

                        }

                    }
                    slash.setText("Question " + (numQuestCorr) + " : ");

                    switch (type){
                        case 2:
                            numQuCorrig.setText("" + exo2Math.getCalcul().get(numQuestCorr - 1).toString());
                            Log.w("calcul.toString() :","voilà ce que l'on a : " + exo2Math.getCalcul().get(numQuestCorr - 1).toString());
                            break;
                        default:
                            numQuCorrig.setText(exoMath.getCalculEnonce().get(numQuestCorr - 1) + " = " + exoMath.getResultats()[numQuestCorr - 1]);
                            break;

                    }


                }
                if (numQuestCorr == reponseJuste.length) {
                    score.setText("Ton score");
                    nextQuest.setText("Acceuil");
                    nextQuest.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent2 = new Intent(ExoMath1Resultat.this, MenuActivity.class);
                            startActivity(intent2);
                        }
                    });
                }
            }
        });

        // bouton pour revenir à l'ecran d'accueil visible uniquement avant l'affichage de la correction et apres ( pas pendant que les correction sont affichées).
        if (numQuestCorr == -1 || numQuestCorr == reponseJuste.length + 1) {
            accueil.setVisibility(View.VISIBLE);
            accueil.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent2 = new Intent(ExoMath1Resultat.this, MenuActivity.class);
                    startActivity(intent2);
                }
            });
        }
    }

    // on renvoi une array list de String, la premiere valeurs correspond à la réponse,
    // la deuxieme à l'expression de gauche, la derniere à la droite de l'expression.
    private ArrayList<String> correction(ArrayList<Integer> bornes, int resultat) {

        ArrayList<String> rep = new ArrayList<>();

        if (bornes.size() == 1) {
            if (resultat < bornes.get(0)) {
                rep.add("" + resultat);
                rep.add("");
                rep.add(" _ < _ " + bornes.get(0));
                return rep;
            } else {
                rep.add("" + resultat);
                rep.add(" _ " + bornes.get(0) + " _ < _ ");
                rep.add("");
                return rep;
            }
        }
        if (bornes.size() == 2) {
            if (resultat < bornes.get(0)) {
                rep.add("" + resultat);
                rep.add("");
                rep.add(" < " + bornes.get(0) + " < " + bornes.get(1));

                return rep;
            }
            if (resultat > bornes.get(1)) {
                rep.add("" + resultat);
                rep.add(" _ " + bornes.get(0) + " < " + bornes.get(1) + " < ");
                rep.add("");
                return rep;
            }
            rep.add("" + resultat);
            rep.add("_ " + bornes.get(0) + " < ");
            rep.add(" < " + bornes.get(1));
            return rep;
        }
        if (bornes.size() == 3) {
            if (resultat < bornes.get(0)) {
                rep.add("" + resultat);
                rep.add("");
                rep.add(" < " + bornes.get(0) + " < " + bornes.get(1) + " < " + bornes.get(2));
                return rep;
            }
            if (resultat > bornes.get(2)) {
                rep.add("" + resultat);
                rep.add(bornes.get(0) + " < " + bornes.get(1) + " < " + bornes.get(2) + " < ");
                rep.add("");
                return rep;
            }
            if (resultat < bornes.get(1)) {
                rep.add("" + resultat);
                rep.add("" + bornes.get(0) + " < ");
                rep.add(" < " + bornes.get(1) + " < " + bornes.get(2));
                return rep;
            } else {
                rep.add("" + resultat);
                rep.add(bornes.get(0) + " < " + bornes.get(1) + " < ");
                rep.add(" < " + bornes.get(2));
                return rep;
            }
        }
        return null;
    }
}
