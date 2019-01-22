package com.example.andres.ex2h_g02.ec.edu.uce.vista;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import com.example.andres.ex2h_g02.MainActivity;
import com.example.andres.ex2h_g02.R;
import com.example.andres.ex2h_g02.ec.edu.uce.modelo.Bdvehiculos;
import com.example.andres.ex2h_g02.ec.edu.uce.modelo.Reserva;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class BusquedaReservas extends AppCompatActivity {

    String busqueda1;
    ArrayList<Reserva> estado1 = new ArrayList<>(100);

    EditText buscar;
    EditText Numero, Email, Costo,Celular,Fechaentrega;
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    private Spinner dia;
    private Spinner mes;
    private Spinner ano;
    Date fecha;
    private Date fechaAux;
    ArrayList<Reserva> items= new ArrayList<Reserva>(100);
    public BusquedaReservas() throws ParseException {
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menubusquedareserva, menu);
        return true;
    }


    public boolean onOptionsItemSelected(MenuItem item) {
        final Bdvehiculos dblite = new Bdvehiculos(getApplicationContext());
        Reserva reservas = new Reserva();
        if(item.getItemId()== R.id.item1) {


           // busqueda1=buscar.getText().toString();

            dblite.buscarReserva(reservas,buscar.getText().toString());
            Numero.setFocusable(false);
            Numero.setText(reservas.getNumero().toString());
            Email.setFocusable(false);
            Email.setText(reservas.getEmail());
            Costo.setFocusable(false);
            Costo.setText(reservas.getValor().toString());
            Celular.setFocusable(false);
            Celular.setText(reservas.getEmail());

            if (ano.getSelectedItem().toString().equals("1950") == true && mes.getSelectedItem().toString().equals("1") && dia.getSelectedItem().toString().equals("1")) {
                reservas.setFecEntrega(fechaAux);
            } else {
                Calendar fechaAux = Calendar.getInstance();
                fechaAux.set(Integer.parseInt(ano.getSelectedItem().toString()),
                        Integer.parseInt(mes.getSelectedItem().toString())-1,
                        Integer.parseInt(dia.getSelectedItem().toString()));
                fecha = new Date();
                fecha.setTime(fechaAux.getTimeInMillis());

            }
           // Fechaentrega.setFocusable(false);
//            Fechaentrega.setText(fecha.toString());
        }else if(item.getItemId()==R.id.item2) {
            Intent intent = new Intent(BusquedaReservas.this, Reservas.class);
            startActivity(intent);
        }else if(item.getItemId()==R.id.item3) {
            finish();
            Intent intent = new Intent(BusquedaReservas.this, MainActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intent);
        }


        return super.onOptionsItemSelected(item);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_busqueda_reservas);

        buscar = (EditText) findViewById(R.id.txtbuscarre);
        Numero = (EditText) findViewById(R.id.numero2);
        Email = (EditText) findViewById(R.id.email2);
        Celular = (EditText) findViewById(R.id.celular2);
        Costo = (EditText) findViewById(R.id.costo2);
        Fechaentrega=(EditText) findViewById(R.id.fecha2);
        dia = (Spinner) findViewById(R.id.spinner_dia);
        mes = (Spinner) findViewById(R.id.spinner_mes);
        ano = (Spinner) findViewById(R.id.spinner_ano);
        cargarFechas();
    }

    public void cargarFechas() {
        String[] opcionesDia = new String[31];
        String[] opcionesMes = new String[12];
        String[] opcionesAno = new String[70];
        for (int i = 1; i <= 31; i++) {
            opcionesDia[i - 1] = String.valueOf(i);
        }
        for (int i = 1; i <= 12; i++) {
            opcionesMes[i - 1] = String.valueOf(i);
        }
        for (int i = 1950; i <= 2019; i++) {
            opcionesAno[i - 1950] = String.valueOf(i);
        }

        ArrayAdapter<String> adapter;
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, opcionesDia);
        this.dia.setAdapter(adapter);
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, opcionesMes);
        this.mes.setAdapter(adapter);
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, opcionesAno);
        this.ano.setAdapter(adapter);
    }
}
