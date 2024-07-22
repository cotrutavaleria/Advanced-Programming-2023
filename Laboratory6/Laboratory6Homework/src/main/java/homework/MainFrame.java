package homework;

import javax.swing.*;

import java.awt.*;

public class MainFrame extends JFrame {
    ConfigPanel configPanel;
    ControlPanel controlPanel;
    DrawingPanel canvas;

    public MainFrame() {
        super("Laboratory 6 GUI");
        init();
    }

    private void init() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        this.configPanel = new ConfigPanel(this);
        add(this.configPanel, BorderLayout.NORTH);

        this.canvas = new DrawingPanel(this);
        add(this.canvas, BorderLayout.CENTER);

        this.controlPanel = new ControlPanel(this);
        add(this.controlPanel, BorderLayout.SOUTH);
        pack();
    }
}
