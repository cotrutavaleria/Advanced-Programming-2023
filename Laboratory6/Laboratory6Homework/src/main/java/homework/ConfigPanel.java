package homework;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class ConfigPanel extends JPanel {
    final MainFrame mainFrame;
    JLabel dotsLabel, linesLabel;
    JSpinner dotsSpinner;
    JComboBox<Double> linesCombo;
    JButton createNewGameBtn;

    public ConfigPanel(MainFrame mainFrame) {
        this.mainFrame = mainFrame;
        init();
    }

    private void init() {
        this.dotsLabel = new JLabel("Number of dots:");
        this.dotsSpinner = new JSpinner(new SpinnerNumberModel(6, 3, 100, 1));
        this.linesLabel = new JLabel("Line probability:");
        Double[] linesProbabilities = {1.0, 0.1, 0.2, 0.3, 0.4, 0.5, 0.6, 0.7, 0.8, 0.9};
        this.linesCombo = new JComboBox<>(linesProbabilities);
        this.createNewGameBtn = new JButton("Create a new game");
        this.createNewGameBtn.addActionListener(this::createNewGame);
        add(this.dotsLabel);
        add(this.dotsSpinner);
        add(this.linesLabel);
        add(this.linesCombo);
        add(this.createNewGameBtn);
    }
    private void createNewGame(ActionEvent event) {
        this.mainFrame.canvas.setGameContinuesVariable();
        this.mainFrame.canvas.graphics.setBackground(Color.WHITE);
        this.mainFrame.canvas.graphics.clearRect(0, 0, 800, 600);
        this.mainFrame.canvas.graphics.setBackground(Color.WHITE);
        this.mainFrame.canvas.createBoard();
        this.mainFrame.canvas.repaint();
    }
    public JLabel getDotsLabel() {
        return this.dotsLabel;
    }

    public int getDotsNumber() {
        return (Integer) dotsSpinner.getValue();
    }
}
