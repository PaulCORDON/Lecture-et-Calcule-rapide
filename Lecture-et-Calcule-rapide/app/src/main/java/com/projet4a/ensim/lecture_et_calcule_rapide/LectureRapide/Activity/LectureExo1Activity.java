package com.projet4a.ensim.lecture_et_calcule_rapide.LectureRapide.Activity;


import android.content.Intent;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.projet4a.ensim.lecture_et_calcule_rapide.LectureRapide.Model.Exo1Lecture;
import com.projet4a.ensim.lecture_et_calcule_rapide.LectureRapide.Model.ParamEl1;
import com.projet4a.ensim.lecture_et_calcule_rapide.R;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;


/**
 * Activité liée à l'affichage : activity lecture exo 1
 */
public class LectureExo1Activity extends AppCompatActivity {

    /**
     * Compteur du nombre d'apparition de l'énoncé pendant l'exercice
     */
    int nbAppDeEnonce = 0;

    /**
     * Compteur du nombre de bonnes réponses données par l'élève
     */
    int nbBonneRep = 0;

    /**
     * Compteur du nombre de mauvaises réponses données par l'élève
     */
    int nbMauvaiseRep = 0;

    /**
     * Variable servant pour le temps
     */

    int nbAppCourent = 0;
    Exo1Lecture exo;
    ParamEl1 param = new ParamEl1();

