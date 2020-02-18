package com.HelmetVideogame;

import java.awt.Graphics2D;
import java.awt.Rectangle;

public class Object {

    private static int Y = 330;
    private static int WITH = 60;
    private static int HEIGHT = 10;
    int x = 0;
    int xa = 0;
    private Main game;

    public Object(Main game) {
        this.game = game;
    }

    public void paint(Graphics2D g, int x, int Y, int WITH, int HEIGHT) {
        this.x = x;
        this.Y = Y;
        this.WITH = WITH;
        this.HEIGHT = HEIGHT;
        g.fillRect(x, Y, WITH, HEIGHT);
    }

    public Rectangle getBoundsMahou() {
        return new Rectangle(x, Y, WITH, HEIGHT);
    }

    public int getTopY() {
        return Y - HEIGHT;
    }

    public int getX() {
        return x;
    }
    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return Y;
    }
    public void setY(int y) {
        this.Y = y;
    }

    public int getWidth() {
        return WITH;
    }
    public void setWidth(int width) {
        this.WITH = width;
    }

    public int getHeight() {
        return HEIGHT;
    }
    public void setHeight(int height) {
        this.HEIGHT = height;
    }

    public Rectangle getBounds() {
        return new Rectangle(x, Y, WITH, HEIGHT);
    }

    public int getUnderY(){
        return this.Y + HEIGHT;
    }

    public int getRightX() {
        return this.x + WITH;
    }

    /*private boolean collision() {
        return game.racquet.getBounds().intersects(getBounds());
    }*/

}
