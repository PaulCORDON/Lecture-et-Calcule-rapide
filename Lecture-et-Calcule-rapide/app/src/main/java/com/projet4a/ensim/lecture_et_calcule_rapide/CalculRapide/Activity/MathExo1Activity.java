package com.projet4a.ensim.lecture_et_calcule_rapide.CalculRapide.Activity;

//TODO lire un fichier XAML ou autre pour instanicer les parametres de l'exercice;


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


import static java.lang.System.currentTimeMillis;

/**
 * Activité gérant l'exercice 1 de maths, un calcul apparait aisni qu'une frise avec des bornes, l'élève doit séléctionner le bon intervalle dans
 * le quel se situ la réponse du calcul.
 */

public class MathExo1Activity extends AppCompatActivity
{
    /**
     * numero de la question actuelle.
     */
    private static int numQuestAct = 0;

    /**
     * tableau des réponse, reponse juste = true dans la case du numero de la question.
     */
    private static boolean[] reponseJuste ;


    private static Exo1Math exo;

    /**
     * une réponse à t'elle était donné ?
     */
    private boolean reponseDonnee = false;

    /**
     * les variables pour gérer le temps que l'on passe sur chaque question
     */
    private long timeStart = currentTimeMillis();
    private long timeAct;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        /**
         * Timer
         */
        final CountDownTimer timer = new CountDownTimer(5000,500)
        {
            @Override
            public void onTick(long l) {

            }

            @Override
            public void onFinish()
            {
                if(!reponseDonnee)
                {
                    reponseJuste[numQuestAct] = false;
                }

                Log.w("UN truc QUI se VOIT","Reponse " + numQuestAct + " " + reponseJuste[numQuestAct]);

                numQuestAct++;

                if(numQuestAct==exo.getParam().getNbQuestions())
                {
                    numQuestAct = 0;

                    Intent intent = new Intent(MathExo1Activity.this, ExoMath1Resultat.class);
                    intent.putExtra("ReponseDonnee",reponseJuste);

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
         * Si c'est la premiere fois que l'on charge l'activité, on instancie les paramettres de l'exercice
         * anisi que les question grâce au constructeur de l'exercie de math,
         * on crée le tableau qui vas contenir les reponse aux bonnes dimensions.
         */
        if(numQuestAct==0)
        {
            ParamEm1 param = new ParamEm1();
            exo = new Exo1Math(param);
            reponseJuste = new boolean[param.getNbQuestions()];
        }

        Log.w("resultat", "resultat = " + exo.getResultats()[numQuestAct]);

        /**
         * Création des instances des boutons pour les réponse qui vont être initialisé au besoin celon
         * le nombre de questions.
         */
        Button BonneRep = null;
        Button RepF1 = null;
        Button RepF2 = null;
        Button RepF3 = null;
        TextView Borne1 = null;
        TextView Borne2 = null;
        TextView Borne3 = null;

        /**
         *  Celon le nombre de bornes defini dans les parametre on vas choisir quelle VIEW on affiche
         *  puis on instancie les bouttons et textView avec les valeurs appropriées.
         *
         *  On defini aussi les interractions avec les boutons.
         */
        switch (exo.getParam().getNbBornes())
        {
            case 1 :
                /**
                 * instanciation
                 */
                setContentView(R.layout.activity_math_exo1_1bornes);
                Borne1 = (TextView) findViewById(R.id.Borne1);
                Borne1.setText(""+exo.getBornes().get(numQuestAct).get(0));
                if (exo.getResultats()[numQuestAct] > exo.getBornes().get(numQuestAct).get(0)){
                    BonneRep = (Button) findViewById(R.id.BtnRepB);
                    RepF1 = (Button) findViewById(R.id.BtnRepA);
                }
                else {
                    BonneRep = (Button) findViewById(R.id.BtnRepA);
                    RepF1 = (Button) findViewById(R.id.BtnRepB);
                }
                /**
                 * Définition des interractions avec les bouttons.
                 */
                BonneRep.setOnClickListener(new View.OnClickListener() {

                    @Override
                    public void onClick(View view) {
                        reponseDonnee = true;
                        reponseJuste[numQuestAct] = true;
                        timer.cancel();
                        timer.onFinish();
                    }
                });
                RepF1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        reponseDonnee = true;
                        reponseJuste[numQuestAct] = false;
                        timer.cancel();
                        timer.onFinish();
                    }
                });

                break;

            case 2 :
                /**
                 * instanciation
                 */
                setContentView(R.layout.activity_math_exo1_2bornes);
                Borne1 = (TextView) findViewById(R.id.Borne1);
                Borne2 = (TextView) findViewById(R.id.Borne2);
                Borne1.setText(""+exo.getBornes().get(numQuestAct).get(0));
                Borne2.setText(""+exo.getBornes().get(numQuestAct).get(1));
                if (exo.getResultats()[numQuestAct] > exo.getBornes().get(numQuestAct).get(0)){

                    if (exo.getResultats()[numQuestAct] > exo.getBornes().get(numQuestAct).get(1)){
                        BonneRep = (Button) findViewById(R.id.BtnRepC);
                        RepF1 = (Button) findViewById(R.id.BtnRepA);
                        RepF2 = (Button) findViewById(R.id.BtnRepB);
                    }
                    else {
                        BonneRep = (Button) findViewById(R.id.BtnRepB);
                        RepF1 = (Button) findViewById(R.id.BtnRepA);
                        RepF2 = (Button) findViewById((R.id.BtnRepC));
                    }

                }else {
                    BonneRep = (Button) findViewById(R.id.BtnRepA);
                    RepF1 = (Button) findViewById(R.id.BtnRepB);
                    RepF2 = (Button) findViewById((R.id.BtnRepC));
                }

                /**
                 * Définition des interractions avec les bouttons.
                 */
                BonneRep.setOnClickListener(new View.OnClickListener() {

                    @Override
                    public void onClick(View view) {
                        reponseDonnee = true;
                        reponseJuste[numQuestAct] = true;
                        timer.cancel();
                        timer.onFinish();
                    }
                });
                RepF1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        reponseDonnee = true;
                        reponseJuste[numQuestAct] = false;
                        timer.cancel();
                        timer.onFinish();
                    }
                });
                RepF2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        reponseDonnee = true;
                        reponseJuste[numQuestAct] = false;
                        timer.cancel();
                        timer.onFinish();
                    }
                });

                break;

            case 3:
                /**
                 * instanciation
                 */
                setContentView(R.layout.activity_math_exo1_3bornes);
                Borne1 = (TextView) findViewById(R.id.Borne1);
                Borne2 = (TextView) findViewById(R.id.Borne2);
                Borne3 = (TextView) findViewById(R.id.Borne3);
                Borne1.setText(""+exo.getBornes().get(numQuestAct).get(0));
                Borne2.setText(""+exo.getBornes().get(numQuestAct).get(1));
                Borne3.setText(""+exo.getBornes().get(numQuestAct).get(2));
                if (exo.getResultats()[numQuestAct] > exo.getBornes().get(numQuestAct).get(0)){

                    if (exo.getResultats()[numQuestAct] > exo.getBornes().get(numQuestAct).get(1)){

                        if(exo.getResultats()[numQuestAct]>exo.getBornes().get(numQuestAct).get(2)){
                            BonneRep = (Button) findViewById(R.id.BtnRepD);
                            RepF1 = (Button) findViewById(R.id.BtnRepA);
                            RepF2 = (Button) findViewById(R.id.BtnRepB);
                            RepF3 = (Button) findViewById(R.id.BtnRepC);
                        }else
                        {
                            BonneRep = (Button) findViewById(R.id.BtnRepC);
                            RepF1 = (Button) findViewById(R.id.BtnRepA);
                            RepF2 = (Button) findViewById(R.id.BtnRepB);
                            RepF3 = (Button) findViewById(R.id.BtnRepD);
                        }

                    }
                    else {
                        BonneRep = (Button) findViewById(R.id.BtnRepB);
                        RepF1 = (Button) findViewById(R.id.BtnRepA);
                        RepF2 = (Button) findViewById((R.id.BtnRepC));
                        RepF3 = (Button) findViewById((R.id.BtnRepD));
                    }

                }else {
                    BonneRep = (Button) findViewById(R.id.BtnRepA);
                    RepF1 = (Button) findViewById(R.id.BtnRepB);
                    RepF2 = (Button) findViewById((R.id.BtnRepC));
                    RepF3 = (Button) findViewById((R.id.BtnRepD));
                }


                /**
                 * Définition des interractions avec les bouttons.
                 */
                BonneRep.setOnClickListener(new View.OnClickListener() {

                    @Override
                    public void onClick(View view) {
                        reponseDonnee = true;
                        reponseJuste[numQuestAct] = true;
                        timer.cancel();
                        timer.onFinish();
                    }
                });
                RepF1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        reponseDonnee = true;
                        reponseJuste[numQuestAct] = false;
                        timer.cancel();
                        timer.onFinish();
                    }
                });
                RepF2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        reponseDonnee = true;
                        reponseJuste[numQuestAct] = false;
                        timer.cancel();
                        timer.onFinish();
                    }
                });
                RepF3.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        reponseDonnee = true;
                        reponseJuste[numQuestAct] = false;
                        timer.cancel();
                        timer.onFinish();
                    }
                });

                break;
        }

        /**
         * Affichage de l'énoncé pour la question actuelle.
         */
        TextView enonce = (TextView) findViewById(R.id.Enonce);
        enonce.setText(exo.getCalculEnonce().get(numQuestAct));

        /**
         * mise en place du texte pour la question actuelle.
         */
        switch (exo.getParam().getNbBornes())
        {
            case 1:
                Borne1.setText(""+exo.getBornes().get(numQuestAct).get(0));
                break;

            case 2:
                Borne1.setText(""+exo.getBornes().get(numQuestAct).get(0));
                Borne2.setText(""+exo.getBornes().get(numQuestAct).get(1));
                break;

            case 3:
                Borne1.setText(""+exo.getBornes().get(numQuestAct).get(0));
                Borne2.setText(""+exo.getBornes().get(numQuestAct).get(1));
                Borne3.setText(""+exo.getBornes().get(numQuestAct).get(2));
                break;
        }

    }
}



