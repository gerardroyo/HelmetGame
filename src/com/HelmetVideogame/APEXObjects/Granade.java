package com.HelmetVideogame.APEXObjects;

import com.HelmetVideogame.Main;
import com.HelmetVideogame.Player;

public class Granade extends ObjectMove{
    private Main game;

    public Granade(int x, int y, int WIDTH, int HEIGHT, Main game, String image) {
        super(x, y, WIDTH, HEIGHT, game, image);
        this.game = game;
    }

    @Override
    public void ObjectAction() {
        game.player.setVidas(game.player.getVidas() - 2);
        game.player.setX(50);
    }

}
