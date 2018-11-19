package com.example.carloscaiza.ccaiza_ex_1h.ec.edu.uce.controladores;

import com.example.carloscaiza.ccaiza_ex_1h.ec.edu.uce.modelo.Vehiculo;

import java.util.ArrayList;
import java.util.Date;

public class Busqueda {

   // public static int buscarEnArray(ArrayList<Vehiculo> arrayDondeBuscar, Date nombreParametroBusqueda){

     //   int ubicacionEnArray = arrayDondeBuscar.indexOf(new Vehiculo(null,null,nombreParametroBusqueda,0.0,null,null));

        public static int buscarEnArray(ArrayList<Vehiculo> arrayDondeBuscar, String nombreParametroBusqueda){

            int ubicacionEnArray = arrayDondeBuscar.indexOf(new Vehiculo(nombreParametroBusqueda,null,null,0.0,null,null));

            return ubicacionEnArray;
    }


}
