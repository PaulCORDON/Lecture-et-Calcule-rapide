package com.projet4a.ensim.lecture_et_calcule_rapide;

public abstract class Exercice
{
    private Double note;

    private int bonneRep;

    private int mauvaiseRep;


    private void calculeNote()
    {
        //TODO calculNote()
    }

    public void afficheNote()
    {
        //TODO afficheNote()
    }


    public Double getNote() {return note;}

    public int getBonneRep() {return bonneRep;}

    public int getMauvaiseRep() {return mauvaiseRep;}


    public void setNote(Double note) {this.note = note;}

    public void setBonneRep(int bonneRep) {this.bonneRep = bonneRep;}

    public void setMauvaiseRep(int mauvaiseRep) {this.mauvaiseRep = mauvaiseRep;}
}
