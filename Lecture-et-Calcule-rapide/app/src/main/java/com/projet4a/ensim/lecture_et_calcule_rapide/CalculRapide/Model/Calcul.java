package com.projet4a.ensim.lecture_et_calcule_rapide.CalculRapide.Model;

import java.io.Serializable;

/**
 * classe d'un calcul
 */
public class Calcul implements Serializable {
    private int operande1;
    private int operande2;
    private char operation;
    private boolean multiOp = false;
    private int resultat;

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

        return "" + operande1 + operation + operande2;
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
}
