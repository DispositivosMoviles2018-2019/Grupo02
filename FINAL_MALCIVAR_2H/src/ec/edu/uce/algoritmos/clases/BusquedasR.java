/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.uce.algoritmos.clases;

import ec.edu.uce.algoritmos.interfaces.BusquedaRecursiva;
import ec.edu.uce.algoritmos.pojos.Vehiculo;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Metodo de Busqueda Recursivos
 *
 * @author Marcos
 */
public class BusquedasR implements BusquedaRecursiva {

    private static final SimpleDateFormat df = new SimpleDateFormat("yyyy-mm-dd");

    /**
     * Algoritmo de busqueda Secuencial Recursiva(Precio)
     *
     * @param num_v dimension del arreglo
     * @param inicio posicion en donde se encuentra el elemento a comparar
     * @param arreglo Estructura que se va a ordenar
     * @param busqueda valor a buscar
    
     */
    @Override
    public void secuencialprecio(int num_v, int inicio, Vehiculo arreglo[], String busqueda) {

        int i, p = 0, u = num_v - 1;
        boolean encontrado = false;
        i = p;
        if (inicio >= 0 && u >= 0 && inicio <= u) {
            encontrado = false;
         
            double busqueda_precio = 0.00001;
            try {
                busqueda_precio = Double.parseDouble(busqueda);
            } catch (Exception ex2) {
            }

            //Compara si el objeto a buscar es igual al objecto del arreglo en la posicion correspondiente
            if (((arreglo[inicio].getPrecio()).equals(busqueda_precio))) {
                encontrado = true;

                //Si el objeto a comparar no era el buscadi se procede a llamar de nuevo 
                //al metodo incrementando el indice en 1 
            } else {

                secuencialprecio(num_v, inicio + 1, arreglo, busqueda);
            }

        }
        if (encontrado) {//pasa el primer if si es verdadero pasa ha esta if
            // vector[i] = 100000;
            System.out.println("\n Se ha encontrado el vehiculo en la posicion:\n" + (inicio + 1) + arreglo[inicio]);
        } else {
            System.out.println("\n No se ha encontrado el vehiculo!!");
        }
 
    }

    /**
     * Algoritmo de busqueda Secuencial Recursiva(Placa)
     *
     * @param num_v dimension del arreglo
     * @param inicio posicion en donde se encuentra el elemento a comparar
     * @param arreglo Estructura que se va a ordenar
     * @param busqueda valor a buscar
     * @param cont El numero de interaciones que realiza el algoritmo
     */
    @Override
    public void secuencialplaca(int num_v, int inicio, Vehiculo[] arreglo, String busqueda) {
        int i, p = 0, u = num_v - 1;
        boolean encontrado = false;
        i = p;
        if (inicio >= 0 && u >= 0 && inicio <= u) {
            encontrado = false;
       
            //Compara si el objeto a buscar es igual al objecto del arreglo en la posicion correspondiente
            if (busqueda.equals(arreglo[i].getPlaca())) {
                encontrado = true;

                //Si el objeto a comparar no era el buscadi se procede a llamar de nuevo 
                //al metodo incrementando el indice en 1 
            } else {

                secuencialplaca(num_v, inicio + 1, arreglo, busqueda);
            }

        }
        if (encontrado) {//pasa el primer if si es verdadero pasa ha esta if
            // vector[i] = 100000;
            System.out.println("\n Se ha encontrado el vehiculo en la posicion:\n" + (inicio + 1) + arreglo[inicio]);
        } else {
            System.out.println("\n No se ha encontrado el vehiculo!!");
        }
   
    }

