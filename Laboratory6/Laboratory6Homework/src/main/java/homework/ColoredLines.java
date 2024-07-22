package homework;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ColoredLines implements Serializable {
    private List<Line> coloredLines;
    public ColoredLines(){
        this.coloredLines = new ArrayList<>();
    }

    public void setColoredLines(List<Line> coloredLines) {
        this.coloredLines = coloredLines;
    }

    public List<Line> getColoredLines() {
        return coloredLines;
    }

    @Override
    public String toString() {
        return "ColoredLines{" +
                "coloredLines=" + coloredLines +
                '}';
    }
}
