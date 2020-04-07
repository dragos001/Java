package com.company;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class ControlPanel extends JPanel {

    final MainFrame frame;
    JButton saveBtn = new JButton("Save");
    JButton loadBtn = new JButton("Load");
    JButton resetBtn = new JButton("Reset");
    JButton exitBtn = new JButton("Exit");

    public ControlPanel(MainFrame frame){

        this.frame = frame;
        init();
    }

    private void init()
    {
        setLayout(new GridLayout(1, 4));


        saveBtn.setBounds(23,400,50,50);
        saveBtn.addActionListener(this::save);
        this.add(saveBtn);


        loadBtn.setBounds(73,450,50,50);
        loadBtn.addActionListener(this::load);
        this.add(loadBtn);

        resetBtn.setBounds(123,450,50,50);
        resetBtn.addActionListener(this::reset);
        this.add(resetBtn);


        exitBtn.setBounds(173,450,50,50);
        exitBtn.addActionListener(this::exit);
        this.add(exitBtn);


    }

    private void save(ActionEvent e)
    {

        try{
            ImageIO.write(frame.canvas.image, "PNG", new File("C:\\Users\\Dragos\\Desktop\\descărcare.png"));
        } catch (IOException ex) { System.err.println(ex); }
    }

    private void load(ActionEvent e)
    {
        try{
            BufferedImage image = ImageIO.read(new FileInputStream("C:\\Users\\Dragos\\Desktop\\descărcare.png"));
            frame.canvas.loadImage(image);

        } catch (IOException ex) { System.err.println(ex); }
    }
    private void reset(ActionEvent e)
    {
        try{
            this.frame.canvas.createOffscreenImage();
        } catch (Exception ex) {System.err.println(ex);}
    }
    private void exit(ActionEvent e)
    {   try {
        frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
    } catch (Exception ex) { System.err.println(ex); }
    }

}
