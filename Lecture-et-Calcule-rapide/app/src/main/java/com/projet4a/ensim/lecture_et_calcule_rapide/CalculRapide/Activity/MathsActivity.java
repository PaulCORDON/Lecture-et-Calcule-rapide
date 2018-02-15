package com.projet4a.ensim.lecture_et_calcule_rapide.CalculRapide.Activity;


import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.projet4a.ensim.lecture_et_calcule_rapide.R;

import java.io.InputStream;

import static com.projet4a.ensim.lecture_et_calcule_rapide.R.id.GifImageView;

public class MathsActivity extends AppCompatActivity {

/* booleens pour savoir quel exercice est selectionné */
    boolean isExercice1;
    boolean isExercice2;
    boolean isExercice3;
    TextView descriptionM;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maths);

    /* creation des boutons exercice 1,2,3 qui serviront pour le calcul et la lecture*/
        final Button exercice1 = findViewById(R.id.exo1M);
        final Button exercice2 = (Button) findViewById(R.id.exo2M);
        final Button exercice3 = (Button) findViewById(R.id.exo3M);
    /* creation du boutton parametre */
        final Button parametreM = (Button) findViewById(R.id.paramM);
    /*creation bouton goM */

    final  Button go = findViewById(R.id.goM);

        /**
         * image gif
         *
         * Bitmap b;
         InputStream is = getResources().openRawResource(+R.drawable.raw);
         b = BitmapFactory.decodeStream(is);

         ImageView gifImageView = (ImageView) findViewById(R.id.GifImageView);
         gifImageView.setImageBitmap(b);
         *
         *
         */


        @SuppressLint("WrongViewCast") GifImageView gifImageViewer = (GifImageView) findViewById(R.id.GifImageView);
        if(Build.VERSION.SDK_INT>=11){
            gifImageViewer.setLayerType(View.LAYER_TYPE_SOFTWARE,null);
        }



        /** click sur le bouton exercice 1 , on affiche la description et on met le bouton enable */
        exercice1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                exercice1.setEnabled(false);
                exercice2.setEnabled(true);
                exercice3.setEnabled(true);
                isExercice1 = true;
                isExercice2 = false;
                isExercice3 = false;
                descriptionM = (TextView) findViewById(R.id.descriptionM);


                descriptionM.setText("Exercice 1 de Lecture !!!!! ");




            }
        });
        /** click sur le bouton exercice 2 , on affiche la description et on met le bouton enable */
        exercice2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                exercice1.setEnabled(true);
                exercice2.setEnabled(false);
                exercice3.setEnabled(true);
                isExercice1 = false;
                isExercice2 = true;
                isExercice3 = false;
                descriptionM = (TextView) findViewById(R.id.descriptionM);


                descriptionM.setText("Exercice 2 de Lecture !!!!! ");



            }
        });
        /** click sur le bouton exercice 3 , on affiche la description et on met le bouton enable */
        exercice3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                exercice1.setEnabled(true);
                exercice2.setEnabled(true);
                exercice3.setEnabled(false);
                isExercice1 = false;
                isExercice2 = false;
                isExercice3 = true;
                descriptionM = (TextView) findViewById(R.id.descriptionM);


                descriptionM.setText("Exercice 3 de Lecture !!!!! ");


            }
        });
        /** click sur le bouton parametre qui renvoie sur la bonne activité en fonction des booleens */
        parametreM.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (isExercice1){

                    Intent intent = new Intent(MathsActivity.this, ModifParamEm1Activity.class);
                    startActivity(intent);

                }
                //TODO faire pareil pour les autres exercices quand les activités seront créer

            }
        });


        /**Click sur go : on lance l'exercice !!! */

        go.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent intent = new Intent(MathsActivity.this, MathExo1Activity.class);
                startActivity(intent);



            }
        });


    }
}
