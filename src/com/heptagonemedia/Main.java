package com.heptagonemedia;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {

    private Socket commSocket;

    public static void main(String[] args) {
        //commencerEcoute(args[0]);
        commencerEcoute(1432+"");

        //surveillerPile();


    }

    private static void surveillerPile() {
        Runnable surveillance = () -> {
            GestionnaireBuffer buffer = GestionnaireBuffer.getInstance();

        };


        Thread thread = new Thread(surveillance);
        thread.start();

        System.out.println("Surveillance commencée!");
    }

    private static void commencerEcoute(String port) {
        int portNumber = Integer.parseInt(port);
        try (
                ServerSocket serverSocket = new ServerSocket(portNumber);
                Socket clientSocket = serverSocket.accept();
                PrintWriter out =
                        new PrintWriter(clientSocket.getOutputStream(), true);
                BufferedReader in = new BufferedReader(
                        new InputStreamReader(clientSocket.getInputStream()));
        ) {
            String inputLine, outputLine;

            // Initiate conversation with client
            ProtocoleDonneeBouee handlerProtocole = new ProtocoleDonneeBouee();
            outputLine = handlerProtocole.gererEntree("Start;");
            out.println(outputLine);

            while ((inputLine = in.readLine()) != null) {
                outputLine = handlerProtocole.gererEntree(inputLine);
                out.println(outputLine);
                if (outputLine.equals("Bye."))
                    break;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
