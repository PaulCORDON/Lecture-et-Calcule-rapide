package com.projet4a.ensim.lecture_et_calcule_rapide.CalculRapide.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.projet4a.ensim.lecture_et_calcule_rapide.CalculRapide.Model.Exo1Math;
import com.projet4a.ensim.lecture_et_calcule_rapide.CalculRapide.Model.ParamEm1;
import com.projet4a.ensim.lecture_et_calcule_rapide.R;

import org.w3c.dom.Text;

import static java.lang.System.currentTimeMillis;


public class MathExo1Activity extends AppCompatActivity {

    private boolean reponseDonnee = false;
    private  int numQuestAct = 1;
    private  boolean[] reponseJuste;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ParamEm1 param = new ParamEm1();
        Exo1Math exo = new Exo1Math(param);
        TextView enonce = (TextView) findViewById(R.id.Enonce);

        reponseJuste = new boolean[param.getNbQuestions()];

        boolean Reponse = false;

        long timeStart;

        int btnBonneRep = -1;

        Button BonneRep = null;

        Button RepF1 = null;
        Button RepF2 = null;
        Button RepF3 = null;

        TextView Borne1 = null;
        TextView Borne2 = null;
        TextView Borne3 = null;



        switch (param.getNbBornes()){
            case 1 :
                setContentView(R.layout.activity_math_exo1_1bornes);
                Borne1 = (TextView) findViewById(R.id.Borne1);
                Borne1.setText(exo.getBornes().get(numQuestAct).get(0));
                if (exo.getResultats()[0] > exo.getBornes().get(numQuestAct).get(0)){
                    BonneRep = (Button) findViewById(R.id.BtnRepB);
                    RepF1 = (Button) findViewById(R.id.BtnRepA);
                }
                else {
                    BonneRep = (Button) findViewById(R.id.BtnRepA);
                    RepF1 = (Button) findViewById(R.id.BtnRepB);
                }

                break;
            case 2 :
                setContentView(R.layout.activity_math_exo1_2bornes);
                Borne1 = (TextView) findViewById(R.id.Borne1);
                Borne2 = (TextView) findViewById(R.id.Borne2);
                Borne1.setText(exo.getBornes().get(numQuestAct).get(0));
                Borne2.setText(exo.getBornes().get(numQuestAct).get(1));
                if (exo.getResultats()[0] > exo.getBornes().get(numQuestAct).get(0)){

                    if (exo.getResultats()[0] > exo.getBornes().get(numQuestAct).get(1)){
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

                break;
            case 3:
                setContentView(R.layout.activity_math_exo1_3bornes);
                Borne1 = (TextView) findViewById(R.id.Borne1);
                Borne2 = (TextView) findViewById(R.id.Borne2);
                Borne3 = (TextView) findViewById(R.id.Borne3);
                Borne1.setText(exo.getBornes().get(numQuestAct).get(0));
                Borne2.setText(exo.getBornes().get(numQuestAct).get(1));
                Borne3.setText(exo.getBornes().get(numQuestAct).get(2));
                if (exo.getResultats()[0] > exo.getBornes().get(numQuestAct).get(0)){

                    if (exo.getResultats()[0] > exo.getBornes().get(numQuestAct).get(1)){

                        if(exo.getResultats()[0]>exo.getBornes().get(numQuestAct).get(3)){
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



                BonneRep = (Button) findViewById(R.id.BtnRepA);
                RepF1 = (Button) findViewById(R.id.BtnRepB);
                RepF2 = (Button) findViewById(R.id.BtnRepC);
                RepF3 = (Button) findViewById(R.id.BtnRepD);
                break;
        }

        timeStart = currentTimeMillis();
        do{
            enonce.setText(exo.getCalculEnonce().get(numQuestAct));





            try{
                BonneRep.setOnClickListener(new View.OnClickListener() {

                    @Override
                    public void onClick(View view) {
                        reponseDonnee = true;
                        reponseJuste[numQuestAct] = true;

                    }
                });


                RepF1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        reponseDonnee = true;
                        reponseJuste[numQuestAct] = false;
                    }
                });
                RepF2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        reponseDonnee = true;
                        reponseJuste[numQuestAct] = false;
                    }
                });
                RepF3.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        reponseDonnee = true;
                        reponseJuste[numQuestAct] = false;
                    }
                });
            }catch (NullPointerException e){
                System.out.println(e);
            }


            if(!reponseDonnee  || timeStart >= timeStart + 10000){ // param.getTempsRep()

                if(!reponseDonnee){
                    reponseJuste[numQuestAct] = false;
                }
                numQuestAct ++;
                reponseDonnee = false;
            }



        }while (numQuestAct != param.getNbQuestions());


    }







}



