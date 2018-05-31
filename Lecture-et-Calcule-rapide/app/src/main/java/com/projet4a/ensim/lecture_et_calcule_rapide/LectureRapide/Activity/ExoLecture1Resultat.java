package com.projet4a.ensim.lecture_et_calcule_rapide.LectureRapide.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.projet4a.ensim.lecture_et_calcule_rapide.EnvoiResultat.GenerateQRCodeActivity;
import com.projet4a.ensim.lecture_et_calcule_rapide.Menu.MenuActivity;
import com.projet4a.ensim.lecture_et_calcule_rapide.R;

public class ExoLecture1Resultat extends AppCompatActivity {
    Button accueil;
    TextView score;
    TextView scoreMax;
    String contenuBouton;
    ImageView bonhommebof;
    ImageView bonhommecool;
    ImageView bonhommebigsmile;
    int reponseJuste;
    int nbDapparitionTotal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exo_lecture1_resultat);

        /**
         * On recupère le nombre de bonne réponses données par l'élève et le nombre total d'apparitions qu'il y a eut lors de l'exercice
         */
        Intent intent = getIntent();
        reponseJuste = intent.getIntExtra("nbBonneRep", 0);
        Log.d("rep juste", reponseJuste + "");
        nbDapparitionTotal = intent.getIntExtra("nbAppCourent", 0);
        Log.d("nbAppCourrent", nbDapparitionTotal + "");
        /**
         * on instancie les objets de la vue
         */
        accueil = findViewById(R.id.AcceuilBtn);
        score = findViewById(R.id.scoreTxt);
        scoreMax = findViewById(R.id.nbAppTxt);
        bonhommebof = findViewById(R.id.bonhommebof);
        bonhommebof.setVisibility(View.GONE);
        bonhommecool = findViewById(R.id.bonhommecool);
        bonhommecool.setVisibility(View.GONE);
        bonhommebigsmile = findViewById(R.id.bonhommebigsmile);
        bonhommebigsmile.setVisibility(View.GONE);

        /**
         * on affiche l'image du bonhomme en fonction du score
         */
        if (reponseJuste <= 3) bonhommebof.setVisibility(View.VISIBLE);
        if (reponseJuste > 3 && reponseJuste < 8) bonhommecool.setVisibility(View.VISIBLE);
        if (reponseJuste >= 8) bonhommebigsmile.setVisibility(View.VISIBLE);

        /**
         * on remplit les champs textes avec ce qu'on a récupérer au dessus
         */
        contenuBouton = reponseJuste + "";
        score.setText(contenuBouton);
        contenuBouton = nbDapparitionTotal + "";
        scoreMax.setText(contenuBouton);

        /**
         * Si on clic sur le bouton accueil on retourne à l'accueil
         */
        accueil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
