package com.projet4a.ensim.lecture_et_calcule_rapide.CalculRapide.Model;

import java.io.Serializable;

public class ParamEm2 extends ParamMath implements Serializable {

    private int typeRep;
    /**
     * type de réponse à donner par l'élève
     */

    private int nbCalcul;
    /**
     * Nombre de question
     */

    private int valMaxOperande;

    private Boolean nombrePair;
    private Boolean nombreImpair;
    private int typeNombre;


    private Boolean repDeuxBornes;
    private Boolean repQuatreBornes;
    private Boolean repPaveNum;

    /* Gere le fait qu les calculs puissent s'enchainer exemple : 7+8 suivi de 7+18 */
    private boolean calcChaine;


    public ParamEm2()
    /**
     * Constructeur de paramètres par défault
     */
    {
        super();
        typeRep = 0;
        nbCalcul = 5;
        nombrePair = true;
        nombreImpair = true;
        repDeuxBornes = false;
        repQuatreBornes = false;
        repPaveNum = true;
        valMaxOperande = 10;
        typeNombre = 0;
        calcChaine = false;
    }

    public ParamEm2(int typeRep, int nbCalcul, int valMaxOperande, boolean nombreImpair, boolean nombrePair, boolean repDeuxBornes, boolean repPaveNum, boolean repQuatreBornes, boolean chaine)
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
        this.calcChaine = chaine;
        if (nombrePair) {
            this.typeNombre = 0;
        }
        if (nombreImpair) {
            this.typeNombre = 1;
        }
        if (nombreImpair && nombrePair) {
            this.typeNombre = 2;
        }


    }

    /**
     * @return nbBornes
     */
    public int gettypeRep() {
        return typeRep;
    }

    public int getNbCalcul() {
        return nbCalcul;
    }

    public int getValMaxOperande() {
        return valMaxOperande;
    }

    public Boolean getNombrePair() {
        return nombrePair;
    }

    public Boolean getNombreImpair() {
        return nombreImpair;
    }

    public Boolean getRepDeuxBornes() {
        return repDeuxBornes;
    }

    public Boolean getRepQuatreBornes() {
        return repQuatreBornes;
    }

    public Boolean getRepPaveNum() {
        return repPaveNum;
    }

    public int getTypeNombre() {
        return typeNombre;
    }

    public boolean getCalcChaine() {
        return calcChaine;
    }

}
