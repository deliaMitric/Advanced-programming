package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.SocketException;
import java.net.SocketTimeoutException;

public class GetClientInput extends Thread {
    private boolean running;
    private final Socket clientSocket;
    private final GameServer gameServer;
    private BufferedReader in;

    public GetClientInput(Socket clientSocket, GameServer server){
        this.clientSocket = clientSocket;
        this.running = false;
        this.gameServer = server;

        try {
            this.in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

        } catch (IOException e){
            System.err.println("Error trying to listen to the port: " + e.getMessage());
        }
    }

    @Override
    public void run(){
        this.running = true;

        try {
            clientSocket.setSoTimeout(5000);
        } catch (SocketException e) {
            System.err.println("Error trying to set the timeout for the socket: " + e.getMessage());
            throw new RuntimeException(e);
        }

        while (running){
            try {
                String response;
                if ((response = in.readLine()) != null){
                    System.out.println("Server received the request: " + response);
                }

                if (response.equalsIgnoreCase("exit")){
                    PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
                    out.println("Server stopped");
                    out.close();

                    System.out.println("Server stopped");

                    //stop everything
                    gameServer.stop();
                }

            } catch (SocketTimeoutException e) {
                if(!running){
                    break;
                }
            } catch (IOException e) {
                System.err.println("Error connecting to the server: " + e.getMessage());
                throw new RuntimeException(e);
            }
        }

        //Clean up resources
        try {
            in.close();
        } catch (IOException e) {
            System.err.println("Error trying to close the socket: " + e.getMessage());
            throw new RuntimeException(e);
        }
    }

    public void setRunning(boolean running) {
        this.running = running;
    }
}
