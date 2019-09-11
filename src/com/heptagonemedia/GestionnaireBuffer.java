package com.heptagonemedia;

public class GestionnaireBuffer {
    public static GestionnaireBuffer instance = null;
    public static GestionnaireBuffer getInstance(){
        if(instance == null) instance = new GestionnaireBuffer();
        return instance;
    }

    public  GestionnaireBuffer(){
        
    }
}
