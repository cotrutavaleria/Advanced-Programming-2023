package homework;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private List<List<Integer>> redLines, blueLines;
    private List<Line> coloredLines;
    private int winner = 0;

    public Game() {
        this.coloredLines = new ArrayList<>();
        this.blueLines = new ArrayList<>();
        this.redLines = new ArrayList<>();
    }

    public void addToList(int player, List<Integer> verticesCoordinates) throws IllegalAccessException {
        if (!this.blueLines.contains(verticesCoordinates) && !this.redLines.contains(verticesCoordinates)) {
            try {
                switch (player) {
                    case 1:
                        this.blueLines.add(verticesCoordinates);
                        determineTheWinner(this.blueLines, 1);
                        break;
                    case 2:
                        this.redLines.add(verticesCoordinates);
                        determineTheWinner(this.redLines, 2);
                        break;
                    default:
                        throw new IllegalAccessException();
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        } else {
            throw new IllegalAccessException("The line have already been colored");
        }
    }

    public List<Integer> createCoordinatesList(int coordinate1, int coordinate2, int coordinate3, int coordinate4) {
        List<Integer> verifyIfExists = new ArrayList<>();
        verifyIfExists.add(coordinate1);
        verifyIfExists.add(coordinate2);
        verifyIfExists.add(coordinate3);
        verifyIfExists.add(coordinate4);
        return verifyIfExists;
    }

    public void determineTheWinner(List<List<Integer>> linesList, int player) {
        if (linesList.size() >= 3) {
            for (List<Integer> coordinates : linesList) {
                System.out.println("Coordinates:" + coordinates);
                for (List<Integer> nextCoordinates : linesList) {
                    if (coordinates.get(0).equals(nextCoordinates.get(0))) {
                        if (linesList.contains(createCoordinatesList(coordinates.get(2),coordinates.get(3), nextCoordinates.get(2), nextCoordinates.get(3))) || linesList.contains(createCoordinatesList(nextCoordinates.get(2), nextCoordinates.get(3), coordinates.get(2), coordinates.get(3)))) {
                            this.winner = player;
                            break;
                        }
                    } else if (coordinates.get(2).equals(nextCoordinates.get(0))) {
                        if (linesList.contains(createCoordinatesList(coordinates.get(0),coordinates.get(1), nextCoordinates.get(0), nextCoordinates.get(1))) || linesList.contains(createCoordinatesList(nextCoordinates.get(0),nextCoordinates.get(1), coordinates.get(0), coordinates.get(1)))) {
                            this.winner = player;
                            break;
                        }
                    } else {
                        this.winner = 0;
                    }

                }
            }
        }
    }

    public int getTheWinner() {
        System.out.println(this.winner);
        return this.winner;
    }
    public int getRedLinesSize(){
        return this.redLines.size();
    }

    public List<List<Integer>> getBlueLines() {
        return this.blueLines;
    }

    public int getBlueLinesSize(){
        return this.blueLines.size();
    }
    public List<List<Integer>> getRedLines() {
        return this.redLines;
    }
}