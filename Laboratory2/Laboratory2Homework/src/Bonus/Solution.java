package Bonus;


import java.util.*;

public class Solution {
    private HashMap<String, HashMap<String, Double>> routes;//Key = String(location1), Value = a pair of String(location2) and Double (roadLength)

    public Solution() {
        routes = new HashMap<>();
    }

    public void addLocation(String location1, String location2, double routeLength) {
        if (!routes.containsKey(location1)) {//ex: Iasi, Bucuresti, 388.6
            routes.put(location1, new HashMap<>());
        }
        //if key "location1" does not have as its value(Hashmap) location2, then add the value (location2, routeLength)
        if (!routes.get(location1).containsKey(location2)) {
            routes.get(location1).put(location2, routeLength);
        }

        if (!routes.containsKey(location2)) {//ex: Bucuresti, Iasi, 388.6, as the x->y road = y->x road
            routes.put(location2, new HashMap<>());
        }
        if (!routes.get(location2).containsKey(location1)) {
            routes.get(location2).put(location1, routeLength);
        }
    }

    public HashMap<String, Double> Algorithm(String source) {
        HashMap<String, Double> distances = new HashMap<>();
        for (String key : routes.keySet()) {
            distances.put(key, Double.MAX_VALUE);//for every destination, put infinte value
        }
        distances.put(source, 0.0);

        ArrayList<String> visited = new ArrayList<>();
        PriorityQueue<String> queue = new PriorityQueue<>(); //a Min Heap
        queue.offer(source); //inserts the source into queue
        while (!queue.isEmpty()) {
            String currentLocation = queue.poll();// gets the head of the PQ and removes it from the queue
            //System.out.println(currentLocation);
            if (visited.contains(currentLocation)) {
                continue;
            }
            visited.add(currentLocation);
            HashMap<String, Double> destinationLocation = routes.get(currentLocation);//the hashmap value of the currentLocation
           // System.out.println(destinationLocation); 
            if (destinationLocation == null) {
                continue;
            }
            for (HashMap.Entry<String, Double> nextLocation : destinationLocation.entrySet()) {
                String destination = nextLocation.getKey();
                double roadLength = nextLocation.getValue();
                //System.out.println(destination + " " + roadLength);
                double distanceToDestinationLocation = distances.get(currentLocation) + roadLength;
                if (distanceToDestinationLocation < distances.get(destination)) {
                    distances.put(destination, distanceToDestinationLocation);//replace the previous min length with the new one
                    queue.offer(destination);//add destination to the queue
                }
            }
        }
        return distances;
    }
}

