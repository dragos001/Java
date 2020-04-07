package com.company;

import javax.swing.*;

import java.awt.*;

import static java.awt.FlowLayout.CENTER;

public class MainFrame extends JFrame {

    ConfigPanel configPanel;
    ControlPanel controlPanel;
    DrawingPanel canvas;

    public MainFrame()
    {
        super("My Drawing Application");
        init();
    }

    private void init()
    {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        canvas = new DrawingPanel(this);
        configPanel = new ConfigPanel(this);
        controlPanel = new ControlPanel(this);




        add(canvas, BorderLayout.CENTER);
        add(configPanel , BorderLayout.NORTH);
        add(controlPanel , BorderLayout.SOUTH);

        pack();
    }

}
