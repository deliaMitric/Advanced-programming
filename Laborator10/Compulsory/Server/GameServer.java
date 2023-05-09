package org.example.server;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
        import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class GameServer {
    private ServerSocket serverSocket;
    private boolean running;
    private int port;
    private BufferedReader keyboardInput;
    private List<ClientThread> clients = new ArrayList<>();

    public GameServer(int port) {
        try {
            this.port = port;
            serverSocket = new ServerSocket(port);
            keyboardInput = new BufferedReader(new InputStreamReader(System.in));

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
                clients.add(clientThread);
                clientThread.start();

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
            } catch (IOException e) {
                System.err.println("Error accepting client connection.");
                e.printStackTrace();
            }
        }

    }


    public void stop() {
        running = false;
        try {
            for (ClientThread clientThread : clients) {
                clientThread.setRunning(false);
            }
            serverSocket.close();
            System.out.println("Game server stopped.");
        } catch (IOException e) {
            System.err.println("Error stopping the server.");
            e.printStackTrace();
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

    public void setPort(int port) {
        this.port = port;
    }

    public BufferedReader getKeyboardInput() {
        return keyboardInput;
    }

    public void setKeyboardInput(BufferedReader keyboardInput) {
        this.keyboardInput = keyboardInput;
    }

    public List<ClientThread> getClients() {
        return clients;
    }

    public void setClients(List<ClientThread> clients) {
        this.clients = clients;
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

