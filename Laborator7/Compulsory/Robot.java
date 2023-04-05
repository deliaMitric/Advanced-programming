package compulsory;

import java.util.Random;

public class Robot implements Runnable{
    private String name;
    private boolean running;
    Exploration explore;
    public Robot(String name, Exploration explore) {
        this.name = name;
        this.explore = explore;
        this.running =  true;
    }

    public void run() {
        while (running) {
            int rows, columns;
            int row, col;
            rows = explore.getMap().getRows();
            columns = explore.getMap().getColumns();
            Random random = new Random();
            row = random.nextInt(rows);
            col = random.nextInt(columns);

            explore.getMap().visit( row, col, this);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isRunning() {
        return running;
    }

    public void setRunning(boolean running) {
        this.running = running;
    }

    public Exploration getExplore() {
        return explore;
    }

    public void setExplore(Exploration explore) {
        this.explore = explore;
    }

    @Override
    public String toString() {
        return "Robot{" +
                "name='" + name + '\'' +
                ", running=" + running +
                ", explore=" + explore +
                '}';
    }
}
