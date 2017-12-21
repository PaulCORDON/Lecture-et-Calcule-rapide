package com.projet4a.ensim.lecture_et_calcule_rapide.CalculRapide.Activity;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.autofill.AutofillValue;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.Switch;

import com.projet4a.ensim.lecture_et_calcule_rapide.CalculRapide.Model.ParamEm1;

import com.projet4a.ensim.lecture_et_calcule_rapide.LectureRapide.Activity.ModifParamEl1Activity;
import com.projet4a.ensim.lecture_et_calcule_rapide.Menu.MenuActivity;
import com.projet4a.ensim.lecture_et_calcule_rapide.R;

public class ModifParamEm1Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modif_param_em1);

        /** seekBar qui stocke le nombre de bornes de la phrise */
        final SeekBar nbBornes=  findViewById(R.id.ChoixNbBornes);

        /** seekBar qui stocke le nombre de questions de l'exercice */
        final SeekBar nbQuestions=  findViewById(R.id.ChoixNbQuestions);

        /** radioButton qui permet de savoir si on affiche le calcul avant la reponse */
        final RadioButton rb1= findViewById(R.id.ChoixCalculAvantRep);

        /** radioButton qui permet de savoir si on affiche le choix des reponses avant le calcul, rb1 et rb2 ne peuvent pas etre vrai en meme temps*/
        final RadioButton rb2=findViewById(R.id.ChoixRepAvantCalcul);

        /** Booleen qui est vrai si on affiche le calcul avant la reponse et faux si on affiches les reponses avant le calcul */
        Boolean ordreApparition=true;
        if(rb1.isChecked()){
            ordreApparition=true;
        }
        if(rb2.isChecked()){
            ordreApparition=false;
        }

        /** Booleen qui permet de stocker la valeur de ordreApparition en final */
        final Boolean finalOrdreApparition = ordreApparition;

        /** Switch qui permet de savoir si le calcul disparait pendant le choix des reponses*/
        final Switch disparitionCalcul=  findViewById(R.id.ChoixDisparitionCalcul);

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

        /** tableau de booleens qui stocke les reponses des checkBoxs concernant les operations (addition, soustraction, division, multiplication)*/
        final Boolean[] operateurs= new Boolean[4];



        /** Bouton qui permet de valider les parametres et de retourner sur la page d'accueil*/
        Button valider=  findViewById(R.id.BoutonValider);


        valider.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                operateurs[0]=addition.isChecked();
                operateurs[1]=soustraction.isChecked();
                operateurs[2]=multiplication.isChecked();
                operateurs[3]=division.isChecked();

                if(!tpsReponse.getText().toString().equals("") && !valMax.getText().toString().equals("")) {
                    //cas ou les deux Edit text sont remplis
                    ParamEm1 param = new ParamEm1(Long.parseLong(tpsReponse.getText().toString())*1000, nbPairsOnly.isChecked(), operateurs, nbBornes.getProgress(), nbQuestions.getProgress(), disparitionCalcul.isChecked(), finalOrdreApparition, bornesSelectionnables.isChecked(), bornesEgalesReps.isChecked(), Integer.parseInt(valMax.getText().toString()));

                    Log.i("info", "tps reponse: " + param.getTempsRep() + "\nnbs pairs seulement: " + param.getPairOnly() + "\noperateurs: " + param.getOperateur()[0] + param.getOperateur()[1] + param.getOperateur()[2] + param.getOperateur()[3] + "\nnb bornes: " + param.getNbBornes() +
                            "\nnb questions: " + param.getNbQuestions() + "\ndisparition du calcul: " + param.getCalculDisparait() + "\nordre apparition: " + param.getOrdreApparition() +
                            "\nbornes selectionnables: " + param.getBorneSelectionnable() + "\nbornes egales reponses: " + param.getBorneEqualsOp() + "\nvaleur max: " + param.getValMax());
                }

                else if(!tpsReponse.getText().toString().equals("") && valMax.getText().toString().equals("")) {
                    //cas ou seulement tpsReponse est rempli
                    ParamEm1 param = new ParamEm1(Long.parseLong(tpsReponse.getText().toString())*1000, nbPairsOnly.isChecked(), operateurs, nbBornes.getProgress(), nbQuestions.getProgress(), disparitionCalcul.isChecked(), finalOrdreApparition, bornesSelectionnables.isChecked(), bornesEgalesReps.isChecked(), 50);

                    Log.i("info", "tps reponse: " + param.getTempsRep() + "\nnbs pairs seulement: " + param.getPairOnly() + "\noperateurs: " + param.getOperateur()[0] + param.getOperateur()[1] + param.getOperateur()[2] + param.getOperateur()[3] + "\nnb bornes: " + param.getNbBornes() +
                            "\nnb questions: " + param.getNbQuestions() + "\ndisparition du calcul: " + param.getCalculDisparait() + "\nordre apparition: " + param.getOrdreApparition() +
                            "\nbornes selectionnables: " + param.getBorneSelectionnable() + "\nbornes egales reponses: " + param.getBorneEqualsOp() + "\nvaleur max: " + param.getValMax());
                }

                else if(tpsReponse.getText().toString().equals("") && !valMax.getText().toString().equals("")) {
                    //cas ou seulement valmax est rempli
                    Long tps=new Long(10000);
                    ParamEm1 param = new ParamEm1(tps, nbPairsOnly.isChecked(), operateurs, nbBornes.getProgress(), nbQuestions.getProgress(), disparitionCalcul.isChecked(), finalOrdreApparition, bornesSelectionnables.isChecked(), bornesEgalesReps.isChecked(), Integer.parseInt(valMax.getText().toString()));

                    Log.i("info", "tps reponse: " + param.getTempsRep() + "\nnbs pairs seulement: " + param.getPairOnly() + "\noperateurs: " + param.getOperateur()[0] + param.getOperateur()[1] + param.getOperateur()[2] + param.getOperateur()[3] + "\nnb bornes: " + param.getNbBornes() +
                            "\nnb questions: " + param.getNbQuestions() + "\ndisparition du calcul: " + param.getCalculDisparait() + "\nordre apparition: " + param.getOrdreApparition() +
                            "\nbornes selectionnables: " + param.getBorneSelectionnable() + "\nbornes egales reponses: " + param.getBorneEqualsOp() + "\nvaleur max: " + param.getValMax());
                }

                else if(tpsReponse.getText().toString().equals("") && valMax.getText().toString().equals("")) {
                    //cas ou les deux Edit text sont vides
                    Long tps=new Long(10000);
                    ParamEm1 param = new ParamEm1(tps, nbPairsOnly.isChecked(), operateurs, nbBornes.getProgress(), nbQuestions.getProgress(), disparitionCalcul.isChecked(), finalOrdreApparition, bornesSelectionnables.isChecked(), bornesEgalesReps.isChecked(), 50);

                    Log.i("info", "tps reponse: " + param.getTempsRep() + "\nnbs pairs seulement: " + param.getPairOnly() + "\noperateurs: " + param.getOperateur()[0] + param.getOperateur()[1] + param.getOperateur()[2] + param.getOperateur()[3] + "\nnb bornes: " + param.getNbBornes() +
                            "\nnb questions: " + param.getNbQuestions() + "\ndisparition du calcul: " + param.getCalculDisparait() + "\nordre apparition: " + param.getOrdreApparition() +
                            "\nbornes selectionnables: " + param.getBorneSelectionnable() + "\nbornes egales reponses: " + param.getBorneEqualsOp() + "\nvaleur max: " + param.getValMax());
                }


                Intent intent=new Intent(ModifParamEm1Activity.this, MenuActivity.class);
                startActivity(intent);
            }

        });





    }
}
