package homework;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Robot extends Thread {
    Exploration explore;
    private List<Token> placedTokens;
    private String robotName;
    private boolean running, paused = false;
    private int pauseTime;
    private ExplorationAlgorithm algorithm;

    public Robot(String name, Exploration explore) {
        this.explore = explore;
        this.running = true;
        this.robotName = name;
        this.pauseTime = 2000;
        this.placedTokens = new ArrayList<>();
        this.algorithm = new ExplorationAlgorithm(this.explore, this);
    }

    public void run() {
        while (running) {
            Stack<Cell> paths = new Stack<>();
            algorithm.findPaths(paths, 0, 0);
        }
    }

    public void robotSleeps() {
        try {
            if (explore.getFlag() == 1) {
                running = false;
            } else {
                if (!paused) {
                    sleep(this.pauseTime);
                } else {
                    sleep(this.pauseTime);
                    resetPauseTime();
                }
            }
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }

    public void setPaused(boolean paused) {
        this.paused = paused;
    }

    public String getRobotName() {
        return this.robotName;
    }

    public void resetPauseTime() {
        this.pauseTime = 2000;
    }

    public void setPauseTime(int time) {
        this.pauseTime = time;
    }

    public List<Token> getPlacedTokens() {
        return placedTokens;
    }

    public void addToPlacedTokens(List<Token> tokens) {
        for (Token token : tokens) {
            this.placedTokens.add(token);
        }
    }

    @Override
    public String toString() {
        return "Robot{" +
                "explore=" + explore +
                ", name='" + robotName + '\'' +
                ", running=" + running +
                '}';
    }
}
