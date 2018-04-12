package com.projet4a.ensim.lecture_et_calcule_rapide.CalculRapide.Activity;

import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
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
public class MathExo1Activity extends AppCompatActivity {
    /**
     * numero de la question actuelle.
     */
    private static int numQuestAct = 0;

    /**
     * tableau des réponses, reponse juste = true dans la case du numero de la question  si il a bien répondue, faux sinon.
     */
    private static boolean[] reponseJuste;

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

    private ProgressBar progress;
    private ImageView img,img1,img2;

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
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        /**
         * Déclaration des variables
         */
        Button RepF1 = null;
        Button RepF2 = null;
        Button RepF3 = null;
        Button RepF4 = null;


        /**
         * Si c'est la premiere fois que l'on charge l'activité, on instancie les parametres de l'exercice
         * ainsi que les questions grâce au constructeur de l'exercie de math,
         * on créé le tableau qui va contenir les reponses aux bonnes dimensions.
         */
        if (numQuestAct == 0) {
            ParamEm1 param = new ParamEm1();
            try {
                FileInputStream fis = openFileInput("ParamEm1.txt");
                ObjectInputStream ois = new ObjectInputStream(fis);
                param = (ParamEm1) ois.readObject();
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
                RepF1 =(Button)findViewById(R.id.BtnRepA);
                RepF2 = (Button)findViewById(R.id.BtnRepB);
                RepF3 = (Button)findViewById(R.id.BtnRepC);
                RepF4 =(Button)findViewById(R.id.BtnRepD);
                break;
            case 2:
                setContentView(R.layout.activity_math_exo1_2bornes);
                RepF1 =(Button) findViewById(R.id.BtnRepA);
                RepF2 = (Button)findViewById(R.id.BtnRepB);
                RepF3 = (Button)findViewById(R.id.BtnRepC);
                break;
            case 1:
                setContentView(R.layout.activity_math_exo1_1bornes);
                RepF1 = (Button)findViewById(R.id.BtnRepA);
                RepF2 = (Button)findViewById(R.id.BtnRepB);
                break;
        }

        /**
         * Affichage de l'énoncé pour la question actuelle.
         */
        final TextView enonce = (TextView)findViewById(R.id.Enonce);
        enonce.setText(exo.getCalculEnonce().get(numQuestAct));

        /**
         *  Initialisation des bornes avec les valeurs de l'exercice
         */
        switch (exo.getParam().getNbBornes()) //r1 b1 r2 b2 r3 b3 r4
        {
            case 3:
                Log.w("case3", "case 3");

                final TextView Borne3 =(TextView) findViewById(R.id.Borne3);
                Borne3.setText("" + exo.getBornes().get(numQuestAct).get(2));

                if (exo.getResultats()[numQuestAct] > exo.getBornes().get(numQuestAct).get(2))
                    RepF4.setOnClickListener(OCLBonneReponse);
                else RepF4.setOnClickListener(OCLMauvaiseReponse);

                if (exo.getResultats()[numQuestAct] == exo.getBornes().get(numQuestAct).get(2) && exo.getParam().getBorneSelectionnable())
                    Borne3.setOnClickListener(OCLBonneReponse);
                else Borne3.setOnClickListener(OCLMauvaiseReponse);

            case 2:
                Log.w("case2", "case 2");

                final TextView Borne2 = (TextView)findViewById(R.id.Borne2);
                Borne2.setText("" + exo.getBornes().get(numQuestAct).get(1));

                if (exo.getParam().getNbBornes() == 2) {
                    if (exo.getResultats()[numQuestAct] > exo.getBornes().get(numQuestAct).get(1))
                        RepF3.setOnClickListener(OCLBonneReponse);
                    else RepF3.setOnClickListener(OCLMauvaiseReponse);
                } else {
                    if (exo.getResultats()[numQuestAct] > exo.getBornes().get(numQuestAct).get(1) && exo.getResultats()[numQuestAct] < exo.getBornes().get(numQuestAct).get(2))
                        RepF3.setOnClickListener(OCLBonneReponse);
                    else RepF3.setOnClickListener(OCLMauvaiseReponse);
                }

                if (exo.getResultats()[numQuestAct] == exo.getBornes().get(numQuestAct).get(1) && exo.getParam().getBorneSelectionnable())
                    Borne2.setOnClickListener(OCLBonneReponse);
                else Borne2.setOnClickListener(OCLMauvaiseReponse);

            case 1:
                Log.w("case1", "case 1");

                final TextView Borne1 = (TextView)findViewById(R.id.Borne1);
                Borne1.setText("" + exo.getBornes().get(numQuestAct).get(0));

                if (exo.getParam().getNbBornes() == 1) {
                    if (exo.getResultats()[numQuestAct] > exo.getBornes().get(numQuestAct).get(0))
                        RepF2.setOnClickListener(OCLBonneReponse);
                    else RepF2.setOnClickListener(OCLMauvaiseReponse);
                } else {
                    if (exo.getResultats()[numQuestAct] > exo.getBornes().get(numQuestAct).get(0) && exo.getResultats()[numQuestAct] < exo.getBornes().get(numQuestAct).get(1))
                        RepF2.setOnClickListener(OCLBonneReponse);
                    else RepF2.setOnClickListener(OCLMauvaiseReponse);
                }


                if (exo.getResultats()[numQuestAct] == exo.getBornes().get(numQuestAct).get(0) && exo.getParam().getBorneSelectionnable())
                    Borne1.setOnClickListener(OCLBonneReponse);
                else Borne1.setOnClickListener(OCLMauvaiseReponse);

                if (exo.getResultats()[numQuestAct] < exo.getBornes().get(numQuestAct).get(0))
                    RepF1.setOnClickListener(OCLBonneReponse);
                else RepF1.setOnClickListener(OCLMauvaiseReponse);

                break;
        }

        /**
         *
         * recuperation du temps total pour la progress bar
         */
        final long tempsTotal = exo.getParam().getTempsRep() + exo.getParam().getTempsRestantApparant();

        /**
         * declaration des variables de la progress bar
         */
        progress = (ProgressBar) findViewById(R.id.progressBar1);
        /**
         * img = findViewById(R.id.imageViewBar);
         img.setImageResource(R.drawable.car);
         img.setVisibility(View.INVISIBLE);
         */

        progress.setMax((int) tempsTotal);
        /**
         * création d'une image animée*
         *
         * final TranslateAnimation transanim  = new TranslateAnimation(TranslateAnimation.RELATIVE_TO_PARENT,-0.5f,
         TranslateAnimation.RELATIVE_TO_PARENT,0.0f,
         TranslateAnimation.RELATIVE_TO_PARENT,0.0f,
         TranslateAnimation.RELATIVE_TO_PARENT,0.0f);

         transanim.setDuration(((int) tempsTotal));
         img.startAnimation(transanim);
         img.setLayoutDirection(View.LAYOUT_DIRECTION_LTR);
         */


        /**
         * Définition des actions du timer
         */
        timer = new CountDownTimer(tempsTotal, 500) {
            @Override
            public void onTick(long l) {
                progress.setProgress(((int) tempsTotal) - ((int) l));
                if(progress.getProgress()<=((int) tempsTotal)/2){
                    progress.getProgressDrawable().setColorFilter(
                            Color.GREEN, android.graphics.PorterDuff.Mode.SRC_IN);
                }else if(progress.getProgress()<=((int) tempsTotal)-2000){
                    progress.getProgressDrawable().setColorFilter(
                            Color.YELLOW, android.graphics.PorterDuff.Mode.SRC_IN);
                }else{
                    progress.getProgressDrawable().setColorFilter(
                            Color.RED, android.graphics.PorterDuff.Mode.SRC_IN);
                }


                if (exo.getParam().getDisparition()) {
                    Log.w("ordre apparition", "ordre" + exo.getParam().getOrdreApparition());
                    if (exo.getParam().getOrdreApparition()) {
                        if (l <= exo.getParam().getTempsRep()) {
                            switch (exo.getParam().getNbBornes()) {
                                case 3:
                                    TextView Borne3 =(TextView) findViewById(R.id.Borne3);
                                    Borne3.setVisibility(View.VISIBLE);
                                case 2:
                                    TextView Borne2 = (TextView)findViewById(R.id.Borne2);
                                    Borne2.setVisibility(View.VISIBLE);
                                case 1:
                                    TextView Borne1 = (TextView)findViewById(R.id.Borne1);
                                    Borne1.setVisibility(View.VISIBLE);
                            }
                            enonce.setVisibility(View.INVISIBLE);
                        } else {
                            switch (exo.getParam().getNbBornes()) {
                                case 3:
                                    TextView Borne3 = (TextView)findViewById(R.id.Borne3);
                                    Borne3.setVisibility(View.INVISIBLE);
                                case 2:
                                    TextView Borne2 =(TextView) findViewById(R.id.Borne2);
                                    Borne2.setVisibility(View.INVISIBLE);
                                case 1:
                                    TextView Borne1 = (TextView)findViewById(R.id.Borne1);
                                    Borne1.setVisibility(View.INVISIBLE);
                            }
                        }
                    } else {
                        if (l <= exo.getParam().getTempsRep()) {
                            switch (exo.getParam().getNbBornes()) {
                                case 3:
                                    TextView Borne3 =(TextView) findViewById(R.id.Borne3);
                                    Borne3.setVisibility(View.INVISIBLE);
                                case 2:
                                    TextView Borne2 = (TextView)findViewById(R.id.Borne2);
                                    Borne2.setVisibility(View.INVISIBLE);
                                case 1:
                                    TextView Borne1 = (TextView)findViewById(R.id.Borne1);
                                    Borne1.setVisibility(View.INVISIBLE);
                            }
                            enonce.setVisibility(View.VISIBLE);
                        } else {
                            enonce.setVisibility(View.INVISIBLE);
                        }
                    }
                }
            }

            @Override
            public void onFinish() {
                if (!reponseDonnee) {
                    reponseJuste[numQuestAct] = false;
                }

                Log.w("Reponse", "Reponse " + numQuestAct + " " + reponseJuste[numQuestAct]);

                numQuestAct++;

                if (numQuestAct == exo.getParam().getNbQuestions()) {
                    numQuestAct = 0;

                    Intent intent = new Intent(MathExo1Activity.this, ExoMath1Resultat.class);
                    intent.putExtra("ReponseDonnee", reponseJuste);

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
                } else {
                    finish();
                    startActivity(getIntent());
                }
            }
        }.start();
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("OnStop","OnStop Exo1Math");
        this.finish();
    }
}