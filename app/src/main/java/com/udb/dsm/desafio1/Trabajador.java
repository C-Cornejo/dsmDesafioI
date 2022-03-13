package com.udb.dsm.desafio1;

import java.text.DecimalFormat;

public class Trabajador {

    final static double  HORA_BASE  =  9.75;
    final static double HORA_EXTRA = 11.50;
    final static double       ISSS = 0.0525;
    final static double        AFP = 0.0688;
    final static double      RENTA = 0.1;

    final static String SECRETARIA  = "SECRETARIA";
    final static String  ASISTENTE  =  "ASISTENTE";
    final static String    GERENTE  =    "GERENTE";

    final static double BONO_SECRETARIA = 0.02;
    final static double  BONO_ASISTENTE = 0.03;
    final static double    BONO_GERENTE = 0.05;

    final static DecimalFormat df = new DecimalFormat("0.00");

    String nombre,cargo;
    double descuento,sueldo,sueldo_base,horas,bono;

    public String getNombre() {
        return nombre;
    }

    public String getCargo() {
        return cargo;
    }

    public String getDescuento() {
        return df.format(descuento) + " $";
    }

    public String getSueldo() {
        return df.format(sueldo) + " $";
    }
    public String getBono()
    {
        return df.format(bono) + " $";
    }

    public Trabajador(){}

    public Trabajador(String nombre, String cargo, double horas) {
        this.nombre    = nombre;
        this.cargo     = cargo;
        this.horas     = horas;

        sueldo = sueldo_base = descuento = bono = 0;

    }

    public void calcularSueldo()
    {
        if(horas > 160)
        {
            sueldo_base = 160 * HORA_BASE;
            sueldo_base += (horas - 160) * HORA_EXTRA;
        }
        else
        {
            sueldo_base = horas * HORA_BASE;
        }
    }

    public void descontar()
    {
        descuento = (sueldo_base * ISSS) + (sueldo_base * AFP);
        sueldo = sueldo_base - descuento;
        sueldo = sueldo * (1 - RENTA);
    }

    public void aplicarBono()
    {
        switch (cargo.toUpperCase())
        {
            case SECRETARIA:
                bono = sueldo * BONO_SECRETARIA;

                break;
            case ASISTENTE:
                bono = sueldo * BONO_ASISTENTE;

                break;
            case GERENTE:
                bono = sueldo * BONO_GERENTE;

                break;
            default:
                break;
        }

        sueldo += bono;
    }

}
