package com.projet4a.ensim.lecture_et_calcule_rapide.LectureRapide.Activity;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.cpiz.android.bubbleview.BubbleTextView;
import com.projet4a.ensim.lecture_et_calcule_rapide.R;

import java.util.Locale;

import pl.droidsonroids.gif.GifImageView;

public class LectureAccueilActivity extends AppCompatActivity {
    /* booleens pour savoir quel exercice est selectionné */
    boolean isExercice1;
    TextView descriptionL;
    /* speaker*/
    TextToSpeech tts;

    /**
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lecture_accueil);

        /*création de l'image du bonhomme et de son animation*/
        final ImageView bonhomme = (ImageView) findViewById(R.id.bonhomme);
        TranslateAnimation animate = new TranslateAnimation(500, 0, 0, 0);
        animate.setDuration(500);
        animate.setFillAfter(true);
        bonhomme.startAnimation(animate);

        final BubbleTextView bulle1 = findViewById(R.id.bulle1);
        final TranslateAnimation animate2 = new TranslateAnimation(0, 0, -500, 0);
        animate2.setDuration(500);
        animate2.setFillAfter(false);
        bulle1.startAnimation(animate2);

        final BubbleTextView bulle2 = findViewById(R.id.bulle2);
        bulle2.setVisibility(View.GONE);

        /* creation des boutons exercice 1,2,3 qui serviront pour le calcul et la lecture*/
        final Button exercice1 = (Button) findViewById(R.id.exo1L);

        /* on modifie la transparence des boutons */
        exercice1.getBackground().setAlpha(100);

        /* Bouton volume pour les parametre*/
        final ImageButton volume = findViewById(R.id.volumeLec);
        TextToSpeech.OnInitListener listener =
                new TextToSpeech.OnInitListener() {
                    @Override
                    public void onInit(final int status) {
                        if (status == TextToSpeech.SUCCESS) {
                            Log.d("TTS", "Text to speech engine started successfully.");
                            tts.setLanguage(Locale.FRANCE);
                        } else {
                            Log.d("TTS", "Error starting the text to speech engine.");
                        }
                    }
                };
        tts = new TextToSpeech(getApplicationContext(), listener);

        volume.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Resources res = getResources();
                String text = res.getString(R.string.consigneExoLect1);
                tts.speak(text, TextToSpeech.QUEUE_ADD, null, "DEFAULT");
            }
        });

        /* creation du boutton parametre */
        final ImageButton parametreL = (ImageButton) findViewById(R.id.paramL);
        /*creation du boutton go */
        final Button go = (Button) findViewById(R.id.goL);
        /*création du gif*/
        final GifImageView gif = findViewById(R.id.gifFrise);
        descriptionL = findViewById(R.id.descriptionL);
        parametreL.setVisibility(View.GONE);
        go.setVisibility(View.GONE);
        gif.setVisibility(View.GONE);

        /** click sur le bouton exercice 1 , on affiche la description et on met le bouton enable */
        exercice1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                exercice1.setEnabled(false);
                parametreL.setVisibility(View.VISIBLE);
                go.setVisibility(View.VISIBLE);
                isExercice1 = true;
                gif.setVisibility(View.VISIBLE);
                TranslateAnimation animate = new TranslateAnimation(0, 100, 0, 0);
                animate.setDuration(500);
                animate.setFillAfter(true);
                bonhomme.startAnimation(animate);
                bulle1.setVisibility(View.GONE);
                bulle2.setVisibility(View.VISIBLE);
                bulle2.startAnimation(animate2);
                descriptionL.setText("Exercice 1 de Lecture\nConsigne : Trouve le mot qui est écrit exactement\n comme le mot de l'énoncé");
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
