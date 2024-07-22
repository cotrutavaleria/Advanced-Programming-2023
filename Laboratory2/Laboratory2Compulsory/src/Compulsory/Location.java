package Compulsory;

public class Location {
    public enum locationType {
        CITY, AIRPORT, GASSTATION
    }
    private String name;
    private locationType type;
    private double xCoordinate;
    private double yCoordinate;
    public Location(String name) {
        this.name = name;
    }

    public void setXSetY(double xCoordinate, double yCoordinate) {

        this.xCoordinate = xCoordinate;
        this.yCoordinate = yCoordinate;
    }

    public String getName() {
        return this.name;
    }

    public double getXCoordinate() {
        return this.xCoordinate;
    }

    public double getYCoordinate() {
        return this.yCoordinate;
    }

    public locationType getType() {
        return this.type;
    }

    public void setType(locationType type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "The name of the location: " + this.name + "; the coordinates (x,y): " + this.xCoordinate + " , " + this.yCoordinate + "; The type of the location: " + this.type;
    }

}