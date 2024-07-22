package Bonus;

public class AdjacencyMatrixRegularGraph {
    private int numberOfVertices;
    private int vertexDegree;
    private int [][] adjMatrix;

    public AdjacencyMatrixRegularGraph(int nrOfVertices, int vertexDegree) {
        this.numberOfVertices = nrOfVertices;
        this.vertexDegree = vertexDegree;
        this.adjMatrix = new int[nrOfVertices][nrOfVertices];
    }

    public void createAdjacencyMatrix() {
        for (int row = 0; row < this.numberOfVertices; row++) {
            for (int column = 0; column < this.numberOfVertices; column++) {
                if (row == column) {
                    adjMatrix[row][column] = 0;
                } else {
                    adjMatrix[row][column] = 1;
                }
            }
        }
    }
    public void displayAdjacencyMatrix(){
        for (int row = 0; row < this.numberOfVertices; row++) {
            for (int column = 0; column < this.numberOfVertices; column++) {
                System.out.print(this.adjMatrix[row][column] + " ");
            }
            System.out.println();
        }
    }
}