    Button rep1;
    Button rep2;
    Button rep3;
    Button rep4;
    Button rep5;
    Button rep6;
    Button rep7;
    Button rep8;
    Button rep9;
    Button rep10;
    ProgressBar scoreBar;
    ProgressBar timeBar;
    ArrayList<Button> listeDesBoutons = new ArrayList<>();
    TextView enonce;
    ArrayList<Integer> idDesBoutonsDesApparitions = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lecture_exo1);
        Log.d("EXO 1 Lecture", "Dans le on crete");
        rep1 = findViewById(R.id.Rep1);
        rep2 = findViewById(R.id.Rep2);
        rep3 = findViewById(R.id.Rep3);
        rep4 = findViewById(R.id.Rep4);
        rep5 = findViewById(R.id.Rep5);
        rep6 = findViewById(R.id.Rep6);
        rep7 = findViewById(R.id.Rep7);
        rep8 = findViewById(R.id.Rep8);
        rep9 = findViewById(R.id.Rep9);
        rep10 = findViewById(R.id.Rep10);
        scoreBar = findViewById(R.id.scoreBar);
        enonce = findViewById(R.id.EnonceLectureEx1);

        try {
            FileInputStream fis = openFileInput("ParamEl1.txt");
            ObjectInputStream ois = new ObjectInputStream(fis);
            param = (ParamEl1) ois.readObject();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            exo = new Exo1Lecture(param);
            Log.d("Dans le try", "On a cree un EXo1Lecture");
        } catch (FileNotFoundException e) {
            Log.d("Dans le catch", "On a pas réussi a cree un EXo1Lecture");
            e.printStackTrace();
        }
        Log.d("EXO 1 Lecture", "Après la désérialisation");


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
        final long tempsTotal = (param.getTempsApparution() * param.getNbApparution()) / param.getNbAparitionSimultanee();
        timeBar = findViewById(R.id.progressBar);
        timeBar.setMax((int) (param.getTempsApparution() + 0));


        /**
         * Premier CountDownTimer pour passer d'un groupe d'apparition a un autre
         */
        final CountDownTimer timer = new CountDownTimer(tempsTotal + 100, param.getTempsApparution()) {
            /**
             * A chaque tick un groupe d'apparition apparait
             * @param l
             */
            @Override
            public void onTick(long l) {

                /**
                 * Second CountDownTimer pour pouvoir incrémenté la timeBar
                 */
                final CountDownTimer t = new CountDownTimer(param.getTempsApparution(), 100) {
                    /**
                     * A chaque tick on incrémente de m la timeBar
                     * @param m
                     */
                    @Override
                    public void onTick(long m) {
                        timeBar.setProgress((int) (param.getTempsApparution() - m));
                    }

                    /**
                     * Si on a choisit de faire disparaitre l'énoncée elle disparaitra en meme temps que le premier groupe d'apparition
                     */
                    @Override
                    public void onFinish() {
                        if (param.getEnonceDisparait()) {
                            enonce.setVisibility(View.INVISIBLE);
                        }
                    }
                }.start();

                Log.d("EXO 1 Lecture", "dans le on tick");
                Log.d("Nb bonne rep", "" + nbBonneRep);
                Log.d("Nb mauvaise rep", "" + nbMauvaiseRep);
                Log.d("Nb app courrent", "" + nbAppCourent);
                if (nbAppCourent >= param.getNbApparution()) {
                    Log.d("EXO 1 Lecture", "l'exo va finir");

                    this.cancel();
                    this.onFinish();
                } else {
                    /**
                     * boucle qui ferme les apparitions non répondu
                     */
                    Log.d("EXO 1 Lecture", "on fais disparaitre le button si il n'a rien répondu");
                    rendreInvisibleEtVerifierLesBoutonsNonSelectionnes();

                    /**
                     * boucle qui remplie les apparitions
                     */
                    Log.d("EXO 1 Lecture", "On va remplir " + param.getNbAparitionSimultanee() + " apparitions");
                    idDesBoutonsDesApparitions = tirrageAleatoireEntre1et10(param.getNbAparitionSimultanee());
                    Log.d("EXO1L les id aléa sont", " " + idDesBoutonsDesApparitions);
                    for (int unId : idDesBoutonsDesApparitions) {
                        rendreVisibleEtDonneeValeur(listeDesBoutons.get(unId));
                    }
                }
            }

            /**
             * A la fin de l'exercice on lance l'activité d'affichage du score
             */
            @Override
            public void onFinish() {
                rendreInvisibleEtVerifierLesBoutonsNonSelectionnes();

                Log.d("NB BONNE REP", "" + nbBonneRep);
                Log.d("NB MAUVAISE REP", "" + nbMauvaiseRep);

                Intent intent = new Intent(LectureExo1Activity.this, ExoLecture1Resultat.class);
                intent.putExtra("nbBonneRep", nbBonneRep);
                intent.putExtra("nbAppCourent", nbAppCourent);
                startActivity(intent);

            }
        }.start();


    }


    /**
     * Méthode qui tire un nombre aléatoire entre 1 et 10
     *
     * @param x nombre d'entier que doit contenir le tableau retourner par cette méthode
     * @return tableau de x entier entre 1 et 10
     */
    private ArrayList<Integer> tirrageAleatoireEntre1et10(int x) {
        ArrayList<Integer> tab = new ArrayList<>(x);
        int length = 0;

        while (length < x) {

            int n = (int) (Math.random() * 9 + 1);
            Log.d("ALEA", " " + n);
            if (!tab.contains(n)) {
                tab.add(n);
                length += 1;
            }
        }


        return tab;
    }

    /**
     * Méthode qui tire un nombre aléatoire entre 1 et le nombre mit en paramêtre
     *
     * @return entier entre 1 et le nombre mit en paramêtre
     */
    public static int tirageAleatoireEntre1EtLeNombreMitEnParam(int p) {
        int num = (int) Math.random() * (p - 1) + 1;
        return num;
    }


    /**
     * Méthode qui tire aléatoirement en index situé entre 0 et la taille du tableau qui contient les apparitions
     *
     * @return un index aléatoire
     */
    private int tirrageAleatoireDunIndex() {
        int num = (int) (Math.random() * exo.getApparition().size());
        return num;
    }

    /**
     * Méthode qui rend visible le boutton et le remplit avec une proposition de réponse
     *
     * @param b le boutton sur lequel apparait une proposition de réponse
     */
    private void rendreVisibleEtDonneeValeur(Button b) {
        b.setText(exo.getApparition().get(tirrageAleatoireDunIndex()));
        Log.d("rendreVisible", b.getText() + " et " + enonce.getText());
        if (b.getText().equals(enonce.getText())) {
            Log.d("L'enonce est apparue", "");
            nbAppDeEnonce++;
        }
        b.setVisibility(View.VISIBLE);

        nbAppCourent++;
    }

    /**
     * Méthode qui vérifie si l'élève a donné une bonne réponse
     *
     * @param b le boutton sur lequel l'élève à répondu
     */
    private void verifierReponse(Button b) {
        Log.d("verifi rep", b.getText() + " et " + enonce.getText());
        if (b.getText().equals(enonce.getText())) {
            Log.d("BONNE REP", "");
            nbBonneRep++;
            scoreBar.setProgress(nbBonneRep * (100 / param.getNbApparution()));
        } else {
            Log.d("Mauvaise REP", "");
            nbMauvaiseRep++;
        }
    }

    /**
     * Méthode qui rend invisible le boutton pris en paramètre
     *
     * @param b un boutton qui doit disparaitre
     */
    private void rendreInvisible(Button b) {
        b.setVisibility(View.GONE);
    }


    /**
     * methode qui ferme les apparitions non répondu
     */
    private void rendreInvisibleEtVerifierLesBoutonsNonSelectionnes() {
        Log.d("EXO 1 Lecture", "on fais disparaitre le button si il n'a rien répondu");
        for (Button b : listeDesBoutons) {
            /**
             * Pour chaque boutons que l'élève n'aura pas cliquer, on regarde le texte qu'il conteint
             */
            if (b.getVisibility() == View.VISIBLE) {
                /**
                 * Si le texte est diférent de l'énoncé c'est une bonne réponce sinon c'est une fausse
                 */
                if (!b.getText().equals(enonce.getText())) {
                    nbBonneRep++;
                    scoreBar.setProgress(nbBonneRep * (100 / param.getNbApparution()));

                } else {
                    nbMauvaiseRep++;
                }
                b.setVisibility(View.GONE);
            }
        }
    }
}
