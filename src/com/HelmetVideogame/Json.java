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

public class Json {


    public void guardarStatsJson(String nombre, String puntuacion) throws IOException, ParseException, org.json.simple.parser.ParseException {
        JSONParser parser = new JSONParser();
        FileReader llegir = new FileReader("puntuaciones.json");

        JSONArray paraules = (JSONArray) parser.parse(llegir);

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

    public static ArrayList<String> visualitzarPuntuaciones() throws IOException, ParseException, org.json.simple.parser.ParseException {
        JSONParser parser = new JSONParser();
        FileReader llegir = new FileReader("puntuacion.json");
        JSONArray partides = new JSONArray();

        try {
            partides = (JSONArray) parser.parse(llegir);
        } catch (IOException e) {
            //e.printStackTrace();
        }

        ArrayList<String> partidasArray = new ArrayList<String>();

        for (int i = 0; i < partides.size(); i++) {
            JSONObject partidesObj = (JSONObject) partides.get(i);
            //LLegir Paraula Json
            String visuJugador = partidesObj.get("JUGADOR").toString();
            String visuEstado = partidesObj.get("RESULTADO").toString();

            partidasArray.add(visuJugador + ", " + visuEstado);
        }

        //partidasArray = top5Filter(partidasArray);

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
