package com.example.andres.final_2h_g02.ec.edu.uce.modelo;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.text.ParseException;

public class Bdvehiculos extends SQLiteOpenHelper implements InterfazCRUD{

    private static final String NOMBRE_BD = "bdvh0.bd";
    private static final int VERSION_BD = 1;
    //VARIABLE PARA EL SCRIPT QUE NOS PERMITIRA CREAR LA TABLA DE NUESTRA BD
   // private static final String TABLA_CURSOS = "CREATE TABLE USUARIOS(USUARIO TEXT PRIMARY KEY, CONTRASEÑA TEXT)";
    private static final String TABLA_VEHICULOS = "CREATE TABLE VEHICULOS(PLACA TEXT PRIMARY KEY, MARCA TEXT, FECFABRICACION TEXT, COSTO TEXT, MATRICULADO TEXT, COLOR TEXT, ESTADO TEXT, TIPO TEXT)";
    private static final String TABLA_CURSOS = "CREATE TABLE USUARIOS(USUARIO TEXT PRIMARY KEY, CONTRASEÑA TEXT)";
    private static final String TABLA_RESERVAS = "CREATE TABLE RESERVAS(NUMERO TEXT PRIMARY KEY, EMAIL TEXT, CELULAR TEXT, FECPRESTAMO TEXT, FECENTREGA TEXT, VALOR TEXT,PLACA TEXT)";


    public Bdvehiculos(Context context) {
        super(context, NOMBRE_BD, null, VERSION_BD);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        //Ejecutar las sentencias SQL
        db.execSQL(TABLA_VEHICULOS);
        db.execSQL(TABLA_RESERVAS);
        db.execSQL(TABLA_CURSOS);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS" +TABLA_VEHICULOS);
         db.execSQL(TABLA_VEHICULOS);
        db.execSQL("DROP TABLE IF EXISTS" +TABLA_CURSOS);
        //db.execSQL("DROP TABLE IF EXISTS" +TABLA_VEHICULOS);
        db.execSQL(TABLA_CURSOS);
        db.execSQL("DROP TABLE IF EXISTS" +TABLA_RESERVAS);
        //db.execSQL("DROP TABLE IF EXISTS" +TABLA_VEHICULOS);
        db.execSQL(TABLA_RESERVAS);
    }

    public void ingresarVehiculo(Vehiculo vh){
        //Instanciar un objeto de tipo SQLiteDtabase y luego llamamos al metod getWritableDatabase que nos permitirá trabajar en modo lectura y escitura
        SQLiteDatabase db = getWritableDatabase();
        if (db != null){
            db.execSQL("INSERT INTO VEHICULOS VALUES('"+vh.getPlaca()+"','"+vh.getMarca()+"','"+vh.getFecFabricacion()+"','"+vh.getCosto()+"','"+vh.getMatriculado()+"','"+vh.getColor()+"','"+vh.getEstado()+"','"+vh.getTipo()+"')");
            db.close();
        }
    }



    public  Cursor vista(){
        //Instanciar un objeto de tipo SQLiteDtabase y luego llamamos al metod getWritableDatabase que nos permitirá trabajar en modo lectura y escitura

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM VEHICULOS", null);
        //  ArrayList<Usuario> vehiculos = new ArrayList<>();
        return cursor;
    }

    public int buscarVh(Vehiculo vehiculos, String codigo){
        //Modo de lectura
        try {
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM VEHICULOS WHERE PLACA='"+codigo+"'",null);

            int i = 0;
            cursor.moveToFirst();
            i = cursor.getCount();


        if (cursor.moveToFirst()){
            do{
                vehiculos.setPlaca(cursor.getString(0));
                vehiculos.setMarca(cursor.getString(1));
                //vehiculos.setFecFabricacion(d);
                vehiculos.setCosto(cursor.getDouble(3));
                vehiculos.setMatriculado(Boolean.parseBoolean(cursor.getString(4)));
                vehiculos.setColor(cursor.getString(5));
                vehiculos.setEstado(Boolean.parseBoolean(cursor.getString(6)));
                vehiculos.setTipo(cursor.getString(7));
            }while (cursor.moveToNext());
            cursor.close();
            return i;
        }
        }catch(Exception e)
        {
            e.printStackTrace();
        }return 0;
    }

