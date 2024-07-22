package homework;

import java.util.ArrayList;
import java.util.List;

public class Exploration {
    private final List<Robot> robots;
    private SharedMemory memory;
    private ExplorationMap map;
    private int number;
    private int flag = 0;

    public Exploration(int number) {
        this.robots = new ArrayList<>();
        this.number = number;
        this.map = new ExplorationMap(this.number);
        this.memory = new SharedMemory(this.number);
    }

    public void addRobot(Robot robot) {
        this.robots.add(robot);
    }

    public void start() {
        Commands commands = new Commands(this.robots);
        commands.executeCommand();
    }

    public ExplorationMap getMap() {
        return map;
    }

    public int getNumber() {
        return number;
    }

    public int getExtractedTokenListSize() {
        int count = 0;
        for (Robot robot : robots) {
            count += robot.getPlacedTokens().size();
        }
        return count;
    }

    public int getFlag() {
        return flag;
    }

    public void setFlag(int flag) {
        this.flag = flag;
    }

    public void displayTokenNumber() {
        for (Robot robot : robots) {
            System.out.println("Robotul " + robot.getRobotName() + "a extras " + robot.getPlacedTokens().size() + " tokeni");
        }
    }

    @Override
    public String toString() {
        return "Exploration{" +
                "map=" + map +
                ", number=" + number +
                ", robots=" + robots +
                '}';
    }
}