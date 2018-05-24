package com.projet4a.ensim.lecture_et_calcule_rapide.CalculRapide.Activity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Switch;
import android.widget.Toast;

import com.projet4a.ensim.lecture_et_calcule_rapide.CalculRapide.Model.ParamEm1;
import com.projet4a.ensim.lecture_et_calcule_rapide.CalculRapide.Model.ParamEm2;
import com.projet4a.ensim.lecture_et_calcule_rapide.R;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class ModifParamEm2Activity extends AppCompatActivity {

    static ParamEm2 param = new ParamEm2();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        /**
         * Pour récupérer les parametres déja sérialisés
         */
        try {
            FileInputStream fis = openFileInput("ParamEm2.txt");
            ObjectInputStream ois = new ObjectInputStream(fis);
            param = (ParamEm2) ois.readObject();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

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


        final EditText  nbCal= (EditText)  findViewById(R.id.NbCalcul);
        final EditText  valeurMax= (EditText)  findViewById(R.id.ValMaxOperandes);

        final Switch  nbpair =  (Switch) findViewById(R.id.NbPair);
        final Switch  nbimpair =  (Switch) findViewById(R.id.NbImpair);

        final Switch calcChaine = (Switch) findViewById(R.id.CalculChaine);

        final RadioButton deuxbornes = (RadioButton) findViewById(R.id.DeuxBornes);
        final RadioButton quatrebornes = (RadioButton) findViewById(R.id.QuatreBornes);
        final RadioButton pavNum = (RadioButton) findViewById(R.id.PaveNum);

        /** Bouton qui permet de valider les parametres et de retourner sur la page d'accueil*/
        Button valider=  findViewById(R.id.BtonValider);

        additionC.setChecked(param.getOperateur()[0]);
        soustractionC.setChecked(param.getOperateur()[1]);
        multiplicationC.setChecked(param.getOperateur()[2]);
        divisionC.setChecked(param.getOperateur()[3]);

        nbCal.setText(""+param.getNbCalcul());
        valeurMax.setText(""+param.getValMaxOperande());

        nbpair.setChecked(param.getNombrePair());
        nbimpair.setChecked(param.getNombreImpair());

        calcChaine.setChecked(param.getCalcChaine());

        switch (param.gettypeRep()){
            case 0 :
                pavNum.setChecked(true);
                break;
            case 1 :
                deuxbornes.setChecked(true);
                break;
            case 2 :
                quatrebornes.setChecked(true);
                break;
        }

        /**
         * si on clique sur le bouton valider
         */
        valider.setOnClickListener(new View.OnClickListener() {
            @Override
            /** si le bouton valider a ete cliqué on rentre dans cette methode*/
            public void onClick(View view) {

                boolean parametresCorrects = true;

                int nbcal;
                int valMax;

                /**
                 * verifier si les valeurs de nombre max de calcul et des opérandes sont saisies
                 */
                if (!nbCal.getText().toString().equals(""))
                    nbcal = Integer.parseInt(nbCal.getText().toString());
                else nbcal = param.getNbCalcul();

                if (!valeurMax.getText().toString().equals(""))
                    valMax = Integer.parseInt(valeurMax.getText().toString());
                else valMax = param.getValMaxOperande();

                /**
                 * declaration des variables
                 * récupération des valeurs entrées par l'utilisateur
                 */
                boolean npair = nbpair.isChecked();
                boolean nimpair = nbimpair.isChecked();
                boolean repdeuxbrnes = deuxbornes.isChecked();
                boolean repQuatrebrnes = quatrebornes.isChecked();
                boolean pav = pavNum.isChecked();
                boolean chaine = calcChaine.isChecked();
                int typerep = 0;
                if(pav) typerep = 0;
                else if(repdeuxbrnes) typerep = 1;
                else if(repQuatrebrnes) typerep = 2;
                else parametresCorrects = false;

                Boolean operateur[] = new Boolean[4];
                /**on stocke les booleens correspondant aux operations dans le tableau*/
                operateur[0] = additionC.isChecked();
                operateur[1] = soustractionC.isChecked();
                operateur[2] = multiplicationC.isChecked();
                operateur[3] = divisionC.isChecked();

                if (!operateur[0] && !operateur[1] && !operateur[2] && !operateur[3]) {
                    Toast.makeText(ModifParamEm2Activity.this,"Selectionne au moins un opérateur",Toast.LENGTH_SHORT).show();

                    additionC.setTextColor(Color.RED);
                    soustractionC.setTextColor(Color.RED);
                    multiplicationC.setTextColor(Color.RED);
                    divisionC.setTextColor(Color.RED);

                    parametresCorrects = false;
                }
                if(!nimpair && !npair){
                    Toast.makeText(ModifParamEm2Activity.this,"Selectionne au moins un type de nombre pair ou impair",Toast.LENGTH_SHORT).show();

                    nbimpair.setTextColor(Color.RED);
                    nbpair.setTextColor(Color.RED);

                    parametresCorrects = false;
                }


                if(parametresCorrects){

                     param = new ParamEm2(typerep,nbcal,valMax,nimpair,npair,repdeuxbrnes,pav,repQuatrebrnes,chaine);


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

                    /** quand on a clique sur le bouton valider on reviens au menu*/
                    Intent intent=new Intent(ModifParamEm2Activity.this, MathsActivity.class);
                    startActivity(intent);
                }
            }

        });

        View.OnClickListener retourEcritEnNoir = (new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                additionC.setTextColor(Color.BLACK);
                soustractionC.setTextColor(Color.BLACK);
                divisionC.setTextColor(Color.BLACK);
                multiplicationC.setTextColor(Color.BLACK);
            }
        });

        additionC.setOnClickListener(retourEcritEnNoir);
        soustractionC.setOnClickListener(retourEcritEnNoir);
        divisionC.setOnClickListener(retourEcritEnNoir);
        multiplicationC.setOnClickListener(retourEcritEnNoir);

        View.OnClickListener retourEcritEnNoirParite = (new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                nbimpair.setTextColor(Color.BLACK);
                nbpair.setTextColor(Color.BLACK);
            }
        });

        nbimpair.setOnClickListener(retourEcritEnNoirParite);
        nbpair.setOnClickListener(retourEcritEnNoirParite);

        pavNum.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                deuxbornes.setChecked(false);
                quatrebornes.setChecked(false);
            }
        });

        deuxbornes.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                pavNum.setChecked(false);
                quatrebornes.setChecked(false);
            }
        });

        quatrebornes.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                deuxbornes.setChecked(false);
                pavNum.setChecked(false);
            }
        });
    }
}

