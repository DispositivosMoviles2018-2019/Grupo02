package com.example.andres.final_2h_g02.ec.edu.uce.vista;

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

import com.example.andres.final_2h_g02.MainActivity;
import com.example.andres.final_2h_g02.R;
import com.example.andres.final_2h_g02.ec.edu.uce.modelo.Bdvehiculos;
import com.example.andres.final_2h_g02.ec.edu.uce.modelo.Vehiculo;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class listado extends AppCompatActivity {
    ListView listaV;
    //TextView carros;
    Vehiculo vehiculo= new Vehiculo();
    ArrayList<Vehiculo> items = new ArrayList<Vehiculo>(100);
    String arch="";
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    String fecha1="2015-11-13";
    String fecha2="1998-03-05";
    Date f1=sdf.parse(fecha1);
    Date f2=sdf.parse(fecha2);
    public listado() throws ParseException {
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {

        if(item.getItemId()== R.id.item1) {
            Intent intent = new Intent(listado.this, editar.class);
            startActivity(intent);
        }else if(item.getItemId()==R.id.item2) {
            Intent intent = new Intent(listado.this, busqueda.class);
            startActivity(intent);
        }else if(item.getItemId()==R.id.item6) {
            Intent intent = new Intent(listado.this, Opciones.class);
            startActivity(intent);
        }else if (item.getItemId() == R.id.item3){
            finish();
            Intent intent = new Intent(listado.this, MainActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intent);
        } else if(item.getItemId()== R.id.item4)
        {
            finish();
            Intent intent = new Intent(Intent.ACTION_MAIN);
            intent.addCategory(Intent.CATEGORY_HOME);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
        }else if (item.getItemId() == R.id.item5){
            items=loadFromStorage();
            SharedPreferences.Editor editor = getSharedPreferences("Examen", MODE_PRIVATE).edit();
            Set<String> set = new HashSet<String>();
            for (int i = 0; i < items.size(); i++) {
                set.add(items.get(i).getJSONObject().toString());
            }

            editor.putStringSet("Examen", set);
            editor.commit();

            arch = guardarArchivo(set.toString(),"json");
            Toast.makeText(this, "Se creo respaldo de vehiculos!!!!", Toast.LENGTH_LONG).show();
            /*
            items=loadFromStorage();
            Collections.sort(items,new Vehiculo.MyComparator());

            ArrayAdapter<Vehiculo> adapterM = new ArrayAdapter<Vehiculo>(this, android.R.layout.simple_expandable_list_item_1, items );
            listaV.setAdapter(adapterM);
          //  carros.setText(items.toString());
  */
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listado);
        final Bdvehiculos dblite = new Bdvehiculos(getApplicationContext());
       // final Bdusuario dblite2 = new Bdusuario(getApplicationContext());
        items=loadFromStorage();
        //if(items.isEmpty()) {
           // items.add(new Vehiculo("XTR-9784", "Audi",f1,79990.0, TRUE, "Negro",FALSE,"Automovil"));
            //items.add(new Vehiculo("CCD-0789", "Honda",f2,15340.0, FALSE, "Blanco",TRUE,"Camioneta"));
        //}

       // carros=(TextView) findViewById(R.id.txtcarros);
        listaV = (ListView) findViewById(R.id.listado);
        Collections.sort(items,new Vehiculo.MyComparator());
        SharedPreferences.Editor editor = getSharedPreferences("Examen", MODE_PRIVATE).edit();

        Set<String> set = new HashSet<String>();
        for (int i = 0; i < items.size(); i++) {
            set.add(items.get(i).getJSONObject().toString());
        }

        editor.putStringSet("Examen", set);
        editor.commit();

        ArrayList<String> lista=new ArrayList<>(100);
        Cursor data= dblite.vista();
        Vehiculo vh= new Vehiculo();
        SimpleDateFormat formateador = new SimpleDateFormat("yyyy-MM-dd");
        if(data.getCount()==0){
            Toast.makeText(this, "Esa Base esta vacia!!!!", Toast.LENGTH_LONG).show();
        }else {
            while (data.moveToNext()){
                lista.add(data.getString(0)+"  "+data.getString(1)+"  "+data.getString(2)+"  "+data.getString(3)+"  "+data.getString(4)+"  "+data.getString(5)+"  "+data.getString(6)+"  "+data.getString(7));

                ArrayAdapter<String> adapterM = new ArrayAdapter<>(this, android.R.layout.simple_expandable_list_item_1, lista);
            listaV.setAdapter(adapterM);}
        }
        //carros.setText(set.toString());
    }

    public ArrayList<Vehiculo> loadFromStorage()  {
        SharedPreferences mPrefs = getSharedPreferences("Examen", Context.MODE_PRIVATE);
        ArrayList<Vehiculo> items2 = new ArrayList<Vehiculo>(100);
        Set<String> set = mPrefs.getStringSet("Examen", null);
        if (set != null) {
            for (String s : set) {
                try {
                    JSONObject jsonObject = new JSONObject(s);
                    String placa = jsonObject.getString("placa");
                    String marca = jsonObject.getString("marca");
                    String fechas = jsonObject.getString("fecfabricacion");
                    Date posi= sdf.parse(fechas);
                    Double costo = jsonObject.getDouble("costo");
                    Boolean matriculado = jsonObject.getBoolean("matriculado");
                    String color = jsonObject.getString("color");
                    Boolean estado = jsonObject.getBoolean("estado");
                    String tipo = jsonObject.getString("tipo");
                    Vehiculo myclass = new Vehiculo(placa, marca,posi, costo, matriculado, color,estado,tipo);

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
            f=new File (ruta_sd.getAbsolutePath(),"respaldo_vehiculos"+nombre+"."+tipoarchivo);
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
