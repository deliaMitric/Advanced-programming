package org.example.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class GameClient {
    private String serverAddress;
    private int serverPort;
    private boolean running = false;

    public GameClient(String serverAddress, int serverPort) {
        this.serverAddress = serverAddress;
        this.serverPort = serverPort;
    }

    public void start() {
        try {
            running = true;
            while (running) {
                //conectare la server
                Socket socket = new Socket(serverAddress, serverPort);
                System.out.println("Connected to server: " + serverAddress + ":" + serverPort);

                //
                BufferedReader keyboardInput = new BufferedReader(new InputStreamReader(System.in));
                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

                String userInput;

                //citim mesajele de la server
                while ((userInput = keyboardInput.readLine()) != null) {
                    out.println(userInput);//transmitem mesajul serverului

                    if (userInput.equalsIgnoreCase("exit")) {
                        //running = false;
                        break;
                    }
                    String response;
                    if ((response = in.readLine()) != null){
                        System.out.println("Received command from server: " + response);
                    }
                }
                keyboardInput.close();
                out.close();
                socket.close();
            }
        }catch(IOException e){
                System.err.println("Error connecting to the server: " + e.getMessage());
            }

    }


}
