package Compulsory;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

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

        saveBtn.addActionListener(this::saveBoard);
        loadBtn.addActionListener(this::loadBoard);
        resetBtn.addActionListener(this::resetGame);
        exitBtn.addActionListener(this::exitGame);

        add(loadBtn);
        add(saveBtn);
        add(resetBtn);
        add(exitBtn);
    }

    private void exitGame(ActionEvent event) {
        this.mainFrame.dispose();
    }

    private void loadBoard(ActionEvent event) {
    }

    private void resetGame(ActionEvent event) {
    }

    private void saveBoard(ActionEvent e) {
    }
}
