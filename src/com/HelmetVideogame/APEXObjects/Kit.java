package com.HelmetVideogame.APEXObjects;

import com.HelmetVideogame.Main;

public class Kit extends ObjectMove{

    private Main game;

    public Kit(int x, int y, int WIDTH, int HEIGHT, Main game, String image) {
        super(x, y, WIDTH, HEIGHT, game, image);
        this.game = game;
    }

    @Override
    public void ObjectAction() {
        game.player.setVidas(game.player.getVidas() + 1);
    }

}
