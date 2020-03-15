package com.HelmetVideogame;


import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import javax.swing.*;
import java.util.Comparator;

import static javax.imageio.ImageIO.read;

public class Main extends JPanel {

    //Ball ball = new Ball(this);
    public Player player = new Player(310, 50, 50, this, 3);
    int speed = 60;
    public int puntuacion;
    Object object;
    Door puerta = new Door(-26, 0, 75, 70, this);
    Door puerta2 = new Door(406, 0, 75, 70, this);
    ImageIcon image = new ImageIcon(getClass().getResource("/imatges/background.png"));

    int nsTio = 0;

    public Main() {

        addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
            }

            @Override
            public void keyReleased(KeyEvent e) {
                player.keyReleased(e)
                ;
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
        puerta.paint(g2d);
        puerta2.paint(g2d);

        g2d.setColor(Color.GRAY);
        g2d.setFont(new Font("Verdana", Font.BOLD, 30));
        g2d.drawString("Puntuación: " + String.valueOf(getPuntuacion()), 10, 30);
        g2d.drawString("Vidas: " + String.valueOf(player.getVidas()), 10, 60);
    }

    public void Threads() {
        object = new Object(this);
        object.start();
        puerta2.start();
    }

    public static class OrdenarPorPuntuacion implements Comparator<ScoreUser> {
        @Override
        public int compare(ScoreUser o1, ScoreUser o2) {
            return o2.getPuntuacion() - o1.getPuntuacion(); // Devuelve un entero positivo si la altura de o1 es mayor que la de o2
        }
    }

    public void gameOver() throws ParseException, org.json.simple.parser.ParseException, IOException {

        ArrayList<ScoreUser> partidasArray = new ArrayList<ScoreUser>();
        String partidasString = "";
        if (player.getVidas() <= 0) {

            partidasString = "Puntuaciones: " + "\n" + "";
            partidasArray = Json.visualitzarPuntuaciones();

        }

        if(!partidasArray.isEmpty()) {
            if (player.getVidas() <= 0) {
                for(int i = 0; i < partidasArray.size(); i++) {
                    partidasString = partidasString + partidasArray.get(i) + "\n";
                }

                JOptionPane.showMessageDialog(this, "Puntuación: " + getPuntuacion() + "\n" + "\n" + partidasString,
                        "Game Over", JOptionPane.YES_NO_OPTION);

                String kkk = "";

                if(partidasArray.size() >= 5) {
                    partidasArray.add(new ScoreUser(kkk, getPuntuacion()));
                    int count = 0;
                    for(int i = 0; i < partidasArray.size(); i++) {
                        if (partidasArray.get(i).getPuntuacion() < getPuntuacion() && count == 0){
                            String playerName = JOptionPane.showInputDialog("Nombre: ");
                            Json.guardarStatsJson(playerName, getPuntuacion());
                            count++;
                        }
                    }
                    if(count == 0) {
                        JOptionPane.showMessageDialog(this, "No se te guardara la puntuación porque no llega al TOP 5",
                                "Game Over", JOptionPane.YES_NO_OPTION);
                    }

                } else {
                    String playerName = JOptionPane.showInputDialog("Nombre: ");
                    Json.guardarStatsJson(playerName, getPuntuacion());
                }
                System.exit(ABORT);
            }


            nsTio++;
        } else {
            if (player.getVidas() <= 0) {
                JOptionPane.showMessageDialog(this, "Puntuación: " + getPuntuacion() ,
                        "Game Over", JOptionPane.YES_NO_OPTION);

                String playerName = JOptionPane.showInputDialog("Nombre:");

                Json.guardarStatsJson(playerName, getPuntuacion());

                System.exit(ABORT);
            }
        }

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
