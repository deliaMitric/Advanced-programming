package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ClientThread extends Thread {
    private Socket clientSocket;
    private final GetClientInput getClientInput;
    private PrintWriter out;
    private BufferedReader keyboardInput;
    private GameServer gameServer;
    private boolean running;

    public ClientThread(Socket clientSocket, GameServer gameServer) {
        this.clientSocket = clientSocket;
        this.gameServer = gameServer;
        this.running = false;

        //create a thread to listen to the port
        this.getClientInput = new GetClientInput(clientSocket, this.gameServer);

        try {
            out = new PrintWriter(clientSocket.getOutputStream(), true);
            keyboardInput = new BufferedReader(new InputStreamReader(System.in));

        } catch (IOException e) {
            System.err.println("Error setting up client thread: " + e.getMessage());
        }
    }

    @Override
    public void run() {
        try {
            running = true;

            getClientInput.start();

            while (running) {
                //read the user input
                String userInput;
                if((userInput = keyboardInput.readLine()) != null){
                    //send the message to the client
                    out.println(userInput);
                }
            }

            // Clean up resources
            out.close();
            clientSocket.close();
            keyboardInput.close();
        } catch(IOException e){
            System.err.println("Error in client thread: " + e.getMessage());
        }
    }

    public Socket getClientSocket() {
        return clientSocket;
    }

    public void setClientSocket(Socket clientSocket) {
        this.clientSocket = clientSocket;
    }

    public PrintWriter getOut() {
        return out;
    }

    public void setOut(PrintWriter out) {
        this.out = out;
    }

    public GameServer getGameServer() {
        return gameServer;
    }

    public void setGameServer(GameServer gameServer) {
        this.gameServer = gameServer;
    }

    public boolean isRunning() {
        return running;
    }

    public void setRunning(boolean running) {
        this.running = running;
    }

    public void stopClient(){
        this.setRunning(false);
        this.getClientInput.setRunning(false);
    }
}

/*
                String inputKeyboard;
                PrintWriter clientOut = new PrintWriter(clientSocket.getOutputStream(), true);

                while ((inputKeyboard = keyboardInput.readLine()) != null && running) {
                    clientOut.println(inputKeyboard);//transmit mesajul clientului
                    if (inputKeyboard.equalsIgnoreCase("stop")) {
                        running = false;
                        break;
                    }
                }

                if (inputKeyboard != null && inputKeyboard.equalsIgnoreCase("stop")) {
                    running = false;
                }
 */