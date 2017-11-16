package com.projet4a.ensim.lecture_et_calcule_rapide.CalculRapide.Model;

import java.sql.Time;

/**
 * Created by Cordon Paul on 07/11/2017.
 */

abstract class ParamMath {

   public Time tempsRep;

    public Boolean pairOnly;

    public Boolean chiffres;

    public Boolean operateur[] = new Boolean[5];



        // 0 : +
        // 1 : -
        // 2 : *
        // 3 : /
}
