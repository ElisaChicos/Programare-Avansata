package com.company;

import javax.swing.*;

import static javax.swing.SwingConstants.CENTER;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;
import static sun.security.util.ObjectIdentifier.pack;

public class MainFrame extends JPanel {
    ConfigPanel configPanel;
    ControlPanel controlPanel;
    DrawingPanel canvas;

    public MainFrame() {
        super("My Drawing Application");
        init();
    }

    private void init() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        //create the components
        canvas = new DrawingPanel(this);

        //arrange the components in the container (frame)
        //JFrame uses a BorderLayout by default
        add(canvas, CENTER); //this is BorderLayout.CENTER
        JButton button1 = new JButton("Press");

        //invoke the layout manager
        pack();
    }
}