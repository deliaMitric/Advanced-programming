package compulsory;

import java.util.ArrayList;
import java.util.List;

public class Exploration {

    private final SharedMemory mem;
    private final ExplorationMap map;
    private final List<Robot> robots;

    public Exploration(int numberForSharedMemory, int numberRows, int numberColumns) {
        this.mem = new SharedMemory(numberForSharedMemory);
        this.map =new ExplorationMap(numberRows,numberColumns);
        this.robots = new ArrayList<>();

    }

    public void start() {
        for (Robot robot : robots) {
            new Thread(robot).start();
        }

    }
    /*public void finish(){
        for (Robot robot : robots) {
            robot.setRunning(false);
        }
    }*/

    public void addRobot(Robot robot){
        if(!robots.contains(robot)) {
            robots.add(robot);
        }
    }

    public SharedMemory getMem() {
        return mem;
    }

    public ExplorationMap getMap() {
        return map;
    }

    public List<Robot> getRobots() {
        return robots;
    }


}
