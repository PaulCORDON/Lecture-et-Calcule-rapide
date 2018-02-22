package com.projet4a.ensim.lecture_et_calcule_rapide.CalculRapide.Activity;


import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.Switch;
import android.widget.TextView;

import com.projet4a.ensim.lecture_et_calcule_rapide.CalculRapide.Model.ParamEm1;
import com.projet4a.ensim.lecture_et_calcule_rapide.R;
import com.xw.repo.BubbleSeekBar;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class ModifParamEm1Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modif_param_em1);

        /**Radiobutton qui est coché si on veut que l'exercice se fasse avec une frise*/
        final RadioButton rbFrise= findViewById(R.id.RbFrise);

        /**Radiobutton qui est coché si on veut que l'exercice se fasse avec une frise*/
        final RadioButton rbButton= findViewById(R.id.RbButton);

        /**EditText qui stocke le temps d'apparition de l'enonce ou des bornes*/
        final EditText TpsAvantDisp= findViewById(R.id.tempsAvantDisparition);
        TpsAvantDisp.setVisibility(View.GONE);

        /** TextView qui correspond au titre au dessus du editText pour rentrer le temps avant disparition*/
        final TextView titreTpsAvDisp=  findViewById(R.id.TitreTempsAvantDisparition);
        titreTpsAvDisp.setVisibility(View.GONE);

        /** seekBar qui stocke le nombre de bornes de la phrise */
        final BubbleSeekBar nbBornes=  findViewById(R.id.ChoixNbBornes);

        /** EditText qui stocke le nombre de questions de l'exercice */
        final EditText nbQuestions=  findViewById(R.id.ChoixNbQuestions);

        /** radioButton qui permet de savoir si on affiche le calcul avant la reponse */
        final CheckBox rb1= findViewById(R.id.ChoixCalculAvantRep);

        /** radioButton qui permet de savoir si on affiche le choix des reponses avant le calcul, rb1 et rb2 ne peuvent pas etre vrai en meme temps*/
        final CheckBox rb2=findViewById(R.id.ChoixRepAvantCalcul);


        /** Switch qui permet de savoir si le calcul disparait pendant le choix des reponses*/
        final Switch disparition=  findViewById(R.id.ChoixDisparitionCalcul);
        disparition.setVisibility(View.GONE);

        /** Switch qui permet de savoir si le joueur peut choisir une borne en reponse*/
        final Switch bornesSelectionnables=  findViewById(R.id.ChoixBornesSelectionnables);

        /** Switch qui permet de savoir si les reponses peuvent etre les bornes elles-memes*/
        final Switch bornesEgalesReps= findViewById(R.id.ChoixBornesEgalesRep);

        /** Texte rentré par le parametreur qui donne la valeur max utilisee dans l'exercice*/
        final EditText valMax=  findViewById(R.id.ValeurMax);

        /** texte rentre par le parametreur qui donne le temps de reponse donné au joueur*/
        final EditText tpsReponse=  findViewById(R.id.tempsReponse);

        /** Switch qui dit si l'exercice ne traitera que des nombres pairs */
        final Switch nbPairsOnly=  findViewById(R.id.ChoixNbPairs);

        /**Si cette checkBox est cochee les calculs comporteront des additions*/
        final CheckBox addition=  findViewById(R.id.addition);

        /**Si cette checkBox est cochee les calculs comporteront des soustractions*/
        final CheckBox soustraction=  findViewById(R.id.soustraction);

        /**Si cette checkBox est cochee les calculs comporteront des divisions*/
        final CheckBox division= findViewById(R.id.division);

        /**Si cette checkBox est cochee les calculs comporteront des multiplications*/
        final CheckBox multiplication=  findViewById(R.id.multiplication);

        /** tableau de booleens qui stockera plus tard les reponses des checkBoxs concernant les operations (addition, soustraction, division, multiplication)*/
        final Boolean[] operateurs= new Boolean[5];

        /** Bouton qui permet de valider les parametres et de retourner sur la page d'accueil*/
        Button valider=  findViewById(R.id.BoutonValider);

        /** Colonne qui comprend les parametres pour l'exercice avec une frise*/
        final LinearLayout colonneFrise=  findViewById(R.id.ColonneFrise);
        colonneFrise.setVisibility(View.GONE);

        /** Colonne qui comprend les parametres pour l'exercice avec des boutons*/
        final LinearLayout colonneButton=  findViewById(R.id.ColonneButton);
        colonneButton.setVisibility(View.GONE);

        rbFrise.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(rbFrise.isChecked()) {
                   colonneFrise.setVisibility(View.VISIBLE);
                   colonneButton.setVisibility(View.GONE);

                }
                else {
                    colonneFrise.setVisibility(View.GONE);
                }
            }
        });

        rbButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(rbButton.isChecked()) {
                    colonneButton.setVisibility(View.VISIBLE);
                    colonneFrise.setVisibility(View.GONE);

                }
                else {
                    colonneButton.setVisibility(View.GONE);
                }
            }
        });


        disparition.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(disparition.isChecked()) {
                    titreTpsAvDisp.setVisibility(View.VISIBLE);
                    TpsAvantDisp.setVisibility(View.VISIBLE);
                }
                else{
                    titreTpsAvDisp.setVisibility(View.GONE);
                    TpsAvantDisp.setVisibility(View.GONE);
                }
            }
        });



        rb1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(rb1.isChecked()) {
                    disparition.setVisibility(View.VISIBLE);
                    rb2.setChecked(false);

                }
                else {
                    disparition.setVisibility(View.GONE);
                }


            }
        });

        rb2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(rb2.isChecked()) {
                    disparition.setVisibility(View.VISIBLE);
                    rb1.setChecked(false);

                }
                else{
                    disparition.setVisibility(View.GONE);

                }
            }
        });


        valider.setOnClickListener(new View.OnClickListener() {
            @Override
            /** si le bouton valider a ete cliqué on rentre dans cette methode*/
            public void onClick(View view) {

                long tpsAvDisp;
                int nbQuest;
                boolean ExoFrise;
                long tpsRep;
                int valeurMax;

                if(rbFrise.isChecked())ExoFrise=true;
                else ExoFrise=false;

                if (!TpsAvantDisp.getText().toString().equals(""))tpsAvDisp=Long.parseLong(TpsAvantDisp.getText().toString())*1000;
                else tpsAvDisp=5000;

                if(!nbQuestions.getText().toString().equals(""))  nbQuest=Integer.parseInt(nbQuestions.getText().toString());
                else nbQuest=5;

                if(!tpsReponse.getText().toString().equals("")) tpsRep=Long.parseLong(tpsReponse.getText().toString())*1000;
                else tpsRep=10000;

                if(!valMax.getText().toString().equals("")) valeurMax=Integer.parseInt(valMax.getText().toString());
                else valeurMax=50;


                /** Booleen qui est vrai si on affiche le calcul avant la reponse et faux si on affiches les reponses avant le calcul */
                Boolean ordreApparition=true;
                if(rb1.isChecked()){
                    ordreApparition=true;
                }
                if(rb2.isChecked()){
                    ordreApparition=false;
                }

                /**on stocke les booleens correspondant aux operations dans le tableau*/
                operateurs[0]=addition.isChecked();
                operateurs[1]=soustraction.isChecked();
                operateurs[2]=multiplication.isChecked();
                operateurs[3]=division.isChecked();

                ParamEm1 param = null;


                if(ExoFrise) {
                    /**
                     * Si on utilise une frise dans l'exercice on prend les parametre qui y sont assocés
                     */
                    param = new ParamEm1(
                            ExoFrise,
                            tpsRep,
                            nbPairsOnly.isChecked(),
                            operateurs,
                            nbBornes.getProgress(),
                            nbQuest,
                            disparition.isChecked(),
                            tpsAvDisp,
                            ordreApparition,
                            bornesSelectionnables.isChecked(),
                            bornesEgalesReps.isChecked(),
                            valeurMax);

                    Log.i("info", "frise ou pas:" + ExoFrise + "\ntps avant disparition:" + param.getTempsRestantApparant() + "\ntps reponse: " + param.getTempsRep() + "\nnbs pairs seulement: " + param.getPairOnly() + "\noperateurs: " + param.getOperateur()[0] + param.getOperateur()[1] + param.getOperateur()[2] + param.getOperateur()[3] + "\nnb bornes: " + param.getNbBornes() +
                            "\nnb questions: " + param.getNbQuestions() + "\ndisparition du calcul: " + param.getDisparition() + "\nordre apparition: " + param.getOrdreApparition() +
                            "\nbornes selectionnables: " + param.getBorneSelectionnable() + "\nbornes egales reponses: " + param.getBorneEqualsOp() + "\nvaleur max: " + param.getValMax());
                }

                if(!ExoFrise){




                }



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
                Intent intent=new Intent(ModifParamEm1Activity.this, MathsActivity.class);
                startActivity(intent);
            }

        });





    }
}
