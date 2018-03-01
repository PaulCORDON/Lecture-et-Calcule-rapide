package com.projet4a.ensim.lecture_et_calcule_rapide.CalculRapide.Activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.projet4a.ensim.lecture_et_calcule_rapide.CalculRapide.Model.Exo2Math;
import com.projet4a.ensim.lecture_et_calcule_rapide.CalculRapide.Model.ParamEm2;
import com.projet4a.ensim.lecture_et_calcule_rapide.R;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * Exercice deux de maths,
 * Exercice de multiplications
 */
public class MathExo2Activity extends AppCompatActivity {

    /**
     * le type d'écran de réponse choisis dans les parametres :
     * - 0 : pavé numérique,
     * - 1 : 2 reponses,
     * - 2 : 4 reponses possibles.
     */
    private int typeRep = 1;

    /**
     * tableau des réponses, reponse juste = true dans la case du numero de la question  si il a bien répondue, faux sinon.
     */
    private static boolean[] reponseJuste;

    /**
     * Le numero de la question actuelle
     */
    private static int numQuestAct = 0;

    /**
     * L'instance de l'exercice qui va comprendre l'ensemble des énoncés, un accés au arametre
     * ainsi que les réponses et les valurs à afficher si il y a lieu
     */
    private static Exo2Math exo = null;

    /**
     * une réponse a-t-elle été donnée ?
     */
    private boolean reponseDonnee = false;

    /**
     * dans le cas où on est avec le pavé numerique, on a le résultat donnée par l'éleve qui est sous la forme d'un string :
     */
    private StringBuilder reponse = new StringBuilder();

    /**
     * timer
     */
    private CountDownTimer timer;

    /**
     * textView contenant la réponse de l'élève
     */
    private TextView reponseE;

    /**
     * entier aléatoire pour placer la bonne réponse
     */
    private int placementAlea;

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

    private View.OnClickListener Pav1 = (new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            reponse.append("1");
            reponseE.setText(reponse.toString());
        }
    });
    private View.OnClickListener Pav2 = (new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            reponse.append("2");
            reponseE.setText(reponse.toString());
        }
    });
    private View.OnClickListener Pav3 = (new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            reponse.append("3");
            reponseE.setText(reponse.toString());
        }
    });
    private View.OnClickListener Pav4 = (new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            reponse.append("4");
            reponseE.setText(reponse.toString());
        }
    });
    private View.OnClickListener Pav5 = (new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            reponse.append("5");
            reponseE.setText(reponse.toString());
        }
    });
    private View.OnClickListener Pav6 = (new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            reponse.append("6");
            reponseE.setText(reponse.toString());
        }
    });
    private View.OnClickListener Pav7 = (new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            reponse.append("7");
            reponseE.setText(reponse.toString());
        }
    });
    private View.OnClickListener Pav8 = (new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            reponse.append("8");
            reponseE.setText(reponse.toString());
        }
    });
    private View.OnClickListener Pav9 = (new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            reponse.append("9");
            reponseE.setText(reponse.toString());
        }
    });
    private View.OnClickListener Pav0 = (new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            reponse.append("0");
            reponseE.setText(reponse.toString());
        }
    });

    private View.OnClickListener Valider = (new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            reponseDonnee = true;
            Log.w("exoM2","validation : " + new String(reponse) + ":" +exo.getCalcul().get(numQuestAct).getResultatString() );
            if (new String(reponse).equals(exo.getCalcul().get(numQuestAct).getResultatString())) {
                Log.w("exoM2","La reponse donné est bonne!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!" );
                reponseJuste[numQuestAct] = true;
            } else {
                reponseJuste[numQuestAct] = false;
            }
            timer.cancel();
            timer.onFinish();
        }
    });
    private View.OnClickListener Corriger = (new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            reponse.deleteCharAt(reponse.length() - 1);
        }
    });

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Button rep1 = null;
        Button rep2 = null;
        Button rep3 = null;
        Button rep4 = null;

        Button rep5 = null;
        Button rep6 = null;
        Button rep7 = null;
        Button rep8 = null;
        Button rep9 = null;
        Button rep0 = null;

        Button valider = null;
        Button corriger = null;


        /**
         * si c'est la premiere fois que l'on lance l'activité de cet exercice, on récupere les parametres et on créer les énoncés
         */
        if (numQuestAct == 0) {
            ParamEm2 param = new ParamEm2();
            try {
                FileInputStream out = openFileInput("ParamEm2.txt");
                ObjectInputStream ois = new ObjectInputStream(out);
                param = (ParamEm2) ois.readObject();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }

            exo = new Exo2Math(param);
            reponseJuste = new boolean[param.getNbQuestions()];
        }

        // TODO associé le type de reponse à la variable typeReonse des parametres
        switch (typeRep) { //exo.getParam().gettypeRep()
            case 0:
                setContentView(R.layout.activity_math_exo2_pave_numerique);
                rep0 = findViewById(R.id.p0);
                rep1 = findViewById(R.id.p1);
                rep2 = findViewById(R.id.p2);
                rep3 = findViewById(R.id.p3);
                rep4 = findViewById(R.id.p4);
                rep5 = findViewById(R.id.p5);
                rep6 = findViewById(R.id.p6);
                rep7 = findViewById(R.id.p7);
                rep8 = findViewById(R.id.p8);
                rep9 = findViewById(R.id.p9);

                final TextView reponseDonne = findViewById(R.id.ReponseEleve);
                reponseE = reponseDonne;
                valider = findViewById(R.id.Validation);
                corriger = findViewById(R.id.correction);
                reponseE = findViewById(R.id.ReponseEleve);
                break;
            case 1:
                setContentView(R.layout.activity_math_exo2_2rep);
                rep0 = findViewById(R.id.repA);
                rep1 = findViewById(R.id.repB);
                break;
            case 2:
                setContentView(R.layout.activity_math_exo2_4rep);
                rep0 = findViewById(R.id.R1);
                rep1 = findViewById(R.id.R2);
                rep2 = findViewById(R.id.R3);
                rep3 = findViewById(R.id.R4);
                break;
        }

         TextView op1 = findViewById(R.id.operande1);
         TextView op2 = findViewById(R.id.operande2);
        Log.w("exo2","nombre de calcul crée :" +exo.getCalcul().size());
