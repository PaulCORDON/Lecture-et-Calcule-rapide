package com.projet4a.ensim.lecture_et_calcule_rapide.LectureRapide.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
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

        final SeekBar nbEnonce = findViewById(R.id.seekNbEnonce);

        final EditText tempsApparution = findViewById(R.id.TpsApparution);

        final EditText nbApp = findViewById(R.id.NbMotsApp);

        final Switch multipleApparution = findViewById(R.id.BtnAppMultiple);
        final Switch enonceDisparait = findViewById(R.id.BtnApparutionEnonce);

        Button valider=  findViewById(R.id.Valider);



        valider.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ParamEl1 param = new ParamEl1(nbEnonce.getProgress(),Long.parseLong(tempsApparution.getText().toString()),Integer.parseInt(nbApp.getText().toString()),multipleApparution.isChecked(),enonceDisparait.isChecked());

                Log.i("Info", "NbEnonce : "+param.getNbEnonce()+"\nTempsApp : "+param.getTempsApparution()+"NbMots : "+param.getNbApparution()+"MultipleApparution : "+param.getMultipleApparution()+"EnonceDisparait : "+param.getEnonceDisparait());
            }
        });





    }
}