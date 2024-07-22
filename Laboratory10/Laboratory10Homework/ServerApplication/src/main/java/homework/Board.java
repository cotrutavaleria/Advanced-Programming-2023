package homework;

import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Board {
    private static final int MATRIX_SIZE = 19;
    private int[][] matrix;
    private Socket socket;

    public Board(Socket socket) throws IOException {
        this.socket = socket;
        this.matrix = new int[MATRIX_SIZE][MATRIX_SIZE];
        initBoard();
    }

    public static int getMatrixSize() {
        return MATRIX_SIZE;
    }

    private void initBoard() {
        for (int row = 0; row < MATRIX_SIZE; row++) {
            for (int column = 0; column < MATRIX_SIZE; column++) {
                this.matrix[row][column] = 0;
            }
        }
    }

    public int[][] getMatrix() {
        return matrix;
    }

    public List<List<Integer>> getMatrixString() {
        List<List<Integer>> matrixList = new ArrayList<>();
        for (int index = 0; index < 19; index++) {
            List<Integer> line = new ArrayList<>();
            for (int index1 = 0; index1 < 19; index1++) {
                line.add(matrix[index][index1]);
            }matrixList.add(line);
        }
        return matrixList;
    }

    @Override
    public String toString() {
        return "Board{" +
                "matrix=" + Arrays.toString(matrix) +
                '}';
    }
}
