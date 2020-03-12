package com.HelmetVideogame;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;

public class Object {

    private static int Y = 330;
    private static int WITH = 60;
    private static int HEIGHT = 10;
    int x = 0;
    int xa = 1;
    private Main game;

    private static final int DIAMETER = 20;

    int y = 0;
    int ya = 1;

    public Object(Main game, int x, int Y, int WITH, int HEIGHT) {
        this.game = game;
        this.x = x;
        this.Y = Y;
        this.WITH = WITH;
        this.HEIGHT = HEIGHT;
    }

    void move() {


            /*ya = -game.speed;

            ya = game.speed;*/

        /*boolean changeDirection = true;
        if (x + xa > 0 && x + xa < game.getWidth() - WITH)
            x = x + xa;
        if (x + xa < 0)
            xa = game.speed;
        else if (x + xa > game.getWidth() - DIAMETER)
            xa = -game.speed;
        else if (y + ya < 0)
           ya = game.speed;
        else if (y + ya > game.getHeight() - DIAMETER)
            game.gameOver();
        if (collision()){
            ya = -game.speed;
            y = game.player.getTopY() - DIAMETER;
            game.speed++;
        }*/
        /*else if(collisionMahou()){
            System.out.println(this.y + this.DIAMETER + " <= " + game.mahou.getY());
            System.out.println(this.y + " <= " + game.mahou.getUnderY());
            if(this.y + this.DIAMETER - 1 <= game.mahou.getY()){
                ya = -1;
            }
            else if(this.y + 1 >= game.mahou.getUnderY()){
                ya = 1;
            }
            else if(this.x + this.DIAMETER - 1 <= game.mahou.getX()){
                xa = -1;
            }
            else if(this.x + 1 >= game.mahou.getRightX()){
                xa = 1;
            }
        }*/

        //if (changeDirection)
        //Sound.BALL.play();
        //x = x + xa;
        Y = Y - 1;

    }

    private boolean collision() {
        return game.player.getBounds().intersects(getBounds());
    }
    /*private boolean collisionMahou() {
        return game.mahou.getBoundsMahou().intersects(getBounds());
    }*/

    public void paint(Graphics2D g) {
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
