package models;

import java.text.DecimalFormat;

public class Pneu {
    // MR Tu as oublié le mot-clé final pour indiquer que ces valeurs ne changeront pas
    private TypePneu type;
    private double pression;

    public Pneu(TypePneu type, double pression){
        this.type = type;
        this.pression = pression;
    }

    public TypePneu getType() {
        return type;
    }

    public double getPression() {
        return pression;
    }

    @Override
    public String toString() {
        DecimalFormat format = new DecimalFormat("0.0");
        return "Pneu [type = " + type + ", pression = " + pression + "]";
    }

}
