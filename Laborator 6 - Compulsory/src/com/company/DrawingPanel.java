package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import static jdk.internal.vm.compiler.word.LocationIdentity.init;

public class DrawingPanel extends JPanel {
    final MainFrame frame;
    int rows, cols;
    int canvasWidth = 400, canvasHeight = 400;
    int boardWidth, boardHeight;
    int cellWidth, cellHeight;
    int padX, padY;
    int stoneSize = 20;


    BufferedImage image; //the offscreen image
    Graphics2D offscreen; //the offscreen graphics

    public DrawingPanel(MainFrame frame) {
        this.frame = frame;
        createOffscreenImage();
        init();
    }

    private void createOffscreenImage() {
        image = new BufferedImage(
                canvasWidth, canvasHeight, BufferedImage.TYPE_INT_ARGB);
        offscreen = image.createGraphics();
        offscreen.setColor(Color.WHITE); //fill the image with white
        offscreen.fillRect(0, 0, canvasWidth, canvasHeight);
    }

    private void paintGrid() {
        //same as before, only we draw in memory now
        //only using offscreen instead of the original graphics
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