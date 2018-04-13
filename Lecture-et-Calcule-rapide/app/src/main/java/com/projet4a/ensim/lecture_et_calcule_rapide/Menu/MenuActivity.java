package com.projet4a.ensim.lecture_et_calcule_rapide.Menu;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.projet4a.ensim.lecture_et_calcule_rapide.CalculRapide.Activity.MathExo1Activity;
import com.projet4a.ensim.lecture_et_calcule_rapide.CalculRapide.Activity.MathsActivity;
import com.projet4a.ensim.lecture_et_calcule_rapide.CalculRapide.Activity.ModifParamEm1Activity;
import com.projet4a.ensim.lecture_et_calcule_rapide.LectureRapide.Activity.LectureAccueilActivity;
import com.projet4a.ensim.lecture_et_calcule_rapide.LectureRapide.Activity.LectureExo1Activity;
import com.projet4a.ensim.lecture_et_calcule_rapide.LectureRapide.Activity.ModifParamEl1Activity;
import com.projet4a.ensim.lecture_et_calcule_rapide.R;

import java.util.TimerTask;

import static java.lang.Thread.sleep;

public class MenuActivity extends AppCompatActivity {





    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        /* creation des boutons maths et lecture*/


        final ImageButton math = findViewById(R.id.BtnCalcul);
        final ImageButton lecture = findViewById(R.id.BtnLecture);
        final ImageView bonhomme1 = findViewById(R.id.bonhomme);
        final ImageView bonhomme2 = findViewById(R.id.bonhomme2);
        bonhomme2.setVisibility(View.GONE);
        final ImageView bulle1 = findViewById(R.id.bulle1);
        final ImageView bulle2 = findViewById(R.id.bulle2);
        bulle2.setVisibility(View.GONE);
        final TextView textCalcul=findViewById(R.id.textCalcul);
        final TextView textLecture=findViewById(R.id.textLecture);


        TranslateAnimation animate = new TranslateAnimation(0, 0, 200, 0);
        animate.setDuration(500);
        animate.setFillAfter(true);
        bonhomme1.startAnimation(animate);

        TranslateAnimation animate2 = new TranslateAnimation(0, 0, 400, 0);
        animate2.setDuration(800);
        animate2.setFillAfter(false);
        bulle1.startAnimation(animate2);


        /** si on clique sur math on va vers les exercice de maths*/
        math.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent;
                intent = new Intent(MenuActivity.this, MathsActivity.class);
                startActivity(intent);

            }
        });

        textCalcul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent;
                intent = new Intent(MenuActivity.this, MathsActivity.class);
                startActivity(intent);

            }
        });


        /**si on clique sur lecture on va vers les exercices de lectures*/


        /**Bouton pour aller vers les exercices de lectures*/


        lecture.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent;
                intent = new Intent(MenuActivity.this, LectureAccueilActivity.class);
                startActivity(intent);

            }

        });

        textLecture.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent;
                intent = new Intent(MenuActivity.this, LectureAccueilActivity.class);
                startActivity(intent);

            }

        });


            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {

                    if (bonhomme1.isShown()) {
                        bonhomme1.setVisibility(View.GONE);
                        bulle1.setVisibility(View.GONE);
                        bonhomme2.setVisibility(View.VISIBLE);
                        bulle2.setVisibility(View.VISIBLE);
                    } else {
                        bonhomme1.setVisibility(View.VISIBLE);
                        bulle1.setVisibility(View.VISIBLE);
                        bonhomme2.setVisibility(View.GONE);
                        bulle2.setVisibility(View.GONE);
                    }

                }
            }, 3000);





    }



}
