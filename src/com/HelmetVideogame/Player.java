package com.HelmetVideogame;

import com.HelmetVideogame.APEXObjects.Kit;

import javax.swing.*;
import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.net.URL;

public class Player {
    private boolean Movimientos = false;
    private boolean battery = false;
    private boolean shuriken = false;
    private int WITH;
    private static int HEIGHT;
    private int y;
    int Y;
    int x = 0;
    int xa = 0;
    private Main game;
    private int vidas;

    URL url = Sound.class.getResource("/Sonidos/super-mario-bros-coin-sound-effect.wav");
    AudioClip clip = Applet.newAudioClip(url);

    public Player(int y, int WIDTH, int HEIGHT, Main game, int vidas) {
        this.y = y;
        this.WITH = WIDTH;
        this.HEIGHT = HEIGHT;
        this.game = game;
        this.x = WIDTH;
        this.vidas = vidas;
    }

    public void keyReleased(KeyEvent e) {
        xa = 0;
    }

    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_LEFT)
            xa = -game.speed;
        if (e.getKeyCode() == KeyEvent.VK_RIGHT)
            xa = game.speed;
    }

    public void move() throws InterruptedException {
        if (x + xa >= WITH && x + xa < game.getWidth() - WITH) {
            x = x + xa;
        }
        else if (game.puerta2.getBounds().intersects(getBounds())) {
            if (game.puerta2.CheckDoorColor()) {
                x = 45;
                game.setPuntuacion(game.getPuntuacion() + 5);
                clip.play();
            }
        }
        for (int i = 0; i < Object.objectMove.size(); i++) {
            if (Object.objectMove.get(i).PlayerColision() && !Object.objectMove.get(i).isPlayerColisioning()) {
                if (!isBattery() || Object.objectMove.get(i) instanceof Kit) {
                    Object.objectMove.get(i).setPlayerColisioning(true);
                    Object.objectMove.get(i).ObjectAction();
                }
            }
        }
        xa = 0;
    }

    public void paint(Graphics2D g) {
        Y = game.getHeight() - HEIGHT;
        g.drawImage(new ImageIcon(getClass().getResource("/imatges/player.gif")).getImage(), x, y, WITH, HEIGHT,null);
    }

    public Rectangle getBounds() {
        return new Rectangle(x, Y, WITH, HEIGHT);
    }

    public int getVidas() { return vidas; }
    public void setVidas(int vidas) { this.vidas = vidas; }

    public void setX(int x) { this.x = x; }

    public static int getHEIGHT() { return HEIGHT; }

    public boolean isShuriken() { return shuriken; }
    public void setShuriken(boolean shuriken) { this.shuriken = shuriken; }

    public boolean isBattery() { return battery; }
    public void setBattery(boolean battery) { this.battery = battery; }

    public void setMovimientos(boolean Movimientos) { this.Movimientos = Movimientos; }
    public boolean getMovimientos() { return Movimientos; }

}
