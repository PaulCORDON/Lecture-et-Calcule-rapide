package com.projet4a.ensim.lecture_et_calcule_rapide.CalculRapide.Model;

abstract class ParamMath
        /**
         * Classe definissant les paramètres communs a chaque exercice de maths
         */
{
    private Long tempsRep;
    /**
     * Temps avant de passer à la question suivante
     */

    private Boolean pairOnly;
    /**
     * Vrai : on ne choisira que des nombres pair, Faux : les nombres impairs sont autorisés
     */

    private Boolean operateur[];
    /**
     * Vrai : on peut choisir l'opérateur, Faux : on ne choisira pas cet opérateur
     * 0 : +
     * 1 : -
     * 2 : *
     * 3 : /
     */

    ParamMath()
    /**
     * constructeur des paramètres par défault
     */
    {
        tempsRep=new Long(30);
        pairOnly=true;

        operateur = new Boolean[4];
            operateur[0]=true;
            operateur[1]=false;
            operateur[2]=true;
            operateur[3]=false;

    }

    ParamMath(Long t, Boolean p, Boolean[] o)
    /**
     * constructeur des paramètres personnalisés
     */
    {
        tempsRep=t;
        pairOnly=p;
        operateur=o;
    }

    /**
     * @return tempsRep
     */
    public Long getTempsRep(){return tempsRep;}

    /**
     * @return pairOnly
     */
    public Boolean getPairOnly(){return pairOnly;}

    /**
     * @return operateur
     */
    public Boolean[] getOperateur() {return operateur;}
}
