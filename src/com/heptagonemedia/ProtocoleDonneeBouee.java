package com.heptagonemedia;

public class ProtocoleDonneeBouee {
    private static final int ATTENTE = 0;
    private static final int RECV_DONNEE = 1;
    private static final int ERREUR = 2;
    private static final int AUTRE = 3;

    private int etat = ATTENTE;

    public String gererEntree(String entree) {
        String sortie = null;

        if (etat == ATTENTE) {
            sortie = "Debut reception";

            etat = RECV_DONNEE;
        } else if (etat == RECV_DONNEE) {

        } else if (etat == ERREUR) {

        } else if (etat == AUTRE) {

        } else {
        sortie = "Bye.";
            etat = ATTENTE;
        }

        return sortie;
    }
}