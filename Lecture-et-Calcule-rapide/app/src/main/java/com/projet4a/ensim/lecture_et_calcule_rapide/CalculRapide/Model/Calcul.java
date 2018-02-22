package com.projet4a.ensim.lecture_et_calcule_rapide.CalculRapide.Model;

/**
 * classe d'un calcul
 */
public class Calcul {
    private int operande1;
    private int operande2;

    private char operation;

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
                resultat = operande1 - operande2;
                break;
            case '*':
                resultat = operande1 * operande2;
                break;
            case '/':
                resultat = operande1 / operande2;
                break;
        }
    }

    public String getCalculString() {
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
}
