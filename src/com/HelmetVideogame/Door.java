package com.HelmetVideogame;

import javax.swing.*;
import java.awt.*;

public class Door extends Thread{

    private static int Y = 330;
    private static int WITH = 60;
    private static int HEIGHT = 10;
    int x = 0;
    private Main game;
    private String image;
    private Color color = Color.GREEN;

    public Door(int x, int y, int WIDTH, int HEIGHT, Main game) {
        this.x = x;
        this.Y = y;
        this.WITH = WIDTH;
        this.HEIGHT = HEIGHT;
        this.game = game;
        if (this.x == 0) { this.image = "/imatges/door.png";  }
        else { this.image = "/imatges/door_opened.png"; }
    }

    public void paint(Graphics2D g) {
        Y = game.getHeight() - HEIGHT;
        g.setColor(color);
        g.drawImage(new ImageIcon(getClass().getResource(image)).getImage(), x, Y, WITH, HEIGHT,null);
    }

    @Override
    public void run() {
        while(true) {
            if (color == Color.GREEN) {
                setColor(Color.RED);
                image = "/imatges/door_closed.png";
            }
            else if (color == Color.RED) {
                setColor(Color.GREEN);
                image = "/imatges/door_opened.png";
            }

            try {
                Thread.sleep(3450);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void setColor(Color color) { this.color = color; }

    public boolean CheckDoorColor() { return color == Color.GREEN ? true : false; }

    public Rectangle getBounds() { return new Rectangle(x, Y, WITH, HEIGHT); }

}
