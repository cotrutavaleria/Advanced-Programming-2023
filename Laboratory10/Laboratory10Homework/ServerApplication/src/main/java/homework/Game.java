package homework;

import java.io.IOException;
import java.net.Socket;
import java.util.Timer;

public class Game {
    private Board matrixBoard;
    private Player player1, player2;
    private int winner = 0, row, column;
    private boolean finished;
    private Socket socket;

    public Game(Socket socket) throws IOException {
        this.socket = socket;
        this.matrixBoard = new Board(this.socket);
        finished = false;
    }

    String rules() throws IOException {
        if (!finished) {
            if (this.winner == 0) {
                this.winner = player1.getPlayerNumber();
            }
            if (this.winner == player1.getPlayerNumber()) {
                System.out.println("la 1");
                if (makeAMove(player1)) {
                    return "The winner is " + player1.getName();
                }
            } else {
                System.out.println("la 2");
                if (makeAMove(player2)) {
                    return "The winner is " + player2.getName();
                }
            }
        }
        return "";
    }

    public Board getMatrixBoard() {
        return matrixBoard;
    }

    public Player getPlayer1() {
        return player1;
    }

    public void setPlayer1(Player player1) {
        this.player1 = player1;
    }

    public Player getPlayer2() {
        return player2;
    }

    public void setPlayer2(Player player2) {
        this.player2 = player2;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public boolean makeAMove(Player player) throws IOException {
        this.matrixBoard.getMatrix()[this.row][this.column] = player.getPlayerNumber();
        if (checkWinner(player)) {
            System.out.println(player.getName() + " is the winner!");
            finished = true;
            return true;
        } else {
            if (this.winner == this.player1.getPlayerNumber()) {
                this.winner = this.player2.getPlayerNumber();
                System.out.println("The player has been 1 and is 2");
            } else {
                this.winner = this.player1.getPlayerNumber();
                System.out.println("The player has been 2 and is 1");
            }
            return false;
        }
    }

    private boolean checkWinner(Player player) {
        int boardSize = this.matrixBoard.getMatrixSize();
        int currentRow = this.row, currentColumn = this.column;
        if (checkHorizontally(currentRow, currentColumn, player)) {
            System.out.println("aici7");
            return true;
        } else if (checkVertically(currentRow, currentColumn, player)) {
            System.out.println("aici8");
            return true;
        } else if (checkDiagonal1(currentRow, currentColumn, player)) {
            System.out.println("aici9");
            return true;
        } else if (checkDiagonal2(currentRow, currentColumn, player)) {
            System.out.println("aici10");
            return true;
        }
        System.out.println("aici11");
        return false;
    }

    private boolean checkHorizontally(int currentRow, int currentColumn, Player player) {
        int counter = 1;
        int boardSize = this.matrixBoard.getMatrixSize();
        while (this.matrixBoard.getMatrix()[currentRow][currentColumn] == player.getPlayerNumber()) {
            if (currentColumn + 1 < boardSize && this.matrixBoard.getMatrix()[currentRow][currentColumn + 1] == player.getPlayerNumber()) {
                counter++;
                System.out.println("aici");
                currentColumn++;
            } else {
                break;
            }
        }
        currentColumn = this.column;
        while (this.matrixBoard.getMatrix()[currentRow][currentColumn] == player.getPlayerNumber()) {
            if (currentColumn - 1 >= 0 && this.matrixBoard.getMatrix()[currentRow][currentColumn - 1] == player.getPlayerNumber()) {
                System.out.println("aici1");
                counter++;
                currentColumn--;
            } else {
                break;
            }
        }
        System.out.println("aici2" + counter);
        if (counter == 5) {
            return true;
        }
        return false;
    }

    private boolean checkVertically(int currentRow, int currentColumn, Player player) {
        int counter = 1;
        int boardSize = this.matrixBoard.getMatrixSize();
        while (this.matrixBoard.getMatrix()[currentRow][currentColumn] == player.getPlayerNumber()) {
            if (currentRow + 1 < boardSize && this.matrixBoard.getMatrix()[currentRow + 1][currentColumn] == player.getPlayerNumber()) {
                counter++;
                System.out.println("aici");
                currentRow++;
            } else {
                break;
            }
        }
        currentRow = this.row;
        while (this.matrixBoard.getMatrix()[currentRow][currentColumn] == player.getPlayerNumber()) {
            if (currentRow - 1 >= 0 && this.matrixBoard.getMatrix()[currentRow - 1][currentColumn] == player.getPlayerNumber()) {
                System.out.println("aici1");
                counter++;
                currentRow--;
            } else {
                break;
            }
        }
        System.out.println("aici2" + counter);
        if (counter == 5) {
            return true;
        }
        return false;
    }

    private boolean checkDiagonal1(int currentRow, int currentColumn, Player player) {
        int counter = 1;
        int boardSize = this.matrixBoard.getMatrixSize();
        while (this.matrixBoard.getMatrix()[currentRow][currentColumn] == player.getPlayerNumber()) {
            if (currentColumn + 1 < boardSize && currentRow + 1 < boardSize && this.matrixBoard.getMatrix()[currentRow + 1][currentColumn + 1] == player.getPlayerNumber()) {
                counter++;
                System.out.println("aici");
                currentRow++;
                currentColumn++;
            } else {
                break;
            }
        }
        currentRow = this.row;
        currentColumn = this.column;
        while (this.matrixBoard.getMatrix()[currentRow][currentColumn] == player.getPlayerNumber()) {
            if (currentColumn - 1 >= 0 && currentRow - 1 >= 0 && this.matrixBoard.getMatrix()[currentRow - 1][currentColumn - 1] == player.getPlayerNumber()) {
                System.out.println("aici1");
                counter++;
                currentRow--;
                currentColumn--;
            } else {
                break;
            }
        }
        System.out.println("aici2" + counter);
        if (counter == 5) {
            return true;
        }
        return false;
    }

    private boolean checkDiagonal2(int currentRow, int currentColumn, Player player) {
        int counter = 1;
        int boardSize = this.matrixBoard.getMatrixSize();
        while (this.matrixBoard.getMatrix()[currentRow][currentColumn] == player.getPlayerNumber()) {
            if (currentColumn + 1 < boardSize && currentRow - 1 >= 0 && this.matrixBoard.getMatrix()[currentRow - 1][currentColumn + 1] == player.getPlayerNumber()) {
                counter++;
                System.out.println("aici");
                currentRow--;
                currentColumn++;
            } else {
                break;
            }
        }
        currentRow = this.row;
        currentColumn = this.column;
        while (this.matrixBoard.getMatrix()[currentRow][currentColumn] == player.getPlayerNumber()) {
            if (currentColumn - 1 >= 0 && currentRow + 1 < boardSize && this.matrixBoard.getMatrix()[currentRow + 1][currentColumn - 1] == player.getPlayerNumber()) {
                System.out.println("aici1");
                counter++;
                currentRow++;
                currentColumn--;
            } else {
                break;
            }
        }
        System.out.println("aici2" + counter);
        if (counter == 5) {
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "Game{" +
                "player1=" + player1 +
                ", player2=" + player2 +
                '}';
    }
}
