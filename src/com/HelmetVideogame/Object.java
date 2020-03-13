package com.HelmetVideogame;

import com.HelmetVideogame.APEXObjects.*;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

public class Object extends Thread{

    /*private static int Y = 330;
    private static int WITH = 60;
    private static int HEIGHT = 10;
    int x = 0;
    int xa = 1;*/
    private Main game;
    public static ArrayList<ObjectMove> objectMove = new ArrayList<ObjectMove>();

    /*private static final int DIAMETER = 20;

    int y = 0;
    int ya = 1;*/

    private ArrayList<Integer> Columnas = new ArrayList<Integer>(
            List.of(75, 150, 225, 300, 350)
    );

    private ArrayList<String> objects = new ArrayList<String>(
            List.of("Granade", "Incendiary", "Shuriken", "Battery", "Kit")
    );

    public Object(Main game) {
        this.game = game;
    }

    public void LinkStarto() {
        int x = Columnas.get((int) (Math.random() * 5 + 0));
        String objectsMove = objects.get((int) (Math.random() * 5 + 0));

        switch(objectsMove) {
            case "Granade":
                objectMove.add(new Granade(x, 0, 50, 50, game, "/imatges/granade.png"));
                break;
            case "Incendiary":
                objectMove.add(new Incendiary(x, 0, 50, 50, game, "/imatges/incendiary.png"));
                break;
            case "Shuriken":
                objectMove.add(new Shuriken(x, 0, 50, 50, game, "/imatges/shuriken.png"));
                break;
            case "Battery":
                objectMove.add(new Battery(x, 0, 50, 50, game, "/imatges/battery.png"));
                break;
            case "Kit":
                objectMove.add(new Kit(x, 0, 50, 50, game, "/imatges/kit.png"));
                break;
            default:
                break;
        }

        objectMove.get(objectMove.size()-1).start();
    }

    public static void DeleteObject(ObjectMove object) {
        objectMove.remove(object);
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
}
