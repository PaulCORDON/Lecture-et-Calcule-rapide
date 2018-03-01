package com.projet4a.ensim.lecture_et_calcule_rapide.CalculRapide.Model;

import java.io.Serializable;

public class ParamEm2 extends ParamMath implements Serializable {

    private int typeRep;

    private int nbCalcul;
    /**
     * type de réponse à donner par l'élève
     */

    private int valMaxOperande;
    /**
     * Nombre de question
     */
    private Boolean nombrePair;
    private Boolean nombreImpair;

    /**
     * Vrai : le premier element disparait, Faux : les deux elements s'affiche en meme temps
     */

    private Boolean repDeuxBornes;
    private Boolean repQuatreBornes;
    private Boolean repPaveNum;
    /**
     * Vrai : calcul puis bornes, Faux : bornes puis calcul
     */
    public ParamEm2()
    /**
     * Constructeur de paramètres par défault
     */
    {
        super();
        typeRep = 3;
        nbCalcul = 5;
        nombrePair = true;
        nombreImpair = true;
        repDeuxBornes = false;
        repQuatreBornes = false;
        repPaveNum = true;
        valMaxOperande = 30;
    }

    public ParamEm2(int typeRep,int nbCalcul,int valMaxOperande,boolean nombreImpair,boolean nombrePair,boolean repDeuxBornes,boolean repPaveNum,boolean repQuatreBornes)
    /**
     * Constructeur de paramètres personalisés
     */
    {
        super();
        this.typeRep = typeRep;
        this.nbCalcul = nbCalcul;
        this.nombrePair = nombrePair;
        this.nombreImpair = nombreImpair;
        this.repDeuxBornes = repDeuxBornes;
        this.repQuatreBornes = repQuatreBornes;
        this.repPaveNum = repPaveNum;
        this.valMaxOperande = valMaxOperande;
    }

    /**
     * @return nbBornes
     */
    public int gettypeRep() {
        return typeRep;
    }

    public int getNbCalcul() {return nbCalcul;}

    public int getValMaxOperande() {return valMaxOperande;}

    public Boolean getNombrePair() {return nombrePair;}

    public Boolean getNombreImpair() {return nombreImpair;}

    public Boolean getRepDeuxBornes() {return repDeuxBornes;}

    public Boolean getRepQuatreBornes() {return repQuatreBornes;}

    public Boolean getRepPaveNum() {return repPaveNum;}


}
