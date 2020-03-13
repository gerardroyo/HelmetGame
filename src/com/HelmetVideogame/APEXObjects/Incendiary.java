package com.HelmetVideogame.APEXObjects;

import com.HelmetVideogame.Main;
import com.HelmetVideogame.Player;

import java.util.Timer;
import java.util.TimerTask;

public class Incendiary extends ObjectMove{

    private Main game;

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
    public void ObjectAction() {
        game.player.setVidas(game.player.getVidas() - 1);
        game.player.setMovimientos(true);
        Movimientos();
    }

}
