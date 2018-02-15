package com.projet4a.ensim.lecture_et_calcule_rapide.LectureRapide.Activity;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.Switch;

import com.projet4a.ensim.lecture_et_calcule_rapide.LectureRapide.Model.ParamEl1;
import com.projet4a.ensim.lecture_et_calcule_rapide.Menu.MenuActivity;
import com.projet4a.ensim.lecture_et_calcule_rapide.R;
import com.xw.repo.BubbleSeekBar;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

/**
 * Modification des paramètres de lecture
 * @author group="Info4A" date="14/07/2017"
 *
 */

public class ModifParamEl1Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modif_param_el1);

        /**
         * recuperation de la valeur du nombre d'énoncé
         */
        final SeekBar nbEnonce = findViewById(R.id.seekNbEnonce);

        /**
         * recuperation des valeurs du temps d'apparition, nombre d'apparition,
         * apparition multiple, mode d'apparition
         */
        final EditText tempsApparution = findViewById(R.id.TpsApparution);
        final EditText nbApp = findViewById(R.id.NbMotsApp);

        final Switch multipleApparution = findViewById(R.id.BtnAppMultiple);
        final BubbleSeekBar nbApparition= findViewById(R.id.NbPropositions);
        final Switch enonceDisparait = findViewById(R.id.BtnApparutionEnonce);


        multipleApparution.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(multipleApparution.isChecked()) {
                   nbApparition.setVisibility(View.VISIBLE);
                }
                else{
                    nbApparition.setVisibility(View.GONE);
                }
            }
        });

        /**
         * si appui sur le bouton Valider
         * @param Valider
         */
        Button valider=  findViewById(R.id.Valider);

            valider.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    ParamEl1 param=null;
                    /**
                     * Changement des valeurs booleennes si Update dans les paramètres
                     */
                   // multipleApparution.isChecked();
                   // enonceDisparait.isChecked();

                    int nombreApparition;

                    if(!multipleApparution.isChecked()){
                        nombreApparition=1;
                    }
                    else{
                        nombreApparition=nbApparition.getProgress();
                    }

                    /**
                     * si aucune valeur saisie dans le champ
                     * @param tempsApparution
                     * mettre une valeur par defaut "2000"
                     */
                    if(tempsApparution.getText().toString().equals("")){
                       Long t = new Long(2000);
                        param = new ParamEl1(nbEnonce.getProgress(),t,Integer.parseInt(nbApp.getText().toString()),multipleApparution.isChecked(),enonceDisparait.isChecked(), nombreApparition);
                        Log.i("Info", "NbEnonce : " + param.getNbEnonce() + "\nTempsApp : " + t + "NbMots : " + param.getNbApparution() + "MultipleApparution : " + param.getMultipleApparution() + "EnonceDisparait : " + param.getEnonceDisparait());
                    }
                    /**
                     * si aucune valeur saisie dans le champ
                     * @param nombreDeMotAFaireApparaitre
                     * mettre une valeur par défaut "10"
                     */
                    else if(nbApp.getText().toString().equals("")){

                        Integer nb =10;
                       param = new ParamEl1(nbEnonce.getProgress(),Long.parseLong(tempsApparution.getText().toString()),nb,multipleApparution.isChecked(),enonceDisparait.isChecked(), nombreApparition);
                        Log.i("Info", "NbEnonce : " + param.getNbEnonce() + "\nTempsApp : " + param.getTempsApparution() + "NbMots : " + nb + "MultipleApparution : " + param.getMultipleApparution() + "EnonceDisparait : " + param.getEnonceDisparait());
                    }
                    /**
                     * si aucune valeur saisie dans les champs
                     * @param nombreDeMotAFaireApparaitre
                     * @param tempsApparution
                     * mettre des valeurs par défaut
                     */
                    else if(tempsApparution.getText().toString().equals("")&& nbApp.getText().toString().equals("")){

                        Long t = new Long(2000);
                        Integer nb =10;
                        param = new ParamEl1(nbEnonce.getProgress(),t,nb,multipleApparution.isChecked(),enonceDisparait.isChecked(), nombreApparition);
                        Log.i("Info", "NbEnonce : " + param.getNbEnonce() + "\nTempsApp : " + t + "NbMots : " + nb + "MultipleApparution : " + param.getMultipleApparution() + "EnonceDisparait : " + param.getEnonceDisparait());
                    }

                    /**
                     * Si tout les champs sont remplis, on modifie les valeurs dans le constructeur
                     */
                    else
                    {
                        param = new ParamEl1(nbEnonce.getProgress(), Long.parseLong(tempsApparution.getText().toString()), Integer.parseInt(nbApp.getText().toString()), multipleApparution.isChecked(), enonceDisparait.isChecked(), nombreApparition);
                        /**
                         * test de fonctionnement avec les logs
                         */
                        Log.i("Info", "NbEnonce : " + param.getNbEnonce() + "\nTempsApp : " + param.getTempsApparution() + "NbMots : " + param.getNbApparution() + "MultipleApparution : " + param.getMultipleApparution() + "EnonceDisparait : " + param.getEnonceDisparait());

                    }


                    FileOutputStream outputStream;
                    ObjectOutputStream oos;
                    try {
                        outputStream = openFileOutput("ParamEl1.txt", Context.MODE_PRIVATE);
                        oos = new ObjectOutputStream(outputStream);
                        oos.writeObject(param);


                        oos.flush();
                        oos.close();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                    /**
                     * redirection vers la page StartActivity
                     */
                    Intent  intent = new Intent( ModifParamEl1Activity.this,LectureAccueilActivity.class);
                    startActivity(intent);


                }
            });


    }
}
