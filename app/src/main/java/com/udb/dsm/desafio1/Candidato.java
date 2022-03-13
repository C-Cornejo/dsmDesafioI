package com.udb.dsm.desafio1;

import java.text.DecimalFormat;

public class Candidato {


    private String nombre;
    private int votos;
    private double porcentaje;
    private int total;
    private static final DecimalFormat df = new DecimalFormat("0.00");

    public Candidato(String nombre)
    {
        this.nombre = nombre;
        votos = 0;
    }

    public Candidato(String nombre,int total) {
        this.nombre = nombre;
        votos = 0;
        this.total= total;
    }

    public void setTotal(int total)
    {
        this.total = total;
    }

    public void calcularPorcentaje()
    {
        porcentaje = (Double.parseDouble(String.valueOf(votos)) / Double.parseDouble(String.valueOf(total))) * 100;
    }

    public double getPorcentaje()
    {
        return porcentaje;
    }
    public String getNombre() {
        return nombre;
    }

    public int getVotos() {
        return votos;
    }

    public void sumar()
    {
        this.votos++;
    }

    public String toString()
    {
        String s = "Candidato "+nombre + ": " +votos + " Votos; "+ df.format(porcentaje) + " %";
        return s;
    }
}
