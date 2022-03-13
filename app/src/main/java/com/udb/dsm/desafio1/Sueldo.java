package com.udb.dsm.desafio1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Sueldo extends AppCompatActivity {

    private EditText txtNombre1,txtNombre2,txtNombre3,txtCargo1,txtCargo2,txtCargo3,txtHoras1,txtHoras2,txtHoras3;
    private Button btnCalcularSueldo;
    private TextView lblNombre1,lblNombre2,lblNombre3,lblDescuento1,lblDescuento2,lblDescuento3,lblSueldo1,lblSueldo2,lblSueldo3,lblBono1,lblBono2,lblBono3;
    Trabajador[] planilla;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sueldo);
        txtNombre1 = findViewById(R.id.txtNombre1);
        txtNombre2 = findViewById(R.id.txtNombre2);
        txtNombre3 = findViewById(R.id.txtNombre3);

        txtCargo1 = findViewById(R.id.txtCargo1);
        txtCargo2 = findViewById(R.id.txtCargo2);
        txtCargo3 = findViewById(R.id.txtCargo3);

        txtHoras1 = findViewById(R.id.txtHoras1);
        txtHoras2 = findViewById(R.id.txtHoras2);
        txtHoras3 = findViewById(R.id.txtHoras3);

        lblNombre1 = findViewById(R.id.lblNombre1);
        lblNombre2 = findViewById(R.id.lblNombre2);
        lblNombre3 = findViewById(R.id.lblNombre3);

        lblDescuento1 = findViewById(R.id.lblDescuento1);
        lblDescuento2 = findViewById(R.id.lblDescuento2);
        lblDescuento3 = findViewById(R.id.lblDescuento3);

        lblSueldo1 = findViewById(R.id.lblSueldo1);
        lblSueldo2 = findViewById(R.id.lblSueldo2);
        lblSueldo3 = findViewById(R.id.lblSueldo3);

        lblBono1 = findViewById(R.id.lblBono1);
        lblBono2 = findViewById(R.id.lblBono2);
        lblBono3 = findViewById(R.id.lblBono3);

        planilla = new Trabajador[3];

        btnCalcularSueldo = findViewById(R.id.btnCalcularSueldo);
        btnCalcularSueldo.setOnClickListener(listenerBtnCalcular);

    }

    View.OnClickListener listenerBtnCalcular = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            calcular();
            presentar();
        }
    };

    public void calcular()
    {
        try {

        String cargo1, cargo2 ,cargo3, nombre1,nombre2,nombre3;
        cargo1 = txtCargo1.getText().toString().trim().toLowerCase();
        cargo2 = txtCargo2.getText().toString().trim().toLowerCase();
        cargo3 = txtCargo3.getText().toString().trim().toLowerCase();

        nombre1 = txtNombre1.getText().toString().trim().toLowerCase();
        nombre2 = txtNombre2.getText().toString().trim().toLowerCase();
        nombre3 = txtNombre3.getText().toString().trim().toLowerCase();


            int horas1 = Integer.parseInt(txtHoras1.getText().toString());
            int horas2 = Integer.parseInt(txtHoras2.getText().toString());
            int horas3 = Integer.parseInt(txtHoras3.getText().toString());

            planilla[0] = new Trabajador(nombre1,cargo1,horas1);
            planilla[1] = new Trabajador(nombre2,cargo2,horas2);
            planilla[2] = new Trabajador(nombre3,cargo3,horas3);

            if(horas1 == 0 || horas2 == 0 || horas3 == 0)
            {
                mensaje("Ingrese valores validos para las horas");
            }
            else
            {
                if(cargo1.equals("gerente") && cargo2.equals("asistente") && cargo3.equals("secretaria")){
                    //NO aplicar bonos
                    for (int i =0;i<3;i++)
                    {
                        planilla[i].calcularSueldo();
                        planilla[i].descontar();
                    }
                }
                else
                {
                    for (int i =0;i<3;i++)
                    {
                        planilla[i].calcularSueldo();
                        planilla[i].descontar();
                        planilla[i].aplicarBono();
                    }
                }
            }
        }
        catch (NumberFormatException ex)
        {
            mensaje(ex.toString());
        }catch (NullPointerException e)
        {
            mensaje(e.toString());
        }

    }

    public void mensaje(String msj)
    {
        Toast.makeText(this, msj, Toast.LENGTH_SHORT).show();
    }
    public void presentar(){

        try {

        lblNombre1.setText(planilla[0].getNombre());
        lblSueldo1.setText(String.valueOf(planilla[0].getSueldo()));
        lblDescuento1.setText(planilla[0].getDescuento());
        lblBono1.setText(planilla[0].getBono());

        lblNombre2.setText(planilla[1].getNombre());
        lblSueldo2.setText(String.valueOf(planilla[1].getSueldo()));
        lblDescuento2.setText(planilla[1].getDescuento());
        lblBono2.setText(planilla[1].getBono());

        lblNombre3.setText(planilla[2].getNombre());
        lblSueldo3.setText(String.valueOf(planilla[2].getSueldo()));
        lblDescuento3.setText(planilla[2].getDescuento());
        lblBono3.setText(planilla[2].getBono());

    }catch (NullPointerException e)
    {
        mensaje(e.toString());
    }catch (ArrayIndexOutOfBoundsException e1)
        {
            mensaje("No hay datos suficientes");
        }

    }

}