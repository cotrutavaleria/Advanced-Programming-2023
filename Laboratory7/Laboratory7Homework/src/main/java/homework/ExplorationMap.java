package homework;

import java.util.Arrays;
import java.util.List;

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
            if (!this.matrix[row][col].getIsVisited()) {
                System.out.println("The cell[" + row + "][" + col + "] has been visited now by:" + robot.getRobotName());
                List<Token> tokenList = sharedMemory.extractTokens(this.matrixSize);
                System.out.println(tokenList);
                robot.addToPlacedTokens(tokenList);
                this.matrix[row][col].setTokenInCell(tokenList);
                this.matrix[row][col].setVisited();
                return true;
            }
//            System.out.println("The cell[" + row + "][" + col + "] has been previously visited.");
            return false;
        }
    }

    public Cell[][] getMatrix() {
        return matrix;
    }

    @Override
    public String toString() {
        return "ExplorationMap{" +
                "matrix=" + Arrays.toString(matrix) +
                '}';
    }
}