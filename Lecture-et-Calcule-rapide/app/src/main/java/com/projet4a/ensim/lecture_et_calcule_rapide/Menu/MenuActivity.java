package com.projet4a.ensim.lecture_et_calcule_rapide.Menu;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.projet4a.ensim.lecture_et_calcule_rapide.CalculRapide.Activity.MathExo1Activity;
import com.projet4a.ensim.lecture_et_calcule_rapide.CalculRapide.Activity.MathsActivity;
import com.projet4a.ensim.lecture_et_calcule_rapide.CalculRapide.Activity.ModifParamEm1Activity;
import com.projet4a.ensim.lecture_et_calcule_rapide.LectureRapide.Activity.LectureAccueilActivity;
import com.projet4a.ensim.lecture_et_calcule_rapide.LectureRapide.Activity.LectureExo1Activity;
import com.projet4a.ensim.lecture_et_calcule_rapide.LectureRapide.Activity.ModifParamEl1Activity;
import com.projet4a.ensim.lecture_et_calcule_rapide.R;

public class MenuActivity extends AppCompatActivity {





    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        /* creation des boutons maths et lecture*/


        final Button math= findViewById(R.id.BtnCalcul);
        final Button lecture=findViewById(R.id.BtnLecture);


        /** si on clique sur math on va vers les exercice de maths*/
        math.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent;
                intent = new Intent(MenuActivity.this, MathsActivity.class);
                startActivity(intent);



            }
        });
        /*si on clique sur lecture on va vers les exercices de lectures*/


        /**Bouton pour aller vers les exercices de lectures*/



        lecture.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {




                Intent intent;
                intent = new Intent(MenuActivity.this, LectureAccueilActivity.class);
                startActivity(intent);


                }

        });


    }

}
