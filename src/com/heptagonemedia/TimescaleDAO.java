package com.heptagonemedia;

import org.postgresql.copy.CopyManager;
import org.postgresql.core.BaseConnection;

import java.io.ByteArrayInputStream;
import java.io.IOException;
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

    public String insererDonnees(String donnees) throws Exception {
        try  {
            CopyManager copyManager = new CopyManager((BaseConnection) connection);

            byte[] octets = donnees.getBytes();

            ByteArrayInputStream entree = new ByteArrayInputStream(octets);

            copyManager.copyIn("COPY public.testtable FROM STDIN WITH DELIMITER ';'", entree);

            return "";
        } catch (SQLException | IOException e) {
            throw new Exception(e);
        }
    }
}