    public void editarVh(String codigo, Vehiculo vh){
        //Instanciar un objeto de tipo SQLiteDtabase y luego llamamos al metod getWritableDatabase que nos permitirá trabajar en modo lectura y escitura
        SQLiteDatabase db = getWritableDatabase();
        if (db != null){
            db.execSQL("UPDATE VEHICULOS SET PLACA='"+vh.getPlaca()+"',MARCA='"+vh.getMarca()+"',FECFABRICACION='"+vh.getFecFabricacion()+"',COSTO='"+vh.getCosto()+"',MATRICULADO='"+vh.getMatriculado()+"',COLOR='"+vh.getColor()+"',ESTADO='"+vh.getEstado()+"',TIPO='"+vh.getTipo()+"' WHERE PLACA='"+codigo+"'");
            db.close();
        }
    }

    public void eliminarVH(String codigo){
        //Instanciar un objeto de tipo SQLiteDtabase y luego llamamos al metod getWritableDatabase que nos permitirá trabajar en modo lectura y escitura
        SQLiteDatabase db = getWritableDatabase();
        if (db != null){
            db.execSQL("DELETE FROM VEHICULOS WHERE PLACA='"+codigo+"'");
            db.close();
        }
    }

    //////////////////////////////////////////////////////////////////////////////////////////////////////////////

    public void ingresarUs(Usuario us){
        //Instanciar un objeto de tipo SQLiteDtabase y luego llamamos al metod getWritableDatabase que nos permitirá trabajar en modo lectura y escitura
        SQLiteDatabase db = getWritableDatabase();
        if (db != null){
            db.execSQL("INSERT INTO USUARIOS VALUES('"+us.getUsuario()+"','"+us.getClave()+"')");
            db.close();
        }
    }

    public int validarUs(Usuario us){
        //Instanciar un objeto de tipo SQLiteDtabase y luego llamamos al metod getWritableDatabase que nos permitirá trabajar en modo lectura y escitura
        try {
            int i = 0;
            SQLiteDatabase db = getReadableDatabase();
            Cursor cursor = db.rawQuery("SELECT * FROM USUARIOS WHERE USUARIO='" + us.getUsuario() + "'" + "AND CONTRASEÑA='" + us.getClave() + "'", null);
            cursor.moveToFirst();
            i = cursor.getCount();
            cursor.close();
            return i;
        }catch(Exception e)
        {
            e.printStackTrace();
        }
        return 0;
    }

    public  Cursor vistaUs(){
        //Instanciar un objeto de tipo SQLiteDtabase y luego llamamos al metod getWritableDatabase que nos permitirá trabajar en modo lectura y escitura

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM USUARIOS", null);
        //  ArrayList<Usuario> vehiculos = new ArrayList<>();



        return cursor;
    }
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    public void ingresarReserva(Reserva re){
        //Instanciar un objeto de tipo SQLiteDtabase y luego llamamos al metod getWritableDatabase que nos permitirá trabajar en modo lectura y escitura
        SQLiteDatabase db = getWritableDatabase();
        if (db != null){
            db.execSQL("INSERT INTO RESERVAS VALUES('"+re.getNumero()+"','"+re.getEmail()+"','"+re.getFecPrestamo()+"','"+re.getFecEntrega()+"','"+re.getValor()+"','"+re.getCelular()+"','"+re.getPlacavh()+"')");
            db.close();
        }
    }

    public Cursor fechaactual(){
        //Instanciar un objeto de tipo SQLiteDtabase y luego llamamos al metod getWritableDatabase que nos permitirá trabajar en modo lectura y escitura

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("SELECT date('now');", null);

        return cursor;
    }

    public Cursor vistaReserva(){
        //Instanciar un objeto de tipo SQLiteDtabase y luego llamamos al metod getWritableDatabase que nos permitirá trabajar en modo lectura y escitura

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM RESERVAS", null);

        return cursor;
    }

    public int buscarReserva(Reserva reservas, String codigo) throws ParseException {
        //Modo de lectura
        try {
       // SimpleDateFormat simpleDate = new SimpleDateFormat("yyyy-MM-dd");
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM RESERVAS WHERE NUMERO='"+codigo+"'",null);
            int i = 0;
            cursor.moveToFirst();
            i = cursor.getCount();
        if (cursor.moveToFirst()){
            do{
                reservas.setNumero(Integer.parseInt(cursor.getString(0)));
                reservas.setEmail(cursor.getString(1));
                //reservas.setCelular(cursor.getString(2));
                //vehiculos.setFecFabricacion(d);
                //fecReserva = simpleDate.parse(mCursor.getString(3));
                //reservas.setFecEntrega(simpleDate.parse(cursor.getString(3)));
                reservas.setValor(Double.parseDouble(cursor.getString(4)));
                reservas.setCelular(cursor.getString(5));
                reservas.setPlacavh(cursor.getString(6));

            }while (cursor.moveToNext());
            cursor.close();
            return i;
        }
        }catch(Exception e)
        {
            e.printStackTrace();
        }return 0;
    }
}
