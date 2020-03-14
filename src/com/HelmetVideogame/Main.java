package com.HelmetVideogame;


import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.*;

import static com.sun.java.accessibility.util.AWTEventMonitor.addWindowListener;
import static javax.imageio.ImageIO.read;

public class Main extends JPanel {

    //Ball ball = new Ball(this);
    public Player player = new Player(310, 50, 50, this, 3);
    int speed = 60;
    public int puntuacion;
    Object object;
    Door door = new Door(-26, 0, 75, 70, this);
    Door door2 = new Door(406, 0, 75, 70, this);
    ImageIcon image = new ImageIcon(getClass().getResource("/imatges/background.png"));

    int nsTio = 0;

    public Main() {

        addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
            }

            @Override
            public void keyReleased(KeyEvent e) {
                player.keyReleased(e);
            }

            @Override
            public void keyPressed(KeyEvent e) {
                player.keyPressed(e);
            }
        });
        setFocusable(true);
        //Sound.BACK.loop();
    }

    private void move() throws InterruptedException {
        if (!player.isShuriken()) {
            player.move();
        }
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.drawImage(image.getImage(), 0, 0, getWidth(), getHeight(), this);

        player.paint(g2d);
        for(int i = 0; i < object.objectMove.size(); i++) {
            object.objectMove.get(i).paint(g2d);
        }
        door.paint(g2d);
        door2.paint(g2d);

        g2d.setColor(Color.GRAY);
        g2d.setFont(new Font("Verdana", Font.BOLD, 30));
        g2d.drawString("Puntuación: " + String.valueOf(getPuntuacion()), 10, 30);
        g2d.drawString("Vidas: " + String.valueOf(player.getVidas()), 10, 60);
    }

    public void Threads() {
        object = new Object(this);
        object.start();
        door2.start();
    }

    public void gameOver() throws ParseException, org.json.simple.parser.ParseException, IOException {
        if(nsTio > 0) {
            ArrayList<String> partidasArray = new ArrayList<String>();
            String partidasString = "   Puntuaciones: " + "\n" + "";
            partidasArray = Json.visualitzarPuntuaciones();

            for(int i = 0; i < partidasArray.size(); i++) {
                partidasString = partidasString + partidasArray.get(i) + "\n";
            }

            if (player.getVidas() <= 0) {
                JOptionPane.showMessageDialog(this, "Puntuación: " + getPuntuacion() + "\n" + "\n" + partidasString,
                        "Game Over", JOptionPane.YES_NO_OPTION);
                System.exit(ABORT);
            }

            String playerName = JOptionPane.showInputDialog("Nombre: ");
            nsTio++;
        } else {
            if (player.getVidas() <= 0) {
                JOptionPane.showMessageDialog(this, "Puntuación: " + getPuntuacion() ,
                        "Game Over", JOptionPane.YES_NO_OPTION);
                System.exit(ABORT);

                String playerName = JOptionPane.showInputDialog("Nombre:");

            }
        }

    }

    public void top5() {

    }

    public static void main(String[] args) throws InterruptedException, ParseException, org.json.simple.parser.ParseException, IOException {
        JFrame frame = new JFrame("APEX HELMET by Gerard Royo");
        Main game = new Main();
        frame.add(game);
        frame.setBackground(Color.black);
        frame.setSize(500, 400);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        game.Threads();

        while (true) {
            game.gameOver();
            game.move();
            game.repaint();
            Thread.sleep(5);
        }

    }

    public int getPuntuacion() { return puntuacion; }
    public void setPuntuacion(int puntuacion) { this.puntuacion = puntuacion; }
}
