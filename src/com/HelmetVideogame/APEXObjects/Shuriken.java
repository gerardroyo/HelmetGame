package com.HelmetVideogame.APEXObjects;

import com.HelmetVideogame.Main;

import java.util.Timer;
import java.util.TimerTask;

public class Shuriken extends ObjectMove{

    private Main game;

    public Shuriken(int x, int y, int WIDTH, int HEIGHT, Main game, String image) {
        super(x, y, WIDTH, HEIGHT, game, image);
        this.game = game;
    }

    public void shuriken() {
        Timer tiempo = new Timer();
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                if(game.player.isShuriken()){
                    game.player.setShuriken(false);
                }
            }
        };
        tiempo.schedule(task, 1500);
    }

    @Override
    public void ObjectAction() {
        game.player.setVidas(game.player.getVidas() - 1);
        game.player.setShuriken(true);
        shuriken();
    }

}
