package compulsory;

import java.util.Random;

public class Robot extends Thread {
    Exploration explore;
    private String robotName;
    private boolean running;

    public Robot(String name, Exploration explore) {
        this.explore = explore;
        this.running = true;
        this.robotName = name;
    }

    public void run() {
        while (running) {
            Random random = new Random();
            int row = random.nextInt(this.explore.getNumber());
            int col = random.nextInt(this.explore.getNumber());
            explore.getMap().visit(row, col, this);
            try {
                sleep(100);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }

    }


    public String getRobotName() {
        return this.robotName;
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