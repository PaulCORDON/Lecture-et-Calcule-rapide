package com.projet4a.ensim.lecture_et_calcule_rapide.CalculRapide.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.projet4a.ensim.lecture_et_calcule_rapide.CalculRapide.Model.Exo1Math;
import com.projet4a.ensim.lecture_et_calcule_rapide.CalculRapide.Model.ParamEm1;
import com.projet4a.ensim.lecture_et_calcule_rapide.R;

import java.util.ArrayList;

public class MathExo1Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ParamEm1 param = new ParamEm1();
        Exo1Math exo = new Exo1Math(param);
        TextView enonce = (TextView) findViewById(R.id.Enonce);
        int numQuestAct = 1;
        boolean reponseDonne = false;
        int btnBonneRep = -1;

        Button BonneRep = null;

        Button RepF1 = null;
        Button RepF2 = null;
        Button RepF3 = null;



        switch (param.getNbBornes()){
            case 1 :
                setContentView(R.layout.activity_math_exo1_1bornes);

                if (exo.getResultat() > exo.getBornes().get(numQuestAct).get(0)){
                    Button BonneRep = (Button) findViewById(R.id.BtnRepB);
                    Button RepF1 = (Button) findViewById(R.id.BtnRepA);
                }
                else {
                    Button BonneRep = (Button) findViewById(R.id.BtnRepA);
                    Button RepF1 = (Button) findViewById(R.id.BtnRepB);
                }

                break;
            case 2 :
                setContentView(R.layout.activity_math_exo1_2bornes);

                if (exo.getResultat() > exo.getBornes().get(numQuestAct).get(0)){

                    if (exo.getResultat() > exo.getBornes().get(numQuestAct).get(1)){
                        Button BonneRep = (Button) findViewById(R.id.BtnRepC);
                        Button RepF1 = (Button) findViewById(R.id.BtnRepA);
                        Button RepF2 = (Button) findViewById(R.id.BtnRepB);
                    }
                    else {
                        Button BonneRep = (Button) findViewById(R.id.BtnRepB);
                        Button RepF1 = (Button) findViewById(R.id.BtnRepA);
                        Button RepF2 = (Button) findViewById((R.id.BtnRepC));
                    }

                }else {
                    Button BonneRep = (Button) findViewById(R.id.BtnRepA);
                    Button RepF1 = (Button) findViewById(R.id.BtnRepB);
                    Button RepF2 = (Button) findViewById((R.id.BtnRepC));
                }

                break;
            case 3 :
                setContentView(R.layout.activity_math_exo1_3bornes);

                if (exo.getResultat() > exo.getBornes().get(numQuestAct).get(0)){

                    if (exo.getResultat() > exo.getBornes().get(numQuestAct).get(1)){

                        if(exo.getResultat()>exo.getBornes().get(numQuestAct).get(2)){
                            Button BonneRep = (Button) findViewById(R.id.BtnRepD);
                            Button RepF1 = (Button) findViewById(R.id.BtnRepA);
                            Button RepF2 = (Button) findViewById(R.id.BtnRepB);
                            Button RepF3 = (Button) findViewById(R.id.BtnRepC);
                        }else
                        {
                            Button BonneRep = (Button) findViewById(R.id.BtnRepC);
                            Button RepF1 = (Button) findViewById(R.id.BtnRepA);
                            Button RepF2 = (Button) findViewById(R.id.BtnRepB);
                            Button RepF3 = (Button) findViewById(R.id.BtnRepD);
                        }

                    }
                    else {
                        Button BonneRep = (Button) findViewById(R.id.BtnRepB);
                        Button RepF1 = (Button) findViewById(R.id.BtnRepA);
                        Button RepF2 = (Button) findViewById((R.id.BtnRepC));
                        Button RepF3 = (Button) findViewById((R.id.BtnRepD));
                    }

                }else {
                    Button BonneRep = (Button) findViewById(R.id.BtnRepA);
                    Button RepF1 = (Button) findViewById(R.id.BtnRepB);
                    Button RepF2 = (Button) findViewById((R.id.BtnRepC));
                    Button RepF3 = (Button) findViewById((R.id.BtnRepD));
                }



                Button BonneRep = (Button) findViewById(R.id.BtnRepA);
                Button RepF1 = (Button) findViewById(R.id.BtnRepB);
                Button RepF2 = (Button) findViewById(R.id.BtnRepC);
                Button RepF3 = (Button) findViewById(R.id.BtnRepD);
                break;
        }

        enonce.setText(exo.getCalculEnonce().get(numQuestAct));










    }




}
