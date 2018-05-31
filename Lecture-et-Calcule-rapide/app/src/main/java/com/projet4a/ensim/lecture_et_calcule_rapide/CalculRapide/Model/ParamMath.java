package com.projet4a.ensim.lecture_et_calcule_rapide.CalculRapide.Model;

import java.io.Serializable;

/**
 * Classe definissant les paramètres communs a chaque exercice de maths
 */
abstract class ParamMath implements Serializable {
    /**
     * Temps avant de passer à la question suivante
     */
    private Long tempsRep;

    /**
     * Vrai : on ne choisira que des nombres pair, Faux : les nombres impairs sont autorisés
     */
    private Boolean pairOnly;

    /**
     * Vrai : on peut choisir l'opérateur, Faux : on ne choisira pas cet opérateur
     * 0 : +
     * 1 : -
     * 2 : *
     * 3 : /
     */
    private Boolean operateur[];

    /**
     * constructeur des paramètres par défault
     */
    ParamMath() {
        tempsRep = new Long(5000);
        pairOnly = true;

        operateur = new Boolean[4];
        operateur[0] = true;
        operateur[1] = false;
        operateur[2] = false;
        operateur[3] = false;
    }

    /**
     * constructeur des paramètres personnalisés
     */
    ParamMath(Long t, Boolean p, Boolean[] o) {
        tempsRep = t;
        pairOnly = p;
        operateur = o;
    }

    /**
     * @return tempsRep
     */
    public Long getTempsRep() {
        return tempsRep;
    }

    /**
     * @return pairOnly
     */
    public Boolean getPairOnly() {
        return pairOnly;
    }

    /**
     * @return operateur
     */
    public Boolean[] getOperateur() {
        return operateur;
    }


    /**
     * boolean :
     *
     * @param a add
     * @param b sous
     * @param c mult
     * @param d div
     */
    public void setOperateur(boolean a, boolean b, boolean c, boolean d) {
        operateur[0] = a;
        operateur[1] = b;
        operateur[2] = c;
        operateur[3] = d;
    }
}
