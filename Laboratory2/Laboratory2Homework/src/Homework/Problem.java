package Homework;

import Bonus.Solution;
import Compulsory.Location;
import Compulsory.Road;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Problem {
    public int nrOfLocations, nrOfRoads;
    private Location[] locations;
    private Road[] roads;
    private Solution solution;
    private HashMap<String, ArrayList<String>> toLocationList;
    private HashMap<String, Boolean> visitedLocations;
    private ArrayList<String> locationList;

    public Problem() {
        this.nrOfLocations = 0;
        this.nrOfRoads = 0;
        this.locations = new Location[5];
        this.roads = new Road[5];

        locations[0] = new City();
        locations[1] = new Airport();
        locations[2] = new GasStation();

        toLocationList = new HashMap<>();
        visitedLocations = new HashMap<>();
        locationList = new ArrayList<>();
        solution = new Solution();
    }

    //Verify if the name of the location may be found out in the locations[]
    public boolean isLocationValid(String name, Location location) {
        location.setName(name);
        if (this.nrOfLocations > 0) {
            for (int iterator = 0; iterator < this.nrOfLocations; iterator++) {
                if (locations[iterator].equals(location)) {
                    return true;
                }
            }
            return false;
        }
        return false;
    }

    //Add the location to locations[] if it is valid
    public void addLocation(String name, Location type, double xCoordonate, double yCoordonate) {
        if (!isLocationValid(name, type) && (this.nrOfLocations < this.locations.length)) {
            if (type.getType().equals("City")) {
                this.locations[this.nrOfLocations] = new City();
            } else if (type.getType().equals("Airport")) {
                this.locations[this.nrOfLocations] = new Airport();
            } else if (type.getType().equals("Gas station")) {
                this.locations[this.nrOfLocations] = new GasStation();
            } else
                System.out.println("The site does not exist!");
            this.locations[this.nrOfLocations].setXSetY(xCoordonate, yCoordonate);
            this.locations[this.nrOfLocations].setName(name);
            this.nrOfLocations++;
        } else {
            System.out.println("The location " + name + " already exists!");
        }
    }

    //Get the type of a location if it is existent
    public String existentLocation(String name) {
        for (int iterator = 0; iterator < this.nrOfLocations; iterator++) {
            if (this.locations[iterator].getName().equals(name)) {
                return this.locations[iterator].getType();
            }
        }
        return "";
    }

    //Verify if the road already exists in roads[]
    public boolean isRoadValid(String location1, String location2) {
        if (this.nrOfRoads > 0) {
            Road road = new Road(location1, existentLocation(location1), location2, existentLocation(location2));
            for (int iterator = 0; iterator < this.nrOfRoads; iterator++) {
                if (roads[iterator].equals(road)) {
                    return true;
                }
            }
            return false;
        }
        return false;
    }

    //Add a new road if it is not found in roads[]; add the destination(location2) to the adjacency list of the source (location1)
    public void addRoad(String location1, String location2, Road.roadType type, int speedLimit, double roadLength) {
        if (!isRoadValid(location1, location2) && (nrOfRoads < roads.length)) {
            this.roads[this.nrOfRoads] = new Road(location1, existentLocation(location1), location2, existentLocation(location2));
            addLocationToList(location1, location2); // Add location2 to adjacency list of location1
            this.roads[this.nrOfRoads].setType(type);
            this.roads[this.nrOfRoads].setSpeedLimit(speedLimit);
            this.roads[this.nrOfRoads].setLength(roadLength);
            this.nrOfRoads++;
            solution.addLocation(location1, location2, roadLength); //Add the route
        } else {
            System.out.println("The road " + location1 + "->" + location2 + " already exists!");
        }
    }

    //Implement function for adding location2 to the adjacency list of location1- the Value Content
    public void addLocationToList(String location1, String location2) {
        if (!toLocationList.containsKey(location1)) { //
            toLocationList.put(location1, new ArrayList<>()); //put = add a key with its value/replace the value of the key
        }
        toLocationList.get(location1).add(location2);// get = returns value based on the key, add = adds a new elem in ArrayList
    }

    public void DFSAlgorithm(String location1, String location2) {
        visitedLocations.put(location1, true);
        locationList.add(location1); //Create a new array to see if location2 was visited in location1's adjacency list
        List<String> locationsYouCanGoTo = toLocationList.get(location1);//give a name to the arraylist (value of the key)
        if (locationsYouCanGoTo != null) {
            for (String location : locationsYouCanGoTo) {
                if (!visitedLocations.containsKey(location)) {
                    DFSAlgorithm(location, location2);
                }
            }
        }
    }

    //Give a boolean answer if it is possible to go from one location to another using the given roads.
    public boolean isPossibleToGetTo(String location2) {
        // System.out.println(locationList);
        for (String location : locationList) {//the list of locations you can go to from location1
            if (location.equals(location2)) {
                return true;
            }
        }
        return false;
    }

    public void runDFS(String location1, String location2) {
        DFSAlgorithm(location1, location2);
        System.out.println(isPossibleToGetTo(location2));
        locationList.clear();
        visitedLocations.clear();
    }

    public void displayLocations() {
        for (int iterator = 0; iterator < this.nrOfLocations; iterator++) {
            System.out.println(locations[iterator]);
        }
    }

    public void displayRoads() {
        for (int iterator = 0; iterator < this.nrOfRoads; iterator++) {
            System.out.println(roads[iterator]);
        }
    }

    public void DijkstraAlgorithm(String sourceLocation) {
        Map<String, Double> result = solution.Algorithm(sourceLocation);
        for (Map.Entry<String, Double> destinationLength : result.entrySet()) {
            System.out.println(destinationLength.getKey() + " " + destinationLength.getValue());
        }
    }
}
