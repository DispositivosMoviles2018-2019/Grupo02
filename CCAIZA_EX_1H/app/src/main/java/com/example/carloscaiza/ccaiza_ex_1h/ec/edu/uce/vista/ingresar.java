package com.example.carloscaiza.ccaiza_ex_1h.ec.edu.uce.vista;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.Toast;

import com.example.carloscaiza.ccaiza_ex_1h.R;
import com.example.carloscaiza.ccaiza_ex_1h.ec.edu.uce.modelo.Vehiculo;

import org.json.JSONException;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ingresar extends AppCompatActivity {

EditText Marca, Placa, Costo;
Switch Matriculado;
RadioButton Blanco, Negro, Azul, Otro;
RadioGroup color;
String ncolor;
Boolean estado;
private Spinner dia;
private Spinner mes;
private Spinner ano;
private Spinner colora;
private Date fechaAux;
Date fecha;
    String valido;
    int Copia=0;

    //SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MMMM-dd");

    ArrayList<Vehiculo> items= new ArrayList<>(100);

    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menuingreso, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {

        if(item.getItemId()== R.id.item1) {
            try {
                String valideplaca = "[A-Z]{3}" +
                        "\\-" +
                        "[0-9]{4}";
                String placa = Placa.getText().toString();
                Matcher matcher = Pattern.compile(valideplaca).matcher(placa);

                String validecosto = "[0-9]{1,5}"+"\\."+"[0-9]{1}";
                //String validecosto = "[0-9]{1,4}";
                String costo = Costo.getText().toString();
                Matcher matcher2 = Pattern.compile(validecosto).matcher(costo);

                if (Placa.getText().toString().isEmpty())
                //EditText contiene algún caracter!
                {
                    Toast.makeText(this, "Campo Placa Vacio", Toast.LENGTH_LONG).show();
                } else {
                    for (int i = 0; i < items.size(); i++) {
                        valido = items.get(i).getPlaca();
                        if (valido.equals(Placa.getText().toString())) {
                            Copia = 0;
                            break;
                        } else {
                            Copia = 1;
                        }
                    }
                    if (Copia == 0) {
                        Toast.makeText(this, "Esa Placa ya existe!!!!", Toast.LENGTH_LONG).show();
                    } else {
                        if (Marca.getText().toString().isEmpty())
                        //EditText contiene algún caracter!
                        {
                            Toast.makeText(this, "Campo Marca Vacio", Toast.LENGTH_LONG).show();
                        } else {
                            if (Costo.getText().toString().isEmpty())
                            {
                                Toast.makeText(this, "Campo Costo Vacio", Toast.LENGTH_LONG).show();
                            } else {
//                                if (colora.gett .getCheckedRadioButtonId() == -1) {
//                                    Toast.makeText(this, "Campo Color Vacio", Toast.LENGTH_LONG).show();
//                                } else {
                                    if (matcher.matches()) {
                                        if (matcher2.matches()) {
                                            Vehiculo vehiculo = new Vehiculo();
                                           /* int opcion = color.getCheckedRadioButtonId();
                                            if (opcion == Blanco.getId()) {
                                                ncolor = "Blanco";
                                            } else if (opcion == Negro.getId()) {
                                                ncolor = "Negro";
                                            } else if (opcion == Azul.getId()) {
                                                ncolor = "Azul";
                                            } else if (opcion == Otro.getId()) {
                                                ncolor = "Otro";
                                            }*/
                                            String colorA = colora.getSelectedItem().toString();
                                            Boolean estado;
                                            if (Matriculado.isChecked()) {
                                                estado = true;
                                            } else {
                                                estado = false;
                                            }
                                            if (ano.getSelectedItem().toString().equals("1950") == true && mes.getSelectedItem().toString().equals("1") && dia.getSelectedItem().toString().equals("1")) {
                                                vehiculo.setFecFabricacion(fechaAux);
                                            } else {
                                                Calendar fechaAux = Calendar.getInstance();
                                                fechaAux.set(Integer.parseInt(ano.getSelectedItem().toString()),
                                                        Integer.parseInt(mes.getSelectedItem().toString()) - 1,
                                                        Integer.parseInt(dia.getSelectedItem().toString()));
                                                fecha = new Date();
                                                fecha.setTime(fechaAux.getTimeInMillis());
                                            }
                                            items.add(new Vehiculo(Placa.getText().toString(), Marca.getText().toString(), fecha, Double.parseDouble(Costo.getText().toString()), estado, colorA));
                                            SharedPreferences sharpref = getSharedPreferences("Examen", Context.MODE_PRIVATE);
                                            SharedPreferences.Editor editor = sharpref.edit();
                                            Set<String> set = new HashSet<String>();
                                            for (int i = 0; i < items.size(); i++) {
                                                set.add(items.get(i).getJSONObject().toString());
                                            }
                                            editor.putStringSet("Examen", set);
                                            editor.commit();

                                            Intent intent = new Intent(ingresar.this, listado.class);
                                            startActivity(intent);

                                        } else {
                                            Toast.makeText(getApplicationContext(), "Costo mal ingresado (xxxxx.x)", Toast.LENGTH_LONG).show();
                                        }
                                    } else {
                                        Toast.makeText(getApplicationContext(), "Formato Incorrecto (ABC-1234)", Toast.LENGTH_LONG).show();
                                    }

                            }
                        }
                    }
                }
            }catch (Exception e){
                e.printStackTrace();
            }

        }else if(item.getItemId()==R.id.item2) {

                Intent intent = new Intent(ingresar.this, listado.class);
                startActivity(intent);

        }else if (item.getItemId() == R.id.item3){

            finish();
            Intent intent = new Intent(Intent.ACTION_MAIN);
            intent.addCategory(Intent.CATEGORY_HOME);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ingresar);

        items = loadFromStorage();
        Placa = findViewById(R.id.txtPlaca);
        Marca = findViewById(R.id.txtMarca);
        Costo = findViewById(R.id.txtCosto);
        /*Blanco = findViewById(R.id.rdblanco);
        Negro = findViewById(R.id.rdnegro);
        Azul = findViewById(R.id.rdazul);
        Otro = findViewById(R.id.rdotro);*/
        Matriculado = (Switch) findViewById(R.id.swmatricula);
        color = (RadioGroup) findViewById(R.id.rdcolor);
        dia = findViewById(R.id.spinner_dia);
        mes = findViewById(R.id.spinner_mes);
        ano = (Spinner) findViewById(R.id.spinner_ano);
        colora = findViewById(R.id.spinner_color);
        cargarFechas();

        String[] opciones = {"Rojo", "Plomo", "Azul", "Otro"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, opciones);
        colora.setAdapter(adapter);

    }



    public void cargarFechas() {
        String[] opcionesDia = new String[31];
        String[] opcionesMes = new String[12];
        String[] opcionesAno = new String[69];
        for (int i = 1; i <= 31; i++) {
            opcionesDia[i - 1] = String.valueOf(i);
        }
        for (int i = 1; i <= 12; i++) {
            opcionesMes[i - 1] = String.valueOf(i);
        }
        for (int i = 1950; i <= 2018; i++) {
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
                    Vehiculo myclass = new Vehiculo(placa, marca,posi, costo, matriculado, color);

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
}
