package Homework;

import java.util.ArrayList;
import java.util.List;

public class TimeKeeper extends Thread{
    private long timeLim, difference;
    private boolean running;
    private List<Robot> robots;
    private Exploration exploration;


    public TimeKeeper(long timeLim, boolean running, Exploration exploration) {
        this.timeLim = timeLim;
        this.running = running;
        this.difference = 0;
        this.exploration = exploration;
        robots =  new ArrayList<>();
        setDaemon(true);
    }
    public void run(){
        long startTime =  System.currentTimeMillis();
        while(running && exploration.getMap().verifyThereIsEmptyCells()){

            long currentTime =  System.currentTimeMillis();
            difference = currentTime - startTime;

            if(difference >= timeLim){
                //stop all threads
                for(Robot robot : robots){
                    robot.setRunning(false);
                }
                running = false;
                System.out.println("Stopped exploration");
            }
        }
        System.out.println(difference);
    }
    public void addRobot(Robot robot){
        if(!robots.contains(robot)){
            robots.add(robot);
        }
    }

    public long getTimeLim() {
        return timeLim;
    }

    public void setTimeLim(long timeLim) {
        this.timeLim = timeLim;
    }

    public boolean isRunning() {
        return running;
    }

    public void setRunning(boolean running) {
        this.running = running;
    }

    public long getDifference() {
        return difference;
    }

    public void setDifference(long difference) {
        this.difference = difference;
    }

    public List<Robot> getRobots() {
        return robots;
    }

    public void setRobots(List<Robot> robots) {
        this.robots = robots;
    }
}
