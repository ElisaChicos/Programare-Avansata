package com.company;

import javax.swing.*;

import java.io.IOException;

import static java.awt.BorderLayout.*;

public class MainFrame extends JFrame {
    ConfigPanel configPanel;
    ControlPanel controlPanel;
    DrawingPanel canvas;

    public MainFrame() throws IOException {
        super("Spanzuratoarea");
        init();
    }

    private void init() throws IOException {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        configPanel = new ConfigPanel(this);
        controlPanel = new ControlPanel(this);
        canvas = new DrawingPanel(this);
        add(canvas, CENTER);
        add(configPanel, NORTH);
        add(controlPanel, SOUTH);
        pack();
    }
}
