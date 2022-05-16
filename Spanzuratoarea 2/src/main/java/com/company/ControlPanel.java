package com.company;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ControlPanel extends JPanel {
    final MainFrame frame;
    private final JButton startButton = new JButton("Start");
    private final JButton exitButton = new JButton("Exit");
    private final JLabel label = new JLabel("<html><h1><strong><i>Spanzuratoarea</i></strong></h1></html>");
    private final BufferedImage myPicture = ImageIO.read(new File("C:\\Users\\chico\\Documents\\GitHub\\Programare-Avansata\\Spanzuratoarea 2\\Img\\background.png"));
    private final JLabel picLabel = new JLabel(new ImageIcon(myPicture));

    public ControlPanel(MainFrame frame) throws IOException {
        this.frame = frame;
        init();
    }

    private void init() throws IOException {

        setBorder(new EmptyBorder(10, 10, 10, 10));
        setLayout(new GridBagLayout());

        picLabel.setBounds(10,5,600,600);
        label.setBounds(300, 250, 200, 40);
        startButton.setBounds(250, 350, 300, 40);
        exitButton.setBounds(250, 450, 300, 40);

        frame.add(picLabel);
        frame.add(label);
        frame.add(startButton);
        frame.add(exitButton);

        startButton.addActionListener(e -> {
            try {
                startGame(e);
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        });
        exitButton.addActionListener(this::exitGame);

    }


    private void startGame(ActionEvent e) throws IOException {
        frame.remove(picLabel);
        frame.remove(label);
        frame.remove(startButton);
        frame.remove(exitButton);
        frame.repaint();
        frame.canvas.startGame();

    }

    private void exitGame(ActionEvent e) {
        frame.dispose();
    }
}