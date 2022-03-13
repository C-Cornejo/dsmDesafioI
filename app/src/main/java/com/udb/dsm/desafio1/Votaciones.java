package com.udb.dsm.desafio1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class Votaciones extends AppCompatActivity {


    private TextView nombre,conteo;
    private Button btnContar;
    private ListView lvResultados;
    private ArrayList<Candidato> papeleta;
    private int cantidadVotos = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_votaciones);

        nombre = findViewById(R.id.txtCandidatos);
        conteo = findViewById(R.id.txtVotos);

        lvResultados = findViewById(R.id.lvResultados);
        btnContar =    findViewById(R.id.btnContar);
        btnContar.setOnClickListener(listenerBtnContar);

        papeleta = new ArrayList<Candidato>();
    }

    View.OnClickListener listenerBtnContar = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            papeleta = new ArrayList<Candidato>();
            conteoVotos();
            mostrarResultados();
        }
    };

    public void mensaje(String msj)
    {
        Toast.makeText(this,msj,Toast.LENGTH_SHORT).show();
    }


    public void mostrarResultados()
    {

        ArrayAdapter arrayAdapter = new ArrayAdapter(this,android.R.layout.simple_list_item_1, papeleta);

        lvResultados.setAdapter(arrayAdapter);


    }

    public void conteoVotos()
    {
        String cadenaNombres = nombre.getText().toString();
        String cadenaVotos = conteo.getText().toString();

        String[] nombresSeparados = cadenaNombres.split(",");
        String[] votos = cadenaVotos.split(",");
        cantidadVotos = votos.length;
        mensaje("cantidad votos: "+String.valueOf(cantidadVotos));

        for ( String actual: nombresSeparados) {
            papeleta.add(new Candidato(actual,cantidadVotos));
        } //llenamos la papeleta de nombres

        for (String votoActual: votos) {
            for (Candidato candidatoActual:papeleta) {

                if (candidatoActual.getNombre().toString().equals(votoActual))// Comparamos el nombre en el voto
                {
                    candidatoActual.sumar(); // Agregamos un voto al candidato
                    candidatoActual.calcularPorcentaje();
                }
            }
        }
    }

}