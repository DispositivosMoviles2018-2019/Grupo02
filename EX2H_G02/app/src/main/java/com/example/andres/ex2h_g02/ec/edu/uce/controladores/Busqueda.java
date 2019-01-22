package com.example.andres.ex2h_g02.ec.edu.uce.controladores;

import com.example.andres.ex2h_g02.ec.edu.uce.modelo.Vehiculo;

import java.util.ArrayList;

public class Busqueda {

    public static int buscarEnArray(ArrayList<Vehiculo> arrayDondeBuscar, String nobreParametroBusqueda){

        int ubicacionEnArray = arrayDondeBuscar.indexOf(new Vehiculo(nobreParametroBusqueda,null,null,0.0,null,null,null,null));

        return ubicacionEnArray;
    }

}
