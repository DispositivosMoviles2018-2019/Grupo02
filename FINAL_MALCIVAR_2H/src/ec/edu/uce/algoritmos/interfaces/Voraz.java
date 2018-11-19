package ec.edu.uce.algoritmos.interfaces;

/**
 * Interfaz algoritmo voraz
 *
 * @author Marcos
 */

public interface Voraz {

    /**
     * Interfaz cargadesdeteclado (ingreso de variables)
     */
    public void cargaDesdeTeclado();

    /**
     * Interfaz cargadesdearchivo(metodo de carga de variables)
     */
    public void cargaDesdeArchivo();

    /**
     * Interfaz resolver
     *
     * @param origen devuele
     */
    public void resuelve(int origen);

    /**
     * Interfaz min
     *
     * @param dest variable que indica posicion
     * @return
     */
    int min(int dest);

    /**
     * Interfaz imprimecamino
     *
     * @param cam variable de tipo Sring
     * @param nod variaple de tipo entero
     * @param o variable de tipo entero
     */
    void imprimeCamino(String cam, int nod, int o);
}
