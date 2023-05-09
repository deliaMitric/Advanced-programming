package org.example.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ClientThread extends Thread {
    private Socket clientSocket;
    private PrintWriter out;
    private BufferedReader in;
    private GameServer gameServer;
    private boolean running = false;

    public ClientThread(Socket clientSocket,GameServer gameServer) {
        this.clientSocket = clientSocket;
        this.gameServer = gameServer;

        try {
            out = new PrintWriter(clientSocket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        } catch (IOException e) {
            System.err.println("Error setting up client thread: " + e.getMessage());
        }
    }

    @Override
    public void run() {
        try {
            String inputLine;
            running = true;

            while (running) {

                while ((inputLine = in.readLine()) != null) {
                    System.out.println("Received command from client: " + inputLine);

                    if (inputLine.equalsIgnoreCase("stop")) {
                        out.println("Server stopped");
                        System.out.println("Server stopped");

                        gameServer.stop();
                        break;
                    } else {
                        out.println("Server received the request: " + inputLine);
                    }
                }

                // Clean up resources
                in.close();
                out.close();
                clientSocket.close();
            }
        }catch(IOException e){
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

    public BufferedReader getIn() {
        return in;
    }

    public void setIn(BufferedReader in) {
        this.in = in;
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
}
