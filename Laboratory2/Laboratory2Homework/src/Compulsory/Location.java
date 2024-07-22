package Compulsory;

public abstract class Location {
    protected String name;
    protected double xCoordinate;
    protected double yCoordinate;

    public Location() {
    }

    public abstract void setXSetY(double xCoordinate, double yCoordinate);

    public abstract String getName();

    public abstract void setName(String name);

    public abstract double getXCoordinate();

    public abstract double getYCoordinate();

    public abstract String getType();

    @Override
    public abstract String toString();

    @Override
    public abstract boolean equals(Object obj);

}
