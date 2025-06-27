package app;

import models.*;

public class Application {

    public static void main(String[] args) {

        // ---------------------------------------------------------------------------------------
        // Etape 1 : Création d'une voiture de Formule 1
        // ---------------------------------------------------------------------------------------

        Voiture voiture1 = new Voiture(16, "Ferrari");

        // ---------------------------------------------------------------------------------------
        // Etape 2 : Afficher la voiture
        // ---------------------------------------------------------------------------------------

        System.out.println(voiture1);

        // ---------------------------------------------------------------------------------------
        // Etape 3 : Création d'un pilote de Formule 1 et afficher ses informations
        // ---------------------------------------------------------------------------------------

        Pilote pilote1 = new Pilote("Charles Leclerc", "Monégasque", voiture1);
        pilote1.setNombreCourses(16);
        pilote1.setNombrePoints(65);
        pilote1.setNombreVictoires(3);
        pilote1.setNombrePodiums(7);

        // ---------------------------------------------------------------------------------------
        // Etape 4 : Afficher le Pilote
        // ---------------------------------------------------------------------------------------

        System.out.println(pilote1);

        // ---------------------------------------------------------------------------------------
        // Etape 5 : Tests des méthodes de la classe Pilote
        // ---------------------------------------------------------------------------------------

        Pneu pneu1 = new Pneu(TypePneu.DUR_BLANC, 1.5);
        Pneu pneu2 = new Pneu(TypePneu.MEDIUM_JAUNE, 1.8);
        Pneu pneu3 = new Pneu(TypePneu.TENDRE_ROUGE, 2.0);
        Pneu pneu4 = new Pneu(TypePneu.DUR_BLANC, 1.6);
        Pneu pneu5 = new Pneu(TypePneu.MEDIUM_JAUNE, 1.7);


        // deposerPneuEnReserve() 5 fois de types différents

        pilote1.deposerPneuEnReserve(pneu1);
        pilote1.deposerPneuEnReserve(pneu2);
        pilote1.deposerPneuEnReserve(pneu3);
        pilote1.deposerPneuEnReserve(pneu4);
        pilote1.deposerPneuEnReserve(pneu5);

        // retirerPneuEnReserve() de type TENDRE_ROUGE et l'afficher

        Pneu pneuDeRetour = pilote1.retirerPneuEnReserve(TypePneu.TENDRE_ROUGE);
        System.out.println("Le" + pneuDeRetour.getType() + " qui a été retiré : " + pneuDeRetour);

        // getNombrePneusEnReserve() et afficher le nombre de pneus en réserve

        System.out.println("Nombre de pneus en réserve : " + pilote1.getNombrePneusEnReserve());

        // getPneusEnReserveSansTrous() et afficher les pneus en réserve

        System.out.println("Pneus en réserve sans trous :");
        Pneu[] pneuSansTrou = pilote1.getPneusEnReserveSansTrous();
        for (int i = 0; i < pneuSansTrou.length; i++) {
            System.out.println("- " + pneuSansTrou[i].getType() + " avec une presson " + pneuSansTrou[i].getPression());
        }

        // pressionMoyenneDesPneusEnReserveFormatee() et afficher la pression moyenne des
        // pneus

        System.out.println(pilote1.pressionMoyenneDesPneusEnReserveFormatee());

        // compterNombrePneusEnReserveDeType() et afficher le nombre de pneus en réserve
        // de type DUR_BLANC

        System.out.println("Nombre de pneus en réserve de type " + "DUR_BLANC" + " : " + pilote1.compterNombrePneusEnReserveDeType(TypePneu.DUR_BLANC));

        // Créer les 3 pneus et ajout le lot de pneus pour le pilote et afficher réussi
        // ou échoué

        Pneu pneuD1 = new Pneu(TypePneu.DUR_BLANC, 1.3);
        Pneu pneuD2 = new Pneu(TypePneu.DUR_BLANC, 1.2);
        Pneu pneuD3 = new Pneu(TypePneu.DUR_BLANC, 1.1);
        Pneu[] lot = new Pneu[3];
        lot[0] = pneuD1;
        lot[1] = pneuD2;
        lot[2] = pneuD3;
        boolean lotAjouter = pilote1.ajouterLotDePneus(lot);
        if (!lotAjouter) {
            System.out.println("Ajout du lot de pneus rater ;(");
        }
        else{
            System.out.println("Ajout du lot de pneus réussi :-)");
        }
        

        // Supprimer les pneus de pression inférieure à 1.4 et afficher le nombre de
        // pneus supprimés

        double nbrePressionDesPneuASupprimer = 1.4;
        int nbreDePneuSupprimer = pilote1.supprimerPneusDePressionInferieure(nbrePressionDesPneuASupprimer);
        System.out.println("Nombre de pneus suprimés de pression inférieure à " + nbrePressionDesPneuASupprimer + " : " + nbreDePneuSupprimer);

        // ---------------------------------------------------------------------------------------
        
    }

}
