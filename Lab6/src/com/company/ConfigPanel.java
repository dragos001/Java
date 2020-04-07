package com.company;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class ConfigPanel extends JPanel {
    Random rand = new Random();
    final MainFrame frame;
    JLabel label;
    public JSpinner sidesField;
    JComboBox colorCombo;

    public ConfigPanel(MainFrame frame){
        this.frame = frame;
        init();
    }

    private void init() {

        JLabel sidesLabel = new JLabel("Number of sides:");
        sidesField = new JSpinner(new SpinnerNumberModel(0, 0, 100, 1));
        sidesField.setValue(4);
        float a,b,c;


        a=rand.nextFloat();
        b=rand.nextFloat();
        c=rand.nextFloat();

       String[] colors = { "BLACK" , "RANDOM"};
       colorCombo = new JComboBox(colors);



        add(colorCombo);
        add(sidesField);
        add(colorCombo);
    }
    }
