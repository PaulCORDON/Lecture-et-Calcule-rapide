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

import java.util.ArrayList;
import java.util.logging.Logger;

public class ExoMath1Resultat extends AppCompatActivity {

    /**
     * tableau des reponses de l'élève
     */
    private static boolean[] reponseJuste;

    /**
     * nombre de bonne reponse de l'élève
     */
    private int bonneRep;

    /**
     * numero de la question qui est actuellement affiché à l'ecran
     */
    private int numQuestCorr = -1;

    /**
     *Tableau de string contenant les énoncées
     */
    ArrayList<String> enonces = new ArrayList<>();

    /**
     *tableau de résultat
     * */
    int[] resultats;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exo_math1_resultat);
        Intent intent = getIntent();

        // on récupere le tableau contenant les réponses données par l'élève
        reponseJuste = intent.getBooleanArrayExtra("ReponseDonnee");
        enonces = intent.getStringArrayListExtra("Enonce");
        resultats = intent.getIntArrayExtra("Reponses");

        /**
         * lien avec le vue
         */
        final TextView nbRep = (TextView) findViewById(R.id.score);
        final TextView nbQuest = (TextView) findViewById(R.id.nbQuestion);
        final Button acceuil = (Button) findViewById(R.id.Acceuil);
        final TextView numQuCorrig = (TextView) findViewById(R.id.numQuCorrig);
        final TextView reponse = (TextView) findViewById(R.id.reponse);
        final Button nextQuest = (Button) findViewById(R.id.nextQuest);


        acceuil.setText("Acceuil");
        nextQuest.setText("Voir la correction");

        for(boolean b : reponseJuste){
            if(b){
                Log.i("reponse juste","rep" + b);
                bonneRep++;
            }
        }

        nbRep.setText(""+bonneRep);
        nbQuest.setText(""+reponseJuste.length);

        /**
         * Affichage de la correction pour chaque question jusqu'a ce que l'on appuie sur correction suivante
         */
        /*
        if(numQuestCorr !=-1 ){ // && numQuestCorr != reponseJuste.length+1

            numQuCorrig.setText(""+ numQuCorrig+1);
            reponse.setText("" + "2+2=4" );

        }
*/



            nextQuest.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(numQuestCorr == -1 ){
                        numQuestCorr ++;
                        acceuil.setVisibility(View.INVISIBLE);
                        nextQuest.setText("Correction suivante");
                        numQuCorrig.setText("Question "+ (numQuestCorr) + " : ");  //TODO mettre le vrai énoncé
                        reponse.setText(enonces.get(0)+ " = " + resultats[0]);

                    }

                    if (numQuestCorr > -1 && numQuestCorr < reponseJuste.length +1) {
                        numQuestCorr ++;
                        numQuCorrig.setText("Question "+ (numQuestCorr) + " : ");
                        reponse.setText(enonces.get(numQuestCorr-1)+ " = " + resultats[numQuestCorr-1]);

                    }

                    if(numQuestCorr == reponseJuste.length){
                        nextQuest.setVisibility(View.INVISIBLE);
                        acceuil.setVisibility(View.VISIBLE);
                    }

                }

            });





        /**
         * bouton pour revenir à l'ecran d'acceuil visible uniquement avant l'affichage de la correction et apres ( pas pendant que les correction sont affichées).
         */
        if(numQuestCorr == -1 || numQuestCorr == reponseJuste.length+1 ){
            acceuil.setVisibility(View.VISIBLE);
            acceuil.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent2 = new Intent( ExoMath1Resultat.this ,MenuActivity.class);
                    startActivity(intent2);

                }

            });
        }





    }
}
