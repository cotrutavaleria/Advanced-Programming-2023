package homework;

import com.fasterxml.jackson.databind.ObjectMapper;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class ControlPanel extends JPanel {
    final MainFrame mainFrame;
    JButton loadBtn, saveBtn, resetBtn, exitBtn;

    public ControlPanel(MainFrame mainFrame) {
        this.mainFrame = mainFrame;
        init();
    }

    private void init() {
        setLayout(new FlowLayout());
        this.loadBtn = new JButton("Load");
        this.saveBtn = new JButton("Save");
        this.resetBtn = new JButton("Reset");
        this.exitBtn = new JButton("Exit");

        saveBtn.addActionListener(this::saveGameState);
        loadBtn.addActionListener(this::savePNG);
        resetBtn.addActionListener(this::restoreGame);
        exitBtn.addActionListener(this::exitGame);

        add(loadBtn);
        add(saveBtn);
        add(resetBtn);
        add(exitBtn);
    }

    private void exitGame(ActionEvent event) {
        this.mainFrame.dispose();
    }

    private void savePNG(ActionEvent event) {
        if (Desktop.isDesktopSupported()) {
            try {
                JFileChooser fileChooser = new JFileChooser();
                fileChooser.showSaveDialog(this.mainFrame);
                System.out.println("File's path: " + fileChooser.getSelectedFile());
                ImageIO.write(this.mainFrame.canvas.image, "png", fileChooser.getSelectedFile());

            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }

    }

    private void addToList(List<List<Integer>> list, String color, List<Line> coloredLines) {
        for (List<Integer> coordinates : list) {
            Vertex vertex1 = new Vertex(coordinates.get(0), coordinates.get(1));
            Vertex vertex2 = new Vertex(coordinates.get(2), coordinates.get(3));
            Line line = new Line(vertex1, vertex2, color);
            coloredLines.add(line);
        }
    }

    private void saveGameState(ActionEvent event) {
        Game game = this.mainFrame.canvas.gameRules;
        List<Line> coloredLines = new ArrayList<>();
        addToList(game.getBlueLines(), "blue", coloredLines);
        addToList(game.getRedLines(), "red", coloredLines);
        ColoredLines getLines = new ColoredLines();
        getLines.setColoredLines(coloredLines);
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            objectMapper.writeValue(new File("src/main/Save_Restore_Board/boardInformation.json"), getLines);
            System.out.println("Object has been serialized");
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
            ex.printStackTrace();
        }
    }

    private void restoreGame(ActionEvent e) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            ColoredLines coloredLines = objectMapper.readValue(new File("src/main/Save_Restore_Board/boardInformation.json"), ColoredLines.class);
            System.out.println(coloredLines);
            Game game = this.mainFrame.canvas.gameRules;
            int nrOfColoredLines = coloredLines.getColoredLines().size();
            for (int index = 0; index < nrOfColoredLines; index++) {
                List<Integer> list = new ArrayList<>();
                list.add(coloredLines.getColoredLines().get(index).getVertex1().getX());
                list.add(coloredLines.getColoredLines().get(index).getVertex1().getY());
                list.add(coloredLines.getColoredLines().get(index).getVertex2().getX());
                list.add(coloredLines.getColoredLines().get(index).getVertex2().getY());
                if (coloredLines.getColoredLines().get(index).getColor().equals("red")) {
                    try {
                        game.addToList(2, list);
                        this.mainFrame.canvas.graphics.setColor(Color.RED);
                        this.mainFrame.canvas.graphics.drawLine(coloredLines.getColoredLines().get(index).getVertex1().getX(), coloredLines.getColoredLines().get(index).getVertex1().getY(), coloredLines.getColoredLines().get(index).getVertex2().getX(), coloredLines.getColoredLines().get(index).getVertex2().getY());
                    } catch (IllegalAccessException ex) {
                        ex.printStackTrace();
                    }
                } else {
                    try {
                        game.addToList(1, list);
                        this.mainFrame.canvas.graphics.setColor(Color.BLUE);
                        this.mainFrame.canvas.graphics.drawLine(coloredLines.getColoredLines().get(index).getVertex1().getX(), coloredLines.getColoredLines().get(index).getVertex1().getY(), coloredLines.getColoredLines().get(index).getVertex2().getX(), coloredLines.getColoredLines().get(index).getVertex2().getY());

                    } catch (IllegalAccessException ex) {
                        ex.printStackTrace();
                    }
                }
            }
            if(game.getRedLinesSize() > game.getBlueLinesSize()){
                this.mainFrame.canvas.setPlayer(1);
            }else{
                this.mainFrame.canvas.setPlayer(2);
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }

}
