package Homework;

import Compulsory.Location;

public class Airport extends Location {
    private int nrOfTerminals;

    public Airport() {
        this.nrOfTerminals = 0;
    }

    public int getNrOfTerminals() {
        return this.nrOfTerminals;
    }

    public void setNrOfTerminals(int terminals) {
        this.nrOfTerminals = terminals;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setXSetY(double xCoordinate, double yCoordinate) {
        this.xCoordinate = xCoordinate;
        this.yCoordinate = yCoordinate;
    }

    public double getXCoordinate() {
        return this.xCoordinate;
    }

    public double getYCoordinate() {
        return this.yCoordinate;
    }

    public String getType() {
        return "Airport";
    }

    @Override
    public String toString() {
        return "The name of the location: " + this.name + "; the coordinates (x,y): " + this.xCoordinate + " , " + this.yCoordinate + "; The type of the location: " + getType();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Airport location = (Airport) obj;
        return name.equals(location.name);
    }


}
