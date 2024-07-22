package homework;

import java.util.ArrayList;
import java.util.List;

public class Cell {
    private List<Token> tokenInCell;
    private boolean isVisited;

    public Cell() {
        this.isVisited = false;
        this.tokenInCell = new ArrayList<>();
    }

    public void setTokenInCell(List<Token> tokenInCell) {
        this.tokenInCell = tokenInCell;
    }

    public void setVisited() {
        this.isVisited = true;
    }

    public boolean getIsVisited() {
        return this.isVisited;
    }

    @Override
    public String toString() {
        return "Cell{" +
                "tokenInCell=" + tokenInCell +
                ", isVisited=" + isVisited +
                '}';
    }
}