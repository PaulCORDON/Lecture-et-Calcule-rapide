package com.projet4a.ensim.lecture_et_calcule_rapide.LectureRapide.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.Switch;

import com.projet4a.ensim.lecture_et_calcule_rapide.LectureRapide.Model.ParamEl1;
import com.projet4a.ensim.lecture_et_calcule_rapide.R;

public class ModifParamEl1Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modif_param_el1);

        SeekBar nbEnonce = findViewById(R.id.seekNbEnonce);

        EditText tempsApparution = findViewById(R.id.TpsApparution);
        Long Tps=Long.parseLong(tempsApparution.getText().toString());

        EditText nbApp = findViewById(R.id.NbMotsApp);
        int nb=Integer.parseInt(nbApp.getText().toString());

        Switch multipleApparution = findViewById(R.id.BtnAppMultiple);
        Switch enonceDisparait = findViewById(R.id.BtnApparutionEnonce);

        Button valider=  findViewById(R.id.Valider);
        final boolean enregistrer = valider.isPressed();

        if(enregistrer){
            ParamEl1 param = new ParamEl1(nbEnonce.getProgress(),Tps,nb,multipleApparution.isChecked(),enonceDisparait.isChecked());
        }



    }
}
