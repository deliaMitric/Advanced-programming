package org.example;

public class Main {
    public static void main(String[] args) {
        int port = 1235; // Specify the port number for the server
        GameServer server = new GameServer(port);
        server.start();
    }
}