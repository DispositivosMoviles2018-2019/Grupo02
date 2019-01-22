package com.example.andres.ex2h_g02.ec.edu.uce.vista;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.andres.ex2h_g02.R;
import com.example.andres.ex2h_g02.ec.edu.uce.modelo.Bdvehiculos;
import com.example.andres.ex2h_g02.ec.edu.uce.modelo.Reserva;
import com.example.andres.ex2h_g02.ec.edu.uce.modelo.Vehiculo;

import org.json.JSONException;
import org.json.JSONObject;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.lang.Boolean.TRUE;

public class Reservaciones extends AppCompatActivity {

    EditText Email, Costo, Celular,Comprobacion;
    private Spinner dia;
    private Spinner mes;
    private Spinner ano;
    private Date fechaAux;
    Date fecha;
    String valido;
    RadioButton Automovil, Camioneta, Furgoneta;
    RadioGroup Tipo;
    Double ntipo;
    Double total;
    Date fechaactual;
    int Copia=0;
    Integer generado=0;
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

    ArrayList<Reserva> items= new ArrayList<>(100);
    public Reservaciones() throws ParseException {
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menuingresoreservas, menu);
        return true;
    }


    public boolean onOptionsItemSelected(MenuItem item) {
        final Bdvehiculos dblite = new Bdvehiculos(getApplicationContext());
        //final Bdvehiculos dblite2 = new Bdvehiculos(getApplicationContext());
        Vehiculo vehiculos= new Vehiculo();

        if(item.getItemId()==R.id.item4) {





            dblite.buscarVh(vehiculos,Comprobacion.getText().toString());
            String seleccion2=vehiculos.getEstado().toString();
            if(seleccion2.equals("true")){
                String seleccion4=vehiculos.getTipo();

                if(seleccion4.equals("Automovil") ){
                    Automovil.setChecked(TRUE);
                }else if(seleccion4.equals("Camioneta")){
                    Camioneta.setChecked(TRUE);
                }else if(seleccion4.equals("Furgoneta")){
                    Furgoneta.setChecked(TRUE);
                }
            }else {
                Toast.makeText(getApplicationContext(),"El vehiculo no esta disponible....", Toast.LENGTH_SHORT).show();
            }
        }else if(item.getItemId()== R.id.item1) {
            dblite.buscarVh(vehiculos,Comprobacion.getText().toString());
            String seleccion2=vehiculos.getEstado().toString();
            if(seleccion2.equals("true")) {
                Reserva res = new Reserva();
                if (ano.getSelectedItem().toString().equals("1950") == true && mes.getSelectedItem().toString().equals("1") && dia.getSelectedItem().toString().equals("1")) {
                    res.setFecEntrega(fechaAux);
                } else {
                    Calendar fechaAux = Calendar.getInstance();
                    fechaAux.set(Integer.parseInt(ano.getSelectedItem().toString()),
                            Integer.parseInt(mes.getSelectedItem().toString()) - 1,
                            Integer.parseInt(dia.getSelectedItem().toString()));
                    fecha = new Date();
                    fecha.setTime(fechaAux.getTimeInMillis());
                }
                fechaactual = new Date();
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                // String numero1= dateFormat.format(fechaactual);
                //String numero2= dateFormat.format(fecha);
                int dias = (int) ((fecha.getTime() - fechaactual.getTime()) / 86400000);
                int opcion2 = Tipo.getCheckedRadioButtonId();
                if (opcion2 == Automovil.getId()) {
                    ntipo = 60.0;
                } else if (opcion2 == Camioneta.getId()) {
                    ntipo = 75.0;
                } else if (opcion2 == Furgoneta.getId()) {
                    ntipo = 100.0;
                }

                if(dias<=7){
                total = (ntipo) * dias;}
                else{
                    total = ((ntipo) * dias)*1.10;
                }

                String validemail = "[a-zA-Z0-9\\+\\.\\_\\%\\-\\+]{1,256}" +
                        "\\@" +
                        "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,64}" +
                        "(" +
                        "\\." +
                        "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,25}" +
                        ")+";
                String correo = Email.getText().toString();
                Matcher matcher = Pattern.compile(validemail).matcher(correo);

                String validecell = "[09]{2}"+"[a-zA-Z0-9]{8}";
                String celu = Celular.getText().toString();
                Matcher matcher2 = Pattern.compile(validecell).matcher(celu);

                if (matcher.matches()  ) {

                    if(matcher2.matches()){

                        int numMinimo = 1000; // declaramos el numero minimo
                        int numMaximo = 9999; // declaramos el numero maximo
                        int n = 1; // declaramos la cantidad de resultados
                        int[] resultado = new int[n]; // creamos el arreglo de resultado
                        for(int i = 0; i < n; i++){ // llenamos resultado de los numeros al azar de arreglo
                            int rnd = (int)Math.floor(Math.random()*(numMinimo-(numMaximo+1))+(numMaximo));
                            resultado[i]=rnd;
                        }/* llenamos la lista de numeros al azar pero en esta solucion
   pueden haber muchas coincidencias. */
                        for(int i1 = 0; i1 < n; i1++){ // creamos la primera variable para la comprobacion
                            for(int i2 = 0; i2 < n; i2++){//creamos la segunda que hara la comprobacion
                                if(resultado[i1]==resultado[i2]&&i1!=i2){
                                    int rnd = (int)Math.floor(Math.random()*(numMinimo-(numMaximo+1))+(numMaximo));
                                    resultado[i1]=rnd;
                                    i1=0; }/* este if comprobara si hay coincidencias en el arreglo
    y de conseguirlas, la cambia y vuelve a hacer la comprobacion */
                            }// fin del for de la segunda comprobacion
                        }// fin del for de la segunda comprobacion

                        for(int i = 0; i < n; i++){
                           generado=resultado[i];
                        }

                dblite.ingresarReserva(new Reserva(generado, Email.getText().toString(), fechaactual, fecha, total, Celular.getText().toString()));

                items.add(new Reserva(generado, Email.getText().toString(), fechaactual, fecha, total, Celular.getText().toString()));

                try {
                    //items.add(new Vehiculo(Placa.getText().toString(), Marca.getText().toString(), fecha, Double.parseDouble(Costo.getText().toString()), estado, ncolor));

                    SharedPreferences sharpref = getSharedPreferences("Examen3", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharpref.edit();
                    Set<String> set = new HashSet<String>();
                    for (int i = 0; i < items.size(); i++) {
                        set.add(items.get(i).getJSONObject().toString());
                    }
                    editor.putStringSet("Examen3", set);
                    editor.commit();
                    finish();
                    Intent intent = new Intent(Reservaciones.this, Reservas.class);
                    startActivity(intent);

                } catch (Exception e) {
                    e.printStackTrace();
                }
                    }else{
                        Toast.makeText(getApplicationContext(), "Celular Invalido", Toast.LENGTH_LONG).show();
                    }
                } else {
                    Toast.makeText(getApplicationContext(), "Correo Invalido", Toast.LENGTH_LONG).show();
                }




            }else {
                Toast.makeText(getApplicationContext(),"El vehiculo no esta disponible....", Toast.LENGTH_SHORT).show();
            }
             }else if(item.getItemId()==R.id.item2) {
            Intent intent = new Intent(Reservaciones.this, Reservas.class);
            startActivity(intent);
        }else if(item.getItemId()==R.id.item3) {
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
        setContentView(R.layout.activity_reservaciones);
        items=loadFromStorage();
        Comprobacion=(EditText)findViewById(R.id.comprobar2);
        Email=(EditText)findViewById(R.id.email);
        //Costo=(EditText)findViewById(R.id.costo);
        Celular=(EditText)findViewById(R.id.celular);
        dia = (Spinner) findViewById(R.id.spinner_dia);
        mes = (Spinner) findViewById(R.id.spinner_mes);
        ano = (Spinner) findViewById(R.id.spinner_ano);
        Automovil = (RadioButton) findViewById(R.id.rdautomovil3);
        Camioneta = (RadioButton) findViewById(R.id.rdcamioneta3);
        Furgoneta = (RadioButton) findViewById(R.id.rdfurgoneta3);
        Tipo = (RadioGroup) findViewById(R.id.rdtipo3);
        cargarFechas();
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
