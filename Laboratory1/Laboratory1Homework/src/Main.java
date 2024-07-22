/**
 * Cotruță Valeria, 2A1
 */

import Bonus.AdjacencyMatrixCycleGraph;
import Bonus.AdjacencyMatrixRegularGraph;
import Homework.LatinSquareMatrix;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Laboratory1Homework();
        Laboratory1Bonus1();
        Laboratory1Bonus2();
    }

    public static void Laboratory1Homework() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter an integer number:");
        int n;
        do {
            n = scanner.nextInt();
            if (n <= 0) {
                System.out.println("Enter a valid integer number:");
            }
        } while (n <= 0);
        LatinSquareMatrix latinSquareMatrix = new LatinSquareMatrix(n);
        long startTime = System.nanoTime();
        latinSquareMatrix.createMatrix();
        long endTime = System.nanoTime();
        long timeDifference = endTime - startTime;
        if (n >= 30_000) {
            System.out.println("Running time application in nanoseconds: " + timeDifference);
        } else {
            latinSquareMatrix.displayMatrix();
        }
    }

    public static void Laboratory1Bonus1() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the size of the cycle graph:");
        int size;
        do {
            size = scanner.nextInt();
            if (size <= 0) {
                System.out.println("Enter a valid size:");
            }
        } while (size <= 0);
        AdjacencyMatrixCycleGraph adjMatrix = new AdjacencyMatrixCycleGraph(size);
        adjMatrix.createAdjacencyMatrix();
        adjMatrix.displayAdjacencyMatrix();
        adjMatrix.computePowers();
    }

    public static void Laboratory1Bonus2() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the size of the cycle graph:");
        int numberOfVertices, vertexDegree;
        do {
            numberOfVertices = scanner.nextInt();
            vertexDegree = scanner.nextInt();
            if (numberOfVertices <= 0 || vertexDegree <= 0) {
                System.out.println("Enter a valid number of Vertices and vertex degree:");
            }
            if (numberOfVertices <= vertexDegree) {
                System.out.println("The number of vertices is smaller or equal to the vertex degree!");
            }
        } while (numberOfVertices <= 0 || vertexDegree <= 0);

        if (vertexDegree == 2) {
            AdjacencyMatrixCycleGraph adjMatrix = new AdjacencyMatrixCycleGraph(numberOfVertices);
            adjMatrix.createAdjacencyMatrix();
            adjMatrix.displayAdjacencyMatrix();
        } else {
            AdjacencyMatrixRegularGraph adjMatrixRegularGraph = new AdjacencyMatrixRegularGraph(numberOfVertices, vertexDegree);
            if ((numberOfVertices >= vertexDegree + 1) && (numberOfVertices * vertexDegree % 2 == 0)) {
                adjMatrixRegularGraph.createAdjacencyMatrix();
                adjMatrixRegularGraph.displayAdjacencyMatrix();
            } else {
                System.out.println("The regular graph does not exist!");
            }
        }
    }
}
