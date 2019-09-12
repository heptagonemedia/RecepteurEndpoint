package com.heptagonemedia;

import java.util.Stack;

public class GestionnaireBuffer {
    public static GestionnaireBuffer instance = null;
    public static GestionnaireBuffer getInstance(){
        if(instance == null) instance = new GestionnaireBuffer();
        return instance;
    }

    private Stack<String> pileEntree;
    public  GestionnaireBuffer(){
        pileEntree = new Stack<>();
    }

    public void ajouterEntree(String entree){
        pileEntree.push(entree);
    }

    public int getTaillePile(){
        return pileEntree.size();
    }

    public String getNbLignes(int nombre){
        String lignes = new String();
        for(int index = 0; index < nombre; index++) lignes += pileEntree.pop();
        return lignes;
    }

}
