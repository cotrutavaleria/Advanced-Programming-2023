package Homework;

import Compulsory.Location;

public class GasStation extends Location {
    private double gasPrice;

    public GasStation() {
        this.gasPrice = 0;
    }

    public double getGasPrice() {
        return this.gasPrice;
    }

    public void setGasPrice(double price) {
        this.gasPrice = price;
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
        return "Gas station";
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
        GasStation location = (GasStation) obj;
        return name.equals(location.name);
    }

}
