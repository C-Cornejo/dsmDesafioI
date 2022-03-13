package com.udb.dsm.desafio1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Home extends AppCompatActivity {

   private Button btnCuadratica, btnSueldo, btnVotaciones;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        btnCuadratica = findViewById(R.id.btnCuadratica);
        btnVotaciones = findViewById(R.id.btnVotaciones);
        btnSueldo = findViewById(R.id.btnSueldo);

        btnCuadratica.setOnClickListener(listenerBtnCuadratica);
        btnVotaciones.setOnClickListener(listenerBtnVotaciones);
        btnSueldo.setOnClickListener(listenerBtnSueldo);
    }
    View.OnClickListener listenerBtnCuadratica = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent i = new Intent(view.getContext(),Cuadratica.class);
            startActivity(i);
        }
    };
    View.OnClickListener listenerBtnVotaciones= new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent i = new Intent(view.getContext(),Votaciones.class);
            startActivity(i);
        }
    };
    View.OnClickListener listenerBtnSueldo = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent i = new Intent(view.getContext(),Sueldo.class);
            startActivity(i);
        }
    };

}