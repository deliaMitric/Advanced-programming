package org.example;

public class Main {
    public static void main(String[] args) {
        String serverAddress = "127.0.0.1"; // Specify the server address
        int serverPort = 1024; // Specify the server port

        GameClient client = new GameClient(serverAddress, serverPort);
        client.start();
    }
}