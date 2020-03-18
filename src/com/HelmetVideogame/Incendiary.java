package com.HelmetVideogame;

import java.applet.Applet;
import java.applet.AudioClip;
import java.net.URL;
import java.util.Timer;
import java.util.TimerTask;

public class Incendiary extends ObjectMove {

    private Main game;

    URL url = Sound.class.getResource("/Sonidos/minecraft-alpha-damage-sound-effect.wav");
    AudioClip clip = Applet.newAudioClip(url);

    public Incendiary(int x, int y, int WIDTH, int HEIGHT, Main game, String image) {
        super(x, y, WIDTH, HEIGHT, game, image);
        this.game = game;
    }

    public void Movimientos() {
        Timer tiempo = new Timer();
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                if(game.player.getMovimientos()){
                    game.player.setMovimientos(false);
                }
            }
        };
        tiempo.schedule(task, 2750);
    }

    @Override
    public void AcionObjeto() {
        game.player.setVidas(game.player.getVidas() - 1);
        game.player.setMovimientos(true);
        Movimientos();
        clip.play();
    }

}
