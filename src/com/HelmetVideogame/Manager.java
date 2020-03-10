package com.HelmetVideogame;

import java.util.ArrayList;

public class Manager {

    public static ArrayList<Object> instMahous(Main context) {
        ArrayList<Object> mahous = null;
        int plus = 75;
        int one = 1;
        mahous.clear();
        for(int i = 0; i < 5; i++) {
            mahous.add(new Object(context, plus, 1, 50, 50));
            plus = plus + 75;
        }
        return mahous;
    }

}
