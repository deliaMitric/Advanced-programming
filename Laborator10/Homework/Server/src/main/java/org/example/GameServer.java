package org.example;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class GameServer {
    private ServerSocket serverSocket;
    private boolean running;
    private final int port;
    private List<ClientThread> waitingClients = new ArrayList<>();
    private List<Game> waitingMatches = new ArrayList<>();
    private List<Game> activeMatches = new ArrayList<>();

    public GameServer(int port) {
        this.port = port;

        try {
            serverSocket = new ServerSocket(port);
            System.out.println("Game server started on port " + port);

        } catch (IOException e) {
            System.err.println("Error: Could not start the server on port " + port);
            e.printStackTrace();
        }
    }

    public void start() {
        running = true;

        while (running) {
            try {
                Socket clientSocket = serverSocket.accept();
                System.out.println("New client connected: " + clientSocket.getInetAddress().getHostAddress());

                // Create a new client thread to handle the client's requests
                ClientThread clientThread = new ClientThread(clientSocket,this);
                waitingClients.add(clientThread);
                clientThread.start();

            } catch (IOException e) {
                if(!running)
                    break;
                else {
                    System.err.println("Error accepting client connection.");
                    e.printStackTrace();
                }
            }
        }
    }

    public void stop() {
        running = false;

        try {
            for (ClientThread clientThread : waitingClients) {
                clientThread.stopClient();
            }

            serverSocket.close();
            System.out.println("Game server stopped.");

        } catch (IOException e) {
            System.err.println("Error stopping the server.");
            e.printStackTrace();
        }
    }

    public void addMatchOnQueue(Socket client){
        this.waitingMatches.add(new Game(client, this));

        try {
            PrintWriter out = new PrintWriter(client.getOutputStream(), true);
            out.println("Game created successfully: Waiting for player 2 ...");

            // Clean up resources
            //out.close();
        } catch (IOException e) {
            System.err.println("Error trying to communicate with the client: " + e.getMessage());
        }

        System.out.println("Waiting for player 2");
    }

    public void startGame(Socket client){
        //check if there are any games on queue
        if(waitingMatches.size() == 0){
            try {
                PrintWriter out = new PrintWriter(client.getOutputStream(), true);
                out.println("No games in queue: Please create a game");

            } catch (IOException e) {
                System.err.println("Error trying to communicate with the client: " + e.getMessage());
            }
        }
        else {
            Game game = waitingMatches.get(0);
            this.activeMatches.add(game);

            waitingMatches.remove(0);
            game.setPlayer2(client);

            game.start();
        }
    }

    public void stopGame(Game gameFinnished){
        for(Game game : activeMatches){
            if(game.equals(gameFinnished)){
                activeMatches.remove(game);
            }
        }
    }

    public void makeMove(Socket client, String response){
        //check if the client is in a game
        for(Game game : activeMatches){
            if(game.getPlayer1().equals(client)){
                //check turn
                if(game.getTurn().equals("player1")) {
                    //make move for player1
                    game.movePlayer1(response);
                }
                else {
                    try {
                        PrintWriter out = new PrintWriter(client.getOutputStream(), true);
                        out.println("Not your turn");

                    } catch (IOException e) {
                        System.err.println("Error trying to communicate with the client: " + e.getMessage());
                    }
                }
            }

            if(game.getPlayer2().equals(client)){
                if(game.getTurn().equals("player2")) {
                    //make move for player1
                    game.movePlayer2(response);
                }
                else {
                    try {
                        PrintWriter out = new PrintWriter(client.getOutputStream(), true);
                        out.println("Not your turn");

                    } catch (IOException e) {
                        System.err.println("Error trying to communicate with the client: " + e.getMessage());
                    }
                }
            }
        }

    }

    public ServerSocket getServerSocket() {
        return serverSocket;
    }

    public void setServerSocket(ServerSocket serverSocket) {
        this.serverSocket = serverSocket;
    }

    public boolean isRunning() {
        return running;
    }

    public void setRunning(boolean running) {
        this.running = running;
    }

    public int getPort() {
        return port;
    }

    public List<ClientThread> getClients() {
        return waitingClients;
    }

    public void setClients(List<ClientThread> clients) {
        this.waitingClients = clients;
    }
}

/*import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class GameServer {
    private int port;
    private List<ClientThread> clients;

    public GameServer(int port) {
        this.port = port;
        this.clients = new ArrayList<>();
    }

    public void start() {
        try {
            ServerSocket serverSocket = new ServerSocket(port);
            System.out.println("Game server started on port " + port);

            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("New client connected: " + clientSocket.getInetAddress().getHostAddress());

                // Create a new client thread for each connected client
                ClientThread clientThread = new ClientThread(clientSocket);
                clients.add(clientThread);
                clientThread.start();
            }
        } catch (IOException e) {
            System.err.println("Error starting the game server: " + e.getMessage());
        }
    }

    public void broadcastMessage(String message) {
        for (ClientThread client : clients) {
            client.sendMessage(message);
        }
    }

    public static void main(String[] args) {
        int port = 1234; // Specify the port number for the server
        GameServer server = new GameServer(port);
        server.start();
    }
}
*/