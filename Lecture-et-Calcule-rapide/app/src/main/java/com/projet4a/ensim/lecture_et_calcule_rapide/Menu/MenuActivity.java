package com.projet4a.ensim.lecture_et_calcule_rapide.Menu;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.projet4a.ensim.lecture_et_calcule_rapide.CalculRapide.Activity.MathExo1Activity;
import com.projet4a.ensim.lecture_et_calcule_rapide.CalculRapide.Activity.ModifParamEm1Activity;
import com.projet4a.ensim.lecture_et_calcule_rapide.LectureRapide.Activity.LectureExo1Activity;
import com.projet4a.ensim.lecture_et_calcule_rapide.LectureRapide.Activity.ModifParamEl1Activity;
import com.projet4a.ensim.lecture_et_calcule_rapide.R;

public class MenuActivity extends AppCompatActivity {
    boolean isMath ;
    boolean isLecture ;
    boolean isExercice1;
    boolean isExercice2;
    boolean isExercice3;
    TextView description;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        /* creation des boutons maths et lecture*/
         final Button math=(Button) findViewById(R.id.BtnCalcul);
         final Button lecture=(Button)findViewById(R.id.BtnLecture);
          /* creation des boutons exercice 1,2,3 qui serviront pour le calcul et la lecture*/
         final Button exercice1 = (Button) findViewById(R.id.exo1);
         final Button exercice2 = (Button) findViewById(R.id.exo2);
         final Button exercice3 = (Button) findViewById(R.id.exo3);
         /* creation du boutton parametre */
         final Button parametre = (Button) findViewById(R.id.param);
        final Button debutExo = (Button) findViewById(R.id.go);

        isMath = true;
        isLecture =false;


        /* si on clique sur math on va vers les exercice de maths*/
        math.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            //   startActivity(new Intent(MenuActivity.this, MathExo1Activity.class));
                isMath = true;
                isLecture = false;
                isExercice1 = true;
                isExercice2 = false;
                isExercice3 = false;
                math.setEnabled(false);
                lecture.setEnabled(true);
                exercice1.setEnabled(false);
                exercice2.setEnabled(true);
                exercice3.setEnabled(true);
                description = (TextView) findViewById(R.id.descriptionExo);
                description.setText("Exercice 1 de Maths !!!!");




            }
        });
        /*si on clique sur lecture on va vers les exercices de lectures*/

        lecture.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

               // startActivity(new Intent(MenuActivity.this, LectureAccueilActivity.class));

                isMath = false;
                isLecture = true;
                isExercice1 = true;
                isExercice2 = false;
                isExercice3 = false;
                math.setEnabled(true);
                lecture.setEnabled(false);
                description = (TextView) findViewById(R.id.descriptionExo);
                description.setText("Exercice 1 de Lecture  !!!!");
                exercice1.setEnabled(false);
                exercice2.setEnabled(true);
                exercice3.setEnabled(true);
                }

        });

        exercice1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                exercice1.setEnabled(false);
                exercice2.setEnabled(true);
                exercice3.setEnabled(true);
                isExercice1 = true;
                isExercice2 = false;
                isExercice3 = false;
                description = (TextView) findViewById(R.id.descriptionExo);
                if (isLecture){

                    description.setText("Exercice 1 de Lecture !!!!! ");

                }

                if (isMath){
                    description.setText("Exercice 1 de Calcul !!!!! ");

                }
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
                description = (TextView) findViewById(R.id.descriptionExo);
                if (isLecture){

                    description.setText("Exercice 2 de Lecture !!!!! ");

                }

                if (isMath){
                    description.setText("Exercice 2 de Calcul !!!!! ");

                }
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
                description = (TextView) findViewById(R.id.descriptionExo);
                if (isLecture){

                    description.setText("Exercice 3 de Lecture !!!!! ");

                }

                if (isMath){
                    description.setText("Exercice 3 de Calcul !!!!! ");

                }
            }
        });

        parametre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (isMath && isExercice1){

                    Intent intent = new Intent(MenuActivity.this, ModifParamEm1Activity.class);
                    startActivity(intent);

                }

                if (isLecture && isExercice1){

                    Intent intent = new Intent(MenuActivity.this, ModifParamEl1Activity.class);
                    startActivity(intent);

                }


            }
        });
        debutExo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (isMath && isExercice1){

                    Intent intent = new Intent(MenuActivity.this, MathExo1Activity.class);
                    startActivity(intent);

                }

                if (isLecture && isExercice1){

                    Intent intent = new Intent(MenuActivity.this, LectureExo1Activity.class);
                    startActivity(intent);

                }


            }
        });
    }

}
