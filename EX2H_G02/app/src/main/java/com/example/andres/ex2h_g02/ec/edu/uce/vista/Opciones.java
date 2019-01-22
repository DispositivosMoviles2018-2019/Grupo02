package com.example.andres.ex2h_g02.ec.edu.uce.vista;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.andres.ex2h_g02.MainActivity;
import com.example.andres.ex2h_g02.R;

public class Opciones extends AppCompatActivity {

    private Button Vehiculos;
    private Button Reservas;
    private Button Salir;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_opciones);

        Vehiculos = (Button) findViewById(R.id.btnop1);
        Reservas = (Button) findViewById(R.id.btnop2);
        Salir = (Button) findViewById(R.id.btnop3);

        Vehiculos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                Intent intent = new Intent(Opciones.this, listado.class);
                startActivity(intent);

            }
        });

        Reservas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                Intent intent = new Intent(Opciones.this, Reservas.class);
                startActivity(intent);

            }
        });

        Salir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                Intent intent = new Intent(Opciones.this, MainActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intent);

            }
        });


    }


}
