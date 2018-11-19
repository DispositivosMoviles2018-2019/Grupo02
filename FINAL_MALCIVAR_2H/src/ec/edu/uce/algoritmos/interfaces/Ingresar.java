package ec.edu.uce.algoritmos.interfaces;

import ec.edu.uce.algoritmos.pojos.Vehiculo;

/**
 * Interfaz opcion de ingreso
 *
 * @author Marcos
 */
public interface Ingresar {

    /**
     * Interfaz crear
     *
     * @param num_v dimension del arreglo
     * @param arreglo Estructura que se va a ordenar
     * @return nuevo parametro de vehiculo
     */
    public abstract Vehiculo crear(int num_v, Vehiculo arreglo[]);

    /**
     * Interfaz editar
     *
     * @param num_v dimension del arreglo
     * @param arreglo Estructura que se va a ordenar
     */
    public abstract void editar(int num_v, Vehiculo arreglo[]);

    /**
     * Interfaz eliminar
     *
     * @param num_v dimension del arreglo
     * @param arreglo Estructura que se va a ordenar
     * @return elimina el elemento seleccionado
     */
    public abstract int eliminar(int num_v, Vehiculo arreglo[]);

    /**
     * Interfaz impresion
     *
     * @param num_v dimension del arreglo
     * @param arreglo Estructura que se va a ordenar
     */
    public abstract void listar(int num_v, Vehiculo arreglo[]);

}
