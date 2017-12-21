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


/**
 * Activité liée à l'affichage : activity lecture exo 1
 */
public class LectureExo1Activity extends AppCompatActivity {

    /**
     * Compteur du nombre d'apparition de l'énoncé pendant l'exercice
     */
    int nbAppDeEnonce=0;

    /**
     * Compteur du nombre de bonnes réponses données par l'élève
     */
    int nbBonneRep=0;

    /**
     * Compteur du nombre de mauvaises réponses données par l'élève
     */
    int nbMauvaiseRep=0;

    /**
     * Variable servant pour le temps
     */
    private long tempsDepart;

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
                aRepondu=true;
            }
        });
        rep2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                verifierReponse(rep2);
                aRepondu=true;
            }
        });
        rep3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                verifierReponse(rep3);
                aRepondu=true;
            }
        });
        rep4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                verifierReponse(rep4);
                aRepondu=true;
            }
        });
        rep5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                verifierReponse(rep5);
                aRepondu=true;
            }
        });
        rep6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                verifierReponse(rep6);
                aRepondu=true;
            }
        });
        rep7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                verifierReponse(rep7);
                aRepondu=true;
            }
        });
        rep8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                verifierReponse(rep8);
                aRepondu=true;
            }
        });
        rep9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                verifierReponse(rep9);
                aRepondu=true;
            }
        });
        rep10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                verifierReponse(rep10);
                aRepondu=true;
            }
        });

        if(!param.getMultipleApparution()){

            for(int nbApparition=0;nbApparition<=param.getNbApparution();nbApparition++){
                aRepondu=false;

                switch (tirrageAleatoireEntre1et10()){
                    case 1:rendreVisibleEtDonneeValeur(rep1);
                        while ((System.currentTimeMillis()-tempsDepart)<param.getTempsApparution()&&!aRepondu){}
                        rendreInvisible(rep1);
                        break;
                    case 2:rendreVisibleEtDonneeValeur(rep2);
                        while ((System.currentTimeMillis()-tempsDepart)<param.getTempsApparution()&&!aRepondu){}
                        rendreInvisible(rep2);
                        break;
                    case 3:rendreVisibleEtDonneeValeur(rep3);
                        while ((System.currentTimeMillis()-tempsDepart)<param.getTempsApparution()&&!aRepondu){}
                        rendreInvisible(rep3);
                        break;
                    case 4:rendreVisibleEtDonneeValeur(rep4);
                        while ((System.currentTimeMillis()-tempsDepart)<param.getTempsApparution()&&!aRepondu){}
                        rendreInvisible(rep4);
                        break;
                    case 5:rendreVisibleEtDonneeValeur(rep5);
                        while ((System.currentTimeMillis()-tempsDepart)<param.getTempsApparution()&&!aRepondu){}
                        rendreInvisible(rep5);
                        break;
                    case 6:rendreVisibleEtDonneeValeur(rep6);
                        while ((System.currentTimeMillis()-tempsDepart)<param.getTempsApparution()&&!aRepondu){}
                        rendreInvisible(rep6);
                        break;
                    case 7:rendreVisibleEtDonneeValeur(rep7);
                        while ((System.currentTimeMillis()-tempsDepart)<param.getTempsApparution()&&!aRepondu){}
                        rendreInvisible(rep7);
                        break;
                    case 8:rendreVisibleEtDonneeValeur(rep8);
                        while ((System.currentTimeMillis()-tempsDepart)<param.getTempsApparution()&&!aRepondu){}
                        rendreInvisible(rep8);
                        break;
                    case 9:rendreVisibleEtDonneeValeur(rep9);
                        while ((System.currentTimeMillis()-tempsDepart)<param.getTempsApparution()&&!aRepondu){}
                        rendreInvisible(rep9);
                        break;
                    case 10:rendreVisibleEtDonneeValeur(rep10);
                        while ((System.currentTimeMillis()-tempsDepart)<param.getTempsApparution()&&!aRepondu){}
                        rendreInvisible(rep10);
                        break;
                    default:break;
                }
            }
        }
        calculerScore();
    }
    /**
     * Méthode qui tire un nombre aléatoire entre 1 et 10
     * @return entier entre 1 et 10
     */
    private int tirrageAleatoireEntre1et10(){
        int num = (int)Math.random()*9+1;
        return num;
    }

    /**
     * Méthode qui tire aléatoirement en index situé entre 0 et la taille du tableau qui contient les apparitions
     * @return un index aléatoire
     */
    private int tirrageAleatoireDunIndex(){
        int num = (int)Math.random()*exo.getApparition().size();
        return num;
    }

    /**
     * Méthode qui rend visible le boutton et le remplit avec une proposition de réponse
     * @param b le boutton sur lequel apparait une proposition de réponse
     */
    private void rendreVisibleEtDonneeValeur(Button b){
        b.setText(exo.getApparition().get(tirrageAleatoireDunIndex()));
        if(b.getText().equals(enonce)){
            nbAppDeEnonce++;
        }
        b.setVisibility(View.VISIBLE);
        tempsDepart=System.currentTimeMillis();
    }

    /**
     * Méthode qui vérifie si l'élève a donné une bonne réponse
     * @param b le boutton sur lequel l'élève à répondu
     */
    private void verifierReponse(Button b){
        if(b.getText().equals(enonce)){
            nbBonneRep++;
            b.setBackgroundColor(Color.GREEN);
        }
        else{
            nbMauvaiseRep++;
            b.setBackgroundColor(Color.RED);
        }
    }

    /**
     * Méthode qui rend invisible le boutton pris en paramètre
     * @param b un boutton qui doit disparaitre
     */
    private void rendreInvisible(Button b){
        b.setVisibility(View.GONE);
        b.setBackgroundColor(Color.WHITE);
    }

    /**
     * Méthode qui calcule le score de l'élève
     * @return le score de l'élève en pourcentage
     */
    private float calculerScore(){
       int score;
       if(nbBonneRep+nbMauvaiseRep!=0){
           score=((nbBonneRep/nbAppDeEnonce)/(nbBonneRep+nbMauvaiseRep))*100;
       }
       else{
           score=0;
       }
       return score;
    }
}
