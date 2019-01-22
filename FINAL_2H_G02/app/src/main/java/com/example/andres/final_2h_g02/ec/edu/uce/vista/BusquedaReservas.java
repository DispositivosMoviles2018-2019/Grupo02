package com.example.andres.final_2h_g02.ec.edu.uce.vista;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Environment;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.andres.final_2h_g02.MainActivity;
import com.example.andres.final_2h_g02.R;
import com.example.andres.final_2h_g02.ec.edu.uce.modelo.Bdvehiculos;
import com.example.andres.final_2h_g02.ec.edu.uce.modelo.Reserva;
import com.example.andres.final_2h_g02.ec.edu.uce.modelo.Vehiculo;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.HeaderFooter;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Phrase;
import com.lowagie.text.pdf.PdfWriter;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import harmony.java.awt.Color;

public class BusquedaReservas extends AppCompatActivity {
Vehiculo vehiculos= new Vehiculo();
Reserva reservas= new Reserva();
    String busqueda1;
    ArrayList<Reserva> estado1 = new ArrayList<>(100);
    private final static String NOMBRE_DIRECTORIO = "MiPdf";
    private final static String NOMBRE_DOCUMENTO = "prueba.pdf";
    private final static String ETIQUETA_ERROR = "ERROR";
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
       // Reserva reservas = new Reserva();
        if(item.getItemId()== R.id.item1) {


           // busqueda1=buscar.getText().toString();


            try {
                if(dblite.buscarReserva(reservas,buscar.getText().toString())==1){

            if(dblite.buscarVh(vehiculos,buscar.getText().toString())==1)
            Numero.setFocusable(false);
            Numero.setText(reservas.getNumero().toString());
            Email.setFocusable(false);
            Email.setText(reservas.getEmail());
            Costo.setFocusable(false);
            Costo.setText(reservas.getValor().toString());
            Celular.setFocusable(false);
            Celular.setText(reservas.getCelular());
            Fechaentrega.setText(reservas.getPlacavh());

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
                }else{
                    Toast.makeText(getApplicationContext(), "Vehiculo no existe", Toast.LENGTH_LONG).show();
                }
            } catch (ParseException e) {
                e.printStackTrace();
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
        }else if(item.getItemId()==R.id.item4) {

            generarPdf();
            Toast.makeText(BusquedaReservas.this, "Se creo tu archivo pdf", Toast.LENGTH_SHORT).show();


        }


        return super.onOptionsItemSelected(item);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_busqueda_reservas);

        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE,}, 1000);
        } else {
        }

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

    public void generarPdf() {

        // Creamos el documento.
        Document documento = new Document();

        try {

            File f = crearFichero(NOMBRE_DOCUMENTO);

            // Creamos el flujo de datos de salida para el fichero donde
            // guardaremos el pdf.
            FileOutputStream ficheroPdf = new FileOutputStream(
                    f.getAbsolutePath());

            // Asociamos el flujo que acabamos de crear al documento.
            PdfWriter writer = PdfWriter.getInstance(documento, ficheroPdf);

            // Incluimos el pie de pagina y una cabecera
            HeaderFooter cabecera = new HeaderFooter(new Phrase(
                    "Universidad Central del Ecuador"), false);
            HeaderFooter pie = new HeaderFooter(new Phrase(
                    "Optativa 3"), false);

            documento.setHeader(cabecera);
            documento.setFooter(pie);

            // Abrimos el documento.
            documento.open();

            // Añadimos un titulo con la fuente por defecto.
            documento.add(new Paragraph("Optativa Grupo 2"));

            Font font = FontFactory.getFont(FontFactory.HELVETICA, 28,
                    Font.BOLD, Color.RED);
            documento.add(new Paragraph("Auto Reservado", font));

            // Insertamos una imagen que se encuentra en los recursos de la
            // aplicacion.
            /*
            Bitmap bitmap = BitmapFactory.decodeResource(this.getResources(),
                    R.drawable.logo);
            ByteArrayOutputStream stream = new ByteArrayOutputStream();
            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, stream);
            Image imagen = Image.getInstance(stream.toByteArray());
            documento.add(imagen);
*/
            // Insertamos una tabla.
            /*
            PdfPTable tabla = new PdfPTable(1);

                tabla.addCell("Numero " + reservas.getNumero());
            tabla.addCell("Costo " + reservas.getValor());
            documento.add(tabla);
            */
            Font font2 = FontFactory.getFont(FontFactory.HELVETICA, 20,
                    Font.BOLD, Color.black);
            documento.add(new Paragraph("Placa: " + reservas.getPlacavh(), font2));
            documento.add(new Paragraph("Numero: " + reservas.getNumero(), font2));
            documento.add(new Paragraph("Costo: " + reservas.getValor(), font2));
            documento.add(new Paragraph("Email: " + reservas.getEmail(), font2));
            documento.add(new Paragraph("Celular: " + reservas.getCelular(), font2));
            //documento.add(new Paragraph("Fecha de Prestamo: " + reservas.getFecPrestamo(), font2));
        } catch (DocumentException e) {

            Log.e(ETIQUETA_ERROR, e.getMessage());

        } catch (IOException e) {

            Log.e(ETIQUETA_ERROR, e.getMessage());

        } finally {
            // Cerramos el documento.
            documento.close();
        }
    }

    public static File crearFichero(String nombreFichero) throws IOException {
        File ruta = getRuta();
        File fichero = null;
        if (ruta != null)
            fichero = new File(ruta, nombreFichero);
        return fichero;
    }

    public static File getRuta() {

        // El fichero sera almacenado en un directorio dentro del directorio
        // Descargas
        File ruta = null;
        if (Environment.MEDIA_MOUNTED.equals(Environment
                .getExternalStorageState())) {
            ruta = new File(
                    Environment
                            .getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS),
                    NOMBRE_DIRECTORIO);

            if (ruta != null) {
                if (!ruta.mkdirs()) {
                    if (!ruta.exists()) {
                        return null;
                    }
                }
            }
        } else {
        }

        return ruta;
    }

}
