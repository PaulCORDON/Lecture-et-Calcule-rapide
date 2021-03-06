package com.projet4a.ensim.lecture_et_calcule_rapide.CalculRapide.Activity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.projet4a.ensim.lecture_et_calcule_rapide.CalculRapide.Model.ParamEm1;
import com.projet4a.ensim.lecture_et_calcule_rapide.R;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class ModifParamEm1Activity extends AppCompatActivity {

    static ParamEm1 param = new ParamEm1();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        /**
         * Pour récupérer les parametres déja sérialisés
         */
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

        setContentView(R.layout.activity_modif_param_em1);

        /**Radiobutton qui est coché si on veut que l'exercice se fasse avec une frise*/
        final RadioButton rbFrise = findViewById(R.id.RbFrise);
        /**Radiobutton qui est coché si on veut que l'exercice se fasse avec des boutons*/
        final RadioButton rbButton = findViewById(R.id.RbButton);


        /** TextView des titres du paramètre nombre de boutton et nombre de bornes */
        final TextView titreNbBouttons = findViewById(R.id.TitreNbButtons);
        final TextView titreNbBornes = findViewById(R.id.TitreNbBornes);

        /** Radiobuttons qui correspondent au nombre de boutons de l'exo si on fait des boutons*/
        final RadioButton DeuxButtons = findViewById(R.id.Rb2Buttons);
        final RadioButton TroisButtons = findViewById(R.id.Rb3Buttons);

        /** seekBar qui stocke le nombre de bornes de la phrise */
        final RadioButton UneBornes = findViewById(R.id.ChoixNbBornes1);
        final RadioButton DeuxBornes = findViewById(R.id.ChoixNbBornes2);
        final RadioButton TroisBornes = findViewById(R.id.ChoixNbBornes3);


        /** EditText qui stocke le nombre de questions de l'exercice */
        final EditText nbQuestions = findViewById(R.id.ChoixNbQuestions);


        /** radioButton qui permet de savoir si on affiche le calcul avant la reponse */
        final CheckBox rb1 = findViewById(R.id.ChoixCalculAvantRep);
        /** radioButton qui permet de savoir si on affiche le choix des bornes avant le calcul, rb1 et rb2 ne peuvent pas etre vrai en meme temps*/
        final CheckBox rb2 = findViewById(R.id.ChoixRepAvantCalcul);

        /** Switch qui permet de savoir si le calcul disparait pendant le choix des reponses*/
        final Switch disparition = findViewById(R.id.ChoixDisparitionCalcul);


        /** TextView qui correspond au titre au dessus du editText pour rentrer le temps avant disparition*/
        final TextView titreTpsAvDisp = findViewById(R.id.TitreTempsAvantDisparition);

        /**EditText qui stocke le temps d'apparition de l'enonce ou des bornes*/
        final EditText TpsAvantDisp = findViewById(R.id.tempsAvantDisparition);


        /** texte rentre par le parametreur qui donne le temps de reponse donné au joueur*/
        final EditText tpsReponse = findViewById(R.id.tempsReponse);


        /** Switch qui dit si l'exercice ne traitera que des nombres pairs */
        final Switch nbPairsOnly = findViewById(R.id.ChoixNbPairs);

        /** Switch qui permet de savoir si le joueur peut choisir une borne en reponse*/
        final Switch bornesSelectionnables = findViewById(R.id.ChoixBornesSelectionnables);

        /** Switch qui permet de savoir si les reponses peuvent etre les bornes elles-memes*/
        final Switch bornesEgalesOp = findViewById(R.id.ChoixBornesEgalesRep);


        /** Texte rentré par le parametreur qui donne la valeur max utilisee dans l'exercice*/
        final EditText valMax = findViewById(R.id.ValeurMax);


        /**Si cette checkBox est cochee les calculs comporteront des additions*/
        final CheckBox addition = findViewById(R.id.addition);
        /**Si cette checkBox est cochee les calculs comporteront des soustractions*/
        final CheckBox soustraction = findViewById(R.id.soustraction);
        /**Si cette checkBox est cochee les calculs comporteront des divisions*/
        final CheckBox division = findViewById(R.id.division);
        /**Si cette checkBox est cochee les calculs comporteront des multiplications*/
        final CheckBox multiplication = findViewById(R.id.multiplication);

        /** tableau de booleens qui stockera plus tard les reponses des checkBoxs concernant les operations (addition, soustraction, division, multiplication)*/
        final Boolean[] operateurs = new Boolean[4];


        /** Bouton qui permet de valider les parametres et de retourner sur la page d'accueil*/
        Button valider = findViewById(R.id.BoutonValider);


        /**
         * debut affichage des paramètres
         */
        if (param.getFrise()) {
            rbFrise.setChecked(true);
            titreNbBouttons.setVisibility(View.GONE);
            DeuxButtons.setVisibility(View.GONE);
            TroisButtons.setVisibility(View.GONE);

            switch (param.getNbBornes()) {
                case 1:
                    UneBornes.setChecked(true);
                    break;
                case 2:
                    DeuxBornes.setChecked(true);
                    break;
                case 3:
                    TroisBornes.setChecked(true);
                    break;
            }
        } else {
            rbButton.setChecked(true);
            titreNbBornes.setVisibility(View.GONE);
            UneBornes.setVisibility(View.GONE);
            DeuxBornes.setVisibility(View.GONE);
            TroisBornes.setVisibility(View.GONE);
            bornesSelectionnables.setVisibility(View.GONE);
            bornesEgalesOp.setVisibility(View.GONE);

            DeuxButtons.setChecked(param.getNbBornes() == 1);
            TroisButtons.setChecked(param.getNbBornes() == 2);
        }

        nbQuestions.setText("" + param.getNbQuestions());

        if (param.getOrdreApparition()) rb1.setChecked(true);
        else rb2.setChecked(true);

        if (param.getDisparition()) {
            disparition.setChecked(true);
            TpsAvantDisp.setText("" + param.getTempsRestantApparant() / 1000);
        } else {
            disparition.setChecked(false);
            TpsAvantDisp.setVisibility(View.GONE);
        }

        tpsReponse.setText("" + param.getTempsRep() / 1000);

        nbPairsOnly.setChecked(param.getPairOnly());

        valMax.setText("" + param.getValMax());

        addition.setChecked(param.getOperateur()[0]);
        soustraction.setChecked(param.getOperateur()[1]);
        multiplication.setChecked(param.getOperateur()[2]);
        division.setChecked(param.getOperateur()[3]);

        bornesSelectionnables.setChecked(param.getBorneSelectionnable());

        bornesEgalesOp.setChecked(param.getBorneEqualsOp());
        /**
         * fin de l'affichage des parametres
         */

        disparition.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (disparition.isChecked()) {
                    titreTpsAvDisp.setVisibility(View.VISIBLE);
                    TpsAvantDisp.setVisibility(View.VISIBLE);
                } else {
                    titreTpsAvDisp.setVisibility(View.GONE);
                    TpsAvantDisp.setVisibility(View.GONE);
                }
            }
        });

        rb1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (rb1.isChecked()) {
                    disparition.setVisibility(View.VISIBLE);
                    rb2.setChecked(false);
                } else {
                    disparition.setVisibility(View.GONE);
                }
            }
        });

        rb2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (rb2.isChecked()) {
                    disparition.setVisibility(View.VISIBLE);
                    rb1.setChecked(false);
                } else {
                    disparition.setVisibility(View.GONE);
                }
            }
        });

        /**
         * ici, c'est quand on clique sur valider, on vérifie tous les parametres rentrés et on appelle le constructeur
         */
        valider.setOnClickListener(new View.OnClickListener() {
            @Override
            /** si le bouton valider a ete cliqué on rentre dans cette methode*/
            public void onClick(View view) {
                boolean parametresCorrects = true;

                long tpsAvDisp;
                int nbQuest;
                boolean ExoFrise;
                long tpsRep;
                int valeurMax;
                int nbBornes = 0;

                if (rbFrise.isChecked()) ExoFrise = true;
                else ExoFrise = false;

                /**
                 * Si on utilise une frise dans l'exercice on prend les parametre qui y sont associés
                 */
                if (ExoFrise) {
                    if (UneBornes.isChecked()) {
                        nbBornes = 1;
                    }
                    if (DeuxBornes.isChecked()) {
                        nbBornes = 2;
                    }
                    if (TroisBornes.isChecked()) {
                        nbBornes = 3;
                    }
                }
                /**
                 * Si on utilise des boutons dans l'exercice on prend les parametre qui y sont associés
                 */
                else {
                    if (DeuxButtons.isChecked()) nbBornes = 1;
                    if (TroisButtons.isChecked()) nbBornes = 2;
                }

                if (!TpsAvantDisp.getText().toString().equals(""))
                    tpsAvDisp = Long.parseLong(TpsAvantDisp.getText().toString()) * 1000;
                else tpsAvDisp = param.getTempsRestantApparant();

                if (!nbQuestions.getText().toString().equals(""))
                    nbQuest = Integer.parseInt(nbQuestions.getText().toString());
                else nbQuest = param.getNbQuestions();

                if (!tpsReponse.getText().toString().equals(""))
                    tpsRep = Long.parseLong(tpsReponse.getText().toString()) * 1000;
                else tpsRep = param.getTempsRep();

                if (!valMax.getText().toString().equals(""))
                    valeurMax = Integer.parseInt(valMax.getText().toString());
                else valeurMax = param.getValMax();

                /** Booleen qui est vrai si on affiche le calcul avant la reponse et faux si on affiches les reponses avant le calcul */
                Boolean ordreApparition = true;
                if (rb1.isChecked()) {
                    ordreApparition = true;
                }
                if (rb2.isChecked()) {
                    ordreApparition = false;
                }

                /**on stocke les booleens correspondant aux operations dans le tableau*/
                operateurs[0] = addition.isChecked();
                operateurs[1] = soustraction.isChecked();
                operateurs[2] = multiplication.isChecked();
                operateurs[3] = division.isChecked();
                Log.w("operateur choisis : ", "+" + operateurs[0] + "-" + operateurs[1] + "*" + operateurs[2] + "/" + operateurs[3]);

                if (tpsAvDisp <= tpsRep - 1000 && (operateurs[0] || operateurs[1] || operateurs[2] || operateurs[3]) && nbBornes != 0) {
                    param = new ParamEm1(
                            ExoFrise,
                            tpsRep,
                            nbPairsOnly.isChecked(),
                            operateurs,
                            nbBornes,
                            nbQuest,
                            disparition.isChecked(),
                            tpsAvDisp,
                            ordreApparition,
                            bornesSelectionnables.isChecked(),
                            bornesEgalesOp.isChecked(),
                            valeurMax);

                    Log.i("info", "frise ou pas:" + ExoFrise + "\ntps avant disparition:" + param.getTempsRestantApparant() + "\ntps reponse: " + param.getTempsRep() + "\nnbs pairs seulement: " + param.getPairOnly() + "\noperateurs: " + param.getOperateur()[0] + param.getOperateur()[1] + param.getOperateur()[2] + param.getOperateur()[3] + "\nnb bornes: " + param.getNbBornes() +
                            "\nnb questions: " + param.getNbQuestions() + "\ndisparition du calcul: " + param.getDisparition() + "\nordre apparition: " + param.getOrdreApparition() +
                            "\nbornes selectionnables: " + param.getBorneSelectionnable() + "\nbornes egales reponses: " + param.getBorneEqualsOp() + "\nvaleur max: " + param.getValMax());

                } else {
                    parametresCorrects = false;
                    if (tpsAvDisp > tpsRep - 1000) {
                        TpsAvantDisp.setTextColor(Color.RED);

                        Toast.makeText(ModifParamEm1Activity.this, "Le temps avant la disparition du calcul doit être plus petit", Toast.LENGTH_SHORT).show();
                    }
                    if (!operateurs[0] && !operateurs[1] && !operateurs[2] && !operateurs[3]) {
                        Toast.makeText(ModifParamEm1Activity.this, "Selectionne au moins un opérateur", Toast.LENGTH_SHORT).show();

                        addition.setTextColor(Color.RED);
                        soustraction.setTextColor(Color.RED);
                        multiplication.setTextColor(Color.RED);
                        division.setTextColor(Color.RED);
                    }
                    if (nbBornes == 0){
                        if(ExoFrise) Toast.makeText(ModifParamEm1Activity.this, "Selectionne un nombre de bornes", Toast.LENGTH_SHORT).show();
                        else Toast.makeText(ModifParamEm1Activity.this, "Selectionne un nombre de boutons", Toast.LENGTH_SHORT).show();

                        UneBornes.setTextColor(Color.RED);
                        DeuxBornes.setTextColor(Color.RED);
                        TroisBornes.setTextColor(Color.RED);

                        DeuxButtons.setTextColor(Color.RED);
                        TroisButtons.setTextColor(Color.RED);
                    }
                }

                if (parametresCorrects) {
                    FileOutputStream outputStream;
                    ObjectOutputStream oos;
                    try {
                        outputStream = openFileOutput("ParamEm1.txt", Context.MODE_PRIVATE);
                        oos = new ObjectOutputStream(outputStream);
                        oos.writeObject(param);

                        oos.flush();
                        oos.close();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                    /** quand on a clique sur le bouton valider on reviens au menu*/
                    finish();
                }
            }
        });

        View.OnClickListener retourEcritEnNoir = (new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                addition.setTextColor(Color.BLACK);
                soustraction.setTextColor(Color.BLACK);
                division.setTextColor(Color.BLACK);
                multiplication.setTextColor(Color.BLACK);
            }
        });

        TpsAvantDisp.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                TpsAvantDisp.setTextColor(Color.BLACK);
            }
        });

        addition.setOnClickListener(retourEcritEnNoir);
        soustraction.setOnClickListener(retourEcritEnNoir);
        division.setOnClickListener(retourEcritEnNoir);
        multiplication.setOnClickListener(retourEcritEnNoir);

        rbFrise.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (rbFrise.isChecked()) {
                    titreNbBornes.setVisibility(View.VISIBLE);
                    UneBornes.setVisibility(View.VISIBLE);
                    DeuxBornes.setVisibility(View.VISIBLE);
                    TroisBornes.setVisibility(View.VISIBLE);
                    bornesSelectionnables.setVisibility(View.VISIBLE);
                    bornesEgalesOp.setVisibility(View.VISIBLE);

                    titreNbBouttons.setVisibility(View.GONE);
                    DeuxButtons.setVisibility(View.GONE);
                    TroisButtons.setVisibility(View.GONE);
                } else {
                    titreNbBornes.setVisibility(View.GONE);
                    UneBornes.setVisibility(View.GONE);
                    DeuxBornes.setVisibility(View.GONE);
                    TroisBornes.setVisibility(View.GONE);
                    bornesSelectionnables.setVisibility(View.GONE);
                    bornesEgalesOp.setVisibility(View.GONE);
                }
                rbButton.setChecked(false);
            }
        });

        rbButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (rbButton.isChecked()) {
                    titreNbBouttons.setVisibility(View.VISIBLE);
                    DeuxButtons.setVisibility(View.VISIBLE);
                    TroisButtons.setVisibility(View.VISIBLE);

                    titreNbBornes.setVisibility(View.GONE);
                    UneBornes.setVisibility(View.GONE);
                    DeuxBornes.setVisibility(View.GONE);
                    TroisBornes.setVisibility(View.GONE);
                    bornesSelectionnables.setVisibility(View.GONE);
                    bornesEgalesOp.setVisibility(View.GONE);
                } else {
                    titreNbBouttons.setVisibility(View.GONE);
                    DeuxButtons.setVisibility(View.GONE);
                    TroisButtons.setVisibility(View.GONE);
                }
                rbFrise.setChecked(false);
            }
        });

        UneBornes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DeuxBornes.setChecked(false);
                TroisBornes.setChecked(false);

                UneBornes.setTextColor(Color.BLACK);
                DeuxBornes.setTextColor(Color.BLACK);
                TroisBornes.setTextColor(Color.BLACK);
            }
        });

        DeuxBornes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                UneBornes.setChecked(false);
                TroisBornes.setChecked(false);

                UneBornes.setTextColor(Color.BLACK);
                DeuxBornes.setTextColor(Color.BLACK);
                TroisBornes.setTextColor(Color.BLACK);
            }
        });

        TroisBornes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                UneBornes.setChecked(false);
                DeuxBornes.setChecked(false);

                UneBornes.setTextColor(Color.BLACK);
                DeuxBornes.setTextColor(Color.BLACK);
                TroisBornes.setTextColor(Color.BLACK);
            }
        });

        DeuxButtons.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TroisButtons.setChecked(false);

                DeuxButtons.setTextColor(Color.BLACK);
                TroisButtons.setTextColor(Color.BLACK);
            }
        });

        TroisButtons.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DeuxButtons.setChecked(false);

                DeuxButtons.setTextColor(Color.BLACK);
                TroisButtons.setTextColor(Color.BLACK);
            }
        });
    }
}
