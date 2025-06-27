package models;

import java.text.DecimalFormat;

public class Voiture {
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
        return "Voiture n°" + numero + " de l'équipe '" + nomEquipe + "'";
    }

}
