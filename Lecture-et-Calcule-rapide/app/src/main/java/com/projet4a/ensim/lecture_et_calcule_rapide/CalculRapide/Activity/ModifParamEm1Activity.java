package com.projet4a.ensim.lecture_et_calcule_rapide.CalculRapide.Activity;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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
        SeekBar nbBornes= (SeekBar) findViewById(R.id.ChoixNbBornes);
        SeekBar nbQuestions= (SeekBar) findViewById(R.id.ChoixNbQuestions);

        RadioGroup group = (RadioGroup) findViewById(R.id.GroupRadiobutton);
        RadioButton rb1=(RadioButton) findViewById(R.id.ChoixCalculAvantRep);
        RadioButton rb2=(RadioButton) findViewById(R.id.ChoixRepAvantCalcul);
        Boolean ordreApparition=true;
        if(rb1.isChecked()){
            ordreApparition=true;
        }
        if(rb2.isChecked()){
            ordreApparition=false;
        }

        Switch disparitionCalcul= (Switch) findViewById(R.id.ChoixDisparitionCalcul);
        Switch bornesSelectionnables= (Switch) findViewById(R.id.ChoixBornesSelectionnables);
        Switch bornesEgalesReps= (Switch) findViewById(R.id.ChoixBornesEgalesRep);

        EditText valMax= (EditText) findViewById(R.id.ValeurMax);

        EditText tpsReponse= (EditText) findViewById(R.id.tempsReponse);

        Switch nbPairsOnly= (Switch) findViewById(R.id.ChoixNbPairs);

        CheckBox addition= (CheckBox) findViewById(R.id.addition);
        CheckBox soustraction= (CheckBox) findViewById(R.id.soustraction);
        CheckBox division= (CheckBox) findViewById(R.id.division);
        CheckBox multiplication= (CheckBox) findViewById(R.id.multiplication);

        Boolean[] operateurs= new Boolean[4];
        operateurs[0]=addition.isChecked();
        operateurs[1]=soustraction.isChecked();
        operateurs[2]=multiplication.isChecked();
        operateurs[3]=division.isChecked();


        Button valider= (Button) findViewById(R.id.BoutonValider);
        final boolean enregistrer = valider.callOnClick();

        if(enregistrer){
            //ligne suivante a revoir car les types renvoyés ne sont pas les types attendus
            ParamEm1 param= new ParamEm1(tpsReponse.getText().toString(), nbPairsOnly.isChecked(), enregistrer, nbBornes.getContext(), nbQuestions.getContext(),disparitionCalcul.isChecked(), ordreApparition, bornesSelectionnables.isChecked(),bornesEgalesReps.isChecked(),valMax.getText());
        }



    }
}
