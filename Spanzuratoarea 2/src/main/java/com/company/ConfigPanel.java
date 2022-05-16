package com.company;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class ConfigPanel extends JPanel {
    final MainFrame frame;
    private JLabel label;

    public ConfigPanel(MainFrame frame) {
        this.frame = frame;
        init();
    }

    private void init() {
        label = new JLabel("Bine ai venit!");
        add(label);

    }

    public void modifyHelpMessage(String message) {
        this.label.setText(message);
    }
}