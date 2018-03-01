package com.projet4a.ensim.lecture_et_calcule_rapide.CalculRapide.Activity;

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

/**
 * Created by HP on 22/02/2018.
 */

public class ModifParamEm2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modif_param_em2);

        final EditText  nbCal=  findViewById(R.id.NbCalcul);
        final EditText  valeurMax=  findViewById(R.id.ValMaxOperandes);

        final CheckBox  nbpair = findViewById(R.id.NbPair);
        final CheckBox  nbimpair = findViewById(R.id.NbImpair);

        final RadioButton deuxbornes = findViewById(R.id.DeuxBornes);
        final RadioButton quatrebornes = findViewById(R.id.QuatreBornes);
        final RadioButton pavNum = findViewById(R.id.PaveNum);

        /** Bouton qui permet de valider les parametres et de retourner sur la page d'accueil*/
        Button valider=  findViewById(R.id.BtonValider);

        valider.setOnClickListener(new View.OnClickListener() {
            @Override
            /** si le bouton valider a ete cliqué on rentre dans cette methode*/
            public void onClick(View view) {

                int nbcal;
                int valMax;

                if (!nbCal.getText().toString().equals(""))
                    nbcal = Integer.parseInt(nbCal.getText().toString());
                else nbcal = 10;

                if (!valeurMax.getText().toString().equals(""))
                    valMax = Integer.parseInt(valeurMax.getText().toString());
                else valMax = 10;

                boolean npair=false, nimpair=false,repdeuxbrnes=false,repQuatrebrnes=false,pav=false;
                int typerep = 0;

                if(nbpair.isChecked()){
                    npair=true;
                }

                if(nbpair.isChecked()){
                    nimpair=true;
                }
                if(deuxbornes.isChecked()){
                    repdeuxbrnes = true;
                    typerep=1;
                }else
                if(quatrebornes.isChecked()){
                    repQuatrebrnes = true;
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
                    Log.i("info", "type de reponse:"+param.gettypeRep()+"nb calcul: " + param.getNbCalcul() + "\nvaleur max des operandes: " + param.getValMaxOperande() + "\nnombre pair: " + param.getNombrePair() + "\nnb impair: " + param.getNombreImpair() +
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
                    Log.i("info", "type de reponse:"+param.gettypeRep()+"nb calcul: " + param.getNbCalcul() + "\nvaleur max des operandes: " + param.getValMaxOperande() + "\nnombre pair: " + param.getNombrePair() + "\nnb impair: " + param.getNombreImpair() +
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
                    Log.i("info", "type de reponse:"+param.gettypeRep()+"nb calcul: " + param.getNbCalcul() + "\nvaleur max des operandes: " + param.getValMaxOperande() + "\nnombre pair: " + param.getNombrePair() + "\nnb impair: " + param.getNombreImpair() +
                            "\ndeux bornes: " + param.getRepDeuxBornes() + "\npave num: " + param.getRepPaveNum() + "\nquatre bornes: " + param.getRepQuatreBornes());
                }



                /** quand on a clique sur le bouton valider on reviens au menu*/
                Intent intent=new Intent(ModifParamEm2Activity.this, MathsActivity.class);
                startActivity(intent);

            }

        });

    }
}

