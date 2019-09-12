package com.heptagonemedia;

import java.util.Stack;

public class GestionnaireBuffer {
    public static GestionnaireBuffer instance = null;
    public static GestionnaireBuffer getInstance(){
        if(instance == null) instance = new GestionnaireBuffer();
        return instance;
    }

    private Stack<String> pileEntree;
    private Stack<String> pileSecondaire;

    public  GestionnaireBuffer(){

        pileEntree = new Stack<>();
        pileSecondaire = new Stack<>();
    }

    public synchronized void ajouterEntree(String entree){
        //If no lock
        pileEntree.push(entree);

        //Else
        //pileSecondaire.push(entree);
    }

    public int getTaillePile(){
        return pileEntree.size();
    }

    public synchronized String getNbLignes(int nombre){
        String lignes = new String();
        for(int index = 0; index < nombre; index++) lignes += pileEntree.pop();
        return lignes;
    }

}
