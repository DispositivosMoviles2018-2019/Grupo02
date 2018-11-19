/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.uce.algoritmos.clases;

import ec.edu.uce.algoritmos.interfaces.Busquedaiterativa;
import ec.edu.uce.algoritmos.pojos.Vehiculo;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Metodos de Busqueda Iterativa
 *
 * @author Marcos
 */
public class BusquedasI implements Busquedaiterativa {

    private static final SimpleDateFormat df = new SimpleDateFormat("yyy-mm-dd");
/**
 * Algoritmo de busqueda secuencial Iterativo(precio)
  * @param num_v dimension del arreglo
 * @param arreglo Estructura que se va a ordenar
 * @param busqueda valor a buscar
 * @param cont El numero de interaciones que realiza el algoritmo
 */
    @Override
    public void secuencialprecio(int num_v, Vehiculo arreglo[], String busqueda, int cont) {
        int i, p = 0, u = num_v - 1;
        boolean encontrado = false;
        i = p;
        while (i <= u && !encontrado) {
            double busqueda_precio = 0.00001;
            try {
                busqueda_precio = Double.parseDouble(busqueda);
            } catch (Exception ex2) {
            }
            cont++;
            if (busqueda_precio == arreglo[i].getPrecio()) {
                encontrado = true;
                break;
            }
            i++;
        }
        if (encontrado) {//pasa el primer if si es verdadero pasa ha esta if
      
            System.out.println("\n Se ha encontrado el vehiculo en la posicion:\n" + (i + 1) + arreglo[i]);
        } else {
            System.out.println("\n No se ha encontrado el vehiculo!!");
        }
         System.out.println("Numero de iteraciones es "+ cont);
    }
/**
 * Algoritmo de busqueda secuencial Iterativo(Fecha de fabricacion)
  * @param num_v dimension del arreglo
 * @param arreglo Estructura que se va a ordenar
 * @param busqueda valor a buscar
 * @param cont El numero de interaciones que realiza el algoritmo
 */
    @Override
    public void secuencialf_fabric(int num_v, Vehiculo arreglo[], String busqueda, int cont) {
        int i, p = 0, u = num_v - 1;
        boolean encontrado = false;
        i = p;
        while (i <= u && !encontrado) {
            Date busqueda_fecha = new Date(1000, 01, 01);
            try {
                busqueda_fecha = df.parse(busqueda);
            } catch (ParseException ex) {
            }
            cont++;
            if (busqueda_fecha.equals(arreglo[i].getFec_fabricacion())) {
                encontrado = true;
                break;

            }
            i++;
        }
        if (encontrado) {//pasa el primer if si es verdadero pasa ha esta if
           
            System.out.println("\n Se ha encontrado el vehiculo en la posicion:\n" + (i + 1) + arreglo[i]);
        } else {
            System.out.println("\n No se ha encontrado el vehiculo!!");
        }
        System.out.println("Numero de iteraciones es "+ cont);
    }
/**
 * Algoritmo de busqueda secuencial Iterativo(Placa)
  * @param num_v dimension del arreglo
 * @param arreglo Estructura que se va a ordenar
 * @param busqueda valor a buscar
 * @param cont El numero de interaciones que realiza el algoritmo
 */
    @Override
    public void secuencialplaca(int num_v, Vehiculo arreglo[], String busqueda, int cont) {
        int i, p = 0, u = num_v - 1;
        boolean encontrado = false;
        i = p;

        while (i <= u && !encontrado) {
            cont++;
            if (busqueda.equals(arreglo[i].getPlaca())) {
                encontrado = true;
                break;
            }
            i++;
        }
        if (encontrado) {//pasa el primer if si es verdadero pasa ha esta if
           
            System.out.println("\n Se ha encontrado el vehiculo en la posicion:\n" + (i + 1) + arreglo[i]);
        } else {
            System.out.println("\n No se ha encontrado el vehiculo!!");
        }
 System.out.println("Numero de iteraciones es "+ cont);
    }
/**
 * Algoritmo de busqueda Binaria Iterativo(precio)
  * @param num_v dimension del arreglo
 * @param arreglo Estructura que se va a ordenar
 * @param busqueda valor a buscar
 * @param cont El numero de interaciones que realiza el algoritmo
 */
    @Override
    public void binariaprecio(int num_v, Vehiculo arreglo[], String busqueda, int cont) {
        ordenamientoI ov = new ordenamientoI();
        ov.burbuja2(num_v, arreglo);
        int central = -1, p = 0, u = num_v - 1;
        boolean encontrado = false;
        Double valorCentral;
        while (p <= u) {
            Double busqueda_precio = 0.00001;
            try {
                busqueda_precio = Double.parseDouble(busqueda);
            } catch (Exception ex2) {
            }
            central = ((p + u) / 2); // índice de elemento central
            cont++;
            valorCentral = arreglo[central].getPrecio(); // valor del índice central
            if (busqueda_precio.equals(valorCentral)) {
                encontrado = true;
                break;
            } else if (busqueda_precio.compareTo(valorCentral) > 0) {
                u = central - 1; // ir a sublista inferior
            } else {
                p = central + 1; // ir a sublista superior
            }
        }
        if (encontrado == true) {
            System.out.println("\n Se ha encontrado el vehiculo en la posicion:\n" + (central + 1) + arreglo[central]);
        } else {
            System.out.println("\n No se ha encontrado el vehiculo!!");
        }
       System.out.println("Numero de iteraciones es "+ cont);
    }
/**
 * Algoritmo de busqueda Binaria iterativo (Placa)
  * @param num_v dimension del arreglo
 * @param arreglo Estructura que se va a ordenar
 * @param busqueda valor a buscar
 * @param cont El numero de interaciones que realiza el algoritmo
 */
    @Override
    public void binariaplaca(int num_v, Vehiculo arreglo[], String busqueda, int cont) {
        ordenamientoI ov = new ordenamientoI();
        ov.burbuja2(num_v, arreglo);
        int central = -1, p = 0, u = num_v - 1;
        boolean encontrado = false;
        String valorCentral;
        while (p <= u) {
            central = ((p + u) / 2); // índice de elemento central
            cont++;
            valorCentral = arreglo[central].getPlaca(); // valor del índice central
            if (busqueda.equals(valorCentral)) {
                encontrado = true;
                break;
            } else if (busqueda.compareTo(valorCentral) > 0) {
                u = central - 1; // ir a sublista inferior
            } else {
                p = central + 1; // ir a sublista superior
            }
        }
        if (encontrado == true) {
            System.out.println("\n Se ha encontrado el vehiculo en la posicion:\n" + (central + 1) + arreglo[central]);
        } else {
            System.out.println("\n No se ha encontrado el vehiculo!!");
        }
        System.out.println("Numero de iteraciones es "+ cont);
    }
/**
 * Algoritmo de busqueda Binaria Iterativo(Fecha de fabricacion)
  * @param num_v dimension del arreglo
 * @param arreglo Estructura que se va a ordenar
 * @param busqueda valor a buscar
 * @param cont El numero de interaciones que realiza el algoritmo
 */
    @Override
    public void binariaf_fabricacion(int num_v, Vehiculo arreglo[], String busqueda, int cont) {
        ordenamientoI ov = new ordenamientoI();
        ov.burbuja2(num_v, arreglo);
        int central = -1, p = 0, u = num_v - 1;
        boolean encontrado = false;
        Date valorCentral;

        while (p <= u) {
            Date busqueda_fecha = new Date(1000, 01, 01);
            try {
                busqueda_fecha = df.parse(busqueda);
            } catch (ParseException ex) {
            }

            central = ((p + u) / 2); // índice de elemento central
cont++;
            valorCentral = arreglo[central].getFec_fabricacion();
            // valor del índice central
            if (busqueda_fecha.equals(valorCentral)) {
                encontrado = true;
                break;
            } else if (busqueda_fecha.compareTo(valorCentral) > 0) {
                u = central - 1; // ir a sublista inferior
            } else {
                p = central + 1; // ir a sublista superior
            }
        }
        if (encontrado == true) {
            System.out.println("\n Se ha encontrado el vehiculo en la posicion:\n" + (central + 1) + arreglo[central]);
        } else {
            System.out.println("\n No se ha encontrado el vehiculo!!");
        }
         System.out.println("Numero de iteraciones es "+ cont);
    }

}
