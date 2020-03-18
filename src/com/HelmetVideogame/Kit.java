package com.HelmetVideogame;

import java.applet.Applet;
import java.applet.AudioClip;
import java.net.URL;

public class Kit extends ObjectMove {

    private Main game;

    URL url = Sound.class.getResource("/Sonidos/mmm_yeah.wav");
    AudioClip clip = Applet.newAudioClip(url);

    public Kit(int x, int y, int WIDTH, int HEIGHT, Main game, String image) {
        super(x, y, WIDTH, HEIGHT, game, image);
        this.game = game;
    }

    @Override
    public void AcionObjeto() {
        game.player.setVidas(game.player.getVidas() + 1);
        clip.play();
    }

}
