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
import android.widget.LinearLayout;
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

        /**EditText qui stocke le temps d'apparition de l'enonce ou des bornes*/
        final EditText TpsAvantDisp = findViewById(R.id.tempsAvantDisparition);
        final EditText TpsAvantDispB = findViewById(R.id.tempsAvantDisparitionB);

        /** TextView qui correspond au titre au dessus du editText pour rentrer le temps avant disparition*/
        final TextView titreTpsAvDisp = findViewById(R.id.TitreTempsAvantDisparition);
        final TextView titreTpsAvDispB = findViewById(R.id.TitreTempsAvantDisparitionB);

        /** Radiobuttons qui correspondent au nombre de boutons de l'exo si on fait des boutons*/
        final RadioButton DeuxButtons = findViewById(R.id.Rb2Buttons);
        final RadioButton TroisButtons = findViewById(R.id.Rb3Buttons);

        /** seekBar qui stocke le nombre de bornes de la phrise */
        final RadioButton UneBornes = findViewById(R.id.ChoixNbBornes1);
        final RadioButton DeuxBornes = findViewById(R.id.ChoixNbBornes2);
        final RadioButton TroisBornes = findViewById(R.id.ChoixNbBornes3);

        /** EditText qui stocke le nombre de questions de l'exercice */
        final EditText nbQuestions = findViewById(R.id.ChoixNbQuestions);
        final EditText nbQuestionsB = findViewById(R.id.ChoixNbQuestionsB);

        /** radioButton qui permet de savoir si on affiche le calcul avant la reponse */
        final CheckBox rb1 = findViewById(R.id.ChoixCalculAvantRep);
        final CheckBox rb1B = findViewById(R.id.ChoixCalculAvantRepB);

        /** radioButton qui permet de savoir si on affiche le choix des reponses avant le calcul, rb1 et rb2 ne peuvent pas etre vrai en meme temps*/
        final CheckBox rb2 = findViewById(R.id.ChoixRepAvantCalcul);
        final CheckBox rb2B = findViewById(R.id.ChoixRepAvantCalculB);

        /** Switch qui permet de savoir si le calcul disparait pendant le choix des reponses*/
        final Switch disparition = findViewById(R.id.ChoixDisparitionCalcul);
        final Switch disparitionB = findViewById(R.id.ChoixDisparitionCalculB);

        /** Switch qui permet de savoir si le joueur peut choisir une borne en reponse*/
        final Switch bornesSelectionnables = findViewById(R.id.ChoixBornesSelectionnables);

        /** Switch qui permet de savoir si les reponses peuvent etre les bornes elles-memes*/
        final Switch bornesEgalesOp = findViewById(R.id.ChoixBornesEgalesRep);

        /** Texte rentré par le parametreur qui donne la valeur max utilisee dans l'exercice*/
        final EditText valMax = findViewById(R.id.ValeurMax);
        final EditText valMaxB = findViewById(R.id.ValeurMaxB);

        /** texte rentre par le parametreur qui donne le temps de reponse donné au joueur*/
        final EditText tpsReponse = findViewById(R.id.tempsReponse);
        final EditText tpsReponseB = findViewById(R.id.tempsReponseB);

        /** Switch qui dit si l'exercice ne traitera que des nombres pairs */
        final Switch nbPairsOnly = findViewById(R.id.ChoixNbPairs);
        final Switch nbPairsOnlyB = findViewById(R.id.ChoixNbPairsB);

        /**Si cette checkBox est cochee les calculs comporteront des additions*/
        final CheckBox addition = findViewById(R.id.addition);
        final CheckBox additionB = findViewById(R.id.additionB);

        /**Si cette checkBox est cochee les calculs comporteront des soustractions*/
        final CheckBox soustraction = findViewById(R.id.soustraction);
        final CheckBox soustractionB = findViewById(R.id.soustractionB);

        /**Si cette checkBox est cochee les calculs comporteront des divisions*/
        final CheckBox division = findViewById(R.id.division);
        final CheckBox divisionB = findViewById(R.id.divisionB);

        /**Si cette checkBox est cochee les calculs comporteront des multiplications*/
        final CheckBox multiplication = findViewById(R.id.multiplication);
        final CheckBox multiplicationB = findViewById(R.id.multiplicationB);

        /** tableau de booleens qui stockera plus tard les reponses des checkBoxs concernant les operations (addition, soustraction, division, multiplication)*/
        final Boolean[] operateurs = new Boolean[4];
        final Boolean[] operateursB = new Boolean[4];

        /** Bouton qui permet de valider les parametres et de retourner sur la page d'accueil*/
        Button valider = findViewById(R.id.BoutonValider);

        /** Colonne qui comprend les parametres pour l'exercice avec une frise*/
        final LinearLayout colonneFrise = findViewById(R.id.ColonneFrise);

        /** Colonne qui comprend les parametres pour l'exercice avec des boutons*/
        final LinearLayout colonneButton = findViewById(R.id.ColonneButton);

        /**
         * debut affichage des paramètres
         */
        if (param.getFrise()) {
            rbFrise.setChecked(true);
            colonneButton.setVisibility(View.GONE);
        } else {
            rbButton.setChecked(true);
            colonneFrise.setVisibility(View.GONE);
        }
        //Param frise
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

        switch(param.getNbBornes()){
            case 1 :
                UneBornes.setChecked(true);
                break;
            case 2 :
                DeuxBornes.setChecked(true);
                break;
            case 3 :
                TroisBornes.setChecked(true);
                break;
        }

        bornesSelectionnables.setChecked(param.getBorneSelectionnable());

        bornesEgalesOp.setChecked(param.getBorneEqualsOp());

        //Param bouton
        nbQuestionsB.setText("" + param.getNbQuestions());

        if (param.getOrdreApparition()) rb1B.setChecked(true);
        else rb2B.setChecked(true);

        if (param.getDisparition()) {
            disparitionB.setChecked(true);
            TpsAvantDispB.setText("" + param.getTempsRestantApparant() / 1000);
        } else {
            disparitionB.setChecked(false);
            TpsAvantDispB.setVisibility(View.GONE);
        }

        tpsReponseB.setText("" + param.getTempsRep() / 1000);

        nbPairsOnlyB.setChecked(param.getPairOnly());

        valMaxB.setText("" + param.getValMax());

        additionB.setChecked(param.getOperateur()[0]);
        soustractionB.setChecked(param.getOperateur()[1]);
        multiplicationB.setChecked(param.getOperateur()[2]);
        divisionB.setChecked(param.getOperateur()[3]);

        DeuxButtons.setChecked(param.getNbBornes() == 1);
        TroisButtons.setChecked(param.getNbBornes() == 2);
        /**
         * fin de l'affichage des parametres
         */

        rbFrise.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (rbFrise.isChecked()) {
                    colonneFrise.setVisibility(View.VISIBLE);
                    colonneButton.setVisibility(View.GONE);
                } else {
                    colonneFrise.setVisibility(View.GONE);
                }
            }
        });

        rbButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (rbButton.isChecked()) {
                    colonneButton.setVisibility(View.VISIBLE);
                    colonneFrise.setVisibility(View.GONE);
                } else {
                    colonneButton.setVisibility(View.GONE);
                }
            }
        });

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

        disparitionB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (disparitionB.isChecked()) {
                    titreTpsAvDispB.setVisibility(View.VISIBLE);
                    TpsAvantDispB.setVisibility(View.VISIBLE);
                } else {
                    titreTpsAvDispB.setVisibility(View.GONE);
                    TpsAvantDispB.setVisibility(View.GONE);
                }
            }
        });

        rb1B.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (rb1B.isChecked()) {
                    disparitionB.setVisibility(View.VISIBLE);
                    rb2B.setChecked(false);
                } else {
                    disparitionB.setVisibility(View.GONE);
                }
            }
        });

        rb2B.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (rb2B.isChecked()) {
                    disparitionB.setVisibility(View.VISIBLE);
                    rb1B.setChecked(false);
                } else {
                    disparitionB.setVisibility(View.GONE);
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
                int nbBoutons;
                int nombreDeBornes = 1;

                if (rbFrise.isChecked()) ExoFrise = true;
                else ExoFrise = false;

                /**
                 * Si on utilise une frise dans l'exercice on prend les parametre qui y sont associés
                 */
                if (ExoFrise) {
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

                    if(UneBornes.isChecked()){nombreDeBornes=1;}
                    if(DeuxBornes.isChecked()){nombreDeBornes=2;}
                    if(TroisBornes.isChecked()){nombreDeBornes=3;}



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
                    Log.w("operateur choisis : " , "+" +operateurs[0]+ "-" +operateurs[1]+ "*" +operateurs[2]+ "/" + operateurs[3]);

                    if( tpsAvDisp <= tpsRep-1000 && (operateurs[0] || operateurs[1] || operateurs[2] || operateurs[3])){
                        param = new ParamEm1(
                                ExoFrise,
                                tpsRep,
                                nbPairsOnly.isChecked(),
                                operateurs,
                                nombreDeBornes, /////////////////////////////////////////////////
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

                    }
                    else {
                        parametresCorrects = false;
                        if (tpsAvDisp > tpsRep-1000) {
                            TpsAvantDisp.setTextColor(Color.RED);

                            Toast.makeText(ModifParamEm1Activity.this,"Le temps avant la disparition du calcul doit être plus petit",Toast.LENGTH_SHORT).show();

                        }
                        if (!operateurs[0] && !operateurs[1] && !operateurs[2] && !operateurs[3]) {
                            Toast.makeText(ModifParamEm1Activity.this,"Selectionne au moins un opérateur",Toast.LENGTH_SHORT).show();

                            addition.setTextColor(Color.RED);
                            soustraction.setTextColor(Color.RED);
                            multiplication.setTextColor(Color.RED);
                            division.setTextColor(Color.RED);
                        }
                    }
                }

                /**
                 * Si on utilise des boutons dans l'exercice on prend les parametre qui y sont associés
                 */
                if (!ExoFrise) {
                    if (!TpsAvantDispB.getText().toString().equals(""))
                        tpsAvDisp = Long.parseLong(TpsAvantDispB.getText().toString()) * 1000;
                    else tpsAvDisp = param.getTempsRestantApparant();

                    if (!nbQuestionsB.getText().toString().equals(""))
                        nbQuest = Integer.parseInt(nbQuestionsB.getText().toString());
                    else nbQuest = param.getNbQuestions();

                    if (!tpsReponseB.getText().toString().equals(""))
                        tpsRep = Long.parseLong(tpsReponseB.getText().toString()) * 1000;
                    else tpsRep = param.getTempsRep();

                    if (!valMaxB.getText().toString().equals(""))
                        valeurMax = Integer.parseInt(valMaxB.getText().toString());
                    else valeurMax = param.getValMax();

                    if (DeuxButtons.isChecked()) nbBoutons = 1;
                    else if (TroisButtons.isChecked()) nbBoutons = 2;
                    else nbBoutons = 1;

                    /** Booleen qui est vrai si on affiche le calcul avant la reponse et faux si on affiches les reponses avant le calcul */
                    Boolean ordreApparition = true;
                    if (rb1B.isChecked()) {
                        ordreApparition = true;
                    }
                    if (rb2B.isChecked()) {
                        ordreApparition = false;
                    }

                    /**on stocke les booleens correspondant aux operations dans le tableau*/
                    operateursB[0] = additionB.isChecked();
                    operateursB[1] = soustractionB.isChecked();
                    operateursB[2] = multiplicationB.isChecked();
                    operateursB[3] = divisionB.isChecked();

                    if( tpsAvDisp <= tpsRep-1000 && (operateurs[0] || operateurs[1] || operateurs[2] || operateurs[3])){
                        param = new ParamEm1(
                                ExoFrise,
                                tpsRep,
                                nbPairsOnlyB.isChecked(),
                                operateursB,
                                nbBoutons,
                                nbQuest,
                                disparitionB.isChecked(),
                                tpsAvDisp,
                                ordreApparition,
                                false,
                                false,
                                valeurMax);

                        Log.i("info", "frise ou pas:" + ExoFrise + "\ntps avant disparition:" + param.getTempsRestantApparant() + "\ntps reponse: " + param.getTempsRep() + "\nnbs pairs seulement: " + param.getPairOnly() + "\noperateurs: " + param.getOperateur()[0] + param.getOperateur()[1] + param.getOperateur()[2] + param.getOperateur()[3] + "\nnb boutons: " + param.getNbBornes() +
                                "\nnb questions: " + param.getNbQuestions() + "\ndisparition du calcul: " + param.getDisparition() + "\nordre apparition: " + param.getOrdreApparition() +
                                "\nbornes selectionnables: " + param.getBorneSelectionnable() + "\nbornes egales reponses: " + param.getBorneEqualsOp() + "\nvaleur max: " + param.getValMax());

                    }
                    else {
                        parametresCorrects = false;
                        if (tpsAvDisp > tpsRep-1000){
                            TpsAvantDispB.setTextColor(Color.RED);

                            Toast.makeText(ModifParamEm1Activity.this,"Le temps avant la disparition du calcul doit être plus petit",Toast.LENGTH_SHORT).show();
                        }
                        if (!operateurs[0] && !operateurs[1] && !operateurs[2] && !operateurs[3]) {
                            Toast.makeText(ModifParamEm1Activity.this,"Selectionne au moins un opérateur",Toast.LENGTH_SHORT).show();

                            additionB.setTextColor(Color.RED);
                            soustractionB.setTextColor(Color.RED);
                            multiplicationB.setTextColor(Color.RED);
                            divisionB.setTextColor(Color.RED);
                        }
                    }

                }

                if(parametresCorrects) {
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
                    Intent intent = new Intent(ModifParamEm1Activity.this, MathsActivity.class);
                    startActivity(intent);
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

                additionB.setTextColor(Color.BLACK);
                soustractionB.setTextColor(Color.BLACK);
                divisionB.setTextColor(Color.BLACK);
                multiplicationB.setTextColor(Color.BLACK);
            }
        });

        TpsAvantDisp.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                TpsAvantDisp.setTextColor(Color.BLACK);
            }
        });

        TpsAvantDispB.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                TpsAvantDispB.setTextColor(Color.BLACK);
            }
        });

        addition.setOnClickListener(retourEcritEnNoir);
        soustraction.setOnClickListener(retourEcritEnNoir);
        division.setOnClickListener(retourEcritEnNoir);
        multiplication.setOnClickListener(retourEcritEnNoir);

        additionB.setOnClickListener(retourEcritEnNoir);
        soustractionB.setOnClickListener(retourEcritEnNoir);
        divisionB.setOnClickListener(retourEcritEnNoir);
        multiplicationB.setOnClickListener(retourEcritEnNoir);

    }
}
