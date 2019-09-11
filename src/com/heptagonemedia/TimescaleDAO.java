package com.heptagonemedia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TimescaleDAO {
    public TimescaleDAO instance = null;
    public TimescaleDAO getInstance(){
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
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
