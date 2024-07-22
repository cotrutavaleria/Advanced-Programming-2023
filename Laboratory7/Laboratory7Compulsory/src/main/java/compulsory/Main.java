package compulsory;

public class Main {
    public static void main(String args[]) {
        var explore = new Exploration(3);
        explore.addRobot(new Robot("Wall-E", explore));
        explore.addRobot(new Robot("R2D2", explore));
        explore.addRobot(new Robot("Optimus Prime", explore));
        explore.start();
    }
}