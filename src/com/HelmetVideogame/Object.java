package com.HelmetVideogame;

import java.util.ArrayList;
import java.util.List;

public class Object extends Thread{
    private Main game;
    private ArrayList<Integer> Columnas = new ArrayList<Integer>(List.of(75, 150, 225, 300, 350));
    public static ArrayList<ObjectMove> objectMove = new ArrayList<ObjectMove>();
    private ArrayList<String> objects = new ArrayList<String>(List.of("Granade", "Incendiary", "Shuriken", "Battery", "Kit"));

    public Object(Main game) {
        this.game = game;
    }

    @Override
    public void run() {
        while (true) {
            LinkStarto();

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void BorrarObjeto(ObjectMove object) {
        objectMove.remove(object);
    }

    public void LinkStarto() {
        int x = Columnas.get((int) (Math.random() * 5 + 0));
        String objectsMove = objects.get((int) (Math.random() * 5 + 0));

        switch(objectsMove) {
            case "Battery":
                objectMove.add(new Battery(x, 0, 50, 50, game, "/imatges/battery.png"));
                break;
            case "Granade":
                objectMove.add(new Granade(x, 0, 50, 50, game, "/imatges/granade.png"));
                break;
            case "Kit":
                objectMove.add(new Kit(x, 0, 50, 50, game, "/imatges/kit.png"));
                break;
            case "Shuriken":
                objectMove.add(new Shuriken(x, 0, 50, 50, game, "/imatges/shuriken.png"));
                break;
            case "Incendiary":
                objectMove.add(new Incendiary(x, 0, 50, 50, game, "/imatges/incendiary.png"));
                break;
            default:
                break;
        }

        objectMove.get(objectMove.size()-1).start();
    }
}
