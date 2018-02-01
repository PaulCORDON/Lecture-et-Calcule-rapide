package com.projet4a.ensim.lecture_et_calcule_rapide.CalculRapide.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.projet4a.ensim.lecture_et_calcule_rapide.LectureRapide.Activity.LectureAccueilActivity;
import com.projet4a.ensim.lecture_et_calcule_rapide.Menu.MenuActivity;
import com.projet4a.ensim.lecture_et_calcule_rapide.R;

import java.util.logging.Logger;

public class ExoMath1Resultat extends AppCompatActivity {

    /**
     * tableau des reponses de l'élève
     */
    private static boolean[] reponseJuste;

    private int bonneRep;
    //coucou
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exo_math1_resultat);
        Intent intent = getIntent();

        // on récupere le tableau contenant les réponses données par l'élève
        reponseJuste = intent.getBooleanArrayExtra("ReponseDonnee");


        TextView nbRep = (TextView) findViewById(R.id.score);
        TextView nbQuest = (TextView) findViewById(R.id.nbQuestion);
        Button acceuil = (Button) findViewById(R.id.Acceuil);

        for(boolean b : reponseJuste){
            if(b){
                Log.i("reponse juste","rep" + b);
                bonneRep++;
            }
        }

        nbRep.setText(""+bonneRep);
        nbQuest.setText(""+reponseJuste.length);

        acceuil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2 = new Intent( ExoMath1Resultat.this ,MenuActivity.class);
                startActivity(intent2);

            }

        });



    }
}
