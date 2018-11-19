package ec.edu.uce.algoritmos.interfaces;

import ec.edu.uce.algoritmos.pojos.Vehiculo;

/**
 * Interfaz de algoritmos de busqueda recursivos
 *
 * @author Marcos
 */
public interface BusquedaRecursiva {

    /**
     * Algoritmo de busqueda Secuencial Recursiva(Placa)
     *
     * @param num_v dimension del arreglo
     * @param inicio posicion en donde se encuentra el elemento a comparar
     * @param arreglo Estructura que se va a ordenar
     * @param busqueda valor a buscar
   
     */
    public void secuencialplaca(int num_v, int inicio, Vehiculo arreglo[], String busqueda);

    /**
     * Algoritmo de busqueda Secuencial Recursiva(Fecha de fabricacion)
     *
     * @param num_v dimension del arreglo
     * @param inicio posicion en donde se encuentra el elemento a comparar
     * @param arreglo Estructura que se va a ordenar
     * @param busqueda valor a buscar

     */
    public void secuencialf_fabric(int num_v, int inicio, Vehiculo arreglo[], String busqueda);

    /**
     * Algoritmo de busqueda Secuencial Recursiva(Precio)
     *
     * @param num_v dimension del arreglo
     * @param inicio posicion en donde se encuentra el elemento a comparar
     * @param arreglo Estructura que se va a ordenar
     * @param busqueda valor a buscar

     */
    public void secuencialprecio(int num_v, int inicio, Vehiculo arreglo[], String busqueda);

    /**
     * Algoritmo de busqueda Binaria Recursiva(Precio)
     *
     * @param num_v dimension del arreglo
     * @param inicio posicion en donde se encuentra el elemento a comparar
     * @param arreglo Estructura que se va a ordenar
     * @param busqueda valor a buscar
 
     */
    public void binariaprecio(Vehiculo[] arreglo, String busqueda, int inicio, int num_v);

    /**
     * Algoritmo de busqueda Binaria Recursiva(Fecha de fabricacion)
     *
     * @param num_v dimension del arreglo
     * @param inicio posicion en donde se encuentra el elemento a comparar
     * @param arreglo Estructura que se va a ordenar
     * @param busqueda valor a buscar
   
     */
    public void binariaf_fabric(Vehiculo[] arreglo, String busqueda, int inicio, int num_v);

    /**
     * Algoritmo de busqueda Binaria Recursiva(Placa)
     *
     * @param num_v dimension del arreglo
     * @param inicio posicion en donde se encuentra el elemento a comparar
     * @param arreglo Estructura que se va a ordenar
     * @param busqueda valor a buscar
    
     */
    public void binariaplaca(Vehiculo[] arreglo, String busqueda, int inicio, int num_v);

}
