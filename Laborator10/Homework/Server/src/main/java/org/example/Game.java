package org.example;

public class Game extends Thread {
    boolean running;
    Board board;

    public Game(){
        this.board = new Board();
        this.running = false;
    }

    @Override
    public void run() {
        this.running = true;
    }
}
