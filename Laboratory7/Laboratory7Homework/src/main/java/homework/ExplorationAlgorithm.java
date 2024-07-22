package homework;

import java.util.Stack;

public class ExplorationAlgorithm {
    private Exploration explore;
    private Cell[][] matrix;
    private Robot robot;

    public ExplorationAlgorithm(Exploration explore, Robot robot) {
        this.explore = explore;
        this.matrix = explore.getMap().getMatrix();
        this.robot = robot;
    }

    public void findPaths(Stack<Cell> path, int row, int column) {
        if (matrix == null || matrix.length == 0) {
            return;
        }
        int matrixSize = matrix.length;
        if (row == matrixSize - 1 && column == matrixSize - 1) {
            path.add(matrix[row][column]);
            explore.getMap().visit(row, column, this.robot);
            this.robot.robotSleeps();
            path.pop();
            return;
        }
        path.add(matrix[row][column]);
        if ((row >= 0 && row < matrixSize && column + 1 >= 0 && column + 1 < matrixSize)) {
            explore.getMap().visit(row, column, this.robot);
            this.robot.robotSleeps();
            findPaths(path, row, column + 1);
        }
        if ((row + 1 >= 0 && row + 1 < matrixSize && column >= 0 && column < matrixSize)) {
            explore.getMap().visit(row, column, this.robot);
            this.robot.robotSleeps();
            findPaths(path, row + 1, column);
        }
        path.pop();
    }
}
