package compulsory;

import java.util.ArrayList;
import java.util.List;

public class Exploration {
    private final List<Robot> robots;
    private ExplorationMap map;
    private int number;

    public Exploration(int number) {
        this.robots = new ArrayList<>();
        this.number = number;
        this.map = new ExplorationMap(this.number);
    }

    public void addRobot(Robot robot) {
        this.robots.add(robot);
    }

    public void start() {
        for (Robot robot : robots) {
            robot.start();
        }
    }

    public int getNumber() {
        return number;
    }

    public ExplorationMap getMap() {
        return map;
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