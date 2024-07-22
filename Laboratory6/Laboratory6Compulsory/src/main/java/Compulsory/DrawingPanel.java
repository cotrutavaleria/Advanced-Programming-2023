package Compulsory;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class DrawingPanel extends JPanel {
    final static int width = 800, height = 600;
    final MainFrame mainFrame;
    BufferedImage image; //the offscreen image
    Graphics2D graphics; //the tools needed to draw in the image
    private int numVertices;
    private double edgeProbability;
    private int[] x, y;

    public DrawingPanel(MainFrame frame) {
        this.mainFrame = frame;
        createOffscreenImage();
        initPanel();
        createBoard();
    }

    private void initPanel() {
        setPreferredSize(new Dimension(width, height));
        setBorder(BorderFactory.createEtchedBorder());
    }

    private void createOffscreenImage() {
        image = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        graphics = image.createGraphics();
        graphics.setColor(Color.WHITE);
        graphics.fillRect(0, 0, 800, 600);
    }

    final void createBoard() {
        numVertices = this.mainFrame.configPanel.getDotsNumber();
        edgeProbability = (Double) this.mainFrame.configPanel.linesCombo.getSelectedItem();
        createOffscreenImage();
        createVertices();
        drawLines();
        drawVertices();
        repaint();
    }

    private void createVertices() {
        int x0 = this.width / 2;
        int y0 = this.height / 2; //middle of the board
        int radius = this.height / 2 - 10; //board radius
        double alpha = 2 * Math.PI / this.numVertices; // the angle
        this.x = new int[this.numVertices];
        this.y = new int[this.numVertices];
        for (int i = 0; i < this.numVertices; i++) {
            this.x[i] = x0 + (int) (radius * Math.cos(alpha * i));
            this.y[i] = y0 + (int) (radius * Math.sin(alpha * i));
        }
    }

    private void drawLines() {
        graphics.setColor(Color.gray);
        for (int index = 0; index < x.length; index++) {
            for (int iterator = index + 1; iterator < x.length; iterator++) {
                graphics.drawLine(x[index], y[index], x[iterator], y[iterator]);
            }
        }
    }

    private void drawVertices() {
        graphics.setColor(Color.black);
        for (int index = 0; index < x.length; index++) {
            graphics.fillOval(x[index] - 5, y[index] - 5, 10, 10);// -5 to set the dots correctly
            graphics.drawOval(x[index] - 5, y[index] - 5, 10, 10);
        }
    }

    public int getWidth() {
        return this.width;
    }

    public int getHeight() {
        return this.height;
    }

    @Override
    public void update(Graphics g) {
    } //No need for update

    //Draw the offscreen image, using the original graphics
    @Override
    protected void paintComponent(Graphics graphics) {
        graphics.drawImage(image, 0, 0, this);
    }

}
