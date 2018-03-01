package com.projet4a.ensim.lecture_et_calcule_rapide.LectureRapide.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.projet4a.ensim.lecture_et_calcule_rapide.R;

public class LectureAccueilActivity extends AppCompatActivity {
    /* booleens pour savoir quel exercice est selectionné */
    boolean isExercice1;
    boolean isExercice2;
    boolean isExercice3;
    TextView descriptionL;

    /**
     * @param savedInstanceState
     */
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
        /*creation du boutton go */
        final Button go = (Button) findViewById(R.id.goL);

        descriptionL = findViewById(R.id.descriptionL);
        parametreL.setVisibility(View.GONE);
        go.setVisibility(View.GONE);

        /** click sur le bouton exercice 1 , on affiche la description et on met le bouton enable */
        exercice1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                exercice1.setEnabled(false);
                exercice2.setEnabled(true);
                exercice3.setEnabled(true);
                parametreL.setVisibility(View.VISIBLE);
                go.setVisibility(View.VISIBLE);
                isExercice1 = true;
                isExercice2 = false;
                isExercice3 = false;

                descriptionL.setText("Exercice 1 de Lecture\nConsigne : Trouve le mot qui est écrit exactement comme le mot de l'énoncé");
            }
        });

        /** click sur le bouton exercice 2 , on affiche la description et on met le bouton enable */
        exercice2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                exercice1.setEnabled(true);
                exercice2.setEnabled(false);
                exercice3.setEnabled(true);
                parametreL.setVisibility(View.VISIBLE);
                go.setVisibility(View.VISIBLE);
                isExercice1 = false;
                isExercice2 = true;
                isExercice3 = false;

                descriptionL.setText("Exercice 2 de Lecture\nConsigne : ");
            }
        });

        /** click sur le bouton exercice 3 , on affiche la description et on met le bouton enable */
        exercice3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                exercice1.setEnabled(true);
                exercice2.setEnabled(true);
                exercice3.setEnabled(false);
                parametreL.setVisibility(View.VISIBLE);
                go.setVisibility(View.VISIBLE);
                isExercice1 = false;
                isExercice2 = false;
                isExercice3 = true;

                descriptionL.setText("Exercice 3 de Lecture\nConsigne : ");
            }
        });

        /** click sur le bouton parametre qui renvoie sur la bonne activité en fonction des booleens */
        parametreL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isExercice1) {
                    Intent intent = new Intent(LectureAccueilActivity.this, ModifParamEl1Activity.class);
                    startActivity(intent);
                }
                //TODO faire pareil pour les autres exercices quand les activités seront créer
            }
        });

        go.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isExercice1) {
                    Intent intent = new Intent(LectureAccueilActivity.this, LectureExo1Activity.class);
                    startActivity(intent);
                }
            }
        });
    }
}
