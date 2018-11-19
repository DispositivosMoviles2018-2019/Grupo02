package com.example.andres.proyecto1hemi.ec.edu.uce.ec.edu.uce.utilidades;

import com.example.andres.proyecto1hemi.ec.edu.uce.modelo.Vehiculo;

import java.util.Comparator;

public class Comparador {

    public   static  class MyComparator implements Comparator<Vehiculo> {

        public int compare(Vehiculo o1, Vehiculo o2) {
            if (o1.getCosto().compareTo(o2.getCosto())>0) {
                return -1;
            } else if (o1.getCosto().compareTo(o2.getCosto())<0) {
                return 1;
            }
            return 0;
        }}
}
