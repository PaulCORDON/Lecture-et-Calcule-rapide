package com.projet4a.ensim.lecture_et_calcule_rapide.CalculRapide.Model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

/**
 *
 * Class borne modélisant les bornes des exercices de maths contenant une arraylist d'entier
 */

public class borne implements Parcelable {
    ArrayList<Integer> bornes;
    /**
     *
     * getter renvoyant la liste des bornes
     * @return renvoie la liste des bornes
     */
    public ArrayList<Integer> getBornes() {
        return bornes;
    }


    /**
     *
     * constructeur , 1 paramètre qui est le nombre de borne
     * @param nbBornes, le nombre de borne
     */
    public borne(int nbBornes) {
        bornes = new ArrayList<>(nbBornes);
    }

    /**
     *
     *
     * @param in
     */
    protected borne(Parcel in) {
    }


    /**
     *
     *  Permet de creer des bornes
     */
    public static final Creator<borne> CREATOR = new Creator<borne>() {
        @Override
        public borne createFromParcel(Parcel in) {
            return new borne(in);
        }

        @Override
        public borne[] newArray(int size) {
            return new borne[size];
        }
    };


    /**
     *
     * permet d'ajouter une borne
     * @param borne , la borne a ajouter
     */
    public void add(int borne) {
        bornes.add(borne);
    }

    /**
     *
     * Méthode pour connaitre le nombre de borne
     * @return la taille de l'arrayList comportant les bornes
     */
    public int size() {
        return bornes.size();
    }

    /**
     *
     * Méthode renvoyant la valeur de la borne d'index j
     * @param j l'index de la borne
     * @return la valeur de la borne
     */
    public int get(int j) {
        return bornes.get(j);
    }

    /**
     *
     * Méthode pour insérer une borne de valeur j à l'index i
     * @param j
     * @param i
     */
    public void set(int j, int i) {
        bornes.set(j, i);
    }

    /**
     *
     * Méthode pour connaitre l'index de la borne b
     * @param b
     * @return l'index de la borne b
     */
    public int indexOf(int b) {
        return bornes.indexOf(b);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
    }
}