package org.example.compulsory;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class ConfigPanel extends JPanel {
    final MainFrame frame;
    JLabel dotsLabel, linesLabel;
    JSpinner dotsSpinner;
    JComboBox linesCombo;
    JButton createButton;
    public ConfigPanel(MainFrame frame) {
        this.frame = frame;
        init();
    }
    private void init() {
        //create the label and the spinner
        dotsLabel = new JLabel("Number of dots:");
        dotsSpinner = new JSpinner(new SpinnerNumberModel(4, 3, 100, 1));
        String[] combo = {"1.0","0.5","0.2","0.3","0.4"};
        linesCombo = new JComboBox(combo);
        createButton = new JButton("create");
        //create the rest of the components

        add(dotsLabel); //JPanel uses FlowLayout by default
        add(dotsSpinner);
        add(linesCombo);
        add(createButton);

        createButton.addActionListener(this::newDraw);

    }

    private void newDraw(ActionEvent actionEvent) {
        frame.add(new DrawingPanel(frame), BorderLayout.CENTER);
    }

}
