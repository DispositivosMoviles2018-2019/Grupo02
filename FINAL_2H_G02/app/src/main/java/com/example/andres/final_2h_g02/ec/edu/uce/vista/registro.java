package com.example.andres.final_2h_g02.ec.edu.uce.vista;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.andres.final_2h_g02.MainActivity;
import com.example.andres.final_2h_g02.R;
import com.example.andres.final_2h_g02.ec.edu.uce.modelo.Bdvehiculos;
import com.example.andres.final_2h_g02.ec.edu.uce.modelo.Usuario;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class registro extends AppCompatActivity {


    private EditText usuario;
    private EditText contraseña;
    private Button regist;
    //private final String ARCHIVO = "data.txt";
    Usuario usuarios= new Usuario();
    ArrayList<Usuario> items = new ArrayList<Usuario>(100);
    List<Usuario> lista = new ArrayList<>();
    //File dataFile = new File(Environment.getExternalStorageDirectory(), ARCHIVO);
    //final Bdusuario dblite = new Bdusuario(getApplicationContext());

    String arch="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);
        usuario = (EditText) findViewById(R.id.txtusuario);
        contraseña = (EditText) findViewById(R.id.txtcontraseña);
        regist = (Button) findViewById(R.id.btnregistro);
        items=loadFromStorage();
       final Bdvehiculos dblite = new Bdvehiculos(getApplicationContext());
        regist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                items.add(new Usuario(usuario.getText().toString(), contraseña.getText().toString()));
                //registrar();

                SharedPreferences.Editor editor = getSharedPreferences("Examen2", MODE_PRIVATE).edit();

                Set<String> set = new HashSet<String>();
                for (int i = 0; i < items.size(); i++) {
                    set.add(items.get(i).getJSONObject().toString());
                }

                editor.putStringSet("Examen2", set);
                editor.commit();

                arch = guardarArchivo(set.toString(),"json");

                dblite.ingresarUs(new Usuario(usuario.getText().toString(),contraseña.getText().toString()));
                Toast.makeText(getApplicationContext(),"Se insertó el registro correctamente", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(registro.this, MainActivity.class);
                startActivity(intent);
            }
        });

    }



    public ArrayList<Usuario> loadFromStorage()  {
        SharedPreferences mPrefs = getSharedPreferences("Examen2", Context.MODE_PRIVATE);
        ArrayList<Usuario> items2 = new ArrayList<Usuario>(100);
        Set<String> set = mPrefs.getStringSet("Examen2", null);
        if (set != null) {
            for (String s : set) {
                try {
                    JSONObject jsonObject = new JSONObject(s);
                    String usuario = jsonObject.getString("usuario");
                    String contraseña = jsonObject.getString("contraseña");

                    Usuario myclass = new Usuario(usuario, contraseña);

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
            f=new File (ruta_sd.getAbsolutePath(),"respaldo_usuarios"+nombre+"."+tipoarchivo);
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
