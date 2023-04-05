package org.example.compulsory;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.lang.management.ManagementPermission;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class DrawingPanel extends JPanel {
    final MainFrame frame;
    final static int W = 700, H = 600;
    private int numVertices;
    private double edgeProbability;
    private int[] x, y;
    BufferedImage image; //the offscreen image
    Graphics2D graphics, graphics2; //the tools needed to draw in the image

    public DrawingPanel(MainFrame frame) {
        this.frame = frame;
        createOffscreenImage();
        initPanel();
        //createBoard();
    }

    private void initPanel() {
        setPreferredSize(new Dimension(W, H));
        setBorder(BorderFactory.createEtchedBorder());
        this.addMouseListener(new MouseAdapter() {
            //@Override
            public void mousePressed(MouseEvent e) {

                repaint();
            }
        });

    }

    private void createOffscreenImage() {
        image = new BufferedImage(W, H, BufferedImage.TYPE_INT_ARGB);
        graphics = image.createGraphics();
        graphics.setRenderingHint(
                RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        graphics.setColor(Color.WHITE);
        graphics.fillRect(0, 0, 800, 600);
        //graphics.drawLine(5,5,8,8);
    }

    final void createBoard() {
        numVertices = (int) frame.configPanel.dotsSpinner.getValue();//preluam nr de noduri
        edgeProbability = Double.parseDouble((String) frame.configPanel.linesCombo.getSelectedItem());//preluam probabil
        //System.out.println("am ajuns in desen");
        createOffscreenImage();
        createVertices();
        drawLines();
        drawVertices();
        repaint();
    }

    private void createVertices() {
        int x0 = W / 2;
        int y0 = H / 2; //middle of the board
        int radius = H / 2 - 10; //board radius
        double alpha = 2 * Math.PI / numVertices; // the angle
        x = new int[numVertices];
        y = new int[numVertices];
        for (int i = 0; i < numVertices; i++) {
            x[i] = x0 + (int) (radius * Math.cos(alpha * i));
            y[i] = y0 + (int) (radius * Math.sin(alpha * i));
        }
    }

    private void drawLines() {
        //System.out.println(numVertices);
        graphics.setColor(Color.BLACK);
        Random rand = new Random();
        int firstVert = rand.nextInt(numVertices);
        int secondVert = rand.nextInt(numVertices);
        int lines = 0;
        int[][] matrix = new int[numVertices][numVertices];
        int numberOfLines = (int) (((numVertices*(numVertices-1))/2) * edgeProbability);
        System.out.println(numberOfLines);

        for(int i = 0;i < numVertices; i++){
            for(int j = 0;j < numVertices;j++){
                matrix[i][j] = 0;
            }
        }

        while(lines < numberOfLines){
            if(firstVert != secondVert && matrix[firstVert][secondVert] == 0){
                graphics.drawLine(x[firstVert],y[firstVert],x[secondVert],y[secondVert]);
                matrix[firstVert][secondVert] = matrix[secondVert][firstVert] = 1;
                System.out.println(firstVert);
                System.out.println(secondVert);
                lines++;
            }
            /*System.out.println(firstVert);
            System.out.println(secondVert);*/
            System.out.println();

            firstVert = rand.nextInt(numVertices);
            secondVert = rand.nextInt(numVertices);

        }

        System.out.println(firstVert + secondVert);
        System.out.println("deseneaza linii");

    }
    private void drawVertices() {
        graphics.setColor(Color.BLUE);
        int size = 8;
        for(int i = 0;i < numVertices; i++ )
            graphics.fillOval(x[i],y[i],size,size);
        System.out.println("deseneaza puncte");
    }
    @Override
    public void update(Graphics g) { } //No need for update

    //Draw the offscreen image, using the original graphics
    @Override
    protected void paintComponent(Graphics graphics) {
        graphics.drawImage(image, 0, 0, this);
    }

}
