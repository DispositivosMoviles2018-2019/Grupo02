/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.uce.algoritmos.clases;

import ec.edu.uce.algoritmos.interfaces.Vueltaatras;
import static ec.edu.uce.algoritmos.principal.Main.dimension;

/**
 * Metodo vuelta a atras
 *
 * @author Marcos
 */
public class metvueltaatras implements Vueltaatras {

    /**
     * Metodo resolver (laberinto)
     *
     * @param lab variable de posicion(laberinto)
     * @param x Posicion de movimiento horizontal
     * @param y Posicion de movimiento vertical
     * @return devuelve posicion de la variable
     */
    @Override
//laberinto
    public boolean resuelve(char[][] lab, int x, int y) {
        lab[y][x] = '.';
        if (x == 0 || y == 0 || x == lab[0].length - 1 || y == lab.length - 1) {
            System.out.println("Encontrada solucion: ");
            imprime(lab);
            return true;
        }
        //arriba
        if (lab[y - 1][x] == ' ') {
            boolean tmp = resuelve(lab, x, y - 1);
            if (tmp == true) {
                return true;
            }

        }
        //abajo
        if (lab[y + 1][x] == ' ') {
            boolean tmp = resuelve(lab, x, y + 1);
            if (tmp == true) {
                return true;
            }
        }
        //izquierda
        if (lab[y][x - 1] == ' ') {
            boolean tmp = resuelve(lab, x - 1, y);
            if (tmp == true) {
                return true;
            }

        }
        //derecha
        if (lab[y][x + 1] == ' ') {
            boolean tmp = resuelve(lab, x + 1, y);
            if (tmp == true) {
                return true;
            }

        }
        //este camino no tiene solucion

        lab[y][x] = ' ';

        return false;

    }

    /**
     * Metodo de impresion(laberinto)
     *
     * @param lab devuelve la posicion actual de la variable
     */
    @Override
    public void imprime(char[][] lab) {

        for (int i = 0; i < lab.length; i++) {
            for (int j = 0; j < lab[i].length; j++) {
                System.out.print(lab[i][j]);
            }
            System.out.println();
        }
    }

    //sudoku
    /**
     * Metodo resolver(sudoku)
     *
     * @param tablero estructura que se va a ordenar
     * @return devuele el sudoku con una solucion
     */
    @Override
    public boolean resolver(int[][] tablero) {
        for (int i = 0; i < dimension; i++) {
            for (int j = 0; j < dimension; j++) {
                if (tablero[i][j] != 0) {
                    continue;
                }
                for (int k = 1; k <= 9; k++) {
                    if (esPosibleInsertar(tablero, i, j, k)) {
                        tablero[i][j] = k;
                        boolean b = resolver(tablero);
                        if (b) {
                            return true;
                        }
                        tablero[i][j] = 0;
                    }
                }
                return false;
            }
        }
        System.out.println("Encontrada solucion:");
        imprime(tablero);
        return true;
    }

    /**
     * Metodo impresion(sudoku)
     *
     * @param tablero estructura que se va a ordenar
     */
    @Override
    public void imprime(int[][] tablero) {
        for (int i = 0; i < dimension; i++) {
            if (i % 3 == 0) {
                System.out.println();
            }
            for (int j = 0; j < dimension; j++) {
                if (j % 3 == 0) {
                    System.out.print(" ");
                }
                System.out.print(tablero[i][j]);
            }
            System.out.println();
        }
    }

    /**
     * Metodo esposibleintentar(sudoku)
     *
     * @param tablero estructura que se va a ordenar
     * @param i posicion para verificar las columnas
     * @param j posicion para verificar las filas
     * @param valor posicion para verificar valores del cuadrado
     * @return retorna una solucion unica
     */
    @Override
    public boolean esPosibleInsertar(int[][] tablero, int i, int j, int valor) {
        for (int a = 0; a < dimension; a++) {
            if (a != i && tablero[a][j] == valor) {
                return false;
            }
        }
        //mira fila
        for (int a = 0; a < dimension; a++) {
            if (a != j && tablero[i][a] == valor) {
                return false;
            }
        }
        //mira cuadrado
        int y = (i / 3) * 3;
        int x = (j / 3) * 3;
        for (int a = 0; a < dimension / 3; a++) {
            for (int b = 0; b < dimension / 3; b++) {
                if (a != i && b != j && tablero[y + a][x + b] == valor) {
                    return false;
                }
            }
        }
        return true;
    }
}
