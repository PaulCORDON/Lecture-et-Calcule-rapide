package com.projet4a.ensim.lecture_et_calcule_rapide.CalculRapide.Model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * classe définissant les paramètres de Exo1Maths
 */
public class ParamEm1 extends ParamMath implements Parcelable {

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    private String nom;

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

    private boolean frise;

    /**
     * boolean pour dire si l'exercice utilisera une frise ou des boutons
     */

    public ParamEm1()
    /**
     * Constructeur de paramètres par défault
     */
    {
        super();
        nbBornes = 3;
        nbQuestions = 5;
        disparition = true;
        tempsRestantApparant = 3000;
        ordreApparition = true;
        borneSelectionnable = false;
        borneEqualsOp = false;
        valMax = 30;
        frise = true;
    }

    public ParamEm1(boolean f, Long t, Boolean p, Boolean[] o, int nbb, int nbq, Boolean d, long tra, Boolean oa, Boolean bs, Boolean beo, int vm)
    /**
     * Constructeur de paramètres personalisés
     */
    {
        super(t, p, o);
        frise = f;
        nbBornes = nbb;
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
    public int getNbBornes() {
        return nbBornes;
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

    /**
     * @return frise
     */
    public boolean getFrise() {
        return frise;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.nbBornes);
        dest.writeInt(this.nbQuestions);
        dest.writeValue(this.disparition);
        dest.writeLong(this.tempsRestantApparant);
        dest.writeValue(this.ordreApparition);
        dest.writeValue(this.borneSelectionnable);
        dest.writeValue(this.borneEqualsOp);
        dest.writeInt(this.valMax);
        dest.writeByte(this.frise ? (byte) 1 : (byte) 0);
    }

    protected ParamEm1(Parcel in) {
        this.nbBornes = in.readInt();
        this.nbQuestions = in.readInt();
        this.disparition = (Boolean) in.readValue(Boolean.class.getClassLoader());
        this.tempsRestantApparant = in.readLong();
        this.ordreApparition = (Boolean) in.readValue(Boolean.class.getClassLoader());
        this.borneSelectionnable = (Boolean) in.readValue(Boolean.class.getClassLoader());
        this.borneEqualsOp = (Boolean) in.readValue(Boolean.class.getClassLoader());
        this.valMax = in.readInt();
        this.frise = in.readByte() != 0;
    }

    public static final Creator<ParamEm1> CREATOR = new Creator<ParamEm1>() {
        @Override
        public ParamEm1 createFromParcel(Parcel source) {
            return new ParamEm1(source);
        }

        @Override
        public ParamEm1[] newArray(int size) {
            return new ParamEm1[size];
        }
    };
}
