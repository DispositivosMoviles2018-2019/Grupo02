
package ec.edu.uce.algoritmos.interfaces;

import ec.edu.uce.algoritmos.pojos.Vehiculo;


/**
 *Interfaz de algoritmos de busqueda iterativa
 * @author Marcos
 */
public interface Busquedaiterativa {
 /**
 * Interfaz de busqueda Secuencial iterativo(precio)
  * @param num_v dimension del arreglo
 * @param arreglo Estructura que se va a ordenar
 * @param busqueda valor a buscar
 * @param cont El numero de interaciones que realiza el algoritmo
 */
    public abstract void secuencialprecio(int num_v,Vehiculo arreglo[],String busqueda,int cont);
    /**
 * Interfaz de busqueda Secuencial Iterativo(Placa)
  * @param num_v dimension del arreglo
 * @param arreglo Estructura que se va a ordenar
 * @param busqueda valor a buscar
 * @param cont El numero de interaciones que realiza el algoritmo
 */
 public abstract void secuencialplaca(int num_v,Vehiculo arreglo[],String busqueda,int cont);
 /**
 * Interfaz de busqueda Secuencial Iterativo(Fecha de fabricacion)
  * @param num_v dimension del arreglo
 * @param arreglo Estructura que se va a ordenar
 * @param busqueda valor a buscar
 * @param cont El numero de interaciones que realiza el algoritmo
 */
  public abstract void secuencialf_fabric(int num_v,Vehiculo arreglo[],String busqueda,int cont);
 /**
 * Interfaz de busqueda Binaria Iterativo(precio)
  * @param num_v dimension del arreglo
 * @param arreglo Estructura que se va a ordenar
 * @param busqueda valor a buscar
 * @param cont El numero de interaciones que realiza el algoritmo
 */
    public abstract void binariaprecio(int num_v,Vehiculo arreglo[],String busqueda,int cont);
    /**
 * Interfaz de busqueda Binaria Iterativo(Placa)
  * @param num_v dimension del arreglo
 * @param arreglo Estructura que se va a ordenar
 * @param busqueda valor a buscar
 * @param cont El numero de interaciones que realiza el algoritmo
 */
    public abstract void binariaplaca(int num_v,Vehiculo arreglo[],String busqueda,int cont);
    /**
 * Interfaz de busqueda Binaria Iterativo(Fecha de fabricacion)
  * @param num_v dimension del arreglo
 * @param arreglo Estructura que se va a ordenar
 * @param busqueda valor a buscar
 * @param cont El numero de interaciones que realiza el algoritmo
 */
    public abstract void binariaf_fabricacion(int num_v,Vehiculo arreglo[],String busqueda,int cont);

}
