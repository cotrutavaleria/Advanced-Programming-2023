package Homework;

public class LatinSquareMatrix {

    private int[][] matrix;
    private int n;

    public LatinSquareMatrix(int size) {
        this.n = size;
        this.matrix = new int[n][n];
    }

    public void createMatrix() {
        for (int row = 0; row < this.n; row++) {
            for (int column = 0; column < this.n; column++) {
                this.matrix[row][column] = ((row + 1) + column) % this.n;
                if (this.matrix[row][column] == 0) {
                    this.matrix[row][column] = this.n;
                }
            }
        }
    }

    public void displayMatrix() {
        for (int row = 0; row < this.n; row++) {
            for (int column = 0; column < this.n; column++) {
                System.out.print(this.matrix[row][column] + " ");
            }
            System.out.println();
        }
    }
}
