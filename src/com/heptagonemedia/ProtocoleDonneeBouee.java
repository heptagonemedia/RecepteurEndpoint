package com.heptagonemedia;

public class ProtocoleDonneeBouee {
    private static final int ATTENTE = 0;
    private static final int RECV_DONNEE = 1;
    private static final int ERREUR = 2;
    private static final int AUTRE = 3;

    private int etat = ATTENTE;

    public String gererEntree(String entree) {
        GestionnaireBuffer buffer = GestionnaireBuffer.getInstance();

        String sortie = "Nonconnect;";

        if (etat == ATTENTE) {
            if (entree == "Start;") {
                sortie = "Start;";
                etat = RECV_DONNEE;
                return sortie;
            } else
                return sortie;
        }
        if (etat == RECV_DONNEE) {
            if (entree != "End;") {
                buffer.ajouterEntree(entree);
            } else {
                sortie = "End;";
                etat = 7;
            }
        } else if (etat == ERREUR) {

        } else if (etat == AUTRE) {

        } else {
            sortie = "Bye.";
            etat = ATTENTE;
        }

        return sortie;
    }
}
