package com.projet4a.ensim.lecture_et_calcule_rapide.LectureRapide.Activity;


import android.graphics.Color;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.projet4a.ensim.lecture_et_calcule_rapide.LectureRapide.Model.Exo1Lecture;
import com.projet4a.ensim.lecture_et_calcule_rapide.LectureRapide.Model.ParamEl1;
import com.projet4a.ensim.lecture_et_calcule_rapide.R;

import java.io.FileNotFoundException;
import java.util.ArrayList;


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

    int nbAppCourent=0;

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
    ArrayList<Button> listeDesBoutons =new ArrayList<>();
    TextView enonce=(TextView)findViewById(R.id.EnonceLectureEx1);
    ArrayList<Integer> idDesBoutonsDesApparitions = new ArrayList<>();

    public LectureExo1Activity() throws FileNotFoundException {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lecture_exo1);
        enonce.setText(exo.getEnonce());
        listeDesBoutons.add(rep1);
        listeDesBoutons.add(rep2);
        listeDesBoutons.add(rep3);
        listeDesBoutons.add(rep4);
        listeDesBoutons.add(rep5);
        listeDesBoutons.add(rep6);
        listeDesBoutons.add(rep7);
        listeDesBoutons.add(rep8);
        listeDesBoutons.add(rep9);
        listeDesBoutons.add(rep10);

        rep1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                verifierReponse(rep1);
                rendreInvisible(rep1);
            }
        });
        rep2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                verifierReponse(rep2);
                rendreInvisible(rep2);
            }
        });
        rep3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                verifierReponse(rep3);
                rendreInvisible(rep3);
            }
        });
        rep4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                verifierReponse(rep4);
                rendreInvisible(rep4);
            }
        });
        rep5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                verifierReponse(rep5);
                rendreInvisible(rep5);
            }
        });
        rep6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                verifierReponse(rep6);
                rendreInvisible(rep6);
            }
        });
        rep7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                verifierReponse(rep7);
                rendreInvisible(rep7);
            }
        });
        rep8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                verifierReponse(rep8);
                rendreInvisible(rep8);
            }
        });
        rep9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                verifierReponse(rep9);
                rendreInvisible(rep9);
            }
        });
        rep10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                verifierReponse(rep10);
                rendreInvisible(rep10);
            }
        });


            final CountDownTimer timer = new CountDownTimer(3600000,param.getTempsApparution())
            {
                @Override
                public void onTick(long l) {
                     if (nbAppCourent>=param.getNbApparution()){
                         this.cancel();
                         this.onFinish();
                     }
                     else{
                         /**
                          * boucle qui ferme les apparitions non répondu
                          */
                         for(Button b:listeDesBoutons){
                             b.setVisibility(View.GONE);
                         }
                         /**
                          * boucle qui remplie les apparitions
                          */
                         idDesBoutonsDesApparitions=tirrageAleatoireEntre1et10(param.getNbAparitionSimultanee());
                         for(int unId:idDesBoutonsDesApparitions){
                             rendreVisibleEtDonneeValeur(listeDesBoutons.get(unId));
                         }
                     }
                }
                @Override
                public void onFinish()
                {
                    calculerScore();
                }
            }.start();



    }
    /**
     * Méthode qui tire un nombre aléatoire entre 1 et 10
     * @return tableau de x entier entre 1 et 10
     * @param x nombre d'entier que doit contenir le tableau retourner par cette méthode
     */
    private ArrayList<Integer> tirrageAleatoireEntre1et10(int x){
        ArrayList<Integer> tab = new ArrayList <> (x);
        int length = 0;

        while (length < x)
        {
            int n = (int) (Math.random() * 9 + 1);
            if (!tab.contains(n))
            {
                tab.add(n);
                length += 1;
            }
        }


        return tab;
    }

    /**
     * Méthode qui tire un nombre aléatoire entre 1 et le nombre mit en paramêtre
     * @return entier entre 1 et le nombre mit en paramêtre
     */
    public static int tirageAleatoireEntre1EtLeNombreMitEnParam(int p){
        int num = (int)Math.random()*(p-1)+1;
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

        nbAppCourent++;
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
