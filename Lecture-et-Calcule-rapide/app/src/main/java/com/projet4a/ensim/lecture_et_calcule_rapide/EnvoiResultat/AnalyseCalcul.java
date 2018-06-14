package com.projet4a.ensim.lecture_et_calcule_rapide.EnvoiResultat;

import android.widget.Switch;

import com.projet4a.ensim.lecture_et_calcule_rapide.CalculRapide.Model.Calcul;

/**
 *
 * class qui analyse 
 */
public class AnalyseCalcul {

        public static void analyseCalcul(Calcul C, boolean repJ){
            switch(C.getOperation()){
                case "+":
                    Updateliste("CalculAddition" ,repJ);
                    break;
                case "-":
                    Updateliste("CalculSoustraction" ,repJ);
                    break;
                case "*":
                    Updateliste("CalculMultiplication " ,repJ);
                    break;
                case "/":
                    Updateliste("CalculDivision" ,repJ);
                    break;
            }

            switch (C.getOp1Int()){
                case 3:
                    Updateliste("PbTrois" ,repJ);
                    break;
                case 7:
                    Updateliste("PbSept" ,repJ);
                    break;
                case 8 :
                    Updateliste("PbHuit" ,repJ);
                    break;
                case 9 :
                    Updateliste("PbNeuf" ,repJ);
                    break;
            }
            switch (C.getOp2Int()){
                case 3:
                    Updateliste("PbTrois" ,repJ);
                    break;
                case 7:
                    Updateliste("PbSept" ,repJ);
                    break;
                case 8 :
                    Updateliste("PbHuit" ,repJ);
                    break;
                case 9 :
                    Updateliste("PbNeuf" ,repJ);
                    break;
            }


        }

        private static void Updateliste(String nomCrit,boolean rep){
            ListeCriteres.update(nomCrit,rep);
        }
}
