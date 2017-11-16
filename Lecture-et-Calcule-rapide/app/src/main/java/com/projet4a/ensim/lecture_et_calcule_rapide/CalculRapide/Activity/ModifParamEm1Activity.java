package com.projet4a.ensim.lecture_et_calcule_rapide.CalculRapide.Activity;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import com.projet4a.ensim.lecture_et_calcule_rapide.CalculRapide.Model.ParamEm1;

import com.projet4a.ensim.lecture_et_calcule_rapide.R;

public class ModifParamEm1Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modif_param_em1);
        final ParamEm1 paramEm1=new ParamEm1();
        final SeekBar nbBornes =(SeekBar) findViewById(R.id.NbBornes);
        final EditText tailleFrise = (EditText) findViewById(R.id.TailleFrise);
        Button valider = (Button)findViewById(R.id.Validate);
        valider.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                paramEm1.setNbBornes(((int)nbBornes.getProgress()));
                /*paramEm1.setScaleFrise(tailleFrise.get());*/
            }
        });
    }
}
