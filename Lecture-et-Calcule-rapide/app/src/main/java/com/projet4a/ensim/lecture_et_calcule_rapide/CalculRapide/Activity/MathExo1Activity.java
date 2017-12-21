package com.projet4a.ensim.lecture_et_calcule_rapide.CalculRapide.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.projet4a.ensim.lecture_et_calcule_rapide.CalculRapide.Model.Exo1Math;
import com.projet4a.ensim.lecture_et_calcule_rapide.CalculRapide.Model.ParamEm1;
import com.projet4a.ensim.lecture_et_calcule_rapide.Menu.MenuActivity;
import com.projet4a.ensim.lecture_et_calcule_rapide.R;

import org.w3c.dom.Text;

import static java.lang.System.currentTimeMillis;


public class MathExo1Activity extends AppCompatActivity
{}
   /* private static int numQuestAct = 0;
    private static boolean[] reponseJuste ;
    private static Exo1Math exo;

    private boolean reponseDonnee = false;
    private long timeStart = currentTimeMillis();
    private long timeAct;

    private Intent intent = new Intent(MathExo1Activity.this, MenuActivity.class);

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        Log.i("Debug","coucou depuis le oncreate " + numQuestAct );

        if(numQuestAct==0)
        {
            ParamEm1 param = new ParamEm1();
            exo = new Exo1Math(param);
            reponseJuste = new boolean[param.getNbQuestions()];
        }

        Button BonneRep = null;

        Button RepF1 = null;
        Button RepF2 = null;
        Button RepF3 = null;

        TextView Borne1 = null;
        TextView Borne2 = null;
        TextView Borne3 = null;

        switch (exo.getParam().getNbBornes())
        {
            case 1 :
                setContentView(R.layout.activity_math_exo1_1bornes);
                Borne1 = (TextView) findViewById(R.id.Borne1);
                Borne1.setText(""+exo.getBornes().get(numQuestAct).get(0));
                if (exo.getResultats()[0] > exo.getBornes().get(numQuestAct).get(0)){
                    BonneRep = (Button) findViewById(R.id.BtnRepB);
                    RepF1 = (Button) findViewById(R.id.BtnRepA);
                }
                else {
                    BonneRep = (Button) findViewById(R.id.BtnRepA);
                    RepF1 = (Button) findViewById(R.id.BtnRepB);
                }

                BonneRep.setOnClickListener(new View.OnClickListener() {

                    @Override
                    public void onClick(View view) {
                        reponseDonnee = true;
                        reponseJuste[numQuestAct] = true;
                        finish();
                        startActivity(getIntent());
                    }
                });
                RepF1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        reponseDonnee = true;
                        reponseJuste[numQuestAct] = false;
                        finish();
                        startActivity(getIntent());
                    }
                });

                break;

            case 2 :
                setContentView(R.layout.activity_math_exo1_2bornes);
                Borne1 = (TextView) findViewById(R.id.Borne1);
                Borne2 = (TextView) findViewById(R.id.Borne2);
                Borne1.setText(""+exo.getBornes().get(numQuestAct).get(0));
                Borne2.setText(""+exo.getBornes().get(numQuestAct).get(1));
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

                BonneRep.setOnClickListener(new View.OnClickListener() {

                    @Override
                    public void onClick(View view) {
                        reponseDonnee = true;
                        reponseJuste[numQuestAct] = true;
                        numQuestAct ++;
                        finish();
                        startActivity(getIntent());
                    }
                });
                RepF1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        reponseDonnee = true;
                        reponseJuste[numQuestAct] = false;
                        numQuestAct ++;
                        finish();
                        startActivity(getIntent());
                    }
                });
                RepF2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        reponseDonnee = true;
                        reponseJuste[numQuestAct] = false;
                        numQuestAct ++;
                        finish();
                        startActivity(getIntent());
                    }
                });

                break;

            case 3:
                setContentView(R.layout.activity_math_exo1_3bornes);
                Borne1 = (TextView) findViewById(R.id.Borne1);
                Borne2 = (TextView) findViewById(R.id.Borne2);
                Borne3 = (TextView) findViewById(R.id.Borne3);
                Borne1.setText(""+exo.getBornes().get(numQuestAct).get(0));
                Borne2.setText(""+exo.getBornes().get(numQuestAct).get(1));
                Borne3.setText(""+exo.getBornes().get(numQuestAct).get(2));
                if (exo.getResultats()[0] > exo.getBornes().get(numQuestAct).get(0)){

                    if (exo.getResultats()[0] > exo.getBornes().get(numQuestAct).get(1)){

                        if(exo.getResultats()[0]>exo.getBornes().get(numQuestAct).get(2)){
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

                BonneRep.setOnClickListener(new View.OnClickListener() {

                    @Override
                    public void onClick(View view) {
                        reponseDonnee = true;
                        reponseJuste[numQuestAct] = true;
                        numQuestAct ++;
                        finish();
                        startActivity(getIntent());
                    }
                });
                RepF1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        reponseDonnee = true;
                        reponseJuste[numQuestAct] = false;
                        numQuestAct ++;
                        finish();
                        startActivity(getIntent());
                    }
                });
                RepF2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        reponseDonnee = true;
                        reponseJuste[numQuestAct] = false;
                        numQuestAct ++;
                        finish();
                        startActivity(getIntent());
                    }
                });
                RepF3.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        reponseDonnee = true;
                        reponseJuste[numQuestAct] = false;
                        numQuestAct ++;
                        finish();
                        startActivity(getIntent());
                    }
                });

                break;
        }

        TextView enonce = (TextView) findViewById(R.id.Enonce);

        enonce.setText(exo.getCalculEnonce().get(numQuestAct));

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
        if(numQuestAct==exo.getParam().getNbQuestions()-1)
        {
            if (numQuestAct == exo.getParam().getNbQuestions() - 1) {
                numQuestAct = 0;
                startActivity(intent2);
            }
        }
    }


    /*protected void onStart()
    {1
        super.onStart();

        do
        {
            timeAct=currentTimeMillis();
            if(reponseDonnee)
            {
                break;
            }
            else if(timeAct-timeStart<2000) break;
        }while(true);

        if (!reponseDonnee)
        {<
            reponseJuste[numQuestAct] = false;
        }

        numQuestAct++;
        if(numQuestAct==exo.getParam().getNbQuestions())
        {
            numQuestAct = 0;
            finish();
        }
    }
}


*/
