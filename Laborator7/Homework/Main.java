package Homework;


import java.sql.Time;
import java.util.Scanner;

public class Main {
        public static void main(String args[]) {

            var explore = new Exploration(1000,8,3);
            TimeKeeper  timeKeeper = new TimeKeeper(60000, true, explore);

            Robot r1=  new Robot("Wall-E",explore);
            Robot r2 = new Robot("R2D2",explore);
            Robot r3 = new Robot("Optimus Prime",explore);
            explore.addRobot(r1);
            explore.addRobot(r2);
            explore.addRobot(r3);

            timeKeeper.addRobot(r1);
            timeKeeper.addRobot(r2);
            timeKeeper.addRobot(r3);

            timeKeeper.start();
            //waiting for keyboard commands
            Scanner scanner = new Scanner(System.in);
            while(true){
                System.out.println("Enter a command");
                String command = scanner.nextLine();

                if(command.equalsIgnoreCase("pause")){

                    System.out.println("Enter the name of the robot to pause:");
                    String name = scanner.nextLine();

                    System.out.println("Enter the seconds:");
                    int seconds = scanner.nextInt();
                    //System.out.println("secundele:" + seconds);

                    explore.pauseSpecificRobot(name,seconds);
                }
                else if (command.equalsIgnoreCase("pause all")) {
                    explore.pauseAll();
                }
                else if (command.equals("start")) {

                    System.out.println("Enter the name of the robot to start:");
                    String name = scanner.nextLine();

                    explore.startSpecificRobot(name);
                } else if (command.equals("start all")) {
                    explore.startAll();
                } else if (command.equals("quit")) {
                    // quit the program
                    for(Robot robot : explore.getRobots()){
                        robot.setRunning(false);
                        timeKeeper.setRunning(false);
                    }
                    break;
                }
            }
            System.out.println(timeKeeper.getDifference());

        }

}