package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.SocketTimeoutException;

public class GetServerInput extends Thread {
    private boolean running;
    private final Socket socket;
    private final BufferedReader in;

    public GetServerInput(Socket socket){
        this.socket = socket;
        this.running = false;

        try {
            this.in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void run(){
        this.running = true;

        while (running){
            try {
                socket.setSoTimeout(5000);

                String response;
                if ((response = in.readLine()) != null){
                    System.out.println("Received command from server: " + response);
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
    }

    public void setRunning(boolean running) {
        this.running = running;
    }
}
