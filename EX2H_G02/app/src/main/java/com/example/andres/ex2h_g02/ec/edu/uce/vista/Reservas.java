package com.example.andres.ex2h_g02.ec.edu.uce.vista;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.andres.ex2h_g02.MainActivity;
import com.example.andres.ex2h_g02.R;
import com.example.andres.ex2h_g02.ec.edu.uce.modelo.Bdvehiculos;
import com.example.andres.ex2h_g02.ec.edu.uce.modelo.Reserva;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class Reservas extends AppCompatActivity {
    String arch="";
    ListView listaRe;
    Reserva reservas= new Reserva();
    ArrayList<Reserva> items = new ArrayList<Reserva>(100);
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    String fecha1="2015-11-13";
    String fecha2="1998-03-05";
    Date f1=sdf.parse(fecha1);
    Date f2=sdf.parse(fecha2);
    public Reservas() throws ParseException {
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menureservas, menu);
        return true;
    }


    public boolean onOptionsItemSelected(MenuItem item) {

        if(item.getItemId()==R.id.item1 ) {
            Intent intent = new Intent(Reservas.this, Reservaciones.class);
            startActivity(intent);
        }else if(item.getItemId()==R.id.item2 ) {
            Intent intent = new Intent(Reservas.this, BusquedaReservas.class);
            startActivity(intent);
        }else if(item.getItemId()==R.id.item3) {
            Intent intent = new Intent(Reservas.this, Opciones.class);
            startActivity(intent);
        }else if(item.getItemId()==R.id.item4) {
            finish();
            Intent intent = new Intent(Reservas.this, MainActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intent);
        }else if(item.getItemId()==R.id.item5) {

            items=loadFromStorage();
            SharedPreferences.Editor editor = getSharedPreferences("Examen3", MODE_PRIVATE).edit();
            Set<String> set = new HashSet<String>();
            for (int i = 0; i < items.size(); i++) {
                set.add(items.get(i).getJSONObject().toString());
            }

            editor.putStringSet("Examen3", set);
            editor.commit();

            arch = guardarArchivo(set.toString(),"json");
            Toast.makeText(this, "Se creo respaldo de reservas!!!!", Toast.LENGTH_LONG).show();

        }


        return super.onOptionsItemSelected(item);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reservas);
        final Bdvehiculos dblite = new Bdvehiculos(getApplicationContext());
        items=loadFromStorage();
        listaRe = (ListView) findViewById(R.id.listadoR);

//dblite.ingresarReserva(new Reserva("100","asd@asd.com",null,null,10.5,12344));
        ArrayList<String> lista2=new ArrayList<>(100);
        Cursor data= dblite.vistaReserva();

        //final Bdvehiculos dblite2 = new Bdvehiculos(getApplicationContext());



        if(data.getCount()==0){
            Toast.makeText(this, "Esa Base esta vacia!!!!", Toast.LENGTH_LONG).show();
        }else {
            while (data.moveToNext()){
                lista2.add("Numero: "+data.getString(0).concat("\n")+"Email: "+data.getString(1).concat("\n")+"Fec. Préstamo: "+data.getString(2).concat("\n")+"Fec. Entrega: "+data.getString(3).concat("\n")+"Valor: "+data.getString(4).concat("\n")+"Celular: "+data.getString(5).concat("\n"));
                ArrayAdapter<String> adapterM = new ArrayAdapter<>(this, android.R.layout.simple_list_item_activated_1, lista2);
                listaRe.setAdapter(adapterM);}
        }

    }

    public ArrayList<Reserva> loadFromStorage()  {
        SharedPreferences mPrefs = getSharedPreferences("Examen3", Context.MODE_PRIVATE);
        ArrayList<Reserva> items2 = new ArrayList<Reserva>(100);
        Set<String> set = mPrefs.getStringSet("Examen3", null);
        if (set != null) {
            for (String s : set) {
                try {
                    JSONObject jsonObject = new JSONObject(s);
                    Integer numero = jsonObject.getInt("numero");
                    String email = jsonObject.getString("email");
                    String fechas = jsonObject.getString("fecprestamo");
                    Date posi= sdf.parse(fechas);
                    String fechas2 = jsonObject.getString("fecentrega");
                    Date posi2= sdf.parse(fechas2);
                    Double costo = jsonObject.getDouble("costo");
                    String celular = jsonObject.getString("celular");
                    Reserva myclass = new Reserva(numero, email,posi, posi2, costo, celular);

                    items2.add(myclass);

                } catch (JSONException e) {
                    e.printStackTrace();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

        }
        return items2;
    }

    public String guardarArchivo (String dato,String tipoarchivo ){
        File f=null;
        try {
            //File ruta_sd= Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOCUMENTS);
            File ruta_sd = new File(Environment.getExternalStorageDirectory(), "MIS_DATOS_VEHICULOS");
            if (!ruta_sd.exists()) {
                ruta_sd.mkdirs();
            }

            SimpleDateFormat simpleD = new SimpleDateFormat("yyyy-MM-dd_HH:mm");
            String nombre = simpleD.format(new Date());
            f=new File (ruta_sd.getAbsolutePath(),"respaldo_reservas"+nombre+"."+tipoarchivo);
            //Toast.makeText(getBaseContext(),""+ruta_sd,Toast.LENGTH_SHORT).show();
            OutputStreamWriter archivo= new OutputStreamWriter(new FileOutputStream(f));

            archivo.write(dato);
            archivo.flush();
            archivo.close();
        } catch (IOException e){
            Log.e("Ficheros","Error al escribir respaldo_usuarios a tarjeta SD");
        }
        return f.getAbsolutePath();
    }

}
