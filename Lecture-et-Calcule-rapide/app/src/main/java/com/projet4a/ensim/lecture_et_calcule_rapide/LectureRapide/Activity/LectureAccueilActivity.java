package com.projet4a.ensim.lecture_et_calcule_rapide.LectureRapide.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.projet4a.ensim.lecture_et_calcule_rapide.CalculRapide.Activity.ModifParamEm1Activity;
import com.projet4a.ensim.lecture_et_calcule_rapide.Menu.MenuActivity;
import com.projet4a.ensim.lecture_et_calcule_rapide.R;


public class LectureAccueilActivity extends AppCompatActivity {
    boolean isExercice1;
    boolean isExercice2;
    boolean isExercice3;
    TextView descriptionL;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lecture_accueil);


    /* creation des boutons exercice 1,2,3 qui serviront pour le calcul et la lecture*/
        final Button exercice1 = (Button) findViewById(R.id.exo1L);
        final Button exercice2 = (Button) findViewById(R.id.exo2L);
        final Button exercice3 = (Button) findViewById(R.id.exo3L);
    /* creation du boutton parametre */
        final Button parametreL = (Button) findViewById(R.id.paramL);

        exercice1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                exercice1.setEnabled(false);
                exercice2.setEnabled(true);
                exercice3.setEnabled(true);
                isExercice1 = true;
                isExercice2 = false;
                isExercice3 = false;
                descriptionL = (TextView) findViewById(R.id.descriptionL);


                    descriptionL.setText("Exercice 1 de Lecture !!!!! ");




            }
        });

        exercice2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                exercice1.setEnabled(true);
                exercice2.setEnabled(false);
                exercice3.setEnabled(true);
                isExercice1 = false;
                isExercice2 = true;
                isExercice3 = false;
                descriptionL = (TextView) findViewById(R.id.descriptionL);


                    descriptionL.setText("Exercice 2 de Lecture !!!!! ");



            }
        });
        exercice3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                exercice1.setEnabled(true);
                exercice2.setEnabled(true);
                exercice3.setEnabled(false);
                isExercice1 = false;
                isExercice2 = false;
                isExercice3 = true;
                descriptionL = (TextView) findViewById(R.id.descriptionL);


                    descriptionL.setText("Exercice 3 de Lecture !!!!! ");


            }
        });

        parametreL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (isExercice1){

                    /*Intent intent = new Intent(MenuActivity.this, ModifParamEm1Activity.class);
                    startActivity(intent);*/

                }


            }
        });


    }
}
