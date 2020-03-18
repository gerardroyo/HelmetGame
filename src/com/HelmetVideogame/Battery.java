package com.HelmetVideogame;

import java.applet.Applet;
import java.applet.AudioClip;
import java.net.URL;
import java.util.Timer;
import java.util.TimerTask;

public class Battery extends ObjectMove {

    URL url = Sound.class.getResource("/Sonidos/battery.wav");
    AudioClip clip = Applet.newAudioClip(url);

    private Main game;

    public Battery(int x, int y, int WIDTH, int HEIGHT, Main game, String image) {
        super(x, y, WIDTH, HEIGHT, game, image);
        this.game = game;
    }

    public void invenc() {
        Timer tiempo = new Timer();
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                if(game.player.isBattery()){
                    game.player.setBattery(false);
                }
            }
        };
        tiempo.schedule(task, 2000);
    }

    @Override
    public void AcionObjeto() {
        game.player.setBattery(true);
        invenc();
        clip.play();
    }

}
