package Homework;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Exploration {

    private final SharedMemory mem;
    private final ExplorationMap map;
    private final List<Robot> robots;
    private Map<Robot,Thread> threads = new HashMap<>();

    public Exploration(int numberForSharedMemory, int numberRows, int numberColumns) {
        this.mem = new SharedMemory(numberForSharedMemory);
        this.map =new ExplorationMap(numberRows,numberColumns);
        this.robots = new ArrayList<>();
    }

    public void startAll() {
        for (Robot robot : robots) {
            if(!threads.containsKey(robot)){
                threads.put(robot, new Thread(robot));
                threads.get(robot).start();
            }
            //timeKeeper.start();
            robot.setPause(false);
        }
    }

    public void pauseAll() {
        for(Robot robot : robots){
            /*try {
                threads.get(robot).sleep(2000);
                threads.get(robot).interrupt();
                robot.setPause(true);
            }
            catch (InterruptedException e){
                System.out.println("InterruptedException");
            }*/
            robot.setPause(true);
        }
    }

    public void startSpecificRobot(String name){
        for(Robot robot : robots)
        {
            if(robot.getName().equalsIgnoreCase(name)){
                if(!threads.containsKey(robot)){
                    threads.put(robot, new Thread(robot));
                    threads.get(robot).start();
                }
                robot.setPause(false);
                break;
            }
        }
    }

    public void pauseSpecificRobot(String name, int value)  {
        Robot robot = null;

        for(Robot r : robots){
            if(r.getName().equalsIgnoreCase(name)){
                robot = r;
                ///System.out.println("am gasit rob");
                break;
            }
        }
        if(robot != null) {
            if (value < 0) {
                //System.out.println("aici intrerupem thread-ul");
                robot.setPause(true);
            } else {
                    robot.setPause(true);
                    robot.setValuePause(value);
            }
        }
    }

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
