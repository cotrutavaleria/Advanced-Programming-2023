package compulsory;

import java.util.Arrays;

public class ExplorationMap {
    private final Cell[][] matrix;
    private int matrixSize;
    private SharedMemory sharedMemory;

    public ExplorationMap(int n) {
        this.matrixSize = n;
        this.sharedMemory = new SharedMemory(this.matrixSize);
        this.matrix = new Cell[this.matrixSize][this.matrixSize];
        setMatrix();
    }

    public void setMatrix() {
        for (int index = 0; index < this.matrixSize; index++) {
            for (int index2 = 0; index2 < matrixSize; index2++) {
                this.matrix[index][index2] = new Cell();
            }
        }
    }

    public boolean visit(int row, int col, Robot robot) {
        synchronized (this.matrix[row][col]) {
            if (!this.matrix[row][col].getisVisited()) {
                this.matrix[row][col].setTokenInCell(sharedMemory.extractTokens(this.matrixSize));
                System.out.println("The cell[" + row + "][" + col + "] has been visited now by:" + robot.getRobotName());
                this.matrix[row][col].setVisited();
                return true;
            }
            System.out.println("The cell[" + row + "][" + col + "] has been previously visited.");
            return false;
        }
    }

    public Cell[][] getMatrix() {
        return matrix;
    }

    @Override
    public String toString() {
        for (int i = 0; i < this.matrixSize; i++) {
            for (int j = 0; j < this.matrixSize; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
        return "ExplorationMap{" +
                "matrix=" + Arrays.toString(matrix) +
                '}';
    }
}