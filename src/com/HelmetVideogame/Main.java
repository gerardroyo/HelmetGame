package com.HelmetVideogame;


import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import javax.swing.*;

public class Main extends JPanel {

    //Ball ball = new Ball(this);
    Manager mahouss;
    ArrayList<Object> mahous;
    Player player = new Player(this);
    Door door = new Door(this);
    int speed = 1;
    Graphics2D g2d;

    private int getScore() {
        return speed - 1;
    }


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

    private void move() {
        //ball.move();
        mahous.get(4).move();
        player.move();
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);

        //ball.paint(g2d);
        ins(this);
        player.paint(g2d);
        for(int i = 0; i < mahouss.mahouss.size(); i++) {
            mahouss.mahouss.get(i).paint(g2d);
        }
        door.paint(g2d,0, 286, 30, 75);
        door.paint(g2d,454, 286, 30, 75);

        g2d.setColor(Color.GRAY);
        g2d.setFont(new Font("Verdana", Font.BOLD, 30));
        g2d.drawString(String.valueOf(getScore()), 10, 30);
    }

    public void gameOver() {
        //Sound.BACK.stop();
        //Sound.GAMEOVER.play();
        JOptionPane.showMessageDialog(this, "your score is: " + getScore(),
                "Game Over", JOptionPane.YES_NO_OPTION);
        System.exit(ABORT);
    }

    public static void main(String[] args) throws InterruptedException {
        JFrame frame = new JFrame("HELMET by Gerard Royo");
        Main game = new Main();
        frame.add(game);
        frame.setSize(500, 400);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        while (true) {
            game.move();
            game.repaint();
            Thread.sleep(5);
        }

    }
    public void ins(Main este) {
        mahous = Manager.instMahous(este);
    }
}
