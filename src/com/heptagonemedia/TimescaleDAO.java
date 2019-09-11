package com.heptagonemedia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;

public class TimescaleDAO {
    public static TimescaleDAO instance = null;
    public static TimescaleDAO getInstance(){
        if(instance == null) instance = new TimescaleDAO();
        return instance;
    }




    Connection connection;

    public TimescaleDAO(){
        initierConnection();
    }

    private void initierConnection() {
        try {
            connection = DriverManager.getConnection(
                    "jdbc:postgresql://localhost:5432/imr_timescale",
                    "master",
                    "123qweQWE"
            );
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public String insererDonnees(ArrayList<String> lignes){
        for(String ligne : lignes ){

        }
        return "";
    }
}
