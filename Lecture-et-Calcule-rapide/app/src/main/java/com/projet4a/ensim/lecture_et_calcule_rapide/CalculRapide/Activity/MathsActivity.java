package com.projet4a.ensim.lecture_et_calcule_rapide.CalculRapide.Activity;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.speech.tts.TextToSpeech;
import android.support.annotation.StringRes;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.cpiz.android.bubbleview.BubbleTextView;
import com.projet4a.ensim.lecture_et_calcule_rapide.CalculRapide.Model.ParamEm1;
import com.projet4a.ensim.lecture_et_calcule_rapide.R;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.Locale;

import pl.droidsonroids.gif.GifImageView;

public class MathsActivity extends AppCompatActivity {

    /* booleens pour savoir quel exercice est selectionné */
    boolean isExercice1;
    boolean isExercice2;
    TextView descriptionM;
    TextToSpeech tts ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maths);

        /* creation des boutons exercice 1,2,3 qui serviront pour le calcul et la lecture*/
        final Button exercice1 = (Button) findViewById(R.id.exo1M);
        final Button exercice2 = (Button) findViewById(R.id.exo2M);
        /* creation du boutton parametre */
        final ImageButton parametreM = (ImageButton) findViewById(R.id.paramM);
        /*creation bouton goM */
        final Button go = (Button)findViewById(R.id.goM);
        /* creation de la text view de description */
        final TextView descriptionM = (TextView)findViewById(R.id.descriptionM);

        /*création de l'image du bonhomme et de son animation*/
        final ImageView bonhomme= (ImageView) findViewById(R.id.bonhomme);
        TranslateAnimation animate = new TranslateAnimation(500, 0, 0, 0);
        animate.setDuration(500);
        animate.setFillAfter(true);
        bonhomme.startAnimation(animate);

        final BubbleTextView bulle1= findViewById(R.id.bulle1);
        final TranslateAnimation animate2 = new TranslateAnimation(0, 0, -500, 0);
        animate2.setDuration(500);
        animate2.setFillAfter(false);
        bulle1.startAnimation(animate2);



        final BubbleTextView bulle2=findViewById(R.id.bulle2);
        bulle2.setVisibility(View.GONE);

        final GifImageView gifExo = (GifImageView)findViewById(R.id.Gif);
        final ImageButton volume = findViewById(R.id.volume);
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
       tts = new TextToSpeech(getApplicationContext(),listener);

        volume.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            /* on recuprere les parametre de maths */
                ParamEm1 param = new ParamEm1();
                try {
                    FileInputStream fis = openFileInput("ParamEm1.txt");
                    ObjectInputStream ois = new ObjectInputStream(fis);
                    param = (ParamEm1) ois.readObject();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }


                String text = null;
                Resources res = getResources();
                    if (param.getFrise()) {
                         text = res.getString(R.string.consigneExo1m);
                    }
                    else{ if (param.getNbBornes() == 2 ){
                        text = res.getString(R.string.consigneExo1_2m);


                    }
                    else {

                        text = res.getString(R.string.consigneExo1_1m);


                    }
                }
                tts.speak(text, TextToSpeech.QUEUE_ADD, null, "DEFAULT");

            }
        });

        /* on modifie la transparence des boutons */
        exercice1.getBackground().setAlpha(100);
        exercice2.getBackground().setAlpha(100);


        gifExo.setVisibility(View.GONE);
        parametreM.setVisibility(View.GONE);
        go.setVisibility(View.GONE);

        /** click sur le bouton exercice 1 , on affiche la description et on met le bouton enable */
        exercice1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                exercice1.setEnabled(false);
                exercice2.setEnabled(true);
                parametreM.setVisibility(View.VISIBLE);
                go.setVisibility(View.VISIBLE);
                gifExo.setVisibility(View.VISIBLE);
                isExercice1 = true;
                isExercice2 = false;
                TranslateAnimation animate = new TranslateAnimation(0, 310, 0, 0);
                animate.setDuration(500);
                animate.setFillAfter(true);
                bonhomme.startAnimation(animate);
                bulle1.setVisibility(View.GONE);
                bulle2.setVisibility(View.VISIBLE);
                bulle2.startAnimation(animate2);

                descriptionM.setText("Exercice 1 de Mathématiques\nConsigne : Trouve où se situe le résultat du calcul");
            }
        });


        /** click sur le bouton exercice 2 , on affiche la description et on met le bouton enable */
        exercice2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                exercice1.setEnabled(true);
                exercice2.setEnabled(false);
                parametreM.setVisibility(View.VISIBLE);
                go.setVisibility(View.VISIBLE);
                gifExo.setVisibility(View.VISIBLE);
                isExercice1 = false;
                isExercice2 = true;
                TranslateAnimation animate = new TranslateAnimation(0, 310, 0, 0);
                animate.setDuration(500);
                animate.setFillAfter(true);
                bonhomme.startAnimation(animate);
                bulle1.setVisibility(View.GONE);

                descriptionM.setText("Exercice 2 de Mathématiques\nConsigne : Fait les multiplications");
            }
        });


        /** click sur le bouton parametre qui renvoie sur la bonne activité en fonction des booleens */
        parametreM.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isExercice1) {
                    Intent intent = new Intent(MathsActivity.this, ModifParamEm1Activity.class);
                    startActivity(intent);
                }
                if (isExercice2) {
                    Intent intent = new Intent(MathsActivity.this, ModifParamEm2Activity.class);
                    startActivity(intent);
                }
                //TODO faire pareil pour les autres exercices quand les activités seront créer

            }
        });

        /**Click sur go : on lance l'exercice !!! */
        go.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isExercice1) {
                    Intent intent = new Intent(MathsActivity.this, MathExo1Activity.class);
                    startActivity(intent);
                }
                if (isExercice2) {
                    Intent intent = new Intent(MathsActivity.this, MathExo2Activity.class);
                    startActivity(intent);
                }
            }
        });
    }
}
