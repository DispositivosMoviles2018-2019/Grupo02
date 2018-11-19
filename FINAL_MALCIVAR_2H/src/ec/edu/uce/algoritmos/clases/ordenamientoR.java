package ec.edu.uce.algoritmos.clases;

import ec.edu.uce.algoritmos.interfaces.OrdenamientoRecursivos;

/**
 * Metodos de ordenamiento Recursivos
 *
 * @author Marcos
 * @param <T> Tipo de dato Abstracto
 */
public class ordenamientoR<T extends Comparable<? super T>> implements OrdenamientoRecursivos {

    /**
     *Algoritmo de Ordenamiento Mergesort
     * @param arreglo estructura que se va a ordenar
     * @param inicio posicion en donde se encuentra el elemento a comparar
     * @param dimension dimension del arreglo.
 
     */
    @Override
    public void mezcla(Object[] arreglo, int inicio, int dimension) {
        //Dimension del primer subarreglo
        int dimension1;
        //Dimension del segundo subarreglo
        int dimension2;
        //Subdivide los arreglo hasta que la dimension sea 1
        if (dimension > 1) {
            dimension1 = dimension / 2;
            dimension2 = dimension - dimension1;

            //Envia los subarreglo a seguir subdividiendose
            mezcla(arreglo, inicio, dimension1);
            mezcla(arreglo, inicio + dimension1, dimension2);
            //Mezcla los arreglos
            mezclar(arreglo, inicio, dimension1, dimension2);
        }
      
    }

    /**
     *Metodo de mezcla 
      * @param arreglo estructura que se va a ordenar
     * @param inicio posicion en donde se encuentra el elemento a comparar
     * @param dimension1 Mitad izquierda 
     * @param dimension2 Mitad derecha
 
     */
    private void mezclar(Object[] arreglo, int inicio, int dimension1, int dimension2) {
        Object[] buffer = new Object[dimension1 + dimension2];
        int temp = 0;
        int temp1 = 0;
        int temp2 = 0;
     
        while ((temp1 < dimension1) && (temp2 < dimension2)) {
            
            if (((T) arreglo[inicio + temp1]).compareTo((T) arreglo[inicio + dimension1 + temp2]) < 0) {
                buffer[temp++] = arreglo[inicio + (temp1++)];
            } else {
                buffer[temp++] = arreglo[inicio + dimension1 + (temp2++)];
            }
        }
       
        while (temp1 < dimension1) {
            buffer[temp++] = arreglo[inicio + (temp1++)];
        }
        while (temp2 < dimension2) {
            buffer[temp++] = arreglo[inicio + dimension1 + (temp2++)];
        }
        for (int i = 0; i < dimension1 + dimension2; i++) {
            arreglo[inicio + i] = buffer[i];
        }

    }

    /**
     *Algoritmo de ordenamiento quicksort
    * @param arreglo estructura que se va a ordenar
     * @param inicio posicion en donde se encuentra el elemento a comparar.(realiza la busqueda de izqierda a derecha)
     * @param fin dimension del arreglo.(realiza la busqueda de derecha a izquierda)
 
     */
    @Override
    public void quickSort(Object[] arreglo, int inicio, int fin) {
       
        // Tomamos primer elemento como pivote
        Object pivote = arreglo[inicio];
    
        int i = inicio;
 
        int j = fin;

        Object aux;

      
        while (i < j) {
            
            while (((T) arreglo[i]).compareTo((T) pivote) <= 0 && i < j) {
                i++; // busca elemento mayor que pivote
            }
            while (((T) arreglo[j]).compareTo((T) pivote) > 0) {
                j--; // busca elemento menor que pivote
            }
          
            if (i < j) {
               
                aux = arreglo[i];
                arreglo[i] = arreglo[j];
                arreglo[j] = aux;
            }
        }
    
      
        arreglo[inicio] = arreglo[j];
        arreglo[j] = pivote;
        if (inicio < j - 1) {
            //cont++;
            //Ordenamos subarray izquierdo
            quickSort(arreglo, inicio, j - 1);
        }else
        if(j + 1 < fin) {
          
            //Ordenamos subarray derecho
            quickSort(arreglo, j + 1, fin);
        }
    
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

}
