package com.projet4a.ensim.lecture_et_calcule_rapide.CalculRapide.Model;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;
import java.util.ArrayList;

public class borne implements Parcelable{
    public ArrayList<Integer> getBornes() {
        return bornes;
    }

    ArrayList<Integer> bornes;

    public borne(int nbBornes) {
        bornes = new ArrayList<>(nbBornes);
    }

    protected borne(Parcel in) {
    }

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

    public void add(int borne) {
        bornes.add(borne);
    }

    public int size() {
        return bornes.size();
    }

    public int get(int j) {
        return bornes.get(j);
    }

    public void set(int j, int i) {
        bornes.set(j,i);
    }

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