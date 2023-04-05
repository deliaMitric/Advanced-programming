package org.example.compulsory;

import javax.swing.*;
import java.awt.*;
import java.util.jar.JarFile;

import static java.awt.BorderLayout.CENTER;
import static javax.swing.SwingConstants.*;

public class MainFrame extends JFrame {
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
        controlPanel =  new ControlPanel(this);
        configPanel = new ConfigPanel(this);


        //arrange the components in the container (frame)
        //JFrame uses a BorderLayout by default
        add(canvas, CENTER);//this is BorderLayout.CENTER
        add(controlPanel, BorderLayout.SOUTH);
        add(configPanel, BorderLayout.NORTH);


        //invoke the layout manager
        pack();
    }



}