    /**
     * Algoritmo de busqueda Secuencial Recursiva(Fecha de fabricacion)
     *
     * @param num_v dimension del arreglo
     * @param inicio posicion en donde se encuentra el elemento a comparar
     * @param arreglo Estructura que se va a ordenar
     * @param busqueda valor a buscar
     * @param cont El numero de interaciones que realiza el algoritmo
     */
    @Override
    public void secuencialf_fabric(int num_v, int inicio, Vehiculo[] arreglo, String busqueda) {
        int i, p = 0, u = num_v - 1;
        boolean encontrado = false;
        i = p;
        if (inicio >= 0 && u >= 0 && inicio <= u) {
            encontrado = false;
      
            Date busqueda_fecha = new Date(1000, 01, 01);
            try {
                busqueda_fecha = df.parse(busqueda);
            } catch (ParseException ex) {
            }
            //Compara si el objeto a buscar es igual al objecto del arreglo en la posicion correspondiente
            if (((arreglo[inicio].getFec_fabricacion()).equals(busqueda_fecha))) {
                encontrado = true;

                //Si el objeto a comparar no era el buscadi se procede a llamar de nuevo 
                //al metodo incrementando el indice en 1 
            } else {

                secuencialf_fabric(num_v, inicio + 1, arreglo, busqueda);
            }
         
        }
        if (encontrado) {//pasa el primer if si es verdadero pasa ha esta if
            // vector[i] = 100000;
            System.out.println("\n Se ha encontrado el vehiculo en la posicion:\n" + (inicio + 1) + arreglo[inicio]);
        } else {
            System.out.println("\n No se ha encontrado el vehiculo!!");
        }
    }

    /**
     * Algoritmo de busqueda Binaria Recursiva(Precio)
     *
     * @param num_v dimension del arreglo
     * @param inicio posicion en donde se encuentra el elemento a comparar
     * @param arreglo Estructura que se va a ordenar
     * @param busqueda valor a buscar
     * @param cont El numero de interaciones que realiza el algoritmo
     */
    @Override

    public void binariaprecio(Vehiculo[] arreglo, String busqueda, int inicio, int num_v) {

        ordenamientoI ov = new ordenamientoI();
        ov.burbuja2(num_v, arreglo);

        int medio = -1;
        boolean encontrado = false;
        Double valorCentral;

        //Validacion para que inicio simpre sea menor que la dimension del arreglo
        if (inicio > num_v) {
            //  encontrado=false;
        } else {
            medio = (inicio + (num_v - 1)) / 2;
   
            Double busqueda_precio = 0.00001;
            try {
                busqueda_precio = Double.parseDouble(busqueda);
            } catch (Exception ex2) {
            }
            valorCentral = arreglo[medio].getPrecio();
            if (busqueda_precio.equals(valorCentral)) {
                encontrado = true;

            } else //Comprueba si el objeto a comparar es menor que el objeto a buscar
            if (busqueda_precio.compareTo(valorCentral) < 0) {
              //  encontrado = true;

                //En caso de ser cierto se desecha la parte izquierda del arreglo
                binariaprecio(arreglo, busqueda, medio + 1, num_v);

            } else {
                //En caso de no se menor se comprueba si es mayor
                if (busqueda_precio.compareTo(valorCentral) > 0) {
                //    encontrado = true;

                    //Si el objeto a buscar es mayor se elimina la parte de la derecha del arreglo
                    binariaprecio(arreglo, busqueda, inicio, medio - 1);
                    //En caso de que no sea mayor ni menor quiere decir que los objetos son iguales.
                }

            }

        }
        if (encontrado) {
            System.out.println("\n Se ha encontrado el vehiculo en la posicion:\n" + (medio + 1) + arreglo[medio]);

        } else {
            System.out.println("\n No se ha encontrado el vehiculo!!");
        }
   
    }

