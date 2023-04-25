package Homework;


import java.util.Random;

public class Robot implements Runnable{
    private String name;
    private boolean running, pause;
    Exploration explore;
    private int numberOfTokens, valuePause;
    public Robot(String name, Exploration explore) {
        this.name = name;
        this.explore = explore;
        this.running =  true;
        this.pause = false;
        this.valuePause = 0;
        numberOfTokens = 0;
    }

    public void run() {
        while (running) {
            while (pause) {
                if(valuePause == 0) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                else{
                    try{
                        Thread.sleep(valuePause * 1000);
                    }
                    catch (InterruptedException e){
                        throw new RuntimeException(e);
                    }
                    valuePause = 0;
                    pause =false;
                }
            }

            int rows, columns;
            int row, col;
            rows = explore.getMap().getRows();
            columns = explore.getMap().getColumns();

            for (int j = 0; (j < columns && running && !pause); j++) {//column
                for (int i = 0; (i < rows && running && !pause); i++) {//row
                    //explorarea se face sistematic de sus in jos + de la stanga la dreapta
                    if (explore.getMap().visit(i, j, this)) {
                        try {
                            Thread.sleep(5000);
                        } catch (InterruptedException e) {
                            System.out.println("Thread interrupted");
                        }
                    }
                }
            }

        }
    }

    public int getValuePause() {
        return valuePause;
    }

    public void setValuePause(int valuePause) {
        this.valuePause = valuePause;
    }

    public boolean isPause() {
        return pause;
    }

    public void setPause(boolean pause) {
        this.pause = pause;
    }

    public int getNumberOfTokens() {
        return numberOfTokens;
    }

    public void setNumberOfTokens(int numberOfTokens) {
        this.numberOfTokens = numberOfTokens;
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
