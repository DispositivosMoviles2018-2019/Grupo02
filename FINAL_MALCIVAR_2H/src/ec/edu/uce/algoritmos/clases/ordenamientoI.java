package ec.edu.uce.algoritmos.clases;

import ec.edu.uce.algoritmos.interfaces.OrdenamientoIterativos;
import ec.edu.uce.algoritmos.pojos.Vehiculo;

/**
 * Metodos de ordenamiento Iterativos
 *
 * @author Marcos
 * @param <T> tipo de dato abstracto
 */
public class ordenamientoI<T extends Comparable<? super T>> implements OrdenamientoIterativos {

    /**
     * Algoritmo de Ordenamiento de la Burbuja
     *
     * @param num_v dimension del arreglo
     * @param arreglo Estructura que se va a ordenar
     * @param cont El numero de interaciones que realiza el algoritmo
     */
    @Override
    public void burbuja(int num_v, Object[] arreglo, int cont) {
//        Burbuja Optimizada
        cont = 0;
        Object buffer;
        for (int i = 0; i < num_v; i++) {

            for (int j = 0; j < i; j++) {

                if (((T) arreglo[i]).compareTo((T) arreglo[j])  <0) {
                    cont++;
                    buffer = arreglo[j];
                    arreglo[j] = arreglo[i];
                    arreglo[i] = buffer;
                }
            }
        }
        System.out.println("El numero de interaciones es: " + cont);
    }

    /**
     * Algoritmo de ordenacion por insercion
     *
     * @param num_v dimension del arreglo
     * @param arreglo Estructura que se va a ordenar
     * @param cont El numero de interaciones que realiza el algoritmo
     */
    @Override
    public void insercion(int num_v, Object[] arreglo, int cont) {
        cont = 0;
        int j;
        Object aux;
        for (int i = 1; i < num_v; i++) {
            
            aux = arreglo[i];
            j = i - 1;

            while ((j >= 0) && (((T) aux).compareTo((T) arreglo[j])) < 0) {
                cont++;
                arreglo[j + 1] = arreglo[j];
                j--;
            }
            arreglo[j + 1] = aux;

        }
        System.out.println("El numero de interaciones es: " + cont);
    }

    /**
     * Algoritmo de ordenacion por seleccion
     *
     * @param num_v dimension del arreglo
     * @param arreglo Estructura que se va a ordenar
     * @param cont El numero de interaciones que realiza el algoritmo
     */
    @Override
    public void seleccion(int num_v, Object arreglo[], int cont) {
        int p;
        Object aux;
        cont = 0;
        for (int i = 0; i < num_v - 1; i++) {
            p = i;

            for (int j = i + 1; j < num_v; j++) {
                if (((T) arreglo[j]).compareTo((T) arreglo[p]) < 0) {
                   cont++;
                    p = j;
                }
            }
            if (p != i) {
                
                aux = arreglo[p];
                arreglo[p] = arreglo[i];
                arreglo[i] = aux;
            }
        }
        System.out.println("El numero de interaciones es: " + cont);
    }

    /**
     * Algoritmo de ordenacion por Shellsort
     *
     * @param num_v dimension del arreglo
     * @param arreglo Estructura que se va a ordenar
     * @param cont El numero de interaciones que realiza el algoritmo
     */
    @Override
    public void shellsort(int num_v, Object arreglo[], int cont) {

        Object aux;
        cont = 0;
        for (int gap = num_v / 2; gap > 0; gap = gap == 2 ? 1 : (int) (gap / 2.2)) {

            for (int i = gap; i < num_v; i++) {
               
                aux = arreglo[i];
                int j;
                for (j = i; j >= gap && ((T) aux).compareTo((T) arreglo[j]) >= ((T) aux).compareTo((T) arreglo[j - gap]); j -= gap) {
                     cont++;
                    arreglo[j] = arreglo[j - gap];
                }
                arreglo[j] = aux;
            }

        }
        System.out.println("El numero de interaciones es: " + cont);
    }

    /**
     * Copia los elementos de un arreglo
     *
     * @param arreglo arreglo a copiar
     * @param dimension dimension del arreglo
     * @return una copia del arreglo
     */
    public Object[] copiarArreglo(Object[] arreglo, int dimension) {
        Object[] vector = new Object[dimension];
        for (int i = 0; i < vector.length; i++) {
            vector[i] = arreglo[i];
        }
        return vector;
    }

    /**
     * Metodo de la burbuja para ordenar Busqueda Binaria
     *
     * @param num_v dimension del arreglo
     * @param arreglo Estructura que se va a ordenar
     */
    public void burbuja2(int num_v, Vehiculo[] arreglo) {
//        Burbuja Optimizada
        Vehiculo buffer;
        for (int i = 0; i < num_v; i++) {
            for (int j = 0; j < i; j++) {
                if ((arreglo[i]).compararprecio(arreglo[j]) > 0) {
                    buffer = arreglo[j];
                    arreglo[j] = arreglo[i];
                    arreglo[i] = buffer;
                }
            }
        }

    }

}
