package com.projet4a.ensim.lecture_et_calcule_rapide.CalculRapide.Activity;

import android.content.Context;
import android.content.Intent;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.projet4a.ensim.lecture_et_calcule_rapide.CalculRapide.Model.Exo1Math;
import com.projet4a.ensim.lecture_et_calcule_rapide.CalculRapide.Model.ParamEm1;
import com.projet4a.ensim.lecture_et_calcule_rapide.Menu.MenuActivity;
import com.projet4a.ensim.lecture_et_calcule_rapide.R;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import static java.lang.System.currentTimeMillis;

/**
 * Activité gérant l'exercice 1 de maths, un calcul apparait ainsi qu'une frise avec des bornes, l'élève doit séléctionner le bon intervalle dans
 * lequel se situ la réponse du calcul.
 */
public class MathExo1Activity extends AppCompatActivity
{
    /**
     * numero de la question actuelle.
     */
    private static int numQuestAct = 0;

    /**
     * tableau des réponses, reponse juste = true dans la case du numero de la question  si il a bien répondue, faux sinon.
     */
    private static boolean[] reponseJuste ;

    /**
     * Exercice de Maths
     */
    private static Exo1Math exo;

    /**
     * une réponse a-t-elle été donnée ?
     */
    private boolean reponseDonnee = false;

    /**
     * timer
     */
    private CountDownTimer timer;

    /**
     * OnClickListeners permettant d'enregistrer si l'élève a eu bon ou pas, d'arreter le timer et de passer à la question suivante
     */
    private View.OnClickListener OCLBonneReponse = (new View.OnClickListener() {

        @Override
        public void onClick(View view) {
            reponseDonnee = true;
            reponseJuste[numQuestAct] = true;
            timer.cancel();
            timer.onFinish();
        }
    });
    private View.OnClickListener OCLMauvaiseReponse = (new View.OnClickListener() {

        @Override
        public void onClick(View view) {
            reponseDonnee = true;
            reponseJuste[numQuestAct] = false;
            timer.cancel();
            timer.onFinish();
        }
    });


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        /**
         * Déclaration des variables
         */
        Button BonneRep = null;
        Button RepF1 = null;
        Button RepF2 = null;
        Button RepF3 = null;


