package models;

import java.text.DecimalFormat;

public class Voiture {
    //MR Ce n'est pas static, mais final pour indiquer que ces valeurs ne changeront pas
    private static int numero;
    private static String nomEquipe;

    public Voiture(int numero, String nomEquipe) {
        this.numero = numero;
        this.nomEquipe = nomEquipe;
    }

    public int getNumero() {
        return numero;
    }

    public String getNomEquipe() {
        return nomEquipe;
    }

    @Override
    public String toString() {
        DecimalFormat format = new DecimalFormat("000");
        //MR Tu n'utilises pas le formatage du numéro de la voiture
        return "Voiture n°" + numero + " de l'équipe '" + nomEquipe + "'";
    }

}
