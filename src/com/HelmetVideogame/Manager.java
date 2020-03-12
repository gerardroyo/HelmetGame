package com.HelmetVideogame;

import java.util.ArrayList;

public class Manager {
    public static ArrayList<Object> mahouss = new ArrayList<Object>();
    public static ArrayList<Object> instMahous(Main context) {
        int plus = 75;
        int one = 1;
        mahouss.clear();
        for(int i = 0; i < 5; i++) {
            mahouss.add(new Object(context, plus, 1, 50, 50));
            plus = plus + 75;
        }
        return mahouss;
    }

}
