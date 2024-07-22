/**
 * Cotruță Valeria, 2A1
 */

import Bonus.Solution;
import Compulsory.Road;
import Homework.Airport;
import Homework.GasStation;
import Homework.Problem;
import Homework.City;

public class Main {
    public static void main(String[] args) {
        Problem problem = new Problem();
        problem.addLocation("Iasi", new Airport(), 47.158455, 27.601442);
        problem.addLocation("Bucuresti", new City(), 44.439663, 26.096306);
        problem.addLocation("Bucuresti", new City(), 44.439663, 26.096306);//duplicate
        problem.addLocation("Brasov", new City(), 44.439663, 26.096306);
        problem.addLocation("Mol", new GasStation(), 44.439663, 26.096306);
        problem.addLocation("Chisinau", new City(), 44.439663, 26.096306);

        problem.addRoad("Iasi", "Bucuresti", Road.roadType.HIGHWAYS, 69, 388.6);
        problem.addRoad("Iasi", "Brasov", Road.roadType.EXPRESS, 69, 388.6);
        problem.addRoad("Iasi", "Bucuresti", Road.roadType.HIGHWAYS, 69, 388.6);//duplicate
        problem.addRoad("Bucuresti", "Mol", Road.roadType.HIGHWAYS, 69, 388.6);
        problem.addRoad("Chisinau", "Bucuresti", Road.roadType.HIGHWAYS, 69, 388.6);

        problem.displayLocations();
        problem.displayRoads();

        problem.runDFS("Bucuresti", "Iasi");//false
        problem.runDFS("Iasi", "Mol");//true

        System.gc();
        Runtime runtime = Runtime.getRuntime();
        long usedMemoryBefore = runtime.totalMemory() - runtime.freeMemory();
        long initialTime = System.currentTimeMillis();

        problem.DijkstraAlgorithm("Iasi");

        long runningTime = System.currentTimeMillis() - initialTime;
        long usedMemoryAfter = runtime.totalMemory() - runtime.freeMemory();
        long memoryIncrease = usedMemoryAfter - usedMemoryBefore;
        System.out.println("Running time: " + runningTime);
        System.out.println("Used memory: " + usedMemoryAfter);
        System.out.println("Memory increase: " + memoryIncrease);

    }
}