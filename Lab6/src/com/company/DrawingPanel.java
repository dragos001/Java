package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.util.Random;

public class DrawingPanel extends JPanel {
    Random rand = new Random();
    final MainFrame frame;
    final static int W = 800, H = 600;
    BufferedImage image;
    Graphics2D graphics;

    public DrawingPanel(MainFrame frame)
    {
        this.frame = frame; createOffscreenImage();
        init();
    }

    public void createOffscreenImage(){

        image = new BufferedImage(W, H, BufferedImage.TYPE_INT_ARGB);
        graphics = image.createGraphics();
        graphics.setColor(Color.WHITE);
        graphics.fillRect(0, 0, W, H);
    }

    private void init(){

        setPreferredSize(new Dimension(W, H));
        setBorder(BorderFactory.createEtchedBorder());
        this.addMouseListener(new MouseAdapter()
        {
            public void mousePressed(MouseEvent e)
            {
                drawShape(e.getX(), e.getY()); repaint();
            }
        });

    }


    private void drawShape(int x, int y){
        rand = new Random();

        int radius = rand.nextInt(100);
        int sides = (int)this.frame.configPanel.sidesField.getValue();
        Color color = Color.CYAN;


        if("BLACK".equals((String) frame.configPanel.colorCombo.getSelectedItem()))
        {
            graphics.setColor(new Color(0,0,0));
        }
        else
        {
            float a = rand.nextFloat();
            float b = rand.nextFloat();
            float c = rand.nextFloat();
            graphics.setColor(new Color(a,b,c));
        }



        graphics.fill(new RegularPolygon(x, y, radius, sides));
    }

    public void update(Graphics g) { }


    protected void paintComponent(Graphics g){

        g.drawImage(image, 0, 0, this);
    }


    public void loadImage(BufferedImage image) {
        this.image = image;
        graphics = image.createGraphics();
    }
}
