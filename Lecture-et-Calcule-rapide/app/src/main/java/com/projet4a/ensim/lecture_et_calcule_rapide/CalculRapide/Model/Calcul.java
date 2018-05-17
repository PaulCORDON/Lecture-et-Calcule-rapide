package com.projet4a.ensim.lecture_et_calcule_rapide.CalculRapide.Model;

import android.os.Parcel;
import android.os.Parcelable;

import com.projet4a.ensim.lecture_et_calcule_rapide.EnvoiResultat.Critere;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * classe d'un calcul
 */
public class Calcul implements Parcelable {
    private int operande1;
    private int operande2;
    private char operation;
    private boolean multiOp = false;
    private int resultat;
    private ArrayList<Critere> listCrit;
    /**
     * Constructeur de la classe calcul.
     *
     * @param op1  le premier operande du calcul.
     * @param op2  le second operande du calcul.
     * @param oper l'operation du calcul.
     */
    public Calcul(int op1, int op2, char oper) {
        operande1 = op1;
        operande2 = op2;
        operation = oper;
        switch (operation) {
            case '+':
                resultat = operande1 + operande2;
                break;
            case '-':
                if (operande1 < operande2) {
                    int tempo = operande1;
                    operande1 = operande2;
                    operande2 = tempo;
                }
                resultat = operande1 - operande2;
                break;
            case '*':
                resultat = operande1 * operande2;
                operation='X';
                break;
            case '/':
                resultat = operande1 * operande2;
                int tempo = resultat;
                resultat = operande1;
                operande1= operande2;
                operande2=tempo;

                tempo = operande1;
                operande1 = operande2;
                operande2 = tempo;
                break;
        }

    }



    public String getCalculString() {
        if(multiOp){
            //return "" + cal.getOp1Int() + " " + cal.getOperation() + " " + cal.getOp2Int() + " " + operande2;
        }

        return "" + operande1 + operation + operande2 + " =";
    }

    public String getOp1String() {
        return "" + operande1;
    }

    public String getOp2String() {
        return "" + operande2;
    }

    public int getOp1Int() {
        return operande1;
    }

    public int getOp2Int() {
        return operande2;
    }

    public String getOperation() {
        return "" + operation;
    }

    public int getResultatInt() {
        return resultat;
    }

    public String getResultatString() {
        return "" + resultat;
    }

    public String ToString() {
        if(multiOp){
           //return "" + cal.getOp1Int() + " " + cal.getOperation() + " " + cal.getOp2Int() + " " + operande2 + " = " + resultat;
        }
            return "" + operande1 + " " + operation + " " + operande2 + " = " + resultat; }



    private void setOperande1(int Op){operande1 = Op;}

    private void setOperande2(int Op){operande2 = Op;}

    private void setOperation(char Op){operation = Op;}

    public Calcul(){

    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.operande1);
        dest.writeInt(this.operande2);
        dest.writeInt(this.operation);
        dest.writeByte(this.multiOp ? (byte) 1 : (byte) 0);
        dest.writeInt(this.resultat);
        dest.writeList(this.listCrit);
    }

    protected Calcul(Parcel in) {
        this.operande1 = in.readInt();
        this.operande2 = in.readInt();
        this.operation = (char) in.readInt();
        this.multiOp = in.readByte() != 0;
        this.resultat = in.readInt();
        this.listCrit = new ArrayList<Critere>();
        in.readList(this.listCrit, Critere.class.getClassLoader());
    }

    public static final Creator<Calcul> CREATOR = new Creator<Calcul>() {
        @Override
        public Calcul createFromParcel(Parcel source) {
            return new Calcul(source);
        }

        @Override
        public Calcul[] newArray(int size) {
            return new Calcul[size];
        }
    };
}
