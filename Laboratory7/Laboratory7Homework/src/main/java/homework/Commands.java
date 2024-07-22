package homework;

import java.util.List;
import java.util.Scanner;

public class Commands {
    private boolean runningExploration;
    private List<Robot> robots;

    public Commands(List<Robot> robots) {
        this.runningExploration = true;
        this.robots = robots;
    }

    public void executeCommand() {
        Scanner scanner = new Scanner(System.in);
        while (this.runningExploration) {
            String command = scanner.nextLine();
            String[] splitCommands = command.split(" ");
            if (command.equals("robots start")) {
                for (Robot robot : robots) {
                    robot.start();
                }
            } else if (command.equals("robots pause")) {
                for (Robot robot : robots) {
                    robot.setPaused(true);
                    robot.setPauseTime(10000);
                }
            } else if (splitCommands[0].equals("start")) {
                int robotNumber = Integer.parseInt(splitCommands[1]) - 1;
                if (this.robots.size() > robotNumber && robotNumber >= 0) {
                    this.robots.get(robotNumber).start();
                } else {
                    throw new IllegalArgumentException("The robot does not exist!");
                }
            } else if (splitCommands[0].equals("pause")) {
                int robotNumber = Integer.parseInt(splitCommands[1]) - 1;
                int pauseTime = Integer.parseInt(splitCommands[2]);
                System.out.println("Pause time:" + pauseTime);
                if (this.robots.size() > robotNumber && robotNumber >= 0) {
                    this.robots.get(robotNumber).setPaused(true);
                    this.robots.get(robotNumber).setPauseTime(pauseTime);
                } else {
                    throw new IllegalArgumentException("The robot does not exist!");
                }
            } else {
                throw new IllegalArgumentException("The command does not exist!");
            }
        }
    }
}
