package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.SocketException;
import java.util.Scanner;

public class Game extends Thread {
    boolean running;
    private final Board board;
    private final Socket player1;
    private Socket player2;
    private BufferedReader in1;
    private BufferedReader in2;
    private PrintWriter out1;
    private PrintWriter out2;
    private final GameServer gameServer;
    private String turn;

    public Game(Socket player1, GameServer gameServer){
        this.board = new Board();
        this.running = false;
        this.player1 = player1;
        this.gameServer = gameServer;
        this.turn = "player1";

        try {
            this.in1 = new BufferedReader(new InputStreamReader(player1.getInputStream()));

        } catch (IOException e){
            System.err.println("Error trying to set up a communication chanel: " + e.getMessage());
        }
    }

    @Override
    public void run() {
        this.running = true;
        System.out.println("Game started!");

        try {
            this.in2 = new BufferedReader(new InputStreamReader(player2.getInputStream()));
            this.out1 = new PrintWriter(player1.getOutputStream(), true);
            this.out2 = new PrintWriter(player2.getOutputStream(), true);

            this.player1.setSoTimeout(60*1000);
            this.player2.setSoTimeout(60*1000);


        } catch (SocketException e) {
            System.err.println("Error trying to set the timeout for the socket: " + e.getMessage());
            throw new RuntimeException(e);

        } catch (IOException e){
            System.err.println("Error trying to set up a communication chanel: " + e.getMessage());
        }

        while (running){
            try {
                int row = 0;
                int col = 0;
                boolean ok = false;

                String response1;
                while (!ok) {
                    if ((response1 = in1.readLine()) != null) {
                        //check if the values are valid
                        Scanner scanner = new Scanner(response1);
                        String input = scanner.nextLine();
                        String[] numbers = input.split(" ");

                        try {
                            row = Integer.parseInt(numbers[0]);
                            col = Integer.parseInt(numbers[1]);

                            //check if the cell is empty
                            if(this.board.isCellEmpty(row, col))
                                ok = true;
                            else
                                throw new NumberFormatException();

                        } catch (NumberFormatException e) {
                            out1.println("Invalid move");
                        }
                    }
                }

                //make the changes for player1
                this.board.setCell(row, col, 'X');
                if(this.board.hasWon('X')){
                    this.stopGame("player1");
                }

                String response2;
                ok = false;
                while (!ok) {
                    if ((response2 = in2.readLine()) != null) {
                        //check if the values are valid
                        Scanner scanner = new Scanner(response2);
                        String input = scanner.nextLine();
                        String[] numbers = input.split(" ");

                        try {
                            row = Integer.parseInt(numbers[0]);
                            col = Integer.parseInt(numbers[1]);

                            //check if the cell is empty
                            if(this.board.isCellEmpty(row, col))
                                ok = true;
                            else
                                throw new NumberFormatException();

                        } catch (NumberFormatException e) {
                            out2.println("Invalid move");
                        }
                    }
                }

                //make the changes for player2
                this.board.setCell(row, col, 'O');
                if(this.board.hasWon('O')){
                    this.stopGame("player2");
                }

            } catch (IOException e) {
                System.err.println("Error trying to communicate with the opponent: " + e.getMessage());
                throw new RuntimeException(e);
            }
        }
    }

    public void stopGame(String winner){
        if(winner.equals("player1")) {
            out1.println("Congratulations you won!");
            out2.println("You lost. Better luck next time!");
        }
        else {
            out2.println("Congratulations you won!");
            out1.println("You lost. Better luck next time!");
        }

        this.running = false;
        gameServer.stopGame(this);
    }

    public void movePlayer1(String response1){
        int row = 0;
        int col = 0;
        boolean ok = false;

        //check if the values are valid
        Scanner scanner = new Scanner(response1);
        String input = scanner.nextLine();
        String[] numbers = input.split(" ");

        try {
            row = Integer.parseInt(numbers[2]);
            col = Integer.parseInt(numbers[3]);

            //check if the cell is empty
            if(this.board.isCellEmpty(row, col))
                ok = true;
            else
                throw new NumberFormatException();

        } catch (NumberFormatException e) {
            out1.println("Invalid move");
        }

        //make the changes for player1
        this.board.setCell(row, col, 'X');
        if(this.board.hasWon('X')){
            this.stopGame("player1");
        }

        this.turn="player2";
    }

    public void movePlayer2(String response1){
        int row = 0;
        int col = 0;
        boolean ok = false;

        //check if the values are valid
        Scanner scanner = new Scanner(response1);
        String input = scanner.nextLine();
        String[] numbers = input.split(" ");

        try {
            row = Integer.parseInt(numbers[2]);
            col = Integer.parseInt(numbers[3]);

            //check if the cell is empty
            if(this.board.isCellEmpty(row, col))
                ok = true;
            else
                throw new NumberFormatException();

        } catch (NumberFormatException e) {
            out1.println("Invalid move");
        }

        //make the changes for player2
        this.board.setCell(row, col, 'O');
        if(this.board.hasWon('O')){
            this.stopGame("player2");
        }

        this.turn="player1";
    }

    public void setPlayer2(Socket player2) {
        this.player2 = player2;
    }

    public Socket getPlayer1() {
        return player1;
    }

    public Socket getPlayer2() {
        return player2;
    }

    public String getTurn() {
        return turn;
    }
}
