package com.udb.dsm.desafio1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText txtUsuario;
    private EditText txtPassword;
    private Button btnIngresar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtUsuario = findViewById(R.id.txtUsuario);
        txtPassword =  findViewById(R.id.txtPassword);
        btnIngresar = findViewById(R.id.btnIngresar);

        // REMOVER
        txtUsuario.setText("chacc");
        txtPassword.setText("12345");


        llenarDatos();
        btnIngresar.setOnClickListener(btnIngresarListener);
    }

    View.OnClickListener btnIngresarListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {

            if(validar()) {
                mensaje("Bienvenido");
                Intent i = new Intent(view.getContext(),Home.class);
                startActivity(i);
            }
            else
            {
               mensaje("Datos erroneos");
            }
        }
    };

    public void  mensaje(String msj)
    {
        Toast.makeText(this, msj,
                Toast.LENGTH_SHORT).show();
    }

    public boolean validar()
    {
        //DBAdmin admin = new DBAdmin(this,"administracion", null, 1);

        DBAdmin admin = new DBAdmin(this,"administracion", null, 1);
        SQLiteDatabase bd = admin.getWritableDatabase();

        String usuario = txtUsuario.getText().toString();
        String clave = txtPassword.getText().toString();

        mensaje("datos: "+usuario+"-"+clave);
        boolean respuesta = false;
        Cursor fila = bd.rawQuery("select * from tb_usuario where usuario='"+usuario+"' and clave='" + clave + "';", null);

        if (fila.moveToFirst()) {
            respuesta = true;
        }
        else
        {

        bd.close();
    }
        return respuesta;
}//fin de validar

 public void llenarDatos()
 {
     //DBAdmin admin = new DBAdmin(this,"administracion", null, 1);
     DBAdmin admin = new DBAdmin(this,"administracion", null, 1);

     SQLiteDatabase bd = admin.getWritableDatabase();
     ContentValues registro = new ContentValues();

     registro.put("codigo", "3");
     registro.put("usuario", "chacc");
     registro.put("clave", "12345");

     try {
         bd.insertOrThrow("tb_usuario", null, registro);
         bd.close();
         Toast.makeText(this, "Se cargaron los datos del artículo",Toast.LENGTH_SHORT).show();
     } catch (SQLiteException e) {
         Toast.makeText(this, "ERROR!! No se cargaron los datos del artículo" + e.getMessage(),Toast.LENGTH_LONG).show();
     }
 }


}