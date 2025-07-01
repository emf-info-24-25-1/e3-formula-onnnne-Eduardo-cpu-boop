package models;

import java.text.DecimalFormat;

public class Pilote {
    public final static int NOMBRE_PNEUS_EM_RESERVE = 16;
    //MR Il ne faut pas mettre static ici car chaque pilote a son propre nom et nationalité, plutôt final pour indiquer que ces valeurs ne changeront pas.
    private static String nom;
    private static String nationalite;
    private int nombrePoints;
    private int nombreCourses;
    private int nombreVictoires;
    private int nombrePodiums;
    private Pneu[] pneusEnReserve;// !!! regarde si on peut mettre static
    private Voiture voiture;

    public Pilote(String nom, String nationalite) {
        this.nom = nom;
        this.nationalite = nationalite;
        this.voiture = null;
        this.nombreCourses = 0;
        this.nombrePodiums = 0;
        this.nombrePoints = 0;
        this.nombreVictoires = 0;
        this.pneusEnReserve = new Pneu[NOMBRE_PNEUS_EM_RESERVE];
    }

    public Pilote(String nom, String nationalite, Voiture voiture) {
        this.nom = nom;
        this.nationalite = nationalite;
        this.voiture = voiture;
        this.nombreCourses = 0;
        this.nombrePodiums = 0;
        this.nombrePoints = 0;
        this.nombreVictoires = 0;
        this.pneusEnReserve = new Pneu[NOMBRE_PNEUS_EM_RESERVE];
    }

    public boolean deposerPneuEnReserve(Pneu pneu) {
        boolean deposerPneuEnReserve = false;
        if (pneu != null) {
            for (int i = 0; i < pneusEnReserve.length; i++) {
                if (pneusEnReserve[i] == null) {
                    pneusEnReserve[i] = pneu;
                    deposerPneuEnReserve = true;
                    break;
                }
            }
        }
        return deposerPneuEnReserve;
    }

    public Pneu retirerPneuEnReserve(TypePneu type) {
        Pneu pneuRetire = null;
        if (type != null) {
            for (int i = 0; i < pneusEnReserve.length; i++) {
                if (pneusEnReserve[i] != null) {
                    if (pneusEnReserve[i].getType() == type) {
                        pneuRetire = pneusEnReserve[i];
                        pneusEnReserve[i] = null;
                        break;
                    }
                }
            }
        }
        return pneuRetire;
    }

    public int compterNombrePneusEnReserveDeType(TypePneu type) {
        int nombrePneuDetype = 0;
        if (type != null) {
            for (int i = 0; i < pneusEnReserve.length; i++) {
                if (pneusEnReserve[i] != null) {
                    if (pneusEnReserve[i].getType() == type) {
                        nombrePneuDetype++;
                    }
                }
            }
        }
        return nombrePneuDetype;
    }

    public int getNombrePneusEnReserve() {
        int nbrePneuEnReserve = 0;
        for (int i = 0; i < pneusEnReserve.length; i++) {
            if (pneusEnReserve[i] != null) {
                nbrePneuEnReserve++;
            }
        }
        return nbrePneuEnReserve;
    }

    public Pneu[] getPneusEnReserveSansTrous() {
        Pneu[] pneuEnReserveSansTrou = new Pneu[getNombrePneusEnReserve()];
        int nbre = 0;

        for (int i = 0; i < pneusEnReserve.length; i++) {
            if (pneusEnReserve[i] != null) {
                pneuEnReserveSansTrou[nbre] = pneusEnReserve[i];
                nbre++;
            }
        }
        return pneuEnReserveSansTrou;
    }

    public String pressionMoyenneDesPneusEnReserveFormatee() {
        double pressionMoyenneDesPneusEnReserce = 0;
        int nbrePneuEnReserve = getNombrePneusEnReserve();
        DecimalFormat format = new DecimalFormat("0.00");

        for (int i = 0; i < pneusEnReserve.length; i++) {
            if (pneusEnReserve[i] != null) {
                pressionMoyenneDesPneusEnReserce += pneusEnReserve[i].getPression();
            }
        }
        //MR Il faut vérifier si nbrePneuEnReserve n'est pas 0 pour éviter la division par zéro
        if (pressionMoyenneDesPneusEnReserce != 0) {
            pressionMoyenneDesPneusEnReserce = pressionMoyenneDesPneusEnReserce / nbrePneuEnReserve;
        }

        return "Pression moyenne des pneus en réserve : " + format.format(pressionMoyenneDesPneusEnReserce);
    }

    public int supprimerPneusDePressionInferieure(double pression) {
        int nbreDePneuSupprimer = 0;
        if (pression != 0) {
            for (int i = 0; i < pneusEnReserve.length; i++) {
                if (pneusEnReserve[i] != null) {
                    if (pneusEnReserve[i].getPression() < pression) {
                        pneusEnReserve[i] = null;
                        nbreDePneuSupprimer++;
                    }
                }
            }
        }
        return nbreDePneuSupprimer;
    }

    public boolean ajouterLotDePneus(Pneu[] pneus) {
        boolean ajouterLotDePneus = false;
        if (pneus != null) {
            int nbreDePlacelibre = pneusEnReserve.length - getNombrePneusEnReserve();
            int nbreDePneuDuLot = 0;
            for (int i = 0; i < pneus.length; i++) {
                if (pneus[i] != null) {
                    nbreDePneuDuLot++;
                }
            }
            if (nbreDePneuDuLot <= nbreDePlacelibre) {
                for (int i = 0; i < pneusEnReserve.length; i++) {
                    if (pneusEnReserve[i] == null) {
                        for (int j = 0; j < pneus.length; j++) {
                            if (pneus[j] != null) {
                                pneusEnReserve[i] = pneus[j];
                            }
                        }
                    }
                    ajouterLotDePneus = true;
                }
            }

        }
        return ajouterLotDePneus;
    }

    public String getNom() {
        return nom;
    }

    public String getNationalite() {
        return nationalite;
    }

    public int getNombrePoints() {
        return nombrePoints;
    }

    public int getNombreCourses() {
        return nombreCourses;
    }

    public int getNombreVictoires() {
        return nombreVictoires;
    }

    public int getNombrePodiums() {
        return nombrePodiums;
    }

    public void setNombrePoints(int nombrePoints) {
        this.nombrePoints = nombrePoints;
    }

    public void setNombreCourses(int nombreCourses) {
        this.nombreCourses = nombreCourses;
    }

    public void setNombreVictoires(int nombreVictoires) {
        this.nombreVictoires = nombreVictoires;
    }

    public void setNombrePodiums(int nombrePodiums) {
        this.nombrePodiums = nombrePodiums;
    }

    @Override
    public String toString() {
        String resultat = "Pilote : " + nom + " (" + nationalite + ")\n";

        if (voiture != null) {
            String nomEquipe = voiture.getNomEquipe();
            int numero = voiture.getNumero();

            resultat += "-> Voiture " + nomEquipe + " (" + numero + ")\n";
            resultat += "-> Points : " + nombrePoints + "\n";
            resultat += "-> Courses : " + nombreCourses + "\n";
            resultat += "-> Victoires : " + nombreVictoires + "\n";
            resultat += "-> Podium : " + nombrePodiums + "\n";

        } else {
            resultat += "-> Pas de voiture assignée.\n";
        }

        for (int i = 0; i < pneusEnReserve.length; i++) {
            if (pneusEnReserve[i] != null) {
                TypePneu type = pneusEnReserve[i].getType();
                resultat += "-> Pneu en réserve :  " + type + "\n";
            }
        }

        return resultat;
    }

}

