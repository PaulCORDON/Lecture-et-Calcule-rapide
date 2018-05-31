package com.projet4a.ensim.lecture_et_calcule_rapide.CalculRapide.Activity;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.projet4a.ensim.lecture_et_calcule_rapide.CalculRapide.Model.Exo1Math;
import com.projet4a.ensim.lecture_et_calcule_rapide.CalculRapide.Model.ParamEm1;
import com.projet4a.ensim.lecture_et_calcule_rapide.R;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

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

    /**
     * OnClickListeners permettant d'enregistrer si l'élève a eu bon ou pas, d'arreter le timer et de passer à la question suivante
     */
    private View.OnClickListener OCLBonneReponse = (new View.OnClickListener() {

        @Override
        public void onClick(View view) {
            Log.d("MathExo1Activity", "Dans le on clic");
            reponseDonnee = true;
            reponseJuste[numQuestAct] = true;
            timer.cancel();
            timer.onFinish();
        }
    });
    private View.OnClickListener OCLMauvaiseReponse = (new View.OnClickListener() {

        @Override
        public void onClick(View view) {
            Log.d("MathExo1Activity", "Dans le on clic");
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
        if (exo.getParam().getFrise()) {
            switch (exo.getParam().getNbBornes()) {
                case 3:
                    setContentView(R.layout.activity_math_exo1_3bornes);
                    RepF1 = (Button) findViewById(R.id.BtnRepA);
                    RepF2 = (Button) findViewById(R.id.BtnRepB);
                    RepF3 = (Button) findViewById(R.id.BtnRepC);
                    RepF4 = (Button) findViewById(R.id.BtnRepD);
                    break;
                case 2:
                    setContentView(R.layout.activity_math_exo1_2bornes);
                    RepF1 = (Button) findViewById(R.id.BtnRepA);
                    RepF2 = (Button) findViewById(R.id.BtnRepB);
                    RepF3 = (Button) findViewById(R.id.BtnRepC);
                    break;
                case 1:
                    setContentView(R.layout.activity_math_exo1_1bornes);
                    RepF1 = (Button) findViewById(R.id.BtnRepA);
                    RepF2 = (Button) findViewById(R.id.BtnRepC);
                    break;
            }
        } else {
            switch (exo.getParam().getNbBornes()) {
                case 2:
                    setContentView(R.layout.activity_math_exo1_compris_entre);
                    RepF1 = (Button) findViewById(R.id.BtnRepA);
                    RepF2 = (Button) findViewById(R.id.BtnRepB);
                    RepF3 = (Button) findViewById(R.id.BtnRepC);
                    break;
                case 1:
                    setContentView(R.layout.activity_math_exo1_comparaison);
                    RepF1 = (Button) findViewById(R.id.BtnRepA);
                    RepF2 = (Button) findViewById(R.id.BtnRepC);
                    break;
            }
        }
        /**
         * Récupération du textView pour l'affichage du nombre de questions restantes
         */
        final TextView numQuestion = (TextView) findViewById(R.id.NumQuestion);
        int numQuestActPlusUn = numQuestAct + 1;
        numQuestion.setText("Question " + numQuestActPlusUn + "/" + exo.getParam().getNbQuestions());

        /**
         * Affichage de l'énoncé pour la question actuelle.
         */
        final TextView enonce = (TextView) findViewById(R.id.Enonce);
        enonce.setText(exo.getCalculEnonce().get(numQuestAct).getCalculString());

        /**
         *  Initialisation des bornes avec les valeurs de l'exercice
         */
        switch (exo.getParam().getNbBornes()) //r1 b1 r2 b2 r3 b3 r4
        {
            case 3:
                final TextView Borne3 = (TextView) findViewById(R.id.Borne3);
                Borne3.setText("" + exo.getBornes().get(numQuestAct).get(2));

                if (exo.getResultats()[numQuestAct] > exo.getBornes().get(numQuestAct).get(2))
                    RepF4.setOnClickListener(OCLBonneReponse);
                else RepF4.setOnClickListener(OCLMauvaiseReponse);

                if (exo.getResultats()[numQuestAct] == exo.getBornes().get(numQuestAct).get(2) && exo.getParam().getBorneSelectionnable())
                    Borne3.setOnClickListener(OCLBonneReponse);
                else Borne3.setOnClickListener(OCLMauvaiseReponse);
            case 2:
                final TextView Borne2 = (TextView) findViewById(R.id.Borne2);
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
                final TextView Borne1 = (TextView) findViewById(R.id.Borne1);
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

        final long tempsTotal = exo.getParam().getTempsRep() + exo.getParam().getTempsRestantApparant();
        progress = (ProgressBar) findViewById(R.id.progressBar1);
        progress.setMax((int) tempsTotal);

        /**
         * Définition des actions du timer
         */
        timer = new CountDownTimer(tempsTotal, 500) {
            @Override
            public void onTick(long l) {
                progress.setProgress(((int) tempsTotal) - ((int) l));
            /*
            evolution de la plage de couleur progress bar
             */
                if (progress.getProgress() <= ((int) tempsTotal) / 2) {
                    progress.getProgressDrawable().setColorFilter(
                            Color.GREEN, android.graphics.PorterDuff.Mode.SRC_IN);
                } else if (progress.getProgress() <= ((int) tempsTotal) - 2000) {
                    progress.getProgressDrawable().setColorFilter(
                            Color.YELLOW, android.graphics.PorterDuff.Mode.SRC_IN);
                } else {
                    progress.getProgressDrawable().setColorFilter(
                            Color.RED, android.graphics.PorterDuff.Mode.SRC_IN);
                }
                if (exo.getParam().getDisparition()) {
                    Log.w("ordre apparition", "ordre" + exo.getParam().getOrdreApparition());
                    if (exo.getParam().getOrdreApparition()) {
                        if (l <= exo.getParam().getTempsRep()) {
                            switch (exo.getParam().getNbBornes()) {
                                case 3:
                                    TextView Borne3 = (TextView) findViewById(R.id.Borne3);
                                    Borne3.setVisibility(View.VISIBLE);
                                case 2:
                                    TextView Borne2 = (TextView) findViewById(R.id.Borne2);
                                    Borne2.setVisibility(View.VISIBLE);
                                case 1:
                                    TextView Borne1 = (TextView) findViewById(R.id.Borne1);
                                    Borne1.setVisibility(View.VISIBLE);
                            }
                            enonce.setVisibility(View.INVISIBLE);
                        } else {
                            switch (exo.getParam().getNbBornes()) {
                                case 3:
                                    TextView Borne3 = (TextView) findViewById(R.id.Borne3);
                                    Borne3.setVisibility(View.INVISIBLE);
                                case 2:
                                    TextView Borne2 = (TextView) findViewById(R.id.Borne2);
                                    Borne2.setVisibility(View.INVISIBLE);
                                case 1:
                                    TextView Borne1 = (TextView) findViewById(R.id.Borne1);
                                    Borne1.setVisibility(View.INVISIBLE);
                            }
                        }
                    } else {
                        if (l <= exo.getParam().getTempsRep()) {
                            switch (exo.getParam().getNbBornes()) {
                                case 3:
                                    TextView Borne3 = (TextView) findViewById(R.id.Borne3);
                                    Borne3.setVisibility(View.INVISIBLE);
                                case 2:
                                    TextView Borne2 = (TextView) findViewById(R.id.Borne2);
                                    Borne2.setVisibility(View.INVISIBLE);
                                case 1:
                                    TextView Borne1 = (TextView) findViewById(R.id.Borne1);
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
                    intent.putExtra("exoMath", exo);

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
    public void onBackPressed() {
        Log.d("onBackPressed", "onBackPressed Exo1Math");
        new AlertDialog.Builder(this)
                .setIcon(R.mipmap.bonhommebof)
                .setTitle("Quitter")
                .setMessage("Etes-vous sûr de vouloir quitter l'exercice?")
                .setPositiveButton("Oui", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                        timer.cancel();
                    }
                })
                .setNegativeButton("Non", null)
                .show();
    }
}