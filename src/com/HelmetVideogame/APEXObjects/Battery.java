package com.HelmetVideogame.APEXObjects;

import com.HelmetVideogame.Main;

import java.util.Timer;
import java.util.TimerTask;

public class Battery extends ObjectMove{

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
        tiempo.schedule(task, 4500);
    }

    @Override
    public void ObjectAction() {
        game.player.setBattery(true);
        invenc();
    }

}
