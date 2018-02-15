package com.projet4a.ensim.lecture_et_calcule_rapide.LectureRapide.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.projet4a.ensim.lecture_et_calcule_rapide.CalculRapide.Activity.ExoMath1Resultat;
import com.projet4a.ensim.lecture_et_calcule_rapide.Menu.MenuActivity;
import com.projet4a.ensim.lecture_et_calcule_rapide.R;

public class ExoLecture1Resultat extends AppCompatActivity {

    Button accueil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        accueil=findViewById(R.id.Acceuil);
        setContentView(R.layout.activity_exo_lecture1_resultat);
        accueil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent( ExoLecture1Resultat.this ,MenuActivity.class);
                startActivity(intent);
            }
        });

    }
}