Log.w("exo2","operande 1 :" +exo.getCalcul().get(numQuestAct).getOp1Int());
        Log.w("exo2","operande 2 :" +exo.getCalcul().get(numQuestAct).getOp2Int());
        Log.w("exo2","resultat :" +exo.getCalcul().get(numQuestAct).getResultatString());

        op1.setText(""+exo.getCalcul().get(numQuestAct).getOp1Int());
        op2.setText(""+exo.getCalcul().get(numQuestAct).getOp2Int());

        switch (typeRep) {
            case 1:
                placementAlea = (int)((Math.random() * 3 )+1);
                Log.w("choix bornes :" ,"random pour le choix de la borne" + placementAlea);
                rep0.setText("" + ((int) (Math.random()*100)));
                rep1.setText("" + ((int) (Math.random()*100)));
                if (placementAlea == 1) {
                    Log.w("choix bornes :" ,"GAAUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUCCCCCCCCCHHHHHHHHHHHHHHHHHHHHEEEEEEEEEEEEEE");
                    rep0.setText(""+exo.getCalcul().get(numQuestAct).getResultatString());
                    rep0.setOnClickListener(OCLBonneReponse);
                    rep1.setOnClickListener(OCLMauvaiseReponse);
                }else {
                    Log.w("choix bornes :" ,"DDDDDDDDDRRRRRRRRRRRRRRRRRRRRRRRRRRRRRROIIIIIIIIIIIIIIIIIIIIIIIIIIIIITTTTTTTTTTTTTTTTEEEE");
                    rep1.setText(""+exo.getCalcul().get(numQuestAct).getResultatString());
                                                                                                            int a = (int)(Math.random()*100);
                                                                                                                         Log.w("valeur du random : ", "a ====================================="  + a +"++++++++++++++++++"+ rep0.getText());
                                                                                                                                     rep0.setText(""+a);
                                                                                                                    Log.w("valeur du random : ", "a ====================================="  + a +"------------------"+ rep0.getText());


                    rep1.setOnClickListener(OCLBonneReponse);
                    rep0.setOnClickListener(OCLMauvaiseReponse);
                }
                rep0.setText(exo.getCalcul().get(numQuestAct).getResultatString());
                break;
            case 2:
                rep0.setText("" + (int) ((Math.random() * 100)));
                rep1.setText("" + ((int) (Math.random() * 100)));
                rep2.setText("" + ((int) (Math.random() * 100)));
                rep3.setText("" + ((int) (Math.random() * 100)));

                placementAlea = (int) ((Math.random() * 4)+1);
                switch (placementAlea) {
                    case 0:
                        rep0.setText(""+exo.getCalcul().get(numQuestAct).getResultatString());
                        break;
                    case 1:
                        rep1.setText(""+exo.getCalcul().get(numQuestAct).getResultatString());
                        break;
                    case 2:
                        rep2.setText(""+exo.getCalcul().get(numQuestAct).getResultatString());
                        break;
                    case 3:
                        rep3.setText(""+exo.getCalcul().get(numQuestAct).getResultatString());
                        break;
                }
                break;
            case 0:
                rep0.setOnClickListener(Pav0);
                rep1.setOnClickListener(Pav1);
                rep2.setOnClickListener(Pav2);
                rep3.setOnClickListener(Pav3);
                rep4.setOnClickListener(Pav4);
                rep5.setOnClickListener(Pav5);
                rep6.setOnClickListener(Pav6);
                rep7.setOnClickListener(Pav7);
                rep8.setOnClickListener(Pav8);
                rep9.setOnClickListener(Pav9);

                valider.setOnClickListener(Valider);
                corriger.setOnClickListener(Corriger);
                break;
        }

        timer = new CountDownTimer(5000, 500) {
            @Override
            public void onTick(long l) {

            }

            @Override
            public void onFinish() {
                for (boolean b : reponseJuste) {
                    if (b) {
                        Log.w("correction","juste");

                    }else
                    {
                        Log.w("exoM2","fauxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx" );
                    }
                }

                if (!reponseDonnee) {
                    reponseJuste[numQuestAct] = false;
                }
                numQuestAct++;

                if (numQuestAct == exo.getParam().getNbQuestions()) {
                    numQuestAct = 0;



                    Intent intent = new Intent(MathExo2Activity.this, ExoMath1Resultat.class);
                    intent.putExtra("ReponseDonnee", reponseJuste);

                    FileOutputStream outputStream;
                    ObjectOutputStream oos;
                    try {
                        outputStream = openFileOutput("ExoM2.txt", Context.MODE_PRIVATE);
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
}
