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

        /**
         * si on clique sur le bouton valider
         */
        valider.setOnClickListener(new View.OnClickListener() {
            @Override
            /** si le bouton valider a ete cliqué on rentre dans cette methode*/
            public void onClick(View view) {

                int nbcal;
                int valMax;

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

                ParamEm2 param = null;


                /** Si les deux champs de saisie pour le nombre de calcul et la valeur max des opérandes sont remplis on recupere les valeurs des parametres
                 * et on construit un nouvel objet param avec ces parametres
                 */
                if(!valeurMax.getText().toString().equals("") && !nbCal.getText().toString().equals("")) {
                    param = new ParamEm2(
                            typerep,
                            nbcal,
                            valMax,
                            nimpair,
                            npair,
                            repdeuxbrnes,
                            pav,
                            repQuatrebrnes);
                    Log.i("info", "type de reponse:"+param.gettypeRep()+"nb calcul: " + param.getNbCalcul() + "\nvaleur max des operandes: " + param.getValMaxOperande() + "\nnombre pair: " + param.getNombrePair() + "\nnb impair: " + param.getNombreImpair() +
                            "\ndeux bornes: " + param.getRepDeuxBornes() + "\npave num: " + param.getRepPaveNum() + "\nquatre bornes: " + param.getRepQuatreBornes());
                }
                /** Si le champ de saisie pour le nombre de calcul et la valeur max des opérandes ne sont pas remplis on recupere les valeurs des parametres
                 * et on construit un nouvel objet param avec ces parametres
                 */
                if(valeurMax.getText().toString().equals("") && nbCal.getText().toString().equals("")) {
                    param = new ParamEm2(
                            typerep,
                            10,
                            10,
                            nimpair,
                            npair,
                            repdeuxbrnes,
                            pav,
                            repQuatrebrnes);

                    Log.w("info", "type de reponse:"+param.gettypeRep()+"nb calcul: " + param.getNbCalcul() + "\nvaleur max des operandes: " + param.getValMaxOperande() + "\nnombre pair: " + param.getNombrePair() + "\nnb impair: " + param.getNombreImpair() +
                            "\ndeux bornes: " + param.getRepDeuxBornes() + "\npave num: " + param.getRepPaveNum() + "\nquatre bornes: " + param.getRepQuatreBornes());
                }
                /** Si le champ de saisie pour le nombre de calcul est rempli on recupere les valeurs des parametres
                 * et on construit un nouvel objet param avec ces parametres
                 */
                if(valeurMax.getText().toString().equals("") && !nbCal.getText().toString().equals("")) {
                    param = new ParamEm2(
                            typerep,
                            nbcal,
                            10,
                            nimpair,
                            npair,
                            repdeuxbrnes,
                            pav,
                            repQuatrebrnes);
                    Log.w("info", "type de reponse:"+param.gettypeRep()+"nb calcul: " + param.getNbCalcul() + "\nvaleur max des operandes: " + param.getValMaxOperande() + "\nnombre pair: " + param.getNombrePair() + "\nnb impair: " + param.getNombreImpair() +
                            "\ndeux bornes: " + param.getRepDeuxBornes() + "\npave num: " + param.getRepPaveNum() + "\nquatre bornes: " + param.getRepQuatreBornes());
                }
                /** Si le champ de saisie pour la valeur max des operandes est rempli on recupere les valeurs des parametres
                 * et on construit un nouvel objet param avec ces parametres
                 */
                if(!valeurMax.getText().toString().equals("") && nbCal.getText().toString().equals("")) {
                    param = new ParamEm2(
                            typerep,
                            10,
                            valMax,
                            nimpair,
                            npair,
                            repdeuxbrnes,
                            pav,
                            repQuatrebrnes);
                    Log.w("info", "type de reponse:"+param.gettypeRep()+"nb calcul: " + param.getNbCalcul() + "\nvaleur max des operandes: " + param.getValMaxOperande() + "\nnombre pair: " + param.getNombrePair() + "\nnb impair: " + param.getNombreImpair() +
                            "\ndeux bornes: " + param.getRepDeuxBornes() + "\npave num: " + param.getRepPaveNum() + "\nquatre bornes: " + param.getRepQuatreBornes());
                }

                Boolean operateur[] = new Boolean[4];
                /**on stocke les booleens correspondant aux operations dans le tableau*/
                operateur[0] = additionC.isChecked();
                operateur[1] = soustractionC.isChecked();
                operateur[2] = multiplicationC.isChecked();
                operateur[3] = divisionC.isChecked();

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

        });

    }
}

