package Bonus;

public class AdjacencyMatrixCycleGraph {
    private int size;
    private int[][] adjMatrix;

    public AdjacencyMatrixCycleGraph(int size) {
        this.size = size;
        this.adjMatrix = new int[size][size];
    }

    public void createAdjacencyMatrix() {
        adjMatrix[0][1] = 1;
        adjMatrix[0][this.size - 1] = 1;
        adjMatrix[this.size - 1][0] = 1;
        adjMatrix[this.size - 1][this.size - 2] = 1;
        for (int row = 0; row < this.size; row++) {
            for (int column = 0; column < this.size; column++) {
                if (row == column) {
                    adjMatrix[row][column] = 0;
                }
                if (row > 0 && row < this.size - 1) {
                    adjMatrix[row][row - 1] = 1;
                    adjMatrix[row][row + 1] = 1;
                }
            }
        }
    }

    public void computePowers() {
        int[][] adjMatrixNPower = new int[this.size][this.size];
        System.out.println("Power: 2");
        for (int row = 0; row < this.size; row++) {
            for (int column = 0; column < this.size; column++) {
                for (int result = 0; result < this.size; result++) {
                    adjMatrixNPower[row][column] += adjMatrix[row][result] * adjMatrix[result][column];
                }
                System.out.print(adjMatrixNPower[row][column] + " ");
            }
            System.out.println();
        }
        int[][] adjMatrixNPower1 = new int[this.size][this.size];
        for (int power = 3; power <= this.size; power++) {
            System.out.println("Power: " + power);
            for (int row = 0; row < this.size; row++) {
                for (int column = 0; column < this.size; column++) {
                    for (int result = 0; result < this.size; result++) {
                        adjMatrixNPower1[row][column] += adjMatrixNPower[row][result] * adjMatrix[result][column];
                    }
                    System.out.print(adjMatrixNPower1[row][column] + " ");
                } System.out.println();
            }
            for (int row1 = 0; row1 < this.size; row1++) {
                for (int column1 = 0; column1 < this.size; column1++) {
                    adjMatrixNPower[row1][column1] = adjMatrixNPower1[row1][column1];
                    adjMatrixNPower1[row1][column1] = 0;
                }
            }
        }
    }

    public void displayAdjacencyMatrix() {
        System.out.println("Power: 1");
        for (int row = 0; row < this.size; row++) {
            for (int column = 0; column < this.size; column++) {
                System.out.print(this.adjMatrix[row][column] + " ");
            }
            System.out.println();
        }
    }
}
