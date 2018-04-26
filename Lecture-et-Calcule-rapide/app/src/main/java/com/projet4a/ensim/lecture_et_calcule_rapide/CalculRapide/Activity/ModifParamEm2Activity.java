package com.projet4a.ensim.lecture_et_calcule_rapide.CalculRapide.Activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Switch;

import com.projet4a.ensim.lecture_et_calcule_rapide.CalculRapide.Model.ParamEm2;
import com.projet4a.ensim.lecture_et_calcule_rapide.R;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

/**
 * Created by HP on 22/02/2018.
 */

public class ModifParamEm2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modif_param_em2);
        /**
         *
         * recupération des différents id de activity_modif_paramEm2.xml
         */

        /**Si cette checkBox est cochee les calculs comporteront des additions*/

        final CheckBox additionC = findViewById(R.id.additionC);


        /**Si cette checkBox est cochee les calculs comporteront des soustractions*/

        final CheckBox soustractionC = findViewById(R.id.soustractionC);

        /**Si cette checkBox est cochee les calculs comporteront des divisions*/

        final CheckBox divisionC = findViewById(R.id.divisionC);

        /**Si cette checkBox est cochee les calculs comporteront des multiplications*/

        final CheckBox multiplicationC = findViewById(R.id.multiplicationC);

        /** on a forcement une case de validée */
        if (!additionC.isChecked() && !soustractionC.isChecked() &&!multiplicationC.isChecked() && !divisionC.isChecked()){
            additionC.setChecked(true);
        }


        /** tableau de booleens qui stockera plus tard les reponses des checkBoxs concernant les operations (addition, soustraction, division, multiplication)*/
        final Boolean[] operateurs = new Boolean[5];
        final Boolean[] operateursB = new Boolean[5];



        final EditText  nbCal= (EditText)  findViewById(R.id.NbCalcul);
        final EditText  valeurMax= (EditText)  findViewById(R.id.ValMaxOperandes);

        final CheckBox  nbpair =  (CheckBox) findViewById(R.id.NbPair);
        final CheckBox  nbimpair =  (CheckBox) findViewById(R.id.NbImpair);

        final RadioButton deuxbornes = (RadioButton) findViewById(R.id.DeuxBornes);
        final RadioButton quatrebornes = (RadioButton) findViewById(R.id.QuatreBornes);
        final RadioButton pavNum = (RadioButton) findViewById(R.id.PaveNum);

        /** Bouton qui permet de valider les parametres et de retourner sur la page d'accueil*/
        Button valider=  findViewById(R.id.BtonValider);

        /**  Bouton qui permet d'activer les calculs en chaine**/
        final Switch chaine = findViewById(R.id.CalculChaine);

        /**
         * si on clique sur le bouton valider
         */
        valider.setOnClickListener(new View.OnClickListener() {
            @Override
            /** si le bouton valider a ete cliqué on rentre dans cette methode*/
            public void onClick(View view) {

                int nbcal = 10;
                int valMax = 10;

                /**
                 * verifier si les valeurs de nombre max de calcul et des opérandes sont saisies
                 */
                if (!nbCal.getText().toString().equals(""))
                    nbcal = Integer.parseInt(nbCal.getText().toString());
                else nbcal = 10;

                if (!valeurMax.getText().toString().equals(""))
                    valMax = Integer.parseInt(valeurMax.getText().toString());
                else valMax = 10;

                /**
                 * declaration des variables
                 */
                boolean npair=false, nimpair=false,repdeuxbrnes=false,repQuatrebrnes=false,pav=true;
                int typerep = 0;

                /**
                 * récupération des valeurs entrées par l'utilisateur
                 */
                if(nbpair.isChecked()){
                    npair=true;
                }

                if(nbimpair.isChecked()){
                    nimpair=true;
                    if(!nbpair.isChecked()){
                        npair=false;
                    }
                }


                if(deuxbornes.isChecked()){
                    repdeuxbrnes = true;
                    pav = false;
                    typerep=1;
                }else
                if(quatrebornes.isChecked()){
                    repQuatrebrnes = true;
                    pav = false;
                    typerep=2;
                }else
                if(pavNum.isChecked()){
                    pav = true;
                    typerep=0;
                }

                boolean chaineB = false ;
                if(chaine.isChecked()){
                    chaineB = true;
                }


                ParamEm2 param = null;




                param = new ParamEm2(typerep,nbcal,valMax,nimpair,npair,repdeuxbrnes,pav,repQuatrebrnes,chaineB);

                Boolean operateur[] = new Boolean[4];
                /**on stocke les booleens correspondant aux operations dans le tableau*/

                operateur[0] = additionC.isChecked();
                operateur[1] = soustractionC.isChecked();
                operateur[2] = multiplicationC.isChecked();
                operateur[3] = divisionC.isChecked();

                if(!operateur[0] && !operateur[1] && !operateur[2] && !operateur[3]){
                    operateur[0] = true;
                }
                param.setOperateur(operateur[0],operateur[1],operateur[2],operateur[3]);


                FileOutputStream outputStream;
                ObjectOutputStream oos;
                try {
                    outputStream = openFileOutput("ParamEm2.txt", Context.MODE_PRIVATE);
                    oos = new ObjectOutputStream(outputStream);
                    oos.writeObject(param);

                    oos.flush();
                    oos.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }

                /** quand on a cliqué sur le bouton valider on reviens au menu*/
                Intent intent=new Intent(ModifParamEm2Activity.this, MathsActivity.class);
                startActivity(intent);

            }

        });

    }
}

