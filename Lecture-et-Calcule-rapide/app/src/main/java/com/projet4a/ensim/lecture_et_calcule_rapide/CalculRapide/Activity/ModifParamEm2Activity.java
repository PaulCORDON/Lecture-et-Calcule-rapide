package com.projet4a.ensim.lecture_et_calcule_rapide.CalculRapide.Activity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;

import com.projet4a.ensim.lecture_et_calcule_rapide.R;

/**
 * Created by HP on 22/02/2018.
 */

public class ModifParamEm2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modif_param_em2);

        final EditText  nbCal=  findViewById(R.id.NbCalcul);
        final EditText  valeurMax=  findViewById(R.id.ValMaxOperandes);

        final CheckBox  nbpair = findViewById(R.id.NbPair);
        final CheckBox  nbimpair = findViewById(R.id.NbImpair);

        final RadioButton deuxbornes = findViewById(R.id.DeuxBornes);
        final RadioButton quatrebornes = findViewById(R.id.QuatreBornes);
        final RadioButton pavNum = findViewById(R.id.PaveNum);

        /** Bouton qui permet de valider les parametres et de retourner sur la page d'accueil*/
        Button valider=  findViewById(R.id.BtonValider);

        valider.setOnClickListener(new View.OnClickListener() {
            @Override
            /** si le bouton valider a ete cliqué on rentre dans cette methode*/
            public void onClick(View view) {

                int nbcal;
                int valMax;

                if (!nbCal.getText().toString().equals(""))
                    nbcal = Integer.parseInt(nbCal.getText().toString());
                else nbcal = 5;

                if (!valeurMax.getText().toString().equals(""))
                    valMax = Integer.parseInt(valeurMax.getText().toString());
                else valMax = 30;
            }

        });

    }
}

