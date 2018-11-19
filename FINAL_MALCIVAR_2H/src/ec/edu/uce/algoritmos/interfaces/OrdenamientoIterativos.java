package ec.edu.uce.algoritmos.interfaces;

/**
 * Interfaz Algoritmos de ordenamientos Iterativos
 *
 * @author Marcos
 */
public interface OrdenamientoIterativos {

    /**
     * Interfaz Algoritmo ordenamiento de la burbuja
     *
     * @param num_v
     * @param arreglo
     * @param cont
     */
    public abstract void burbuja(int num_v, Object[] arreglo, int cont);

    /**
     * Interfaz Algoritmo de ordenamiento por Insercion
     *
     * @param num_v dimension del arreglo
     * @param arreglo Estructura que se va a ordenar
     * @param cont El numero de interaciones que realiza el algoritmo
     */
    public abstract void insercion(int num_v, Object[] arreglo, int cont);

    /**
     * Interfaz Algoritmo de ordenamiento por seleccion
     *
     * @param num_v dimension del arreglo
     * @param arreglo Estructura que se va a ordenar
     * @param cont El numero de interaciones que realiza el algoritmo
     */
    public abstract void seleccion(int num_v, Object[] arreglo, int cont);

    /**
     * Interfaz Algoritmo de ordenamiento por Shellsort
     *
     * @param num_v dimension del arreglo
     * @param arreglo Estructura que se va a ordenar
     * @param cont El numero de interaciones que realiza el algoritmo
     */
    public abstract void shellsort(int num_v, Object[] arreglo, int cont);

}
