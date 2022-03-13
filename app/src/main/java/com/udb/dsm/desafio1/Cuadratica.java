package com.udb.dsm.desafio1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DecimalFormat;

public class Cuadratica extends AppCompatActivity {

    private EditText txtA,txtB,txtC;
    private TextView lblX1,lblX2;
    private Button btnCalcular;
    private static final DecimalFormat df = new DecimalFormat("0.0000");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cuadratica);

        txtA = findViewById(R.id.txtA);
        txtB = findViewById(R.id.txtB);
        txtC = findViewById(R.id.txtC);

        lblX1 = findViewById(R.id.txtX1);
        lblX2 = findViewById(R.id.txtX2);

        btnCalcular = findViewById(R.id.btnCalcular);
        btnCalcular.setOnClickListener(listenerBtnCalcular);
    }

    View.OnClickListener listenerBtnCalcular = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            calcular();
        }
    };

    public void calcular()
    {
        double A,B,C,x1,x2,D;
        x1 = x2 = 0;
        B = Double.parseDouble(txtB.getText().toString());
        A = Double.parseDouble(txtA.getText().toString());
        C = Double.parseDouble(txtC.getText().toString());

        D = Math.pow(B,2) - (4 * A * C);

        if(D >= 0)
        {
            x1 = ((B*(-1)) + Math.sqrt(D)) / (2*A);
            x2 = ((B*(-1)) - Math.sqrt(D)) / (2*A);

        }
        
        lblX1.setText(String.valueOf(df.format(x1)));
        lblX2.setText(String.valueOf(df.format(x2)));
    }

}