package homework;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

public class DrawingPanel extends JPanel {
    final static int width = 800, height = 600;
    final MainFrame mainFrame;
    BufferedImage image; //the offscreen image
    Graphics2D graphics; //the tools needed to draw in the image
    private int numVertices;
    private double edgeProbability;
    private int[] x, y;
    private int player;
    public Game gameRules;
    private boolean gameContinues = true;

    public DrawingPanel(MainFrame frame) {
        this.mainFrame = frame;
        createOffscreenImage();
        initPanel();
        createBoard();
    }

    private void initPanel() {
        setPreferredSize(new Dimension(width, height));
        setBorder(BorderFactory.createEtchedBorder());
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                try {
                    colorLines(e.getX(), e.getY());
                    int winner = gameRules.getTheWinner();
                    if (winner != 0) {
                        System.out.println("Thanx for playing"); // we output message
                        gameContinues = false;
                    }
                } catch (IllegalAccessException ex) {
                    ex.printStackTrace();
                }
                repaint();
            }
        });
    }
    public void setGameContinuesVariable(){
        this.gameContinues = true;
    }
    private void createOffscreenImage() {
        image = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        graphics = image.createGraphics();
        graphics.setColor(Color.WHITE);
        graphics.fillRect(0, 0, 800, 600);
    }

    final void createBoard() {
        this.gameRules = new Game();
        this.player = 1;
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

    private void colorLines(int coordX, int coordY) throws IllegalAccessException {
        graphics.setFont(new Font("Courier", Font.BOLD, 10));
        graphics.drawString("Player's color", 10, 20);
        System.out.println("Player: " + this.player);
        int[] firstVertexIndex = selectLine(coordX, coordY);

        List<Integer> toList = new ArrayList<>();
        toList.add(firstVertexIndex[0]);
        toList.add(firstVertexIndex[1]);
        toList.add(firstVertexIndex[2]);
        toList.add(firstVertexIndex[3]);

        if (this.gameContinues) {
            if (firstVertexIndex[0] != 0) {
                this.gameRules.addToList(player, toList);
            } else {
                throw new IllegalAccessException("Click on an existent line!");
            }
            if (this.player == 1) {
                graphics.setColor(Color.BLUE);
                graphics.drawLine(firstVertexIndex[0], firstVertexIndex[1], firstVertexIndex[2], firstVertexIndex[3]);
                this.player = 2;
            } else if (this.player == 2) {
                graphics.setColor(Color.RED);
                graphics.drawLine(firstVertexIndex[0], firstVertexIndex[1], firstVertexIndex[2], firstVertexIndex[3]);
                this.player = 1;
            }
        }
    }
    private int[] selectLine(int coordX, int coordY) {
        int[] verticescoordinates = new int[4];
        for (int index = 0; index < x.length; index++) {
            for (int iterator = index + 1; iterator < x.length; iterator++) {
                double lineEquation = coordX * (y[iterator] - y[index]) - x[index] * (y[iterator] - y[index]) - coordY * (x[iterator] - x[index]) + y[index] * (x[iterator] - x[index]);
                double distanceVertexToLine = (Math.abs(lineEquation) / Math.sqrt(Math.pow((y[iterator] - y[index]), 2) + Math.pow((x[iterator] - y[index]), 2)));
                if (distanceVertexToLine <= 1.0 || distanceVertexToLine <= 2.0) {
                    verticescoordinates[0] = x[index];
                    verticescoordinates[1] = y[index];
                    verticescoordinates[2] = x[iterator];
                    verticescoordinates[3] = y[iterator];
                    return verticescoordinates;
                }
            }
        }
        return verticescoordinates;
    }
    public void setPlayer(int player){
        this.player = player;
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
