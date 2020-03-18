package com.HelmetVideogame;

import java.applet.Applet;
import java.applet.AudioClip;
import java.net.URL;

public class Granade extends ObjectMove {
    private Main game;

    URL url = Sound.class.getResource("/Sonidos/minecraft-alpha-damage-sound-effect.wav");
    AudioClip clip = Applet.newAudioClip(url);

    public Granade(int x, int y, int WIDTH, int HEIGHT, Main game, String image) {
        super(x, y, WIDTH, HEIGHT, game, image);
        this.game = game;
    }

    @Override
    public void AcionObjeto() {
        game.player.setVidas(game.player.getVidas() - 2);
        game.player.setX(45);
        clip.play();
    }

}
