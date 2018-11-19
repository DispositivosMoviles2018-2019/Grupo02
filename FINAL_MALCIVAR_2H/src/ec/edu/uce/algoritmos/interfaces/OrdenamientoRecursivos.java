package ec.edu.uce.algoritmos.interfaces;

/**
 * Interfaz de algoritmos de ordanamiento Recursivos
 *
 * @author Marcos
 */
public interface OrdenamientoRecursivos {

    /**
     *Interfaz de ordenamiento mergesort
     * @param arreglo estructura que se va a ordenar
     * @param inicio posicion en donde se encuentra el elemento a comparar
     * @param dimension dimension del arreglo.
  
     */
    public void mezcla(Object[] arreglo, int inicio, int dimension);

    /**
     *Interfaz de ordenamiento quicksort
     * @param arreglo estructura que se va a ordenar
     * @param inicio posicion en donde se encuentra el elemento a comparar
     * @param fin dimension del arreglo.
     
     */
    public void quickSort(Object[] arreglo, int inicio, int fin);
}
