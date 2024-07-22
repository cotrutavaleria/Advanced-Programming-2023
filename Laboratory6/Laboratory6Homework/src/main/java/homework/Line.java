package homework;

import java.io.Serializable;
import java.util.List;

public class Line implements Serializable {
    private Vertex vertex1, vertex2;
    private String color;
    public Line(){
        this.vertex1 = new Vertex(0,0);
        this.vertex2 = new Vertex(0,0);
        this.color = "";
    }
    public Line(Vertex dot1, Vertex dot2, String color) {
        this.vertex1 = dot1;
        this.vertex2 = dot2;
        this.color = color;
    }
    public Vertex getVertex1(){
        return this.vertex1;
    }

    public Vertex getVertex2() {
        return vertex2;
    }

    public String getColor() {
        return color;
    }

    @Override
    public String toString() {
        return "Line{" +
                "vertex1=" + vertex1 +
                ", vertex2=" + vertex2 +
                ", color='" + color +
                "}\n";
    }
}
