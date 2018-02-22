package com.projet4a.ensim.lecture_et_calcule_rapide.CalculRapide.Model;

import java.io.Serializable;

public class ParamEm2 extends ParamMath implements Serializable {
    private int typeRep;
    /**
     * type de réponse à donner par l'élève
     */

    private int nbQuestions;
    /**
     * Nombre de question
     */

    /*TODO modifier pour l'associer à ordre d'apparition,
        calcul apparait disparait puis borne apparait
        OU
        bornes apparaissent disparaissent puis calcul apparait
     */
    private Boolean disparition;

    /**
     * Vrai : le premier element disparait, Faux : les deux elements s'affiche en meme temps
     */

    private long tempsRestantApparant;
    /**
     * temps pendant lequel le premier element affiché reste apparant dans le cas ou il disparait
     */

    private Boolean ordreApparition;
    /**
     * Vrai : calcul puis bornes, Faux : bornes puis calcul
     */

    private Boolean borneSelectionnable;
    /**
     * Vrai : la borne peut etre le resultat où il faut cliquer, Faux : les bornes ne seront jamais egales aux resultats
     */

    private Boolean borneEqualsOp;
    /**
     * Vrai : une bornes est toujours egale à un opérande à +/- distance , Faux : les bornes sont aléatoires
     */
    //TODO paramètre distance entre borne et opérande dans le cas où une borne doit etre proche d'un opérande

    private int valMax;

    /**
     * Valeur maximale présente dans l'exercice
     */
    //TODO ajouter valMin, valeur minimum présente dans l'exercice
    public ParamEm2()
    /**
     * Constructeur de paramètres par défault
     */
    {
        super();
        typeRep = 3;
        nbQuestions = 5;
        disparition = true;
        tempsRestantApparant = 3000;
        ordreApparition = true;
        borneSelectionnable = false;
        borneEqualsOp = false;
        valMax = 30;
    }

    public ParamEm2(Long t, Boolean p, Boolean[] o, int nbb, int nbq, Boolean d, long tra, Boolean oa, Boolean bs, Boolean beo, int vm)
    /**
     * Constructeur de paramètres personalisés
     */
    {
        super(t, p, o);
        typeRep = nbb;
        nbQuestions = nbq;
        disparition = d;
        tempsRestantApparant = tra;
        ordreApparition = oa;
        borneSelectionnable = bs;
        borneEqualsOp = beo;
        valMax = vm;
    }

    /**
     * @return nbBornes
     */
    public int gettypeRep() {
        return typeRep;
    }

    /**
     * @return nbQuestions
     */
    public int getNbQuestions() {
        return nbQuestions;
    }

    /**
     * @return disparition
     */
    public Boolean getDisparition() {
        return disparition;
    }

    /**
     * @return tempsRestantApparant
     */
    public long getTempsRestantApparant() {
        return tempsRestantApparant;
    }

    /**
     * @return ordreApparition
     */
    public Boolean getOrdreApparition() {
        return ordreApparition;
    }

    /**
     * @return borneSelectionnable
     */
    public Boolean getBorneSelectionnable() {
        return borneSelectionnable;
    }

    /**
     * @return borneEqualsOp
     */
    public Boolean getBorneEqualsOp() {
        return borneEqualsOp;
    }

    /**
     * @return valMax
     */
    public int getValMax() {
        return valMax;
    }
}
