package Homework;

import Compulsory.Location;

public class City extends Location {
    private int population;

    public City() {
        this.population = 0;
    }

    public int getPopulation() {
        return this.population;
    }

    public void setPopulation(int population) {
        this.population = population;
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
        return "City";
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
        City location = (City) obj;
        return name.equals(location.name);
    }


}
