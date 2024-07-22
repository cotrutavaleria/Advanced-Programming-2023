package Compulsory;

public class Road {

    Location location1, location2;
    private roadType type;
    private double length;
    private int speedLimit;
    public Road(Location location1, Location location2) {
        this.location1 = location1;
        this.location2 = location2;
    }

    public double getLength() {
        return this.length;
    }

    public void setLength(double length) {
        if (isTheRoadLengthValid(length)) {
            this.length = length;
        } else {
            System.out.println("The length is not valid!");
        }
    }

    public int getSpeedLimit() {
        return this.speedLimit;
    }

    public void setSpeedLimit(int speedLimit) {
        this.speedLimit = speedLimit;
    }

    public roadType getType() {
        return this.type;
    }

    public void setType(roadType type) {
        this.type = type;
    }

    public boolean isTheRoadLengthValid(double length) {
        double euclideanDistance = Math.sqrt(Math.pow(Math.abs(location1.getXCoordinate() - location2.getXCoordinate()), 2) +
                Math.pow(Math.abs(location1.getYCoordinate() - location2.getYCoordinate()), 2));
        if (length >= euclideanDistance) {
//            System.out.println(length + " " + euclideanDistance);
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "The type of the road: " + this.type + "; the length: " +
                this.length + "; the speed limit: " + this.speedLimit + "; from " + this.location1.getName() + " to " + this.location2.getName();

    }

    public enum roadType {
        HIGHWAYS, EXPRESS, COUNTRY
    }

}