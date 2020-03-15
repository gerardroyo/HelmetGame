package com.HelmetVideogame;

public class ScoreUser implements Comparable<ScoreUser> {

    private String nombre;
    private int puntuacion;

    public ScoreUser (String nombre, int puntuacion) {
        this.nombre = nombre;
        this.puntuacion = puntuacion;}

    @Override
    public int compareTo(ScoreUser o) {
        return this.nombre.compareTo(o.nombre);}
    public int getPuntuacion() {return puntuacion;}

    @Override
    public String toString() {
        return

                nombre + " -- " + puntuacion;

    }
}