        /**
         * Si c'est la premiere fois que l'on charge l'activité, on instancie les parametres de l'exercice
         * ainsi que les questions grâce au constructeur de l'exercie de math,
         * on créé le tableau qui va contenir les reponses aux bonnes dimensions.
         */
        if(numQuestAct==0)
        {
            ParamEm1 param = new ParamEm1();
            try {
                FileInputStream fis = openFileInput("ParamEm1.txt");
                ObjectInputStream ois = new ObjectInputStream(fis);
                param = (ParamEm1)ois.readObject();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            exo = new Exo1Math(param);
            reponseJuste = new boolean[param.getNbQuestions()];
        }
        Log.w("resultat", "resultat = " + exo.getResultats()[numQuestAct]);

        /**
         * On déclare la vue correspondant aux paramètres de l'exercice
         */
        switch (exo.getParam().getNbBornes()) {
            case 3:
                setContentView(R.layout.activity_math_exo1_3bornes);
                break;
            case 2 :
                setContentView(R.layout.activity_math_exo1_2bornes);
                break;
            case 1:
                setContentView(R.layout.activity_math_exo1_1bornes);
                break;
        }

        /**
         * Affichage de l'énoncé pour la question actuelle.
         */
        final TextView enonce = findViewById(R.id.Enonce);
        enonce.setText(exo.getCalculEnonce().get(numQuestAct));

        /**
         *  Initialisation des bornes avec les valeurs de l'exercice
         */
        switch (exo.getParam().getNbBornes())
        {
            case 3:
                Log.w("case3", "case 3");

                final TextView Borne3 = findViewById(R.id.Borne3);
                Borne3.setText(""+exo.getBornes().get(numQuestAct).get(2));

                if (exo.getResultats()[numQuestAct] > exo.getBornes().get(numQuestAct).get(0)){

                    if (exo.getResultats()[numQuestAct] > exo.getBornes().get(numQuestAct).get(1)){

                        if(exo.getResultats()[numQuestAct]>exo.getBornes().get(numQuestAct).get(2)){
                            BonneRep = findViewById(R.id.BtnRepD);
                            RepF1 = findViewById(R.id.BtnRepA);
                            RepF2 = findViewById(R.id.BtnRepB);
                            RepF3 = findViewById(R.id.BtnRepC);
                        }
                        else {
                            BonneRep = findViewById(R.id.BtnRepC);
                            RepF1 = findViewById(R.id.BtnRepA);
                            RepF2 = findViewById(R.id.BtnRepB);
                            RepF3 = findViewById(R.id.BtnRepD);
                        }
                    }
                    else {
                        BonneRep = findViewById(R.id.BtnRepB);
                        RepF1 = findViewById(R.id.BtnRepA);
                        RepF2 = findViewById((R.id.BtnRepC));
                        RepF3 = findViewById((R.id.BtnRepD));
                    }
                }
                else {
                    BonneRep = findViewById(R.id.BtnRepA);
                    RepF1 = findViewById(R.id.BtnRepB);
                    RepF2 = findViewById((R.id.BtnRepC));
                    RepF3 = findViewById((R.id.BtnRepD));
                }

            case 2:
                Log.w("case2", "case 2");

                final TextView Borne2 = findViewById(R.id.Borne2);
                Borne2.setText(""+exo.getBornes().get(numQuestAct).get(1));

                if(BonneRep==null) {
                    if (exo.getResultats()[numQuestAct] > exo.getBornes().get(numQuestAct).get(0)) {

                        if (exo.getResultats()[numQuestAct] > exo.getBornes().get(numQuestAct).get(1)) {
                            BonneRep = findViewById(R.id.BtnRepC);
                            RepF1 = findViewById(R.id.BtnRepA);
                            RepF2 = findViewById(R.id.BtnRepB);
                        } else {
                            BonneRep = findViewById(R.id.BtnRepB);
                            RepF1 = findViewById(R.id.BtnRepA);
                            RepF2 = findViewById((R.id.BtnRepC));
                        }

                    } else {
                        BonneRep = findViewById(R.id.BtnRepA);
                        RepF1 = findViewById(R.id.BtnRepB);
                        RepF2 = findViewById((R.id.BtnRepC));
                    }
                }

            case 1:
                Log.w("case1", "case 1");

                final TextView Borne1 = findViewById(R.id.Borne1);
                Borne1.setText(""+exo.getBornes().get(numQuestAct).get(0));
                if(BonneRep==null) {
                    if (exo.getResultats()[numQuestAct] > exo.getBornes().get(numQuestAct).get(0)) {
                        BonneRep = findViewById(R.id.BtnRepB);
                        RepF1 = findViewById(R.id.BtnRepA);
                    } else {
                        BonneRep = findViewById(R.id.BtnRepA);
                        RepF1 = findViewById(R.id.BtnRepB);
                    }
                }
                break;
        }

        /**
         * Définition des actions du timer
         */
        timer = new CountDownTimer(exo.getParam().getTempsRep()+exo.getParam().getTempsRestantApparant(),500)
        {
            @Override
            public void onTick(long l) {
                if(exo.getParam().getDisparition()){
                    if(exo.getParam().getOrdreApparition()){

                    }
                }

            }

            @Override
            public void onFinish()
            {
                if(!reponseDonnee)
                {
                    reponseJuste[numQuestAct] = false;
                }

                Log.w("Reponse","Reponse " + numQuestAct + " " + reponseJuste[numQuestAct]);

                numQuestAct++;

                if(numQuestAct==exo.getParam().getNbQuestions())
                {
                    numQuestAct = 0;

                    Intent intent = new Intent(MathExo1Activity.this, ExoMath1Resultat.class);
                    intent.putExtra("ReponseDonnee",reponseJuste);

                    FileOutputStream outputStream;
                    ObjectOutputStream oos;
                    try {
                        outputStream = openFileOutput("ExoM1.txt", Context.MODE_PRIVATE);
                        oos = new ObjectOutputStream(outputStream);
                        oos.writeObject(exo);

                        oos.flush();
                        oos.close();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                    finish();
                    startActivity(intent);
                }
                else
                {
                    finish();
                    startActivity(getIntent());
                }
            }
        }.start();


        /**
         *  Initialisation des OnClickListener des boutons
         */
        switch (exo.getParam().getNbBornes())
        {
            case 3:
                RepF3.setOnClickListener(OCLMauvaiseReponse);

            case 2 :
                RepF2.setOnClickListener(OCLMauvaiseReponse);

            case 1 :
                BonneRep.setOnClickListener(OCLBonneReponse);
                RepF1.setOnClickListener(OCLMauvaiseReponse);
                break;
        }
    }
}