    /**
     * Algoritmo de busqueda Binaria Recursiva(Placa)
     *
     * @param num_v dimension del arreglo
     * @param inicio posicion en donde se encuentra el elemento a comparar
     * @param arreglo Estructura que se va a ordenar
     * @param busqueda valor a buscar
     * @param cont El numero de interaciones que realiza el algoritmo
     */
    @Override
    public void binariaf_fabric(Vehiculo[] arreglo, String busqueda, int inicio, int num_v) {
        ordenamientoI ov = new ordenamientoI();
        ov.burbuja2(num_v, arreglo);

        int medio = -1;
        boolean encontrado = false;
        Date valorCentral;

        //Validacion para que inicio simpre sea menor que la dimension del arreglo
        if (inicio > num_v) {
            //  encontrado=false;
        } else {
            medio = (inicio + (num_v - 1)) / 2;
            Date busqueda_fecha = new Date(1000, 01, 01);
          
            try {
                busqueda_fecha = df.parse(busqueda);
            } catch (ParseException ex) {
            }
            valorCentral = arreglo[medio].getFec_fabricacion();
            if (busqueda_fecha.equals(valorCentral)) {
                encontrado = true;

            } else //Comprueba si el objeto a comparar es menor que el objeto a buscar
            if (busqueda_fecha.compareTo(valorCentral) < 0) {
              //  encontrado = true;

                //En caso de ser cierto se desecha la parte izquierda del arreglo
                binariaf_fabric(arreglo, busqueda, medio + 1, num_v);

            } else {
                //En caso de no se menor se comprueba si es mayor
                if (busqueda_fecha.compareTo(valorCentral) > 0) {
                //    encontrado = true;

                    //Si el objeto a buscar es mayor se elimina la parte de la derecha del arreglo
                    binariaf_fabric(arreglo, busqueda, inicio, medio - 1);
                    //En caso de que no sea mayor ni menor quiere decir que los objetos son iguales.
                }

            }

        }
        if (encontrado) {
            System.out.println("\n Se ha encontrado el vehiculo en la posicion:\n" + (medio + 1) + arreglo[medio]);

        } else {
            System.out.println("\n No se ha encontrado el vehiculo!!");
        }
      
    }

    /**
     * Algoritmo de busqueda Binaria Recursiva(Fecha de fabricacion)
     *
     * @param num_v dimension del arreglo
     * @param inicio posicion en donde se encuentra el elemento a comparar
     * @param arreglo Estructura que se va a ordenar
     * @param busqueda valor a buscar
     * @param cont El numero de interaciones que realiza el algoritmo
     */
    @Override
    public void binariaplaca(Vehiculo[] arreglo, String busqueda, int inicio, int num_v) {
        ordenamientoI ov = new ordenamientoI();
        ov.burbuja2(num_v, arreglo);

        int medio = -1;
        boolean encontrado = false;
        String valorCentral;

        //Validacion para que inicio simpre sea menor que la dimension del arreglo
        if (inicio > num_v) {
            //  encontrado=false;
        } else {
            medio = (inicio + (num_v - 1)) / 2;
          
            valorCentral = arreglo[medio].getPlaca();
            if (busqueda.equals(valorCentral)) {
                encontrado = true;

            } else //Comprueba si el objeto a comparar es menor que el objeto a buscar
            if (busqueda.compareTo(valorCentral) < 0) {
              //  encontrado = true;

                //En caso de ser cierto se desecha la parte izquierda del arreglo
                binariaplaca(arreglo, busqueda, medio + 1, num_v);

            } else {
                //En caso de no se menor se comprueba si es mayor
                if (busqueda.compareTo(valorCentral) > 0) {
                //    encontrado = true;

                    //Si el objeto a buscar es mayor se elimina la parte de la derecha del arreglo
                    binariaplaca(arreglo, busqueda, inicio, medio - 1);
                    //En caso de que no sea mayor ni menor quiere decir que los objetos son iguales.
                }

            }

        }
        if (encontrado) {
            System.out.println("\n Se ha encontrado el vehiculo en la posicion:\n" + (medio + 1) + arreglo[medio]);

        } else {
            System.out.println("\n No se ha encontrado el vehiculo!!");
        }
     
    }
}
