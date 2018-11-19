package com.example.carloscaiza.ccaiza_ex_1h.ec.edu.uce.utilidades;

import com.example.carloscaiza.ccaiza_ex_1h.ec.edu.uce.modelo.Vehiculo;

import java.io.Serializable;
import java.util.Comparator;

public class Comparar implements Serializable {

    /*public   static  class MyComparator implements Comparator<Vehiculo> {

        public boolean equals(Object objetoAComparar){
            boolean isEqual = false;
            *//*
             * Se comprueba en primer lugar que el objeto que se ha recivido es una instancia de la clase Producto
             * si lo es entonces se procedera hacer el casting a un objeto de la clase Producto. Se debe hacer esto
             * ya que no se puede comparar un OBJECT con un PRODUCTO.
             *//*
            if(objetoAComparar instanceof Vehiculo){
                //Casting de objeto --> Producto. Con esto ya podemos comparar un Producto con otro Producto
                Vehiculo productoComprar = (Vehiculo)objetoAComparar;

                *//* Recogemos el nombre del producto que se ha pasado por parametro para comprarlo con el objeto
                 * con el que se ha hecho la llamada.
                 * En el caso de que tengan el mismo nombre entonces camiaremos la variable de retorno a TRUE;
                 *//*
                //if(productoComprar.getFecFabricacion().equals(this.fecFabricacion)){
                if(productoComprar.getPlaca().equals(this.placa)){
                    //Si se llega hasta aqui quiere decir que los objetos tienen el mismo nombre
                    isEqual = true;
                }
            }
            *//**
             * En el caso de no ser una instancia de la clase Producto la variable isEqual permanece en FALSE
             * y por tanto no es igual o no pertenece a la clase.
             *//*
            return isEqual;
        }*/

        public int compare(Vehiculo o1, Vehiculo o2) {
            if (o1.getPlaca().compareTo(o2.getPlaca())<0) {
                return -1;
            } else if (o1.getPlaca().compareTo(o2.getPlaca())>0) {
                return 1;
            }
            return 0;
        }

}
