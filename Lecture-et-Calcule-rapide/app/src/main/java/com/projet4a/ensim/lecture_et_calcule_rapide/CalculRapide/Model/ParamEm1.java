package com.projet4a.ensim.lecture_et_calcule_rapide.CalculRapide.Model;

public class ParamEm1 extends ParamMath
    /**
     * classe définissant les paramètres de Exo1Maths
    */
{
    private int nbBornes;
    /**
     * Nombre de bornes
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
    private Boolean calculDisparait;
    /**
     * Vrai : le calcul disparait, Faux : le calcul reste apparant
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

    public ParamEm1()
    /**
     * Constructeur de paramètres par défault
     */
    {
        super();
        nbBornes=3;
        nbQuestions=5;
        calculDisparait=false;
        ordreApparition=true;
        borneSelectionnable=false;
        borneEqualsOp=false;
        valMax=30;
    }

    public ParamEm1(Long t, Boolean p,  Boolean[] o, int nbb, int nbq, Boolean cd, Boolean oa, Boolean bs, Boolean beo, int vm)
    /**
     * Constructeur de paramètres personalisés
     */
    {
        super(t, p, o);
        nbBornes=nbb;
        nbQuestions=nbq;
        calculDisparait=cd;
        ordreApparition=oa;
        borneSelectionnable=bs;
        borneEqualsOp=beo;
        valMax=vm;
    }


    /**
     * @return nbBornes
     */
    public int getNbBornes(){return nbBornes;}

    /**
     * @return nbQuestions
     */
    public int getNbQuestions(){return nbQuestions;}

    /**
     * @return calculDisparait
     */
    public Boolean getCalculDisparait(){return calculDisparait;}

    /**
     * @return ordreApparition
     */
    public Boolean getOrdreApparition(){return ordreApparition;}

    /**
     * @return borneSelectionnable
     */
    public Boolean getBorneSelectionnable(){return borneSelectionnable;}

    /**
     * @return borneEqualsOp
     */
    public Boolean getBorneEqualsOp(){return borneEqualsOp;}

    /**
     * @return valMax
     */
    public int getValMax(){return valMax;}
}
