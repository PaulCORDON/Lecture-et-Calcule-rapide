package com.projet4a.ensim.lecture_et_calcule_rapide.LectureRapide.Activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;

import com.projet4a.ensim.lecture_et_calcule_rapide.LectureRapide.Model.ParamEl1;
import com.projet4a.ensim.lecture_et_calcule_rapide.R;
import com.xw.repo.BubbleSeekBar;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * Modification des paramètres de lecture
 *
 * @author group="Info4A" date="14/07/2017"
 */

public class ModifParamEl1Activity extends AppCompatActivity {

    static ParamEl1 param = new ParamEl1();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        try {
            FileInputStream fis = openFileInput("ParamEl1.txt");
            ObjectInputStream ois = new ObjectInputStream(fis);
            param = (ParamEl1) ois.readObject();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        setContentView(R.layout.activity_modif_param_el1);

        /**
         * recuperation de la valeur du nombre d'énoncé
         */
        final BubbleSeekBar nbEnonce = findViewById(R.id.seekNbEnonce);
        nbEnonce.setProgress(param.getNbEnonce());

        /**
         * recuperation des valeurs du temps d'apparition, nombre d'apparition,
         * apparition multiple, mode d'apparition
         */
        final EditText tempsApparution = findViewById(R.id.TpsApparution);
        tempsApparution.setText("" + param.getTempsApparution() / 1000);

        final EditText nbApp = findViewById(R.id.NbMotsApp);
        nbApp.setText("" + param.getNbApparution());

        final Switch multipleApparution = findViewById(R.id.BtnAppMultiple);
        multipleApparution.setChecked(param.getMultipleApparution());

        final BubbleSeekBar nbApparition = findViewById(R.id.NbPropositions);
        if (!param.getMultipleApparution()) nbApparition.setVisibility(View.GONE);
        else nbApparition.setProgress(param.getNbAparitionSimultanee());

        final Switch enonceDisparait = findViewById(R.id.BtnApparutionEnonce);
        enonceDisparait.setChecked(param.getEnonceDisparait());

        multipleApparution.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (multipleApparution.isChecked()) {
                    nbApparition.setVisibility(View.VISIBLE);
                } else {
                    nbApparition.setVisibility(View.GONE);
                }
            }
        });

        /**
         * si appui sur le bouton Valider
         * @param Valider
         */
        Button valider = findViewById(R.id.Valider);

        valider.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /**
                 * Changement des valeurs booleennes si Update dans les paramètres
                 */
                // multipleApparution.isChecked();
                // enonceDisparait.isChecked();

                int nombreApparition;

                if (!multipleApparution.isChecked()) {
                    nombreApparition = 1;
                } else {
                    nombreApparition = nbApparition.getProgress();
                }

                /**
                 * si aucune valeur saisie dans le champ
                 * @param tempsApparution
                 * mettre une valeur par defaut "2000"
                 */
                if (tempsApparution.getText().toString().equals("") && !nbApp.getText().toString().equals("")) {
                    Long t = new Long(3000);
                    param = new ParamEl1(nbEnonce.getProgress(), t, Integer.parseInt(nbApp.getText().toString()), multipleApparution.isChecked(), enonceDisparait.isChecked(), nombreApparition);
                    Log.i("Info", "NbEnonce : " + param.getNbEnonce() + "\nTempsApp : " + t + "NbMots : " + param.getNbApparution() + "MultipleApparution : " + param.getMultipleApparution() + "EnonceDisparait : " + param.getEnonceDisparait() + "apparitions multiples:" + nombreApparition);
                }
                /**
                 * si aucune valeur saisie dans le champ
                 * @param nombreDeMotAFaireApparaitre
                 * mettre une valeur par défaut "10"
                 */
                else if (nbApp.getText().toString().equals("") && !tempsApparution.getText().toString().equals("")) {
                    Integer nb = 10;
                    param = new ParamEl1(nbEnonce.getProgress(), Long.parseLong(tempsApparution.getText().toString()) * 1000, nb, multipleApparution.isChecked(), enonceDisparait.isChecked(), nombreApparition);
                    Log.i("Info", "NbEnonce : " + param.getNbEnonce() + "\nTempsApp : " + param.getTempsApparution() + "NbMots : " + nb + "MultipleApparution : " + param.getMultipleApparution() + "EnonceDisparait : " + param.getEnonceDisparait());
                }
                /**
                 * si aucune valeur saisie dans les champs
                 * @param nombreDeMotAFaireApparaitre
                 * @param tempsApparution
                 * mettre des valeurs par défaut
                 */
                else if (tempsApparution.getText().toString().equals("") && nbApp.getText().toString().equals("")) {
                    Long t = new Long(3000);
                    Integer nb = 10;
                    param = new ParamEl1(nbEnonce.getProgress(), t, nb, multipleApparution.isChecked(), enonceDisparait.isChecked(), nombreApparition);
                    Log.i("Info", "NbEnonce : " + param.getNbEnonce() + "\nTempsApp : " + t + "NbMots : " + nb + "MultipleApparution : " + param.getMultipleApparution() + "EnonceDisparait : " + param.getEnonceDisparait() + "apparitions multiples:" + nombreApparition);
                }
                /**
                 * Si tout les champs sont remplis, on modifie les valeurs dans le constructeur
                 */
                else {
                    param = new ParamEl1(nbEnonce.getProgress(), Long.parseLong(tempsApparution.getText().toString()) * 1000, Integer.parseInt(nbApp.getText().toString()), multipleApparution.isChecked(), enonceDisparait.isChecked(), nombreApparition);
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
                Intent intent = new Intent(ModifParamEl1Activity.this, LectureAccueilActivity.class);
                startActivity(intent);
            }
        });
    }
}
