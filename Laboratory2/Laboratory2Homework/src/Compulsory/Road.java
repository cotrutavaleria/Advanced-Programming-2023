package Compulsory;

import Homework.Airport;
import Homework.City;
import Homework.GasStation;

public class Road {
    public enum roadType {
        HIGHWAYS, EXPRESS, COUNTRY
    }
    Location location1, location2;
    private roadType type;
    private double length;
    private int speedLimit;


    public Road(String location1Name, String type1, String location2Name, String type2) {
        setLocationType1(type1);
        setLocationType2(type2);
        this.location1.setName(location1Name);
        this.location2.setName(location2Name);
    }
    public void setLocationType1(String type1) {
        switch (type1) {
            case "City":
                this.location1 = new City();
                break;
            case "Airport":
                this.location1 = new Airport();
                break;
            case "Gas station":
                this.location1 = new GasStation();
                break;
            default:
                System.out.println("The type of the location does not exist!");
        }
    }

    public void setLocationType2(String type2) {
        switch (type2) {
            case "City":
                this.location2 = new City();
                break;
            case "Airport":
                this.location2 = new Airport();
                break;
            case "Gas station":
                this.location2 = new GasStation();
                break;
            default:
                System.out.println("The type of the location does not exist!");
        }
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

    //Implement a method that determines if a problem's instance is valid.
    public boolean isTheRoadLengthValid(double length) {
        double euclideanDistance = Math.sqrt(Math.pow(Math.abs(location1.getXCoordinate() - location2.getXCoordinate()), 2) +
                Math.pow(Math.abs(location1.getYCoordinate() - location2.getYCoordinate()), 2));
        if (length >= euclideanDistance) {
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "The type of the road: " + this.type + "; the length: " +
                this.length + "; the speed limit: " + this.speedLimit + "; from " + this.location1.getName() + " to " + this.location2.getName();

    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Road road = (Road) obj;
        if (location1.getName().equals(road.location1.getName()) && (location2.getName().equals(road.location2.getName()))) {
            return true;
        }
        return false;
    }

}
