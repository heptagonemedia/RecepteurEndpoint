package com.heptagonemedia;

import java.sql.Time;

public class ProtocoleDonneeBouee {
    private static final int ATTENTE = 0;
    private static final int RECV_DONNEE = 1;
    private static final int ERREUR = 2;
    private static final int AUTRE = 3;

    private int etat = ATTENTE;

    public String gererEntree(String entree) throws Exception {
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
            if (!entree.equals("End;")) {
                sortie = "received";
                buffer.ajouterEntree(entree + "\r\n");
                return sortie;
            } else {
                sortie = "End;";

                if(buffer.getTaillePile() > 0) {
                    TimescaleDAO baseDeDonnees = TimescaleDAO.getInstance();
                    //String donnees = buffer.getNbLignes(buffer.getTaillePile()).toString();

                    /*String donnees = "";
                    for (int i=0; i<5000; i++){
                        donnees += "now();UllaBritaMongolfiere;254.09872;234.75677"+"\r\n";
                    }*/
                    String donnees = buffer.getNbLignes(buffer.getTaillePile());
                    baseDeDonnees.insererDonnees(donnees);
                }

                etat = 7;
                return sortie;
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
