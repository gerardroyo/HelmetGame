package com.HelmetVideogame;

public class ScoreUser implements Comparable<ScoreUser> {

    private int idPersona;
    private String nombre;
    private int puntuacion;

    public ScoreUser (int idPersona, String nombre, int puntuacion) {
        this.idPersona = idPersona;
        this.nombre = nombre;
        this.puntuacion = puntuacion;}

    @Override
    public int compareTo(ScoreUser o) {
        return this.nombre.compareTo(o.nombre);}

    public int getIdPersona() {return idPersona;}
    public String getNombre() {return nombre;}
    public int getPuntuacion() {return puntuacion;}

    public void setIdPersona(int idPersona) {
        this.idPersona = idPersona;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setPuntuacion(int puntuacion) {
        this.puntuacion = puntuacion;
    }

    @Override
    public String toString() {
        return

                nombre + " -- " + puntuacion;

    }
}
