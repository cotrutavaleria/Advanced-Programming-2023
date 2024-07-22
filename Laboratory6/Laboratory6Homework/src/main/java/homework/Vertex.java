package homework;

import java.io.Serializable;

public class Vertex implements Serializable {
    private int x, y;
    public Vertex(){
        this.x = 0;
        this.y = 0;
    }
    public Vertex(int coordX, int coordY) {
        this.x = coordX;
        this.y = coordY;
    }
    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public String toString() {
        return "Vertex{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
