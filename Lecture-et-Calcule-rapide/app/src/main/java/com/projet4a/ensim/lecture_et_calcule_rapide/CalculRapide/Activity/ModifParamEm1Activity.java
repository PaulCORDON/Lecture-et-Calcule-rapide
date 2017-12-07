package com.projet4a.ensim.lecture_et_calcule_rapide.CalculRapide.Activity;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
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

import com.projet4a.ensim.lecture_et_calcule_rapide.R;

public class ModifParamEm1Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modif_param_em1);



        final SeekBar nbBornes=  findViewById(R.id.ChoixNbBornes);
        final SeekBar nbQuestions=  findViewById(R.id.ChoixNbQuestions);


        final RadioButton rb1= findViewById(R.id.ChoixCalculAvantRep);
        final RadioButton rb2=findViewById(R.id.ChoixRepAvantCalcul);
        Boolean ordreApparition=true;
        if(rb1.isChecked()){
            ordreApparition=true;
        }
        if(rb2.isChecked()){
            ordreApparition=false;
        }
        final Boolean finalOrdreApparition = ordreApparition;

        final Switch disparitionCalcul=  findViewById(R.id.ChoixDisparitionCalcul);
        final Switch bornesSelectionnables=  findViewById(R.id.ChoixBornesSelectionnables);
        final Switch bornesEgalesReps= findViewById(R.id.ChoixBornesEgalesRep);

        final EditText valMax=  findViewById(R.id.ValeurMax);
        //int valmax=Integer.parseInt(valMax.getText().toString());

        final EditText tpsReponse=  findViewById(R.id.tempsReponse);
       // Long tpsrep= Long.parseLong(tpsReponse.getText().toString());

        final Switch nbPairsOnly=  findViewById(R.id.ChoixNbPairs);

        CheckBox addition=  findViewById(R.id.addition);
        CheckBox soustraction=  findViewById(R.id.soustraction);
        CheckBox division= findViewById(R.id.division);
        CheckBox multiplication=  findViewById(R.id.multiplication);

        final Boolean[] operateurs= new Boolean[4];
        operateurs[0]=addition.isChecked();
        operateurs[1]=soustraction.isChecked();
        operateurs[2]=multiplication.isChecked();
        operateurs[3]=division.isChecked();



        Button valider=  findViewById(R.id.BoutonValider);


        valider.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                ParamEm1 param= new ParamEm1(Long.parseLong(tpsReponse.getText().toString()), nbPairsOnly.isChecked(), operateurs, nbBornes.getProgress(), nbQuestions.getProgress(),disparitionCalcul.isChecked(), finalOrdreApparition, bornesSelectionnables.isChecked(),bornesEgalesReps.isChecked(),Integer.parseInt(valMax.getText().toString()));

                Log.i("info", "tps reponse: "+param.getTempsRep()+"\nnbs pairs seulement: "+param.getPairOnly()+"\noperateurs: "+param.getOperateur()+"\nnb bornes: "+param.getNbBornes()+
                        "\nnb questions: "+param.getNbQuestions()+"\ndisparition du calcul: "+param.getCalculDisparait()+"\nordre apparition: "+param.getOrdreApparition()+
                        "\nbornes selectionnables: " +param.getBorneSelectionnable()+"\nbornes egales reponses: "+param.getBorneEqualsOp()+"\nvaleur max: "+param.getValMax());

            }

        });





    }
}
