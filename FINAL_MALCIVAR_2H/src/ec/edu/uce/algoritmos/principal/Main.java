package ec.edu.uce.algoritmos.principal;

import ec.edu.uce.algoritmos.clases.BusquedasI;
import ec.edu.uce.algoritmos.clases.BusquedasR;
import ec.edu.uce.algoritmos.clases.Login;
import ec.edu.uce.algoritmos.clases.Menus;
import ec.edu.uce.algoritmos.clases.Mochila;
import ec.edu.uce.algoritmos.clases.Objeto;
import ec.edu.uce.algoritmos.clases.Opciones_vehiculo;
import ec.edu.uce.algoritmos.clases.ordenamientoI;
import ec.edu.uce.algoritmos.clases.Validaciones;
import ec.edu.uce.algoritmos.clases.dijkstra;
import ec.edu.uce.algoritmos.clases.metvueltaatras;
import ec.edu.uce.algoritmos.clases.ordenamientoR;
import ec.edu.uce.algoritmos.pojos.Vehiculo;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * Proyecto de Algoritmos
 *
 * @author Marcos
 */
public class Main {

    static final int tam_arreglo = 5;
    public static Scanner sc = new Scanner(System.in);
    public static Vehiculo arreglo[] = new Vehiculo[tam_arreglo];
    public static int num_v = 0;
    public static final int dimension = 9;
    private static final SimpleDateFormat df = new SimpleDateFormat("yyyy-mm-dd");

    private static final BufferedReader scb = new BufferedReader(new InputStreamReader(System.in));

