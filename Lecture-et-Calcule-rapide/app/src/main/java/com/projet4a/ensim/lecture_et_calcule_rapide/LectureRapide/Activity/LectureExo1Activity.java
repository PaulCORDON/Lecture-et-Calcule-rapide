package com.projet4a.ensim.lecture_et_calcule_rapide.LectureRapide.Activity;


import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.projet4a.ensim.lecture_et_calcule_rapide.LectureRapide.Model.Exo1Lecture;
import com.projet4a.ensim.lecture_et_calcule_rapide.LectureRapide.Model.ParamEl1;
import com.projet4a.ensim.lecture_et_calcule_rapide.R;



public class LectureExo1Activity extends AppCompatActivity {
    int nbAppDeEnonce=0;
    int nbBonneRep=0;
    private long tempsDepart=0;
    ParamEl1 param = new ParamEl1();
    Exo1Lecture exo = new Exo1Lecture(param);
    Button rep1=(Button)findViewById(R.id.Rep1);
    Button rep2=(Button)findViewById(R.id.Rep2);
    Button rep3=(Button)findViewById(R.id.Rep3);
    Button rep4=(Button)findViewById(R.id.Rep4);
    Button rep5=(Button)findViewById(R.id.Rep5);
    Button rep6=(Button)findViewById(R.id.Rep6);
    Button rep7=(Button)findViewById(R.id.Rep7);
    Button rep8=(Button)findViewById(R.id.Rep8);
    Button rep9=(Button)findViewById(R.id.Rep9);
    Button rep10=(Button)findViewById(R.id.Rep10);
    TextView enonce=(TextView)findViewById(R.id.EnonceLectureEx1);
    boolean aRepondu=false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lecture_exo1);
        enonce.setText(exo.getEnonce());

        rep1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                verifierReponse(rep1);
            }
        });
        rep2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                verifierReponse(rep2);
            }
        });
        rep3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                verifierReponse(rep3);
            }
        });
        rep4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                verifierReponse(rep4);
            }
        });
        rep5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                verifierReponse(rep5);
            }
        });
        rep6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                verifierReponse(rep6);
            }
        });
        rep7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                verifierReponse(rep7);
            }
        });
        rep8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                verifierReponse(rep8);
            }
        });
        rep9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                verifierReponse(rep9);
            }
        });
        rep10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                verifierReponse(rep10);
            }
        });

        if(!param.getMultipleApparution()){

            for(int nbApparition=0;nbApparition==param.getNbApparution();nbApparition++){
                aRepondu=false;

                switch (tirrageAleatoireEntre1et10()){
                    case 1:rendreVisibleEtDonneeValeur(rep1);
                        while ((System.currentTimeMillis()-tempsDepart)<param.getTempsApparution()){}
                        rendreInvisible(rep1);
                        break;
                    case 2:rendreVisibleEtDonneeValeur(rep2);
                        while ((System.currentTimeMillis()-tempsDepart)<param.getTempsApparution()){}
                        rendreInvisible(rep2);
                        break;
                    case 3:rendreVisibleEtDonneeValeur(rep3);
                        while ((System.currentTimeMillis()-tempsDepart)<param.getTempsApparution()){}
                        rendreInvisible(rep3);
                        break;
                    case 4:rendreVisibleEtDonneeValeur(rep4);
                        while ((System.currentTimeMillis()-tempsDepart)<param.getTempsApparution()){}
                        rendreInvisible(rep4);
                        break;
                    case 5:rendreVisibleEtDonneeValeur(rep5);
                        while ((System.currentTimeMillis()-tempsDepart)<param.getTempsApparution()){}
                        rendreInvisible(rep5);
                        break;
                    case 6:rendreVisibleEtDonneeValeur(rep6);
                        while ((System.currentTimeMillis()-tempsDepart)<param.getTempsApparution()){}
                        rendreInvisible(rep6);
                        break;
                    case 7:rendreVisibleEtDonneeValeur(rep7);
                        while ((System.currentTimeMillis()-tempsDepart)<param.getTempsApparution()){}
                        rendreInvisible(rep7);
                        break;
                    case 8:rendreVisibleEtDonneeValeur(rep8);
                        while ((System.currentTimeMillis()-tempsDepart)<param.getTempsApparution()){}
                        rendreInvisible(rep8);
                        break;
                    case 9:rendreVisibleEtDonneeValeur(rep9);
                        while ((System.currentTimeMillis()-tempsDepart)<param.getTempsApparution()){}
                        rendreInvisible(rep9);
                        break;
                    case 10:rendreVisibleEtDonneeValeur(rep10);
                        while ((System.currentTimeMillis()-tempsDepart)<param.getTempsApparution()){}
                        rendreInvisible(rep10);
                        break;
                    default:break;
                }
            }
        }
    }
    private int tirrageAleatoireEntre1et10(){
        int num = (int)Math.random()*9+1;
        return num;
    }
    private int tirrageAleatoireDunIndex(){
        int num = (int)Math.random()*exo.getApparition().size();
        return num;
    }
    private void rendreVisibleEtDonneeValeur(Button b){
        b.setText(exo.getApparition().get(tirrageAleatoireDunIndex()));
        if(b.getText().equals(enonce)){
            nbAppDeEnonce++;
        }
        b.setVisibility(View.VISIBLE);
        tempsDepart=System.currentTimeMillis();
    }
    private void verifierReponse(Button b){
        if(b.getText().equals(enonce)){
            nbBonneRep++;
            b.setBackgroundColor(Color.GREEN);
        }
        rendreInvisible(b);
    }
    private void rendreInvisible(Button b){
        b.setVisibility(View.GONE);
        b.setBackgroundColor(Color.WHITE);
    }
}
