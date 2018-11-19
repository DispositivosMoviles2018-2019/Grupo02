package ec.edu.uce.algoritmos.interfaces;

/**
 * Interfaz algoritmo vueltaatras
 *
 * @author Marcos
 */
public interface Vueltaatras {

    /**
     * Interfaz resolver (laberinto)
     *
     * @param lab variable de posicion(laberinto)
     * @param x Posicion de movimiento horizontal
     * @param y Posicion de movimiento vertical
     * @return devuelve posicion de la variable
     */
    public abstract boolean resuelve(char[][] lab, int x, int y);

    /**
     * Interfaz de impresion(laberinto)
     *
     * @param lab devuelve la posicion actual de la variable
     */
    public abstract void imprime(char[][] lab);

    /**
     * Interfaz resolver(sudoku)
     *
     * @param tablero estructura que se va a ordenar
     * @return devuele el sudoku con una solucion
     */
    public abstract boolean resolver(int[][] tablero);

    /**
     * Interfaz impresion(sudoku)
     *
     * @param tablero estructura que se va a ordenar
     */
    public abstract void imprime(int[][] tablero);

    /**
     * Interfaz esposibleintentar(sudoku)
     *
     * @param tablero estructura que se va a ordenar
     * @param i posicion para verificar las columnas
     * @param j posicion para verificar las filas
     * @param valor posicion para verificar valores del cuadrado
     * @return retorna una solucion unica
     */
    public abstract boolean esPosibleInsertar(int[][] tablero, int i, int j, int valor);
}
