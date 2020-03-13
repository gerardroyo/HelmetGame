package com.HelmetVideogame.APEXObjects;

import com.HelmetVideogame.Main;
import com.HelmetVideogame.Object;

import javax.swing.*;
import java.awt.*;

public abstract class ObjectMove extends Thread{

    private int y;
    private int width;
    private int height;
    private int x;
    private Main game;
    String image;
    private boolean collisionedWithCharacter = false;

    public ObjectMove(int x, int y, int WIDTH, int HEIGHT, Main game, String image) {
        this.y = y;
        this.width = WIDTH;
        this.height = HEIGHT;
        this.x = x;
        this.game = game;
        this.image = image;
    }

    @Override
    public void run() {
        while(this.y + width < (game.getHeight() - 11) - game.player.getHEIGHT()) {
            move();

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        game.setPuntuacion(1);
        Object.DeleteObject(this);
    }

    public abstract void ObjectAction();

    public boolean isCollisionedWithCharacter() {
        return collisionedWithCharacter;
    }
    public void setCollisionedWithCharacter(boolean collisionedWithCharacter) {
        this.collisionedWithCharacter = collisionedWithCharacter;
    }

    public void move() {
        y = y + width;
    }

    public boolean collisionCharacter() {
        return game.player.getBounds().intersects(getBounds());
    }

    public Rectangle getBounds() {
        return new Rectangle(x, y + width, width, height);
    }

    public void paint(Graphics2D g) {
        g.drawImage(new ImageIcon(getClass().getResource(image)).getImage(), x, y, width, height,null);
    }

}
