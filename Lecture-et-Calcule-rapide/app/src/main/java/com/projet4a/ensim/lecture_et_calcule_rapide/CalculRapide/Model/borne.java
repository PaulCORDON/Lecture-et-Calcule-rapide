package com.projet4a.ensim.lecture_et_calcule_rapide.CalculRapide.Model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

public class borne implements Parcelable {
    ArrayList<Integer> bornes;

    public borne(int nbBornes) {
        bornes = new ArrayList<>(nbBornes);
    }

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
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeList(this.bornes);
    }

    protected borne(Parcel in) {
        this.bornes = new ArrayList<Integer>();
        in.readList(this.bornes, Integer.class.getClassLoader());
    }

    public static final Parcelable.Creator<borne> CREATOR = new Parcelable.Creator<borne>() {
        @Override
        public borne createFromParcel(Parcel source) {
            return new borne(source);
        }

        @Override
        public borne[] newArray(int size) {
            return new borne[size];
        }
    };
}