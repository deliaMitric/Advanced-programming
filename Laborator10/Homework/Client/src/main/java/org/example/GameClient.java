package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class GameClient {
    private final String serverAddress;
    private final int serverPort;
    private boolean running;
    private final PrintWriter out;
    private final Socket socket;
    private final GetServerInput getServerInput;

    public GameClient(String serverAddress, int serverPort) {
        this.serverAddress = serverAddress;
        this.serverPort = serverPort;
        this.running = false;

        try {
            this.socket = new Socket(serverAddress, serverPort);
            this.out = new PrintWriter(socket.getOutputStream(), true);

            //create a thread to listen to the server socket
            this.getServerInput = new GetServerInput(socket);
            getServerInput.start();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void start() {
        this.running = true;

        try {
            while (running) {
                //conectare la server
                System.out.println("Connected to server: " + serverAddress + ":" + serverPort);

                BufferedReader keyboardInput = new BufferedReader(new InputStreamReader(System.in));
                String userInput;

                while ((userInput = keyboardInput.readLine()) != null) {
                    out.println(userInput);//transmitem mesajul serverului

                    if (userInput.equalsIgnoreCase("exit")) {
                        running = false;
                        getServerInput.setRunning(false);
                        break;
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