    /**
     * Metodo Main
     *
     * @param args
     * @throws IOException
     * @throws ParseException
     */
    public static void main(String[] args) throws IOException, ParseException {
        Login.inUsuario();
        Opciones_vehiculo opvh = new Opciones_vehiculo();
        
        
        //Ordenamiento_v ov = new ordenamientoI();
        //ordenamientoR ki = new ordenamientoR();
        BusquedasR km = new BusquedasR();
        BusquedasR kl = new BusquedasR();
        BusquedasI bv = new BusquedasI();
        BusquedasI dv = new BusquedasI();
        ordenamientoR<Vehiculo> ordenar1 = new ordenamientoR<>();
        ordenamientoI<Vehiculo> ordenar2 = new ordenamientoI<>();

       //   BusquedasI<Vehiculo> buscar1 = new BusquedasI<>();
        int opc1;
        do {
            opc1 = Menus.menup();
            switch (opc1) {
                case 1:
                    int opc3;
                    int opc2;
                    do {
                        opc2 = Menus.menu();
                        switch (opc2) {
                            case 1:
                                if (num_v < arreglo.length) {
                                    Vehiculo vh = opvh.crear(num_v, arreglo);
                                    if (vh != null) {
                                        arreglo[num_v] = vh;
                                        num_v++;
                                    }
                                } else {
                                    System.out.println("Ya se ah ingresado el numero maximo de vehiculos!!");
                                }
                                break;
                            case 2:
                                if (num_v != 0) {
                                    opvh.editar(num_v, arreglo);
                                } else {
                                    System.out.println("No existen vehiculos almacenados!!");
                                }
                                break;
                            case 3:
                                if (num_v != 0) {
                                    int busv = opvh.eliminar(num_v, arreglo);
                                    num_v -= busv;
                                } else {
                                    System.out.println("No existen vehiculos almacenados!!");
                                }

                                break;
                            case 4:
                                opvh.listar(num_v, arreglo);
                                break;
                        }
                    } while (opc2 != 5);
                    break;
                case 2:
                    do {
                        opc2 = Menus.menuOrdenar();
                        switch (opc2) {
                            case 1:
                                do {
                                    opc3 = Menus.menuOrdenariterativos();
                                    switch (opc3) {
                                        case 1:
                                            int cont = 0;
                                            Object[] copia3 = ordenar2.copiarArreglo(arreglo, num_v);
                                            ordenar2.burbuja(num_v, copia3, cont);
                                            System.out.println("                                      ***** Lista de vehiculos ordenados \"burbuja\" *****");
                                            System.out.print("\nVehiculo\tPRECIO\t\tPLACA\t\tFECHAFABRICACION\n");
                                            for (int i = 0; i < copia3.length; i++) {
                                                System.out.println((i + 1) + copia3[i].toString());

                                            }
                                            break;
                                        case 2:
                                            int cont2 = 0;
                                            Object[] copia4 = ordenar2.copiarArreglo(arreglo, num_v);
                                            ordenar2.insercion(num_v, copia4, cont2);
                                            System.out.println("                                      ***** Lista de vehiculos ordenados \"insercion\" *****");
                                            System.out.print("\nVehiculo\tPRECIO\t\tPLACA\t\tFECHAFABRICACION\n");
                                            for (int i = 0; i < copia4.length; i++) {
                                                System.out.println((i + 1) + copia4[i].toString());

                                            }
                                            break;
                                        case 3:
                                            int cont3 = 0;
                                            Object[] copia5 = ordenar2.copiarArreglo(arreglo, num_v);
                                            ordenar2.seleccion(num_v, copia5, cont3);
                                            System.out.println("                                      ***** Lista de vehiculos ordenados \"seleccion\" *****");
                                            System.out.print("\nVehiculo\tPRECIO\t\tPLACA\t\tFECHAFABRICACION\n");
                                            for (int i = 0; i < copia5.length; i++) {
                                                System.out.println((i + 1) + copia5[i].toString());

                                            }
                                            break;
                                        case 4:
                                            int cont4 = 0;
                                            Object[] copia6 = ordenar2.copiarArreglo(arreglo, num_v);
                                            ordenar2.shellsort(num_v, copia6, cont4);
                                            System.out.println("                                      ***** Lista de vehiculos ordenados \"shellsort\" *****");
                                            System.out.print("\nVehiculo\tPRECIO\t\tPLACA\t\tFECHAFABRICACION\n");
                                            for (int i = 0; i < copia6.length; i++) {
                                                System.out.println((i + 1) + copia6[i].toString());

                                            }
                                            break;
                                    }

                                } while (opc3 != 5);
                                break;
                            case 2:
                                do {
                                    opc3 = Menus.menuOrdenarrecursivos();
                                    switch (opc3) {
                                        case 1:
                                            Object[] copia1 = ordenar1.copiarArreglo(arreglo, num_v);

                                            ordenar1.mezcla(copia1, 0, copia1.length);

                                            System.out.println("                                      ***** Lista de vehiculos ordenados \"MERGESORT\" *****");
                                            System.out.print("\nVehiculo\tPRECIO\t\tPLACA\t\tFECHAFABRICACION\n");
                                            for (int i = 0; i < copia1.length; i++) {
                                                System.out.println((i + 1) + copia1[i].toString());

                                            }

                                            break;

                                        case 2:
                                         //   copia1 = ordenar1.copiarArreglo(arreglo, num_v);

                                            Object[] copia2 = ordenar1.copiarArreglo(arreglo, num_v);
                                            ordenar1.quickSort(copia2, 0, copia2.length - 1);
                                            System.out.println("                                      ***** Lista de vehiculos ordenados \"QUICKSORT\" *****");
                                            System.out.print("\nVehiculo\tPRECIO\t\tPLACA\t\tFECHAFABRICACION\n");
                                            for (int i = 0; i < copia2.length; i++) {
                                                System.out.println((i + 1) + copia2[i].toString());

                                            }
                                            break;
                                    }
                                } while (opc3 != 3);
                                break;

                        }

                    } while (opc2 != 3);
                    break;
                case 3:
                    do {
                        opc2 = Menus.menuBuscar();
                        switch (opc2) {
                            case 1:
                                do {
                                    opc3 = Menus.menuBuscariterativos();
                                    switch (opc3) {
                                        case 1:

                                            System.out.print("Ingrese un parametro del vehiculo a buscar: ");
                                            int cont7 = 0;
                                            String busqueda1 = sc.next();

                                            bv.secuencialf_fabric(num_v, arreglo, busqueda1, cont7);
                                            break;
                                        case 2:
                                            Vehiculo[] arreglocopia2;
                                            int cont8 = 0;
                                            arreglocopia2 = new Vehiculo[5];
                                            System.arraycopy(arreglo, 0, arreglocopia2, 0, 5);
                                            System.out.print("Ingrese un parametro del vehiculo a buscar: ");
                                            String busqueda2 = sc.next();
                                            dv.binariaprecio(num_v, arreglocopia2, busqueda2, cont8);

                                            break;

                                    }

                                } while (opc3 != 3);
                                break;
                            case 2:
                                do {
                                    opc3 = Menus.menuBuscarrecursivos();
                                    switch (opc3) {
                                        case 1:
                                           
                                            System.out.print("Ingrese un parametro del vehiculo a buscar: ");
                                            String busqueda3 = sc.next();
                                            kl.secuencialprecio(num_v, 0, arreglo, busqueda3);

                                            break;
                                        case 2:
                                  
                                            Vehiculo[] arreglocopia;
                                            arreglocopia = new Vehiculo[5];
                                            System.arraycopy(arreglo, 0, arreglocopia, 0, 5);

                                            System.out.print("Ingrese un parametro del vehiculo a buscar: ");
                                            String busqueda4 = sc.next();
                                            km.binariaprecio(arreglocopia, busqueda4, 0, num_v);
                                            break;
                                    }
                                } while (opc3 != 3);

                                break;

                        }

                    } while (opc2 != 3);
                    break;
                case 4:
                    do {
                        opc3 = Menus.menuVoraces();
                        switch (opc3) {
                            case 1:
                                int peso = 10;
                                System.out.println("Problema mochila");
                                List<Objeto> listaObjetos = new LinkedList<Objeto>();
                                listaObjetos.add(new Objeto(5, 30));
                                listaObjetos.add(new Objeto(10, 100));
                                listaObjetos.add(new Objeto(5, 12));
                                listaObjetos.add(new Objeto(5, 50));
                                listaObjetos.add(new Objeto(12, 23));
                                Mochila mochila = new Mochila(listaObjetos, peso);
                                System.out.println(mochila.toString());
                                List<Objeto> solucion = mochila.resolver();
                                System.out.println("Solución: " + solucion.toString());

                                break;
                            case 2:
                                int num = 0;
                                System.out.println("Problema Dijkstra");
                                System.out.println("\n\tImplementacion del algoritmo de Dijkstra");
                                System.out.print("Numero de nodos que tiene el grafo a resolver? ");

                                do {
                                    try {
                                        InputStreamReader l1 = new InputStreamReader(System.in);
                                        BufferedReader l2 = new BufferedReader(l1);
                                        num = Integer.valueOf(l2.readLine()).intValue();
                                    } catch (IOException e) {
                                        System.out.println("Error: " + e);
                                        System.out.println("Ingresa el numero de nodos que tiene el grafo a resolver: ");
                                    } catch (NumberFormatException e2) {
                                        System.out.println("Error: " + e2);
                                        System.out.println("Ingresa el numero de nodos que tiene el grafo a resolver: ");
                                    }
                                    if (num < 3 || num > 26) {
                                        System.out.print(" * El numero de nodos debe estar entre 3 y 26 ");
                                    }

                                } while (num < 3 || num > 26);
                                dijkstra obj = new dijkstra(num);

                                break;
                        }
                    } while (opc3 != 3);
                    break;

                case 5:
                    do {
                        opc3 = Menus.menuVueltaatras();
                        switch (opc3) {
                            case 1:

                                metvueltaatras op = new metvueltaatras();
                                System.out.println("Problema laberinto");
                                char[][] laberinto = new char[][]{
                                    {'#', '#', '#', '#', '#', '#'},
                                    {'#', '.', '#', ' ', ' ', '#'},
                                    {'#', ' ', ' ', '#', ' ', '#'},
                                    {'#', '#', ' ', ' ', ' ', '#'},
                                    {'#', '#', ' ', '#', '#', '#'},
                                    {'#', ' ', ' ', ' ', ' ', ' '},
                                    {'#', '#', '#', '#', '#', '#'}};
                                System.out.println("Situacion inicial: ");
                                op.imprime(laberinto);
                                op.resuelve(laberinto, 1, 1);

                                break;
                            case 2:
                                System.out.println("Problema Sudoku");
                                metvueltaatras as = new metvueltaatras();
                                int[][] tablero = new int[][]{
                                    {0, 0, 0, 0, 0, 0, 0, 0, 0},
                                    {0, 0, 0, 0, 3, 0, 6, 0, 0},
                                    {0, 0, 9, 0, 7, 8, 0, 3, 0},
                                    {3, 0, 5, 0, 0, 4, 0, 0, 0},
                                    {0, 0, 2, 0, 0, 6, 0, 0, 7},
                                    {6, 8, 7, 0, 0, 0, 0, 2, 0},
                                    {0, 0, 0, 0, 0, 0, 3, 5, 4},
                                    {0, 0, 0, 0, 0, 0, 0, 0, 6},
                                    {0, 4, 0, 0, 0, 0, 0, 0, 0},};
                                as.imprime(tablero);
                                if (!as.resolver(tablero)) {
                                    System.out.println("El sudoku no tiene solucion");
                                }

                                break;
                        }
                    } while (opc3 != 3);
            }
        } while (opc1 != 6);

    }

}
