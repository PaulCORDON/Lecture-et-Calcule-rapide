package com.projet4a.ensim.lecture_et_calcule_rapide.CalculRapide.Model;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;

import java.io.Serializable;
import java.util.ArrayList;

public class Exo2Math implements Parcelable {

    /**
     * liste des calculs
     */
    private ArrayList<Calcul> enoncees = new ArrayList<>();

    private ParamEm2 param;

    private int op1;
    private int op2;
    private int choixOp;


    private boolean choixOpVali = true;
    /**
     * si les bornes sont validée alors on passe à false
     */
    private static boolean Nvalide = true;
    private  int a = 0;
    public Exo2Math(ParamEm2 param) {
        this.param = param;

        while (a < this.param.getNbCalcul()){


                Log.w("création operande","opeeeeeeerrrrrrrrrrrandeeeeeeeee");
                op1 = (int) (Math.random() * param.getValMaxOperande());
                op2 = (int) (Math.random() * param.getValMaxOperande());
                op1 = op1+1;
                op2 = op2+1;
                Log.w("création operande","NUm question : " + a + " 1 :" + op1 + "   2 : " + op2);
                if(this.param.getTypeNombre() == 1) {
                    if(op1%2 != 0 && op2%2 != 0){
                    choixOpVali = true;
                    do {
                        choixOp = (int) (Math.random() * 4);
                        if (param.getOperateur()[choixOp]) {
                            choixOpVali = false;
                        }
                    } while (choixOpVali);

                    switch (choixOp) {
                        case 0:
                            enoncees.add(new Calcul(op1, op2, '+'));
                            break;
                        case 1:
                            enoncees.add(new Calcul(op1, op2, '-'));
                            break;
                        case 2:
                            enoncees.add(new Calcul(op1, op2, '*'));
                            break;
                        case 3:
                            enoncees.add(new Calcul(op1, op2, '/'));
                            break;


                    }

                    a++;
                }
                }
                if(this.param.getTypeNombre() == 0){
            if(op1%2 == 0 && op2%2==0){
                    choixOpVali = true;
                    do{
                        choixOp = (int) (Math.random() * 4);
                        if (param.getOperateur()[choixOp]){
                            choixOpVali = false;
                        }
                    }while (choixOpVali);

                    switch (choixOp){
                        case 0:
                            enoncees.add(new Calcul(op1, op2, '+'));
                            break;
                        case 1:
                            enoncees.add(new Calcul(op1, op2, '-'));
                            break;
                        case 2:
                            enoncees.add(new Calcul(op1, op2, '*'));
                            break;
                        case 3 :
                            enoncees.add(new Calcul(op1,op2,'/'));
                            break;


                    }

                    a++;
                }

                }
                if (this.param.getTypeNombre() == 2){

                    choixOpVali = true;
                    do{
                        choixOp = (int) (Math.random() * 4);
                        if (param.getOperateur()[choixOp]){
                            choixOpVali = false;
                        }
                    }while (choixOpVali);

                    switch (choixOp){
                        case 0:
                            enoncees.add(new Calcul(op1, op2, '+'));
                            break;
                        case 1:
                            enoncees.add(new Calcul(op1, op2, '-'));
                            break;
                        case 2:
                            enoncees.add(new Calcul(op1, op2, '*'));
                            break;
                        case 3 :
                            enoncees.add(new Calcul(op1,op2,'/'));
                            break;


                    }

                    a++;


            }

        }
    }

    /**
     * @return la réponse du calcul sous forme de string
     */
    public ArrayList<Calcul> getCalcul() {
        return enoncees;
    }

    /**
     * @return le type de reponse que l'élève doit donner
     */
    public ParamEm2 getParam() {
        return param;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeList(this.enoncees);
        dest.writeSerializable(this.param);
        dest.writeInt(this.op1);
        dest.writeInt(this.op2);
        dest.writeInt(this.choixOp);
        dest.writeByte(this.choixOpVali ? (byte) 1 : (byte) 0);
        dest.writeInt(this.a);
    }

    protected Exo2Math(Parcel in) {
        this.enoncees = new ArrayList<Calcul>();
        in.readList(this.enoncees, Calcul.class.getClassLoader());
        this.param = (ParamEm2) in.readSerializable();
        this.op1 = in.readInt();
        this.op2 = in.readInt();
        this.choixOp = in.readInt();
        this.choixOpVali = in.readByte() != 0;
        this.a = in.readInt();
    }

    public static final Parcelable.Creator<Exo2Math> CREATOR = new Parcelable.Creator<Exo2Math>() {
        @Override
        public Exo2Math createFromParcel(Parcel source) {
            return new Exo2Math(source);
        }

        @Override
        public Exo2Math[] newArray(int size) {
            return new Exo2Math[size];
        }
    };
}
