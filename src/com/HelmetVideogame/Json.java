package com.HelmetVideogame;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;

public class Json {


    public static void guardarStatsJson(String nombre, int puntuacion) throws IOException, ParseException, org.json.simple.parser.ParseException {
        JSONParser parser = new JSONParser();
        FileReader llegir = new FileReader("puntuacion.json");
        JSONArray paraules = new JSONArray();

        try {
            paraules = (JSONArray) parser.parse(llegir);
        } catch (Exception e) { }

        //Guardar info del joc dins d'un Json

        JSONObject stats = new JSONObject();

        stats.put("JUGADOR", nombre);
        stats.put("RESULTADO", puntuacion);

        paraules.add(stats);

        FileWriter omplir = new FileWriter("puntuacion.json");

        omplir.write(paraules.toJSONString());

        omplir.flush();
        omplir.close();
    }

    public static ArrayList<ScoreUser> visualitzarPuntuaciones() throws IOException, ParseException, org.json.simple.parser.ParseException {
        JSONParser parser = new JSONParser();
        FileReader llegir = new FileReader("puntuacion.json");
        JSONArray partides = new JSONArray();

        try {
            partides = (JSONArray) parser.parse(llegir);
        } catch (Exception e) { }


        ArrayList<ScoreUser> partidasArray = new ArrayList<ScoreUser>();
        ArrayList<ScoreUser> partidasArray2 = new ArrayList<ScoreUser>();

        for (int i = 0; i < partides.size(); i++) {
            JSONObject partidesObj = (JSONObject) partides.get(i);
            String visuJugador = "";
            //LLegir Paraula Json
            try {
                visuJugador = partidesObj.get("JUGADOR").toString();
            } catch (Exception e) {
                visuJugador = "Anonimo";
            }
            int visuEstado = Integer.parseInt(partidesObj.get("RESULTADO").toString());

            partidasArray.add(new ScoreUser(i, visuJugador, visuEstado));
        }
        Collections.sort(partidasArray, new Main.OrdenarPersonaPorAltura());

        for(int i = 0; i < partidasArray.size(); i++) {
            if (i >= 4) {
                partidasArray.remove(i);
            }
        }
        return partidasArray;
    }

    /*public ArrayList<String> top5Filter(ArrayList<String> allPartidas) {
        ArrayList<String> top5 = new ArrayList<String>();

        for(int i = 0; i < allPartidas.size(); i++) {

            if(allPartidas(i)) {

            }

        }

        return top5;
    }*/

}
